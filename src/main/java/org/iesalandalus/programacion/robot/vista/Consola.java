package org.iesalandalus.programacion.robot.vista;
import org.iesalandalus.programacion.robot.modelo.Robot;
import org.iesalandalus.programacion.robot.modelo.ControladorRobot;
import org.iesalandalus.programacion.robot.modelo.Zona;
import org.iesalandalus.programacion.robot.modelo.RobotExcepcion;
import org.iesalandalus.programacion.robot.modelo.Orientacion;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {

    private Consola() {}

    public mostrarMenuPrincipal(){

        int opcion;
    System.out.println("Menú principal");
    System.out.println("Seleccione una opción:");
    opcion = Entrada.entero();
        System.out.println("1. Añadir robot");
        System.out.println("2. Mostrar robots");
        System.out.println("3. Ejecutar comando");
        System.out.println("0. Salir");

    }

    public int elegirOpcion(){

        return Entrada.entero();


    }

    public Zona elegirZona(){

        int opcion;
        System.out.println("Elija una zona:");
        System.out.println("1. Zona 1");
        System.out.println("2. Zona 2");
        System.out.println("3. Zona 3");
        opcion = Entrada.entero();

    }

    



}
