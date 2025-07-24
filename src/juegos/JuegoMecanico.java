package juegos;

import AdministradorCentralParque.RegistroFinanciero;
import boleto.*;

public class JuegoMecanico extends Juego {
    private int edadMinima;
    private int alturaMinima;
    private double velocidadMaxima;
    private int duracionViaje;
    private boolean enUso = false;

    public JuegoMecanico(String nombre, int capacidad, String estado, int edadMinima,
                         int alturaMinima, double velocidadMaxima, int duracionViaje) {
        super(nombre, capacidad, estado);
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
        this.velocidadMaxima = velocidadMaxima;
        this.duracionViaje = duracionViaje;
    }

    public String permitirAcceso(Boleto boleto, RegistroFinanciero registro) {
        if (boleto.getEdad() < edadMinima || boleto.getAltura() < alturaMinima) {
            String mensaje = "El cliente no cumple los requisitos para " + getNombre();
            System.out.println(mensaje);
            return mensaje;
        }
        String mensaje = "Acceso permitido a " + getNombre();
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public String iniciar() {
        if (!getEstado()) {
            String mensaje = getNombre() + " no está disponible";
            System.out.println(mensaje);
            return mensaje;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Iniciando ").append(getNombre()).append(" con ").append(getCapacidad()).append(" pasajeros\n");
        sb.append("Velocidad máxima: ").append(velocidadMaxima).append(" km/h\n");
        sb.append("Duración del viaje: ").append(duracionViaje).append(" minutos\n");
        System.out.print(sb.toString());
        enUso = true;
        return sb.toString();
    }

    public String finalizar() {
        if (enUso) {
            String mensaje = "Finalizando " + getNombre();
            System.out.println(mensaje);
            enUso = false;
            return mensaje;
        }
        return "";
    }

    public String cambiarEstado(boolean nuevoEstado) {
        this.setEstado(nuevoEstado);
        String mensaje;
        if (nuevoEstado) {
            mensaje = "El juego " + getNombre() + " está operando";
        } else {
            mensaje = "El juego " + getNombre() + " está en mantenimiento";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    public String obtenerEstadoActual() {
        String mensaje;
        if (getEstado()) {
            mensaje = "El juego " + getNombre() + " está operando";
        } else {
            mensaje = "El juego " + getNombre() + " está en mantenimiento";
        }
        System.out.println(mensaje);
        return mensaje;
    }

    @Override
    public String mostrarInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.mostrarInfo());
        sb.append("\n----------------------------------\n");
        sb.append("      Informacion del juego \n");
        sb.append("----------------------------------\n");
        sb.append("Nombre: ").append(getNombre()).append("\n");
        sb.append("Capacidad: ").append(getCapacidad()).append("\n");
        sb.append("Requisitos para acceder: \n");
        sb.append("Edad minima: ").append(edadMinima).append(" años\n");
        sb.append("Altura mínima: ").append(alturaMinima).append(" cm\n");
        sb.append("Características:\n");
        sb.append("Velocidad maxima: ").append(velocidadMaxima).append(" km/h\n");
        sb.append("Duración del viaje: ").append(duracionViaje).append(" minutos\n");
        sb.append("----------------------------------\n\n");
        System.out.print(sb.toString());
        return sb.toString();
    }
}
