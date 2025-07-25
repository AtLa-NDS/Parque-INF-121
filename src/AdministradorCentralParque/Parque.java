package AdministradorCentralParque;

import BD.TrabajadorBD;
import boleto.*;
import juegos.*;
import personas.*;
import restaurante.*;
import Tienda.*;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

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
        // sin esto no se puede emplear el metod de verificar
        JuegoMecanico ruedaFortuna = new JuegoMecanico("Rueda de la Fortuna", 8,
                "operativo", 8, 100, 20.0, 5);

        // Crear y vender boletos
        Cliente cliente1 = new Cliente(25, 170);
        Boleto boleto1 = new Boleto(cliente1.getEdad(), cliente1.getAltura());
        boleto1.agregarCliente(cliente1);
        boleto1.ventaBoleto(registro);
        boleto1.mostrar();

        Boleto boleto4 = new Boleto(5, 100);
        boleto4.ventaBoleto(registro);
        boleto4.mostrar();
        ruedaFortuna.permitirAcceso(boleto4,registro);



        // Consumo en restaurante
        restaurante.mostrarMenu();
        restaurante.clienteRestaurante(registro);

        //Tienda
        inventario.mostrarInventario();
        inventario.venderProducto("Pelota", 2,registro);
        inventario.reponerProducto("Oreo", 10, registro);

    }

    public void trabajadores(){
        try {
            Gson gson = new Gson();
            FileReader reader = new FileReader("trabajadores.json");

            Type listaTrabajadores = new TypeToken<List<Trabajador>>() {}.getType();
            List<Trabajador> trabajadores = gson.fromJson(reader, listaTrabajadores);

            for (Trabajador t : trabajadores) {
                TrabajadorBD.insertarTrabajador(t);
                gestor.añadirTrabajador(t);
            }
            System.out.println("Los trabajadores fueron agragasdos correctamente");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("No se pudo cargar a los trabajadores " + e.getMessage());
        }
        // a;adir manuealmente trabajadores
        /*
        Trabajador t1 = new Trabajador("Juan Pérez", 30, 12345, "Supervisor", 2500.00);
        TrabajadorBD.insertarTrabajador(t1);

        Trabajador t2 = new Trabajador("María Gómez", 25, 23456, "Cajera", 1800.50);
        TrabajadorBD.insertarTrabajador(t2);

        Trabajador t3 = new Trabajador("Carlos Ruiz", 40, 34567, "Mecánico", 3200.75);
        TrabajadorBD.insertarTrabajador(t3);

        Trabajador t4 = new Trabajador("Lucía Torres", 29, 45678, "Guía de parque", 2100.00);
        TrabajadorBD.insertarTrabajador(t4);

        Trabajador t5 = new Trabajador("Andrés López", 35, 56789, "Encargado de seguridad", 2800.90);
        TrabajadorBD.insertarTrabajador(t5);
        */
        // Añadir trabajador
        Trabajador empl1 = new Trabajador("Raul Mande",20,100,"Administrador",500.0 );
        empl1.mostrarInfoEmpleado();
        gestor.añadirTrabajador(empl1);

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
        //gestor.pagarSueldo(registro);

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

