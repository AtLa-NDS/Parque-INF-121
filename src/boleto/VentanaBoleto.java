package boleto;

import boleto.Boleto;
import AdministradorCentralParque.RegistroFinanciero;

import javax.swing.*;
import java.awt.*;
import BD.*;
public class VentanaBoleto extends JFrame {
    private JTextField campoEdad;
    private JTextField campoAltura;
    private JButton btnGenerar;
    private JButton btnVender;
    private JTextArea areaTexto;

    private Boleto boletoActual;
    private RegistroFinanciero registro;

    public VentanaBoleto(RegistroFinanciero registroExistente) {
        this.registro = registroExistente;
        setTitle("Gestión de Boletos");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(240, 248, 255));
        setLayout(new BorderLayout(10, 10));

        JPanel panelInputs = new JPanel(new GridLayout(2, 2, 10, 10));
        panelInputs.setBackground(new Color(200, 220, 255));
        panelInputs.add(new JLabel("Edad:"));
        campoEdad = new JTextField();
        panelInputs.add(campoEdad);
        panelInputs.add(new JLabel("Altura (cm):"));
        campoAltura = new JTextField();
        panelInputs.add(campoAltura);

        btnGenerar = new JButton("Generar Boleto");
        btnVender = new JButton("Vender Boleto");

        JPanel panelBotones = new JPanel(new GridLayout(1, 2, 10, 10));
        panelBotones.setBackground(new Color(200, 220, 255));
        panelBotones.add(btnGenerar);
        panelBotones.add(btnVender);

        areaTexto = new JTextArea();
        areaTexto.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaTexto);

        add(panelInputs, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);

        btnGenerar.addActionListener(e -> {
            try {
                int edad = Integer.parseInt(campoEdad.getText());
                int altura = Integer.parseInt(campoAltura.getText());
                boletoActual = new Boleto(edad, altura);

                areaTexto.setText("");
                areaTexto.append("Boleto generado:\n");
                areaTexto.append("ID: " + boletoActual.getId() + "\n");
                areaTexto.append("Tipo: " + boletoActual.getTipo() + "\n");
                areaTexto.append("Precio: Bs." + boletoActual.getPrecio() + "\n");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor ingresa números válidos para edad y altura.");
            }
        });

        btnVender.addActionListener(e -> {
            if (boletoActual != null) {
                registro.registrarIngreso(boletoActual.getPrecio());
                RegistroFinancieroBD.guardarRegistro(boletoActual.getPrecio(), 0);

                boletoActual.ventaBoleto(registro);
                areaTexto.append("\nVenta realizada.\n");
                areaTexto.append("Ingresos totales registrados: Bs." + registro.getTotal() + "\n");
            } else {
                JOptionPane.showMessageDialog(this, "Primero genera un boleto.");
            }
        });

    }
}

