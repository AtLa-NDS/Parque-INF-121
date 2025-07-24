package AdministradorCentralParque;

public class RegistroFinanciero {
    private double ingreso;
    private double gasto;

    public RegistroFinanciero() {
        this.ingreso = 0;
        this.gasto = 0;
    }

    public void registrarIngreso(double monto) {
        if (monto > 0) {
            ingreso += monto;
            System.out.println("Ingreso registrado: " + monto);
        }
    }

    public void registrarGasto(double monto) {
        if (monto > 0) {
            gasto += monto;
            System.out.println("Gasto registrado: " + monto);
        }
    }

    public double getTotal() {
        return ingreso - gasto;
    }

    public void mostrarBalance() {
        System.out.println("Ingresos totales: " + ingreso);
        System.out.println("Gastos totales: " + gasto);
        System.out.println("Balance actual: " + getTotal());
    }
}
