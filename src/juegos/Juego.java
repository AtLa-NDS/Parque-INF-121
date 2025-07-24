package juegos;

public abstract class Juego {
    protected String nombre;
    private int capacidad;
    private boolean estado;

    public Juego(String nombre, int capacidad, String estado) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.estado = true;
    }

    public abstract String iniciar();

    public String mostrarInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nInformacion del Juego:\n");
        sb.append("Nombre: ").append(nombre).append("\n");
        sb.append("Capacidad: ").append(capacidad).append(" personas\n");
        sb.append("Estado: ").append(estado).append("\n");
        System.out.print(sb.toString());
        return sb.toString();
    }

    protected void setEstado(boolean estado) {
        this.estado = estado;
    }

    protected boolean getEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }
}

