package org.iesalandalus.programacion.robot.modelo;


public class ControladorRobot {

    private Robot robot;

/**1º CREAMOS EL CONSTRUCTOR DEL CONTROLADOR**/
    public ControladorRobot(Robot robot) {
        if(robot == null){
            throw new NullPointerException("El robot no puede ser nulo.");
        }
        this.robot = new Robot(robot);
    }
/**2º CREAMOS EL GETTER PARA OBTENER EL ROBOT**/
    public  Robot getRobot() {

        return new Robot(robot);


    }
/**3º CREAMOS EL CONSTRUCTOR EJECUTAR PARA EJECUTAR UN COMANDO DE MOVIMIENTO**/
    public void ejecutar(char comando) throws RobotException {

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
                throw new RobotException("Comando desconocido.");
        }
    }
}
