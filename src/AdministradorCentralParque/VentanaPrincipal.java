package AdministradorCentralParque;

import Tienda.VentanaTienda;
import restaurante.Restaurante;
import restaurante.VentanaRestaurante;
import personas.GestionTrabajador;
import personas.VentanaTrabajadores;   
import boleto.VentanaBoleto;
import juegos.VentanaJuego;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private GestionTrabajador gestionTrabajador;
    private RegistroFinanciero registroFinanciero;
    private Restaurante restaurante;

    public VentanaPrincipal() {
        // Inicializaciones centrales
        gestionTrabajador = new GestionTrabajador();
        registroFinanciero = new RegistroFinanciero();
        restaurante = new Restaurante();

        setTitle("Administración del Parque");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(new BorderLayout(10, 10));

        JPanel panelBotones = new JPanel(new GridLayout(2, 3, 15, 15));
        panelBotones.setBackground(new Color(200, 220, 255));

        JButton btnTienda = crearBoton("Tienda");
        JButton btnRestaurante = crearBoton("Restaurante");
        JButton btnTrabajadores = crearBoton("Gestión Trabajadores");
        JButton btnBoletos = crearBoton("Venta de Boletos");
        JButton btnJuegos = crearBoton("Juegos");
        JButton btnSalir = crearBoton("Salir");

        panelBotones.add(btnTienda);
        panelBotones.add(btnRestaurante);
        panelBotones.add(btnTrabajadores);
        panelBotones.add(btnBoletos);
        panelBotones.add(btnJuegos);
        panelBotones.add(btnSalir);

        add(panelBotones, BorderLayout.CENTER);

        // Acciones de los botones con las instancias necesarias
        btnTienda.addActionListener(e -> {
            VentanaTienda tienda = new VentanaTienda();
            tienda.setVisible(true);
        });

        btnRestaurante.addActionListener(e -> {
            VentanaRestaurante ventanaRest = new VentanaRestaurante(restaurante, registroFinanciero);
            ventanaRest.setVisible(true);
        });

        btnTrabajadores.addActionListener(e -> {
            VentanaTrabajadores ventanaTrabajadores = new VentanaTrabajadores(gestionTrabajador, registroFinanciero);
            ventanaTrabajadores.setVisible(true);
        });

        btnBoletos.addActionListener(e -> {
            VentanaBoleto ventanaBoleto = new VentanaBoleto(registroFinanciero);
            ventanaBoleto.setVisible(true);
        });

        btnJuegos.addActionListener(e -> {
            VentanaJuego ventanaJuego = new VentanaJuego(registroFinanciero);
            ventanaJuego.setVisible(true);
        });

        btnSalir.addActionListener(e -> System.exit(0));
    }

    private JButton crearBoton(String texto) {
        JButton btn = new JButton(texto);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        btn.setBackground(new Color(180, 200, 255));
        return btn;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaPrincipal ventana = new VentanaPrincipal();
            ventana.setVisible(true);
        });

        // Para pruebas por consola:
        /*
        Parque parque = new Parque();
        parque.juegos();
        parque.trabajadores();
        parque.simularVisitaCliente();
        parque.mostrarFinanzas();
        */
    }
}


