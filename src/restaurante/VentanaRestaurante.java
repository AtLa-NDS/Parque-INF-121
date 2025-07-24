package restaurante;

import AdministradorCentralParque.RegistroFinanciero;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VentanaRestaurante extends JFrame {
    private Restaurante restaurante;
    private RegistroFinanciero registro;
    private JTextArea areaMensajes;
    private JTextField campoPlato;

    public VentanaRestaurante(Restaurante restaurante, RegistroFinanciero registro) {
        this.restaurante = restaurante;
        this.registro = registro;
        setTitle("Restaurante del Parque");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaMensajes);
        add(scroll, BorderLayout.CENTER);

        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new GridLayout(2, 1));

        JPanel panelPlatos = new JPanel();
        campoPlato = new JTextField(15);
        JButton btnAgregar = new JButton("Agregar Plato");
        JButton btnEliminar = new JButton("Eliminar Plato");
        panelPlatos.add(new JLabel("Plato:"));
        panelPlatos.add(campoPlato);
        panelPlatos.add(btnAgregar);
        panelPlatos.add(btnEliminar);

        JPanel panelAcciones = new JPanel();
        JButton btnMostrarMenu = new JButton("Mostrar Menú");
        JButton btnCliente = new JButton("Cliente Aleatorio");
        JButton btnReponer = new JButton("Reponer Ingredientes");
        panelAcciones.add(btnMostrarMenu);
        panelAcciones.add(btnCliente);
        panelAcciones.add(btnReponer);

        panelInferior.add(panelPlatos);
        panelInferior.add(panelAcciones);
        add(panelInferior, BorderLayout.SOUTH);

     
        btnAgregar.addActionListener((ActionEvent e) -> {
            String nombre = campoPlato.getText().trim();
            if (!nombre.isEmpty()) {
                restaurante.agregarPlato(new Menu(nombre));
                mostrarMensajes();
                campoPlato.setText("");
            }
        });

        btnEliminar.addActionListener((ActionEvent e) -> {
            String nombre = campoPlato.getText().trim();
            if (!nombre.isEmpty()) {
                restaurante.eliminarPlato(nombre);
                mostrarMensajes();
                campoPlato.setText("");
            }
        });

        btnMostrarMenu.addActionListener((ActionEvent e) -> {
            restaurante.mostrarMenu();
            mostrarMensajes();
        });

        btnCliente.addActionListener((ActionEvent e) -> {
            restaurante.clienteRestaurante(registro);
            mostrarMensajes();
        });

        btnReponer.addActionListener((ActionEvent e) -> {
            restaurante.reponerIngredientes(registro);
            mostrarMensajes();
        });
    }

    private void mostrarMensajes() {
        areaMensajes.append(restaurante.getMensajes());
        areaMensajes.setCaretPosition(areaMensajes.getDocument().getLength());
    }
}
