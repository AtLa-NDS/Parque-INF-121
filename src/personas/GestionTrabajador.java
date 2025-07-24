package personas;

import AdministradorCentralParque.RegistroFinanciero;

public class GestionTrabajador {
    private Trabajador[] trabajadores;
    private int cantidad;
    private int maxTrabajadores = 100;

    public GestionTrabajador() {
        trabajadores = new Trabajador[maxTrabajadores];
        cantidad = 0;
    }

    public void añadirTrabajador(Trabajador trabajador) {
            if (cantidad < maxTrabajadores) {
                for (int i = 0; i < cantidad; i++) {
                    if (trabajadores[i].getNroId() == trabajador.getNroId()) {
                        System.out.println("-Ya existe un trabajdor con el ID: " + trabajador.getNroId());
                        return;
                    }
                }
                trabajadores[cantidad] = trabajador;
                cantidad++;
                System.out.println("-Trabajador añadido");
            } else {
                System.out.println("-Ya no hay bacantes para mas empleados");
            }
    }

    public void mostrarListaTrabajadores() {
        System.out.println("\nLista de Trabajadores: " + cantidad + "/" + maxTrabajadores);
        System.out.println("---------------------------------------------------------------------------------------------");
        for (int i = 0; i < cantidad; i++) {
            trabajadores[i].mostrarlista();
            System.out.println("---------------------------------------------------------------------------------------------");
        }
    }

    public void cambiarCargo(int nroId, String cargoNuevo, double sueldoNeuvo) {
        System.out.println("\nActualizando cargo del trabajador " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                trabajadores[i].setCargo(cargoNuevo);
                trabajadores[i].setSueldo(sueldoNeuvo);
                System.out.println("Cargo actualizado para el trabajador " + nroId);
                return;
            }
        }
        System.out.println("no se encontró ningún trabajador con el ID " + nroId);
    }

    public void buscarTrabajador(int nroId) {
        System.out.println("\nBuscando trabajador: " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                System.out.println("Informacion del trabajador " + nroId);
                trabajadores[i].mostrarInfoEmpleado();
                return;
            }
        }
        System.out.println("No se encontro ningun trabajador con el ID " + nroId );
    }

    public void despedirTrabajador(int nroId) {
        System.out.println("\nDespidiendo al trabador " + nroId);
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i].getNroId() == nroId) {
                for (int j = i; j < cantidad - 1; j++) {
                    trabajadores[j] = trabajadores[j + 1];
                }
                trabajadores[cantidad - 1] = null;
                cantidad--;
                System.out.println("Trabajador " + nroId + " despedido");
                return;
            }
        }
        System.out.println("No se encontró ningún trabajador con ID " + nroId);
    }

    public void pagarSueldo(RegistroFinanciero registro) {
        double total = 0.0;
        for (int i = 0; i < cantidad; i++) {
            if (trabajadores[i] != null) {
                total += trabajadores[i].getSueldo();
            }
        }
        registro.registrarGasto(total);
        System.out.println("Total pagado a todos los trabajadores: " + total);

    }
    public void reponerIngredientes(RegistroFinanciero registro) {
        double gasto = 100;
        registro.registrarGasto(gasto);
        System.out.println("Gasto por reposición: " + gasto);
    }

}