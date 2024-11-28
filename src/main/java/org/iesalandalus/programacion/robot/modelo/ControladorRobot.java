package org.iesalandalus.programacion.robot.modelo;


import javax.naming.OperationNotSupportedException;

public class ControladorRobot {

    private Robot robot;


    public ControladorRobot(Robot robot) {
        if(robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = robot;
    }

    public Robot getRobot() {
        return robot;
    }

    public void ejecutar(char comando) throws OperationNotSupportedException, RobotExcepcion {

        switch (Character.toUpperCase(comando)  ) {
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
                throw new OperationNotSupportedException("Comando desconocido.");
        }
    }
}
