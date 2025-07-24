package juegos;

import boleto.*;
import AdministradorCentralParque.RegistroFinanciero;
import promociones.*;

public class JuegoMecanico extends Juego {
    private int edadMinima;
    private int alturaMinima;
    private double velocidadMaxima;
    private int duracionViaje;
    private int ocupados = 0;
    private boolean enUso = false;

    private Boleto[] boletosActivos;
    private int cantidadBoletosActivos;
    private EventoEspecial eventoEspecial;
    private boolean eventoActivo = true;


    public JuegoMecanico(String nombre, int capacidad, String estado, int edadMinima,
                         int alturaMinima, double velocidadMaxima, int duracionViaje) {
        super(nombre, capacidad, estado);
        this.edadMinima = edadMinima;
        this.alturaMinima = alturaMinima;
        this.velocidadMaxima = velocidadMaxima;
        this.duracionViaje = duracionViaje;
        this.boletosActivos = new Boleto[capacidad];
        this.cantidadBoletosActivos = 0;
    }


    public void permitirAcceso(Boleto boleto, RegistroFinanciero registro) {
        if (cantidadBoletosActivos >= boletosActivos.length) {
            System.out.println(getNombre() + " ha alcanzado su capacidad máxima");
            return;
        }
        Cliente[] clientes = boleto.getClientes();
        for (int i = 0; i < boleto.getCantClientes(); i++) {
            Cliente c = clientes[i];
            if (c.getEdad() < edadMinima || c.getAltura() < alturaMinima) {
                System.out.println("Cliente no cumple requisitos para " + getNombre());
                return;
            }
        }
        boletosActivos[cantidadBoletosActivos++] = boleto;
        if (eventoActivo && eventoEspecial != null) {
            double precioConDescuento = eventoEspecial.aplicarDescuento(boleto.getPrecio());
            registro.registrarIngreso(precioConDescuento);
            System.out.println("Se aplicó descuento de " + eventoEspecial.getTematica());
        } else {
            registro.registrarIngreso(boleto.getPrecio());
        }
    }


    public void iniciar() {
        if (!getEstado()) {
            System.out.println(getNombre() + " está en mantenimiento");
            return ;
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
        System.out.println("Capacidad: " + ocupados + "/" + getCapacidad() + " ocupados");
        System.out.println("Requisitos para acceder: ");
        System.out.println("Edad minima: " + edadMinima + " años");
        System.out.println("Altura mínima: " + alturaMinima + " cm");
        System.out.println("Características:");
        System.out.println("Velocidad maxima: " + velocidadMaxima + " km/h");
        System.out.println("Duración del viaje: " + duracionViaje + " minutos");
        System.out.println("----------------------------------\n");

    }

    public void setEventoActivo(boolean eventoActivo) {
        this.eventoActivo = eventoActivo;
    }
}