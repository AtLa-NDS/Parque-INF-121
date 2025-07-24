package boleto;

import AdministradorCentralParque.RegistroFinanciero;
public class GestionBoletos {
    private Boleto[] boletosVendidos;
    private int cantBoletos;
    private int maxBoletos ;
    public GestionBoletos(int maxBoletos) {
        this.boletosVendidos = new Boleto[maxBoletos];
        this.cantBoletos = 0;
        this.maxBoletos = maxBoletos;
    }
    public Boleto crearBoleto(int maxBoletos) {
        if (cantBoletos >= maxBoletos) {
            System.out.println("No se pueden vender más boletos. Capacidad máxima alcanzada.");
        }
        Boleto nuevoBoleto = new  Boleto();
        boletosVendidos[cantBoletos++] = nuevoBoleto;
        return nuevoBoleto;
    }

}