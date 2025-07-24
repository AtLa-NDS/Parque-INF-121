package Tienda;
import AdministradorCentralParque.RegistroFinanciero;

public class Producto{
    private String nombre;
    private int cantidad;
    private double precio;
    private String tipo;

    public Producto(String nombre,int cantidad,double precio,String tipo){
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precio=precio;
        this.tipo=tipo;
    }

    public String getNombre(){
        return nombre;
    }
    public int getCantidad(){
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
    public void mostrar(){
        System.out.println("nombre: "+nombre +" tipo: "+ tipo+" precio: "+  precio +" cantidad: "+ cantidad );
    }
    public void vender(int unidades,RegistroFinanciero registro){
        if (unidades <=cantidad){
            cantidad-=unidades;
            double monto=unidades*precio;
            registro.registrarIngreso(monto);
            System.out.println("Se vendieron " + unidades);

        }else{
            System.out.println("No hay suficiente stock");
        }
    }
    public void reponerInventario(int cantidad,RegistroFinanciero registro){
        double monto=cantidad*precio*0.2;
        registro.registrarGasto(monto);
        this.cantidad+=cantidad;
        System.out.println("se ha repuesto");
    }
}
