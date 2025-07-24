package juegos;

public class Espectaculos extends Juego {
    private String horario;
    private String show;

    public Espectaculos(String nombre, int capacidad, String estado, String horario,String show) {
        super(nombre, capacidad, estado);
        this.horario = horario;
        this.show = show;
    }

    @Override
    public void iniciar() {
        if (getEstado()) {
            System.out.println("El espectaculo " + getNombre() +   show +" ha comenzado en el horario: " + horario);
            System.out.println("Capacidad maxima: " + getCapacidad() + " personas");
        } else {
            System.out.println("El espectaculo " + getNombre() + " no esta disponible en este momento.");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Horario: " + horario);
        System.out.println("Show: " + show);
        System.out.println("Tipo: Espectaculo");
    }

}
