package promociones;

public class DescuentoHallowen implements Descuento {
    @Override
    public double aplicarDescuento(double precioOriginal) {
        return precioOriginal * 0.8;
    }
}
