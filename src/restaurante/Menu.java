package restaurante;

public class Menu {
    private String plato;

    public Menu(String nombreplato){
        this.plato = nombreplato;
    }

    public String getPlato(){
        return plato;
    }

    public String mostrar() {
        return plato;
    }
}

