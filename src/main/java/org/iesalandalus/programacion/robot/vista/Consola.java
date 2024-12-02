package org.iesalandalus.programacion.robot.vista;


import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}
/**1º CREAMOS EL CONSTRUCTOR QUE MOSTRARÁ EL MENU PRINCIPAL**/
    public static void mostrarMenuPrincipal() {
        System.out.println("Menú principal");

        System.out.println("1. Controlar robot por defecto");

        System.out.println("2. Controlar robot indicando su zona");

        System.out.println("3. Controlar robot indicando su zona y orientación");

        System.out.println("4. Controlar robot indicando su zona, orientación y coordenada inicial");

        System.out.println("5. Ejecutar comando");

        System.out.println("0. Salir");
    }
/**2º CREAMOS EL METODO QUE ELIGA LA OPCIÓN DEL MENÚ**/
    public static int elegirOpcion() {
        int opcion = -1;
        do {
            mostrarMenuPrincipal();
            System.out.println("Elija una opción del menú:");
            opcion = Entrada.entero();
        } while (opcion < 0 || opcion > 5);
        return opcion;
    }
/**3º CREAMOS EL CONSTRUCTOR QUE NOS DIRA QUE ANCHURA Y QUE ALTURA QUEREMOS PONER EN LA ZONA**/
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
/**4º CREAMOS EL CONSTRUCTOR QUE NOS MOSTRARÁ LAS ORIENTACIONES QUE HAY**/
    public static void mostrarMenuOrientacion() {
        System.out.println("Menú orientación");

        System.out.println("1.Norte ");

        System.out.println("2.Noreste ");

        System.out.println("3.Este ");

        System.out.println("4.Sureste");

        System.out.println("5.Sur ");

        System.out.println("6.Suroeste");

        System.out.println("7.Oeste");

        System.out.println("8.Noroeste");


    }
/**5º CREAMOS EL METODO QUE ELIGA LA ORIENTACIÓN DEL ROBOT**/
    public static Orientacion elegirOrientacion() {
        int opcion;
        do {
            mostrarMenuOrientacion();
            System.out.println("Elija una orientación:");
            opcion = Entrada.entero();
        } while (opcion < 1 || opcion >8);
        switch (opcion){
            case 1: return Orientacion.NORTE;
            case 2: return Orientacion.NOROESTE;
            case 3: return Orientacion.ESTE;
            case 4: return Orientacion.SURESTE;
            case 5: return Orientacion.SUR;
            case 6: return Orientacion.SUROESTE;
            case 7: return Orientacion.OESTE;
            case 8: return Orientacion.NOROESTE;
            default: return null;
        }
    }
/**6º CREAMOS EL CONSTRUCTOR QUE NOS DIRA QUE AÑADAMOS LAS COORDENADAS**/
    public static Coordenada elegirCoordenada() {
        System.out.println("Introduzca el punto X de la coordenada:");
        int x = Entrada.entero();
        System.out.println("Introduzca el punto Y de la coordenada:");
        int y = Entrada.entero();
        return new Coordenada(x, y);
    }
/**7º CREAMOS EL METODO QUE NOS DIRA QUE COMANDO QUEREMOS EJECUTAR**/
    public static char elegirComando() {
        char comando;
        do {

            System.out.println("Elija una opción del menú:");
            comando = Entrada.caracter();
        } while (Character.toLowerCase(comando) != 'a' && Character.toLowerCase(comando) != 'd' && Character.toLowerCase(comando) != 'i'  );
        return comando;
    }
/**8º CREAMOS EL METODO QUE MOSTRARÁ EL ROBOT QUE CONTROLAMOS**/
    public static void mostrarRobot(ControladorRobot controladorRobot) {
        if (controladorRobot == null) {
            System.out.println("El robot es nulo.");
        } else {
            System.out.println(controladorRobot.getRobot().toString());
        }
    }
/**9º CREAMOS EL METODO QUE MOSTRARÁ EL CONTROLADOR DEL ROBOT**/
    public static void despedirse() {
        System.out.println("Gracias por usar nuestra aplicación. ¡Hasta pronto!");
    }
}
