package personas;

public class GestionTrabajador {
    private Trabajador[] trabajadores;
    private int cantidad;
    private int maxTrabajadores = 100;

    public GestionTrabajador() {
        trabajadores = new Trabajador[maxTrabajadores];
        cantidad = 0;
    }

    public String añadirTrabajador(Trabajador trabajador) {
        String mensaje;
        if (cantidad < maxTrabajadores) {
            for (int i = 0; i < cantidad; i++) {
                if (trabajadores[i].getNroId() == trabajador.getNroId()) {
                    mensaje = "-Ya existe un trabajador con el ID: " + trabajador.getNroId();
                    System.out.println(mensaje);
                    return mensaje;
                }
            }
            trabajadores[cantidad] = trabajador;
            cantidad++;
            mensaje = "-Trabajador añadido";
            System.out.println(mensaje);
            return mensaje;
        } else {
            mensaje = "-Ya no hay vacantes para más empleados";
            System.out.println(mensaje);
            return mensaje;
        }
    }

    public String mostrarListaTrabajadores() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de Trabajadores: ").append(cantidad).append("/").append(maxTrabajadores).append("\n");
        sb.append("---------------------------------------------------------------------------------------------\n");
        for (int i = 0; i < cantidad; i++) {
            String trabajadorInfo = trabajadores[i].getNombre() + " | Edad: " + trabajadores[i].getEdad() + " años" +
                    " | NroId: " + trabajadores[i].getNroId() + " | Cargo: " + trabajadores[i].getCargo() +
                    " | Sueldo: " + trabajadores[i].getSueldo();
            sb.append("| Nombre: ").append(trabajadores[i].getNombre())
              .append(" | Edad: ").append(trabajadores[i].getEdad()).append(" años")
              .append(" | NroId: ").append(trabajadores[i].getNroId())
              .append(" | Cargo: ").append(trabajadores[i].getCargo())
              .append(" | Sueldo: ").append(trabajadores[i].getSueldo())
              .append(" |\n");
            sb.append("---------------------------------------------------------------------------------------------\n");
        }
        String resultado = sb.toString();
        System.out.println(resultado);
        return resultado;
    }

    public String cambiarCargo(int nroId, String cargoNuevo, double sueldoNuevo) {
        String mensaje;
        System.out.println("\nActualizando cargo del trabajador " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                trabajadores[i].setCargo(cargoNuevo);
                trabajadores[i].setSueldo(sueldoNuevo);
                mensaje = "Cargo actualizado para el trabajador " + nroId;
                System.out.println(mensaje);
                return mensaje;
            }
        }
        mensaje = "No se encontró ningún trabajador con el ID " + nroId;
        System.out.println(mensaje);
        return mensaje;
    }

    public String buscarTrabajador(int nroId) {
        System.out.println("\nBuscando trabajador: " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                StringBuilder sb = new StringBuilder();
                sb.append("Información del trabajador ").append(nroId).append("\n");
                sb.append("-------------------------\n");
                sb.append("Información del empleado:\n");
                sb.append("-------------------------\n");
                sb.append("Nombre: ").append(trabajadores[i].getNombre()).append("\n");
                sb.append("Edad: ").append(trabajadores[i].getEdad()).append(" años\n");
                sb.append("NroId: ").append(trabajadores[i].getNroId()).append("\n");
                sb.append("Cargo: ").append(trabajadores[i].getCargo()).append("\n");
                sb.append("Sueldo de: ").append(trabajadores[i].getSueldo()).append("\n");
                sb.append("-------------------------\n");
                String info = sb.toString();
                System.out.println(info);
                return info;
            }
        }
        String noEncontrado = "No se encontró ningún trabajador con el ID " + nroId;
        System.out.println(noEncontrado);
        return noEncontrado;
    }

    public String despedirTrabajador(int nroId) {
        System.out.println("\nDespidiendo al trabajador " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                for (int j = i; j < cantidad - 1; j++) {
                    trabajadores[j] = trabajadores[j + 1];
                }
                trabajadores[cantidad - 1] = null;
                cantidad--;
                String mensaje = "Trabajador " + nroId + " despedido correctamente.";
                System.out.println(mensaje);
                return mensaje;
            }
        }
        String mensaje = "No se encontró ningún trabajador con el ID " + nroId;
        System.out.println(mensaje);
        return mensaje;
    }

}
