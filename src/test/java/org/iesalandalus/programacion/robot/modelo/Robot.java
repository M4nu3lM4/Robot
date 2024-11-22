package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
        private Coordenada coordenada;
        private Zona zona;
        private Orientacion orientacion;

   public Robot(){


   }
    public Robot(Zona zona) {

        this.zona = zona;
    }

    public Robot(Zona zona, Orientacion orientacion) {
        this(zona);
        this.orientacion = orientacion;
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        this(zona, orientacion);
        this.coordenada = coordenada;
    }
    /**3º CONSTRUCTOR COPIA DE ROBOT **/
    public Robot(Robot robot) {

        this.zona = robot.zona;
        this.orientacion = robot.orientacion;
        this.coordenada = robot.coordenada;

    }
/**4º METODOS SETTER Y GETTER PARA zona, orientacion y coordenada **/

/**1. METODO GETCOORDENADA OBTENEMOS LA COORDENADA **/
    public Coordenada getCoordenada() {
        return coordenada;
    }
/**1.1 METODO SETCOORDENADA ASIGNAMOS UNA COORDENADA **/
    private void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
/**2. METODO GETZONA OBTENEMOS LA ZONA **/
    public Zona getZona() {
        return zona;
    }
/**2.1 METODO SETZONA ASIGNAMOS UNA ZONA **/
    private void setZona(Zona zona) {
        this.zona = zona;
    }
/**3. METODO GETORIENTACION OBTENEMOS LA ORIENTACION **/
    public Orientacion getOrientacion() {
        return orientacion;
    }
/**3.1 METODO SETORIENTACION ASIGNAMOS UNA ORIENTACION **/
    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = orientacion;
    }
/**4º METODO AVANZAR HACEMOS QUE EL ROBOT AVANZE **/
    public void avanzar(){
        int x = coordenada.x();
        int y = coordenada.y();

        switch (orientacion) {
            case NORTE:
                y++;
                break;
            case NORESTE:
                x++;
                y++;
                break;
            case ESTE:
                x++;
                break;
            case SURESTE:
                x++;
                y--;
                break;
            case SUR:
                y--;
                break;
            case SUROESTE:
                x--;
                y--;
                break;
            case OESTE:
                x--;
                break;
            case NOROESTE:
                x--;
                y++;
                break;
        }

        Coordenada nuevaCoordenada = new Coordenada(x, y);


    }

    public void girarDerecha(){

        switch (orientacion) {

        case NORTE:
            orientacion = Orientacion.ESTE;
            break;

            case NORESTE:
                orientacion = Orientacion.NORTE;
                break;

            case ESTE:
                orientacion = Orientacion.NOROESTE;
                break;

            case SURESTE:
                orientacion = Orientacion.NORESTE;
                break;

            case SUR:
                orientacion = Orientacion.ESTE;
                break;

            case SUROESTE:
                orientacion = Orientacion.SUR;
                break;

            case OESTE:
                orientacion = Orientacion.SUROESTE;
                break;

            case NOROESTE:
                orientacion = Orientacion.SUR;
                break;

                default:
                    throw new IllegalStateException("Orientación inválida");
        }

    }



    public void girarIzquierda() {

        switch (orientacion) {

            case NORTE:
                orientacion = Orientacion.OESTE;
                break;

            case NORESTE:
                orientacion = Orientacion.NORTE;
                break;

            case ESTE:
                orientacion = Orientacion.NORESTE;
                break;

            case SURESTE:
                orientacion = Orientacion.ESTE;
                break;

            case SUR:
                orientacion = Orientacion.OESTE;
                break;

            case SUROESTE:
                orientacion = Orientacion.NORTE;
                break;

            case OESTE:
                orientacion = Orientacion.SUROESTE;
                break;

            case NOROESTE:
                orientacion = Orientacion.ESTE;
                break;

            default:
                throw new IllegalStateException("Orientación inválida");

        }

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
        return String.format("[coordenada=%s, zona=%s, orientacion=%s]", coordenada, zona, orientacion);
    }

}
