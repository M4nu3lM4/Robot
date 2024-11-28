package org.iesalandalus.programacion.robot.modelo;
import javax.naming.*;
import javax.naming.OperationNotSupportedException;
import java.util.Objects;

public class Robot {
    private Coordenada coordenada;
    private Zona zona;
    private Orientacion orientacion;

    /**
     * 1º CREAMOS EL CONSTRUCTOR ROBOT POR DEFECTO
     **/
    public Robot() {
        this.zona = new Zona();
        this.orientacion = Orientacion.NORTE;
        this.coordenada = this.zona.getCentro();
    }

    /**
     * 2º CREAMOS EL CONSTRUCTOR DEL ROBOT CON EL PARÁMETRO ZONA
     **/
    public Robot(Zona zona) {

        if (zona == null){
            throw new NullPointerException("La zona no puede ser nula.");
        }

        this.zona = zona;
        this.orientacion = Orientacion.NORTE;
        this.coordenada = this.zona.getCentro();




    }

    /**
     * 3º CONSTRUCTOR DEL ROBOT CON LOS PARÁMETROS ZONA Y ORIENTACION
     **/
    public Robot(Zona zona, Orientacion orientacion) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = this.zona.getCentro();
    }

    /**
     * 4º CONSTRUCTOR DEL ROBOT CON TODOS LOS PARÁMETROS
     **/
    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        if (zona == null) {
            throw new NullPointerException("La zona no puede ser nula.");
        }
        if (orientacion == null) {
            throw new NullPointerException("La orientación no puede ser nula.");
        }
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula.");
        }
        if (!zona.pertenece(coordenada)) {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
        this.zona = zona;
        this.orientacion = orientacion;
        this.coordenada = coordenada;
    }

    /**
     * 5º CONSTRUCTOR COPIA DE ROBOT
     **/
    public Robot(Robot robot) {

        if (robot == null) {
            throw new NullPointerException("El robot no puede ser nulo.");
        }

        this.zona = robot.getZona();
        this.orientacion = robot.getOrientacion();
        this.coordenada = robot.getCoordenada();


    }
/**6º METODOS SETTER Y GETTER PARA zona, orientacion y coordenada **/

    /**
     * 1. METODO GETCOORDENADA OBTENEMOS LA COORDENADA
     **/
    public Coordenada getCoordenada() {
        return coordenada;
    }

    /**
     * 1.1 METODO SETCOORDENADA ASIGNAMOS UNA COORDENADA
     **/
    private void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    /**
     * 2. METODO GETZONA OBTENEMOS LA ZONA
     **/
    public Zona getZona() {
        return zona;
    }

    /**
     * 2.1 METODO SETZONA ASIGNAMOS UNA ZONA
     **/
    private void setZona(Zona zona) {
        this.zona = zona;
    }

    /**
     * 3. METODO GETORIENTACION OBTENEMOS LA ORIENTACION
     **/
    public Orientacion getOrientacion() {
        return orientacion;
    }

    /**
     * 3.1 METODO SETORIENTACION ASIGNAMOS UNA ORIENTACION
     **/
    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }

    /**
     * 7º METODO AVANZAR HACEMOS QUE EL ROBOT AVANZE
     **/
    public void avanzar() throws RobotExcepcion {

        int x = coordenada.x();

        int y = coordenada.y();

        switch (orientacion) {

            case NORTE -> y++;

            case NORESTE -> {
                y++;
                x++;
            }

            case ESTE -> x++;

            case SURESTE -> {
                y--;
                x++;
            }

            case SUR -> y--;

            case SUROESTE -> {
                y--;
                x--;
            }

            case OESTE -> x--;

            case NOROESTE -> {
                y++;
                x--;
            }

            default -> throw new RobotExcepcion("Orientación desconocida: " + orientacion);

        }

        Coordenada nuevaCoordenada = new Coordenada(x, y);
        if (zona.pertenece(nuevaCoordenada)) {
            this.coordenada = nuevaCoordenada;
        } else{
            throw new RobotExcepcion("No se puede avanzar, ya que se sale de la zona.");
        }

    }


    /**8º CREAMOS EL METODO GIRARALADERECHA**/
    public void girarALaDerecha() {

        this.orientacion = this.orientacion.next();
    }

    /**9º CREAMOS EL METODO GIRARALAIZQUIERDA**/
    public void girarALaIzquierda() {
        this.orientacion = this.orientacion.previous();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(coordenada, robot.coordenada) && Objects.equals(zona, robot.zona) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coordenada, zona, orientacion);
    }


    @Override
    public String toString() {
        return String.format("Zona[coordenada=%s, zona=%s, orientacion=%s]", coordenada, zona, orientacion);
    }
}