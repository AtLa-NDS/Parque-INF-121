package boleto;
import AdministradorCentralParque.RegistroFinanciero;

import java.util.ArrayList;

import BD.RegistroFinancieroBD;
import promociones.*;
public class Boleto extends Cliente {
    private String tipo;
    private double precio;
    private int id;
    private static int contador=1;

    //-----------------------------------------
    //activar evento manualmente
    private boolean activarEvento=true;
    Descuento descuento = new DescuentoNavidad();
    EventoEspecial evento = new EventoEspecial("Navidad", descuento);
    //--------------------------------------------

    private ArrayList<Cliente> clientes;

    public Boleto(int edad,int altura){
        super(edad,altura);
        clientes = new ArrayList<>();
        id = contador++;
        this.agregarCliente(new Cliente(edad, altura));
    }
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
        verificarTipo();
        System.out.println("Cliente agregado: " + id);
    }

    private void verificarTipo(){

        if (clientes.isEmpty()) return;

        Cliente ultimoCliente = clientes.get(clientes.size() - 1);
        int edad = ultimoCliente.getEdad();

        if (edad>59){
            tipo="TerceraEdad";
            precio=200*0.5;
            if (activarEvento) {
                precio = evento.aplicarDescuento(precio);
                System.out.println("Se aplico descuetno por " + evento.getTematica());
            }
        }

        else if (edad<6){
            tipo="Menor";
            precio=200*0.3;
            if (activarEvento) {
                precio = evento.aplicarDescuento(precio);
                System.out.println("Se aplico descuetno por " + evento.getTematica());
            }
        }
        else{
            tipo="Normal";
            precio=200;
            if (activarEvento) {
                precio = evento.aplicarDescuento(precio);
                System.out.println("Se aplico descuetno por " + evento.getTematica());
            }
        }

    }
    public void mostrar() {
        if (clientes.isEmpty()) {
            System.out.println("el boleto " + id + " no tiene clientes.");
            return;
        }
        Cliente ultCliente = clientes.get(clientes.size() - 1);
        System.out.println("ID: " + id + "\nEdad: " + ultCliente.getEdad() + "\nTipo: " + tipo + "\nPrecio: Bs." + precio);
    }
    public void ventaBoleto(RegistroFinanciero registro){
        registro.registrarIngreso(precio);
        RegistroFinancieroBD.guardarRegistro(precio, 0);
        System.out.println("Un cliente ha comprado un boleto");
        System.out.println("Ingreso recibido: " + precio);
    }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public int getId() { return id; }
    public ArrayList<Cliente> getClientes() { return new ArrayList<>(clientes); }
}
