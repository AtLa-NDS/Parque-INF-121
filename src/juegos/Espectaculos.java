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
    public String iniciar() {
        if (getEstado()) {
            String mensaje = "El espectáculo " + getNombre() + " " + show + " ha comenzado en el horario: " + horario + "\n" +
                    "Capacidad máxima: " + getCapacidad() + " personas";
            System.out.println(mensaje);
            return mensaje;
        } else {
            String mensaje = "El espectáculo " + getNombre() + " no está disponible en este momento.";
            System.out.println(mensaje);
            return mensaje;
        }
    }

    @Override
    public String mostrarInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.mostrarInfo());
        sb.append("Horario: ").append(horario).append("\n");
        sb.append("Show: ").append(show).append("\n");
        sb.append("Tipo: Espectáculo\n");
        System.out.print(sb.toString());
        return sb.toString();
    }
}

