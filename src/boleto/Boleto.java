package boleto;
import AdministradorCentralParque.RegistroFinanciero;

import java.util.ArrayList;

public class Boleto extends Cliente {
    private String tipo;
    private double precio;
    private int id;
    private static int contador=1;

    private ArrayList<Cliente> clientes;

    public Boleto(int edad,int altura){
        super(edad,altura);
        clientes = new ArrayList<>();
        id = contador;
    }
    public void agregarCliente(Cliente cliente) {
       clientes.add(cliente);

    }

    private void verificarTipo(){

        int edad = clientes[cantClientes-1].getEdad();

        if (edad>59){
            tipo="TerceraEdad";
            precio=200*0.5;
        }
        //a;adir el descuento
        else if (edad<6){
            tipo="Menor";
            precio=200*0.3;
        }
        else{
            tipo="Normal";
            precio=200;
        }

    }

    public void mostrar() {
            System.out.println("ID: " + id + "\nEdad: " + clientes[cantClientes - 1].getEdad() + "\nTipo: " + tipo + "\nPrecio: Bs." + precio);
    }
    public void ventaBoleto(RegistroFinanciero registro){
        registro.registrarIngreso(precio);
        System.out.println("Un cliente ha comprado un boleto");
        System.out.println("Ingreso recibido: " + precio);
    }
}
