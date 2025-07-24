package personas;
public class Trabajador {
    private String nombre;
    private int edad;
    private int nroId;
    private String cargo;
    private double sueldo;

    public Trabajador() {}

    public Trabajador(String nombre, int edad, int nroId, String cargo, double sueldo) {
        this.nombre = nombre;
        this.edad = edad;
        this.nroId = nroId;
        this.cargo = cargo;
        this.sueldo = sueldo;
    }

    public void mostrarInfoEmpleado() {
        System.out.println("-------------------------");
        System.out.println("Informacion del empleado:");
        System.out.println("-------------------------");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad + " años");
        System.out.println("NroId: " + nroId );
        System.out.println("Cargo: " + cargo );
        System.out.println("Sueldo de : " + sueldo);
        System.out.println("-------------------------");
    }
    public void mostrarlista() {
        System.out.println("| Nombre: " + nombre + " | Edad: " + edad + " años" + " | NroId: " + nroId +
                " | Cargo: " + cargo + " | Sueldo: " + sueldo+ " |");

    }


    public int getNroId() {
        return nroId;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    public double getSueldo() {
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public String getNombre() {
        return nombre;
    }
    public int getEdad() {
        return edad;
    }
    public String getCargo() {
        return cargo;
    }

}
