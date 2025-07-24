package juegos;

import boleto.*;
import AdministradorCentralParque.RegistroFinanciero;
import promociones.*;

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


    public void permitirAcceso(Boleto boleto, RegistroFinanciero registro) {
        if (boleto.getEdad() < edadMinima || boleto.getAltura() < alturaMinima) {
            System.out.println("El cliente no cumple los requisitos para " + getNombre());
            return;
        }
        System.out.println("Acceso permitido a " + getNombre());
    }


    public void iniciar() {
        if (!getEstado()) {
            System.out.println(getNombre() + " no esta disponible");
            return;
        }
        System.out.println("Iniciando " + getNombre() + " con " + getCapacidad() + " pasajeros");
        System.out.println("Velocidad máxima: " + velocidadMaxima + " km/h");
        System.out.println("Duración del viaje: " + duracionViaje + " minutos");
        enUso = true;
    }
    public void finalizar() {
        if (enUso) {
            System.out.println("Finalizando " + getNombre());
            enUso = false;
        }
    }
    public void cambiarEstado(boolean nuevoEstado) {
        this.setEstado(nuevoEstado);
        if (nuevoEstado) {
            System.out.println("El juego " + getNombre() + " esta operando");
        } else {
            System.out.println("El juego " + getNombre() + " esta en mantenimieto");
        }
    }
    public void obtenerEstadoActual() {
        if (getEstado()) {
            System.out.println("El juego " + getNombre() + " esta operando");
        } else {
            System.out.println("El juego " + getNombre() + " esta en mantenimieto");
        }
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("\n----------------------------------");
        System.out.println("      Informacion del juego ");
        System.out.println("----------------------------------");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Capacidad: " + getCapacidad() );
        System.out.println("Requisitos para acceder: ");
        System.out.println("Edad minima: " + edadMinima + " años");
        System.out.println("Altura mínima: " + alturaMinima + " cm");
        System.out.println("Características:");
        System.out.println("Velocidad maxima: " + velocidadMaxima + " km/h");
        System.out.println("Duración del viaje: " + duracionViaje + " minutos");
        System.out.println("----------------------------------\n");

    }

}