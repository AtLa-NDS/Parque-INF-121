package Tienda;

import AdministradorCentralParque.RegistroFinanciero;
import java.util.ArrayList;

public class Inventario {
    private ArrayList<Producto> productos;

    public Inventario() {
        productos = new ArrayList<>();
    }

    public ArrayList<Producto> getListaProductos() {
        return productos;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public String venderProducto(String nombre, int cantidad, RegistroFinanciero registro) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p.vender(cantidad, registro);
            }
        }
        return "Producto no encontrado.";
    }

    public void mostrarInventario() {
        System.out.println("Inventario de la tienda:");
        for (Producto p : productos) {
            System.out.println(p.descripcion());  // usa el método descripcion() que tienes en Producto
        }
    }

    public String reponerProducto(String nombre, int cantidad, RegistroFinanciero registro) {
        for (Producto p : productos) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                return p.reponerInventario(cantidad, registro);
            }
        }
        return "Producto no encontrado para reponer.";
    }
}
