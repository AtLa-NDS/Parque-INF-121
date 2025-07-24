package personas;

import AdministradorCentralParque.RegistroFinanciero;

import javax.swing.*;
import java.awt.*;

public class VentanaTrabajadores extends JFrame {

    private GestionTrabajador gestionTrabajador;
    private RegistroFinanciero registro;

    private JTextArea areaTexto;

    public VentanaTrabajadores(GestionTrabajador gestion, RegistroFinanciero registro) {
        this.gestionTrabajador = gestion;
        this.registro = registro;

        setTitle("Gestión de Trabajadores");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(new BorderLayout());

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(200, 220, 255));
        panelBotones.setLayout(new GridLayout(3, 2, 10, 10));

        JButton btnAgregar = new JButton("Añadir Trabajador");
        JButton btnMostrar = new JButton("Mostrar Trabajadores");
        JButton btnCambiarCargo = new JButton("Cambiar Cargo");
        JButton btnBuscar = new JButton("Buscar Trabajador");
        JButton btnDespedir = new JButton("Despedir Trabajador");
        JButton btnPagarSueldos = new JButton("Pagar Sueldos");

        panelBotones.add(btnAgregar);
        panelBotones.add(btnMostrar);
        panelBotones.add(btnCambiarCargo);
        panelBotones.add(btnBuscar);
        panelBotones.add(btnDespedir);
        panelBotones.add(btnPagarSueldos);

        add(scrollPane, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        // Listeners
        btnAgregar.addActionListener(e -> añadirTrabajador());
        btnMostrar.addActionListener(e -> mostrarTrabajadores());
        btnCambiarCargo.addActionListener(e -> cambiarCargo());
        btnBuscar.addActionListener(e -> buscarTrabajador());
        btnDespedir.addActionListener(e -> despedirTrabajador());
        btnPagarSueldos.addActionListener(e -> pagarSueldos());
    }

    private void añadirTrabajador() {
        try {
            String nombre = JOptionPane.showInputDialog(this, "Nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
            int nroId = Integer.parseInt(JOptionPane.showInputDialog(this, "Número ID:"));
            String cargo = JOptionPane.showInputDialog(this, "Cargo:");
            double sueldo = Double.parseDouble(JOptionPane.showInputDialog(this, "Sueldo:"));

            Trabajador t = new Trabajador(nombre, edad, nroId, cargo, sueldo);
            String resultado = gestionTrabajador.añadirTrabajador(t);

            JOptionPane.showMessageDialog(this, resultado);
            mostrarTrabajadores(); // Actualizar vista
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al añadir trabajador: " + ex.getMessage());
        }
    }

    private void mostrarTrabajadores() {
        String lista = gestionTrabajador.mostrarListaTrabajadores();
        areaTexto.setText(lista);
    }

    private void cambiarCargo() {
        try {
            int nroId = Integer.parseInt(JOptionPane.showInputDialog(this, "Número ID del trabajador:"));
            String nuevoCargo = JOptionPane.showInputDialog(this, "Nuevo cargo:");
            double nuevoSueldo = Double.parseDouble(JOptionPane.showInputDialog(this, "Nuevo sueldo:"));

            String resultado = gestionTrabajador.cambiarCargo(nroId, nuevoCargo, nuevoSueldo);
            JOptionPane.showMessageDialog(this, resultado);
            mostrarTrabajadores();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al cambiar cargo: " + ex.getMessage());
        }
    }
    
    private void buscarTrabajador() {
        try {
            int nroId = Integer.parseInt(JOptionPane.showInputDialog(this, "Número ID del trabajador:"));
            String resultado = gestionTrabajador.buscarTrabajador(nroId);
            areaTexto.setText(resultado);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al buscar trabajador: " + ex.getMessage());
        }
    }

    private void despedirTrabajador() {
        try {
            int nroId = Integer.parseInt(JOptionPane.showInputDialog(this, "Número ID del trabajador a despedir:"));
            String resultado = gestionTrabajador.despedirTrabajador(nroId);
            JOptionPane.showMessageDialog(this, resultado);
            mostrarTrabajadores();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error al despedir trabajador: " + ex.getMessage());
        }
    }

    private void pagarSueldos() {
        String resultado = gestionTrabajador.pagarSueldo(registro);
        JOptionPane.showMessageDialog(this, resultado);
    }
}


