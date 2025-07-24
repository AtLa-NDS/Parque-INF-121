package AdministradorCentralParque;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });

        // Código para pruebas por consola o simulaciones automáticas.
        // Descomenta si quieres ejecutar estas pruebas fuera de la interfaz gráfica.
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


