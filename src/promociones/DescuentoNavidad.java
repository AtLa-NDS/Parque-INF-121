package promociones;

public class DescuentoNavidad implements Descuento {
    @Override
    public double aplicarDescuento(double precioOriginal) {
        return precioOriginal * 0.8;
    }
}
