package AdministradorCentralParque;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });

    
        /*

        */
        Parque parque = new Parque();
        parque.simularVisitaCliente();
        parque.trabajadores();
        parque.juegos();
        parque.mostrarFinanzas();



    }
}


