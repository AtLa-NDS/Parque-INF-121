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

    public abstract void iniciar();

    public void mostrarInfo() {
        System.out.println("\nInformacion del Juego:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Capacidad: " + capacidad + " personas");
        System.out.println("Estado: " + estado);
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
