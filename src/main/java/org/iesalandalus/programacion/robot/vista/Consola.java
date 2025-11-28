package org.iesalandalus.programacion.robot.vista;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.robot.modelo.ControladorRobot;

import java.util.Objects;

public class Consola {

    private Consola() {
    }

    public static void mostrarMenuPrincipal() {

        System.out.println("--------- ROBOT ---------");
        System.out.println("1º Controlar robot por defecto.");
        System.out.println("2º Controlar robot indicando su zona.");
        System.out.println("3º Controlar robot indicando su zona y orientación.");
        System.out.println("4º Controlar robot indicando su zona, orientación y coordenada inicial.");
        System.out.println("5º Ejecutar comando.");
        System.out.println("0º Salir");
    }

    public static int elegirOpcion() {
        int opcion;
        do {
            System.out.print("Elige una opción: ");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }

    public static Zona elegirZona() {
        Zona zona = null;
        do {
            System.out.print("Introduce el ancho para la zona: ");
            int ancho = Entrada.entero();

            System.out.print("Introduce el alto para la zona: ");
            int alto = Entrada.entero();
            try {
                zona = new Zona(ancho, alto);
            } catch (IllegalArgumentException iae) {
                System.out.println("ERROR: " + iae.getMessage());
            }
        } while (zona == null);
        return zona;


    }

    public static void mostrarMenuOrientacion() {
        System.out.println("Orientaciones");
        System.out.println("-------------");
        System.out.println();
        System.out.println("1.Norte");
        System.out.println("2.Noreste");
        System.out.println("3.Este");
        System.out.println("4.Sureste");
        System.out.println("5.Sur");
        System.out.println("6.Suroeste");
        System.out.println("7.Oeste");
        System.out.println("8.Noroeste");


    }

    public static Orientacion elegirOrientacion() {
        int orientacion;

        do {
            System.out.print("Elige una opción válida: ");
            orientacion = Entrada.entero();
        } while (orientacion < 1 || orientacion > 8);
        return switch (orientacion) {
            case 1 -> Orientacion.NORTE;


            case 2 -> Orientacion.NORESTE;


            case 3 -> Orientacion.ESTE;


            case 4 -> Orientacion.SURESTE;


            case 5 -> Orientacion.SUR;


            case 6 -> Orientacion.SUROESTE;


            case 7 -> Orientacion.OESTE;


            case 8 -> Orientacion.NOROESTE;

            default -> null;
        };

    }

    public static Coordenada elegirCoordenada() {
        System.out.print("Introduce la coordenada X: ");
        int x = Entrada.entero();
        System.out.print("Introduce la coordenada Y: ");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }

    public static char elegirComando() {

        System.out.print("Introduce un comando válido: ");
        return Entrada.caracter();

    }

    public static void mostrarRobot(ControladorRobot controladorRobot) {
        System.out.println();
        Objects.requireNonNull(controladorRobot, "Aun no se ha creado ningún robot para controlar.");
        System.out.println(controladorRobot.getRobot());
        System.out.println();
    }

    public static void despedirse() {
        System.out.println("!!Hasta luego Lucas¡¡");
    }

}
