package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class ControladorRobot {

    private Robot robot;

    public ControladorRobot(Robot robot){
        Objects.requireNonNull(robot,"El robot no puede ser nulo.");
        this.robot = new Robot();
    }


    public Robot getRobot() {
        return new Robot();
    }


    public void ejecutar(char comando)throws RobotExcepcion{
        try {

            switch (comando){
                case 'A','a' -> robot.avanzar();
                case 'D','d'  -> robot.girarALaDerecha();
                case 'I','i' -> robot.girarALaIzquierda();
                default -> throw new RobotExcepcion("Comando desconocido.");
            }
        } catch (Exception e) {
            throw new RobotExcepcion("Comando desconocido.");
        }


    }
}
