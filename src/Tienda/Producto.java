package Tienda;

import AdministradorCentralParque.RegistroFinanciero;
import BD.*;
public class Producto {
    private String nombre;
    private int cantidad;
    private double precio;
    private String tipo;

    public Producto(String nombre, int cantidad, double precio, String tipo) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.precio = precio;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }

    public String vender(int unidades, RegistroFinanciero registro) {
        if (unidades <= cantidad) {
            cantidad -= unidades;
            double monto = unidades * precio;
            registro.registrarIngreso(monto);
            RegistroFinancieroBD.guardarRegistro(monto, 0);

            return "Se vendieron " + unidades + " unidades. Ingreso: " + monto;
        } else {
            return "No hay suficiente stock.";
        }
    }

    public String reponerInventario(int cantidad, RegistroFinanciero registro) {
        double gasto = cantidad * precio * 0.2;
        registro.registrarGasto(gasto);
        RegistroFinancieroBD.guardarRegistro(0, gasto);
        this.cantidad += cantidad;
        return "Se han repuesto " + cantidad + " unidades. Gasto: " + gasto;
    }

    public String descripcion() {
        return "Nombre: " + nombre + ", Tipo: " + tipo + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }
}


