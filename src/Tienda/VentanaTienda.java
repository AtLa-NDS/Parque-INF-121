package Tienda;

import AdministradorCentralParque.RegistroFinanciero;

import javax.swing.*;
import java.awt.*;

public class VentanaTienda extends JFrame {
    private Inventario inventario;
    private RegistroFinanciero registro;

    private JTextArea areaInventario;

    public VentanaTienda() {
        setTitle("Tienda del Parque");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Para cerrar solo esta ventana
        setLocationRelativeTo(null);

        inventario = new Inventario();
        registro = new RegistroFinanciero();

        areaInventario = new JTextArea();
        areaInventario.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaInventario);

        JButton btnAgregar = new JButton("Agregar producto");
        JButton btnVender = new JButton("Vender producto");
        JButton btnReponer = new JButton("Reponer producto");
        JButton btnMostrar = new JButton("Mostrar inventario");

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(200, 220, 255));
        panelBotones.setLayout(new GridLayout(2, 2, 10, 10));
        panelBotones.add(btnAgregar);
        panelBotones.add(btnVender);
        panelBotones.add(btnReponer);
        panelBotones.add(btnMostrar);

        getContentPane().setBackground(new Color(240, 248, 255));
        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnAgregar.addActionListener(e -> agregarProducto());
        btnVender.addActionListener(e -> venderProducto());
        btnReponer.addActionListener(e -> reponerProducto());
        btnMostrar.addActionListener(e -> mostrarInventario());
    }

    private void agregarProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del producto:");
            String tipo = JOptionPane.showInputDialog(this, "Tipo del producto:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad:"));
            double precio = Double.parseDouble(JOptionPane.showInputDialog(this, "Precio:"));

            Producto p = new Producto(nombre, cantidad, precio, tipo);
            inventario.agregarProducto(p);

            JOptionPane.showMessageDialog(this, "Producto agregado: " + nombre);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al agregar producto.");
        }
    }

    private void venderProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del producto a vender:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad a vender:"));

            String mensaje = inventario.venderProducto(nombre, cantidad, registro);
            JOptionPane.showMessageDialog(this, mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al vender producto.");
        }
    }

    private void reponerProducto() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre del producto a reponer:");
            int cantidad = Integer.parseInt(JOptionPane.showInputDialog(this, "Cantidad a reponer:"));

            String mensaje = inventario.reponerProducto(nombre, cantidad, registro);
            JOptionPane.showMessageDialog(this, mensaje);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al reponer producto.");
        }
    }

    private void mostrarInventario() {
        areaInventario.setText("");
        for (Producto p : inventario.getListaProductos()) {
            areaInventario.append(
                "Nombre: " + p.getNombre() +
                ", Tipo: " + p.getTipo() +
                ", Precio: " + p.getPrecio() +
                ", Cantidad: " + p.getCantidad() + "\n"
            );
        }
    }
}




