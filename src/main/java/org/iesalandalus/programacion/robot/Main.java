package org.iesalandalus.programacion.robot;

import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.robot.vista.Consola;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Main {

    private static ControladorRobot controladorRobot;

    /**
     * 1ºCREAMOS EL CONSTRUCTOR DEL MAIN
     **/
    public static void main(String[] args)  {
        int opcion = 0;
        do {

            System.out.println("Elige una opción:");
            opcion = Entrada.entero();

            if ((opcion >= 0 && opcion < 5) || controladorRobot != null) {
                try{
                    ejecutarOpcion(opcion);
                    System.out.println(controladorRobot.getRobot().toString());
                }catch(Exception e){
                    System.out.println("No se puede ejecutar: "+e.getMessage() + "\n");
                }

            } else {
                System.out.println("Opción no valida crea un robot antes");
            }
        } while (opcion != 0);
    }

    /**
     * 2º CREAMOS EL METODO QUE EJECUTA LA OPCIÓN ELEJIDA
     **/
    private static void ejecutarOpcion(int opcion) throws RobotException {

        switch (opcion) {
            case 1:
                controlarRobotDefecto();

                break;
            case 2:
                controlarRobotZona();

                break;
            case 3:
                controlarRobotZonaOrientacion();
                break;
            case 4:
                controlarRobotZonaOrientacionCoordenada();
                break;
            case 5:
                ejecutarComando();

                break;
            case 0:
                Consola.despedirse();
                System.exit(0);
            default:
                System.out.println("Opción no válida.");
        }

    }
    /**3º CREAMOS LOS METODOS QUE CONTROLAN LOS ROBOTS SEGÚN LAS OPCIONES ELEJIDAS**/

    /**
     * 3.1 CREAMOS EL CONTROLADOR DE CONTROLAR EL ROBOT POR DEFECTO
     **/
    private static void controlarRobotDefecto() {
        controladorRobot = new ControladorRobot(new Robot());

    }

    /**
     * 3.2 CREAMOS EL CONTROLADOR DE CONTROLAR EL ROBOT CON LA ZONA ESPECIFICADA
     **/
    private static void controlarRobotZona() {


         controladorRobot = new ControladorRobot(new Robot(Consola.elegirZona()));



    }

    /**
     * 3.3 CREAMOS EL CONTROLADOR DE CONTROLAR EL ROBOT CON LA ZONA Y LA ORIENTACIÓN ESPECIFICADAS
     **/
    private static void controlarRobotZonaOrientacion() {


        controladorRobot= new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion()));



    }

    /**
     * 3.4 CREAMOS EL CONTROLADOR DE CONTROLAR EL ROBOT CON LA ZONA, LA ORIENTACIÓN Y LA COORDENADA ESPECIFICADAS
     **/
    private static void controlarRobotZonaOrientacionCoordenada() {


        ControladorRobot controladorRobot= new ControladorRobot(new Robot(Consola.elegirZona(), Consola.elegirOrientacion(), Consola.elegirCoordenada()));


    }

    /**
     * 4º CREAMOS EL METODO QUE EJECUTA UN COMANDO DE MOVIMIENTO DEL ROBOT
     **/
    private static void ejecutarComando() throws RobotException {

        System.out.println("Introduce un comando (A, D, I): ");
        char comando = Entrada.caracter();
        controladorRobot.ejecutar(comando);

    }
}
