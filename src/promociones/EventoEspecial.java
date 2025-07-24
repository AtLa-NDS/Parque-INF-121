package promociones;

public class EventoEspecial {
    private String tematica;
    private Descuento descuento;

    public EventoEspecial(String tematica, Descuento descuento) {
        this.tematica = tematica;
        this.descuento = descuento;
    }

    public double aplicarDescuento(double precio) {
        return descuento.aplicarDescuento(precio);
    }

    public String getTematica() {
        return tematica;
    }
    public Descuento getDescuento() {
        return descuento;
    }

}
