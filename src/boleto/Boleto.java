package boleto;
import AdministradorCentralParque.RegistroFinanciero;

public class Boleto extends Cliente {
    private String tipo;
    private double precio;
    private int id;
    private static int contador=1;

    private Cliente[] clientes;
    private static int maxClientes = 100;
    private int cantClientes;

    public Boleto(int edad,int altura){
        super(edad,altura);
        clientes = new Cliente[maxClientes];
        cantClientes = 0;
        id = contador;
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
        if (cantClientes > 0) {
            System.out.println("ID: " + id + "\nEdad: " + clientes[cantClientes - 1].getEdad() + "\nTipo: " + tipo + "\nPrecio: Bs." + precio);
        } else {
            System.out.println("ID: " + id + "\nNo hay cliente agregado aún." + "\nTipo: " + tipo + "\nPrecio: Bs." + precio);
        }
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
