package org.iesalandalus.programacion.robot.vista;


import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.robot.modelo.Coordenada;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}

    public static void mostrarMenuPrincipal() {
        System.out.println("Menú principal");
        System.out.println("1. Controlar robot por defecto");
        System.out.println("2. Controlar robot indicando su zona");
        System.out.println("3. Controlar robot indicando su zona y orientación");
        System.out.println("4. Controlar robot indicando su zona, orientación y coordenada inicial");
        System.out.println("5. Ejecutar comando");
        System.out.println("0. Salir");
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            mostrarMenuPrincipal();
            System.out.println("Elija una opción del menú:");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public static Zona elegirZona() {
        int ancho, alto;
        do {
            System.out.println("Introduzca el ancho de la zona (mínimo 10, máximo 100):");
            ancho = Entrada.entero();
            System.out.println("Introduzca el alto de la zona (mínimo 10, máximo 100):");
            alto = Entrada.entero();
        } while (ancho < 10 || ancho > 100 || alto < 10 || alto > 100);
        return new Zona(ancho, alto);
    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Orientaciones disponibles:");
        for (Orientacion orientacion : Orientacion.values()) {
            System.out.println(orientacion.ordinal() + ". " + orientacion);
        }
    }

    public static Orientacion elegirOrientacion() {
        int opcion;
        do {
            mostrarMenuOrientacion();
            System.out.println("Elija una orientación:");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion >= Orientacion.values().length);
        return Orientacion.values()[opcion];
    }

    public static Coordenada elegirCoordenada() {
        System.out.println("Introduzca la componente X de la coordenada:");
        int x = Entrada.entero();
        System.out.println("Introduzca la componente Y de la coordenada:");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static String elegirComando() {
        System.out.println("Introduzca el comando a ejecutar:");
        return Entrada.cadena();
    }

    public static void mostrarRobot(Robot robot) {
        if (robot == null) {
            System.out.println("El robot es nulo.");
        } else {
            System.out.println(robot);
        }
    }

    public static void despedirse() {
        System.out.println("Gracias por usar nuestra aplicación. ¡Hasta pronto!");
    }
}
