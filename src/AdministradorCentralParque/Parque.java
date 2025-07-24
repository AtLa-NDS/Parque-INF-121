package AdministradorCentralParque;

import boleto.*;
import juegos.*;
import personas.*;
import promociones.*;
import restaurante.*;
import Tienda.*;

public class Parque {
    private RegistroFinanciero registro;
    private Restaurante restaurante;
    private Inventario inventario;
    GestionTrabajador gestor = new GestionTrabajador();

    public Parque() {
        registro = new RegistroFinanciero();
        restaurante = new Restaurante();
        inventario = new Inventario();
        //aqui tengo qeu agragar trabajadores,juegos,y espectaculos
        restaurante.agregarPlato(new Menu("Pizza"));
        restaurante.agregarPlato(new Menu("Hamburguesa"));

        inventario.agregarProducto(new Producto("Pelota", 10, 15.0, "Juguete"));
        inventario.agregarProducto(new Producto("Camisa", 5, 50.0, "Ropa"));
        inventario.agregarProducto(new Producto("Oreo", 0, 2.5, "Comestible"));
    }


    public void simularVisitaCliente() {
        // Crear y vender boletos
        Cliente cliente1 = new Cliente(25, 170);
        Boleto boleto1 = new Boleto(cliente1.getEdad(), cliente1.getAltura());
        boleto1.agregarCliente(cliente1);
        boleto1.ventaBoleto(registro);
        boleto1.mostrar();

        Boleto boleto4 = new Boleto(5, 100);
        boleto1.ventaBoleto(registro);
        boleto4.mostrar();

        // Consumo en restaurante
        restaurante.mostrarMenu();
        restaurante.clienteRestaurante(registro);

        //Tienda
        inventario.mostrarInventario();
        inventario.venderProducto("Pelota", 2,registro);
        inventario.reponerProducto("Oreo", 10, registro);

    }

    public void trabajadores(){
        // Añadir trabajador
        Trabajador empl1 = new Trabajador("Raul Mande",20,100,"Administrador",500.0 );
        empl1.mostrarInfoEmpleado();
        gestor.añadirTrabajador(empl1);

        gestor.añadirTrabajador(new Trabajador("Juan Pérez", 35, 101, "Gerente", 450.0));
        gestor.añadirTrabajador(new Trabajador("María López", 28, 102, "Supervisor", 380.0));
        gestor.añadirTrabajador(new Trabajador("Carlos Ruiz", 42, 103, "Técnico", 320.0));

        // mostrar lista de trabajadores
        gestor.mostrarListaTrabajadores();

        // cambio de cargo
        gestor.cambiarCargo(102, "Gerente Adjunto", 4200.00);

        // mostrar lista actualizada
        gestor.mostrarListaTrabajadores();

        // buscar trabajador
        gestor.buscarTrabajador(103);

        // despedir un trabajador
        gestor.despedirTrabajador(101);

        // mostrar lista final
        gestor.mostrarListaTrabajadores();

        // pagar sueldo
        gestor.pagarSueldo(registro);

    }
    public void juegos(){
        //juegoos mecanicos
        JuegoMecanico montañaRusa = new JuegoMecanico("Montaña Rusa", 5, "operativo",
                12, 130, 80.0, 3);
        JuegoMecanico ruedaFortuna = new JuegoMecanico("Rueda de la Fortuna", 8,
                "operativo", 8, 100, 20.0, 5);

        //Esppectaculos
        Espectaculos fuegosArtificiales = new Espectaculos("Noche Mágica", 500,
                "activo", "20:00", "Fuegos Artificiales");
        Espectaculos showDelfines = new Espectaculos("Aventura Marina", 300,
                "activo", "15:30", "Show de Delfines");

        // info espectáculos
        fuegosArtificiales.mostrarInfo();
        fuegosArtificiales.iniciar();

        showDelfines.mostrarInfo();
        showDelfines.iniciar();


        // mostrar informacion del juego
        montañaRusa.mostrarInfo();

        // estado del juego
        montañaRusa.obtenerEstadoActual();

        // mantenimento o fujncionamiento
        ruedaFortuna.cambiarEstado(true);

        // iniciar juegos
        montañaRusa.iniciar();
        ruedaFortuna.iniciar();

        // terminar juegos
        montañaRusa.finalizar();
        ruedaFortuna.finalizar();

    }
    public void mostrarFinanzas() {
        registro.mostrarBalance();
    }

}

