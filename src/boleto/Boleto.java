package boleto;
import AdministradorCentralParque.RegistroFinanciero;

public class Boleto {
    private String tipo;
    private double precio;
    private int id;
    private static int contador=1;

    private Cliente[] clientes;
    private static int maxClientes = 100;
    private int cantClientes;

    public Boleto(){
        clientes = new Cliente[maxClientes];
        cantClientes = 0;
        id = contador;
        contador++;
    }
    public void agregarCliente(Cliente cliente) {
        if (cantClientes < clientes.length) {
            clientes[cantClientes++] = cliente;
            verificarTipo();
        }
    }

    private void verificarTipo(){

        int edad = clientes[cantClientes-1].getEdad();

        if (edad>59){
            tipo="TerceraEdad";
            precio=200*0.5;
        }
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
        System.out.println("ID: " + id + "  Edad: " + clientes[cantClientes-1].getEdad() + "  Tipo: " + tipo + "  Precio: Bs." + precio);
    }
    public void ventaBoleto(RegistroFinanciero registro){
        registro.registrarIngreso(precio);
        System.out.println("Un cliente ha comprado un boleto");
        System.out.println("Ingreso recibido: " + precio);
    }
    public String getTipo() { return tipo; }
    public double getPrecio() { return precio; }
    public int getId() { return id; }
    public Cliente[] getClientes() { return clientes; }
    public int getCantClientes() { return cantClientes; }

}
