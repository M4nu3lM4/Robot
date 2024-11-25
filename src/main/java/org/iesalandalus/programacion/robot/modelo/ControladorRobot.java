package org.iesalandalus.programacion.robot.modelo;


public class ControladorRobot {

    private Robot robot;


    public ControladorRobot(Robot robot) {
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public char ejecutar(char comando)throws RobotExcepcion {

        switch (comando) {
            case 'A':
                robot.avanzar();
                break;
            case 'D':
                robot.girarALaDerecha();
                break;
            case 'I':
                robot.girarALaIzquierda();
                break;
            default:
                throw new RobotExcepcion("Comando no válido");
        }

        return comando;
    }
}
