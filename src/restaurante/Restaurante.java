package restaurante;

import AdministradorCentralParque.RegistroFinanciero;
import java.util.ArrayList;
import java.util.Random;

public class Restaurante {
    private ArrayList<Menu> menu;
    private double ingredientes;
    private Random random = new Random();
    private StringBuilder mensajes;

    public Restaurante() {
        menu = new ArrayList<>();
        ingredientes = 300;
        mensajes = new StringBuilder();
    }

    public void agregarPlato(Menu plato) {
        menu.add(plato);
        String mensaje = "Plato agregado: " + plato.getPlato();
        System.out.println(mensaje);
        mensajes.append(mensaje).append("\n");
    }

    public void eliminarPlato(String nombrePlato) {
        boolean encontrado = false;
        for (int i = 0; i < menu.size(); i++) {
            if (menu.get(i).getPlato().equalsIgnoreCase(nombrePlato)) {
                menu.remove(i);
                String mensaje = "Plato eliminado: " + nombrePlato;
                System.out.println(mensaje);
                mensajes.append(mensaje).append("\n");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            String mensaje = "Plato no encontrado: " + nombrePlato;
            System.out.println(mensaje);
            mensajes.append(mensaje).append("\n");
        }
    }

    public void mostrarMenu() {
        String mensaje = "Menú del Restaurante:";
        System.out.println(mensaje);
        mensajes.append(mensaje).append("\n");

        if (menu.isEmpty()) {
            System.out.println("El menú está vacío.");
            mensajes.append("El menú está vacío.\n");
        }

        for (Menu plato : menu) {
            System.out.println("- " + plato.getPlato());
            mensajes.append("- ").append(plato.getPlato()).append("\n");
        }
    }

    public void clienteRestaurante(RegistroFinanciero registro) {
        double consumo = 10 + random.nextInt(90);
        registro.registrarIngreso(consumo);

        String mensaje1 = "Un cliente ha comido en el restaurante.";
        String mensaje2 = "Ingreso recibido: " + consumo;

        System.out.println(mensaje1);
        System.out.println(mensaje2);
        mensajes.append(mensaje1).append("\n").append(mensaje2).append("\n");
    }

    public void reponerIngredientes(RegistroFinanciero registro) {
        double gasto = 100;
        registro.registrarGasto(gasto);

        String mensaje = "Gasto por reposición de ingredientes: " + gasto;
        System.out.println(mensaje);
        mensajes.append(mensaje).append("\n");
    }

    public String getMensajes() {
        String resultado = mensajes.toString();
        mensajes.setLength(0); 
        return resultado;
    }
}


