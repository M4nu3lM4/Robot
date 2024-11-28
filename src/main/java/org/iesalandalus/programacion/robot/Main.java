package org.iesalandalus.programacion.robot;
import org.iesalandalus.programacion.robot.modelo.*;
import org.iesalandalus.programacion.utilidades.Entrada;
import org.iesalandalus.programacion.robot.*;
public class Main {

    private ControladorRobot controladorRobot;

    public static void main(String[] args) {


        private static void ejecutarOpcion(int opcion){

            System.out.println("Por favor elija una opción:");


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
                    System.exit(0);
                default:
                    System.out.println("Opción no válida.");
            }

        }


    }

    private static void controlarRobotDefecto() {

        Robot robot = new Robot();

    }

    private static void controlarRobotZona() {

        Robot robot = new Robot(new Zona());

    }

    private static void controlarRobotZonaOrientacion() {

        Robot robot = new Robot(new Zona(), Orientacion.NORTE);


    }

    private static void controlarRobotZonaOrientacionCoordenada() {

        Robot robot = new Robot(new Zona(), Orientacion.NORTE, new Coordenada(0, 0));

    }

    private static void ejecutarComando() {


        Robot robot = new Robot();

        controladorRobot = new ControladorRobot(robot);
    }
}
