package Tienda;
import AdministradorCentralParque.RegistroFinanciero;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
        System.out.println("Producto agregado: " + p.getNombre());
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la tienda:");
        for (Producto p : productos) {
            p.mostrar();
        }
    }

    public void venderProducto(String nombre, int cantidad,RegistroFinanciero registro) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.vender(cantidad,registro);
                return;
            }
        }
        System.out.println("Producto no encontrado");
    }
    public void reponerProducto(String nombre, int cantidad, RegistroFinanciero registro) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                p.reponerInventario(cantidad, registro);
                return;
            }
        }
        System.out.println("Producto no encontrado para reponer");
    }
}
