package org.iesalandalus.programacion.robot.modelo;


import javax.naming.OperationNotSupportedException;

public class ControladorRobot {

    private Robot robot;


    public ControladorRobot(Robot robot) {
        if(robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = new Robot(robot);
    }
/**2º CREAMOS EL GETTER PARA OBTENER EL ROBOT**/
    public Robot getRobot() {

        return new Robot(robot);


    }
/**3º CREAMOS EL CONSTRUCTOR EJECUTAR PARA EJECUTAR UN COMANDO DE MOVIMIENTO**/
    public void ejecutar(char comando) throws RobotExcepcion {

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
                throw new RobotExcepcion("Comando desconocido.");
        }
    }
}
