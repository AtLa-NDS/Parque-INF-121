package restaurante;

import AdministradorCentralParque.RegistroFinanciero;
import java.util.ArrayList;
import java.util.Random;

public class Restaurante {
    private ArrayList<Menu>menu;
    private double ingredientes;
    private Random random=new Random();

    public Restaurante(){
        menu=new ArrayList<>();
        ingredientes=300;
    }
    public void agregarPlato(Menu plato){
        menu.add(plato);
        System.out.println("plato agregado "+plato.getPlato());

    }
    public void eliminarPlato(String nombrePlato){
        for(int i=0;i<menu.size();i++){
            if (menu.get(i).getPlato().equalsIgnoreCase(nombrePlato)){
                menu.remove(i);
                System.out.println("Plato eliminado: " + nombrePlato);
                break;
            }
        }

    }

    public void mostrarMenu() {
        System.out.println("Menu del Restaurante:");
        for(Menu plato : menu){
            plato.mostrar();
        }
    }
    public void clienteRestaurante(RegistroFinanciero registro){
        double consumo=10+random.nextInt(90);
        registro.registrarIngreso(consumo);
        System.out.println("Un cliente ha comido en el restaurante.");
        System.out.println("Ingreso recibido: " + consumo);
    }
    public void reponerIngredientes(RegistroFinanciero registro) {
        double gasto = 100;
        registro.registrarGasto(gasto);
        System.out.println("Gasto por reposición: " + gasto);
    }
}

