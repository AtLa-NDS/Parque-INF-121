package AdministradorCentralParque;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });

    
        /*
        parque.juegos();
        parque.trabajadores();
        parque.mostrarFinanzas();
        */
        Parque parque = new Parque();
        parque.trabajadores();
        parque.simularVisitaCliente();


    }
}


