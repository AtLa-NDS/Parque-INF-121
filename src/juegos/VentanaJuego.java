package juegos;

import AdministradorCentralParque.RegistroFinanciero;
import boleto.Boleto;
import java.awt.*;
import javax.swing.*;

public class VentanaJuego extends JFrame {
    private JTextArea areaTexto;
    private JButton btnMostrarInfo, btnIniciar, btnFinalizar, btnCambiarEstado, btnPermitirAcceso;

    private JTextField campoEdad, campoAltura;

    private JuegoMecanico juegoMecanico;
    private Espectaculos espectaculo;
    private RegistroFinanciero registro;

    public VentanaJuego(RegistroFinanciero registro) {
        this.registro = registro;

        setTitle("Gestión de Juegos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(new BorderLayout(10, 10));

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        JPanel panelBotones = new JPanel(new GridLayout(3, 2, 10, 10));
        panelBotones.setBackground(new Color(200, 220, 255));

        btnMostrarInfo = new JButton("Mostrar Información");
        btnIniciar = new JButton("Iniciar Juego");
        btnFinalizar = new JButton("Finalizar Juego");
        btnCambiarEstado = new JButton("Cambiar Estado");
        btnPermitirAcceso = new JButton("Permitir Acceso");

        panelBotones.add(btnMostrarInfo);
        panelBotones.add(btnIniciar);
        panelBotones.add(btnFinalizar);
        panelBotones.add(btnCambiarEstado);
        panelBotones.add(btnPermitirAcceso);

        JPanel panelInputs = new JPanel(new GridLayout(2, 2, 10, 10));
        panelInputs.setBackground(new Color(200, 220, 255));
        panelInputs.add(new JLabel("Edad cliente:"));
        campoEdad = new JTextField();
        panelInputs.add(campoEdad);
        panelInputs.add(new JLabel("Altura cliente (cm):"));
        campoAltura = new JTextField();
        panelInputs.add(campoAltura);

        add(panelInputs, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        juegoMecanico = new JuegoMecanico("Montaña Rusa", 5, "operativo", 12, 130, 80.0, 3);
        espectaculo = new Espectaculos("Noche Mágica", 500, "activo", "20:00", "Fuegos Artificiales");

        btnMostrarInfo.addActionListener(e -> {
            areaTexto.setText("");
            areaTexto.append("----- Juego Mecánico -----\n");
            areaTexto.append(juegoMecanico.mostrarInfo());
            areaTexto.append("----- Espectáculo -----\n");
            areaTexto.append(espectaculo.mostrarInfo());
        });

        btnIniciar.addActionListener(e -> {
            areaTexto.append("\nIntentando iniciar juego mecánico...\n");
            areaTexto.append(juegoMecanico.iniciar() + "\n");

            areaTexto.append("Intentando iniciar espectáculo...\n");
            areaTexto.append(espectaculo.iniciar() + "\n");
        });

        btnFinalizar.addActionListener(e -> {
            areaTexto.append("\nFinalizando juego mecánico...\n");
            areaTexto.append(juegoMecanico.finalizar() + "\n");
        });

        btnCambiarEstado.addActionListener(e -> {
            boolean nuevoEstado = !juegoMecanico.getEstado();
            String mensaje = juegoMecanico.cambiarEstado(nuevoEstado);
            areaTexto.append("\n" + mensaje + "\n");
        });

        btnPermitirAcceso.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(campoEdad.getText());
                int altura = Integer.parseInt(campoAltura.getText());

                Boleto boletoPrueba = new Boleto(edad, altura);
                areaTexto.append("\nVerificando acceso para cliente con edad " + edad + " y altura " + altura + "...\n");
                String resultado = juegoMecanico.permitirAcceso(boletoPrueba, registro);
                areaTexto.append(resultado + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad y altura deben ser números válidos");
            }
        });
    }
}

