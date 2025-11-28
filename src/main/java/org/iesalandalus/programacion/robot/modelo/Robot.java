package org.iesalandalus.programacion.robot.modelo;

import java.util.Objects;

public class Robot {
    private Zona zona;
    private Coordenada coordenada;
    private Orientacion orientacion;


    public Robot() {
        zona = new Zona();
        orientacion = Orientacion.NORTE;
        coordenada = zona.getCentro();

    }

    public Robot(Zona zona) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");
        setZona(zona);
        setOrientacion(Orientacion.NORTE);
        setCoordenada(zona.getCentro());

    }

    public Robot(Zona zona, Orientacion orientacion) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");

        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");

        setZona(zona);

        setOrientacion(orientacion);

        setCoordenada(zona.getCentro());
    }

    public Robot(Zona zona, Orientacion orientacion, Coordenada coordenada) {
        Objects.requireNonNull(zona, "La zona no puede ser nula.");

        Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");

        Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");

        setZona(zona);

        setOrientacion(orientacion);

        setCoordenada(coordenada);
    }

    public Robot(Robot robot) {
        Objects.requireNonNull(robot, "El robot no puede ser nulo.");

        zona = robot.getZona();

        orientacion = robot.getOrientacion();

        coordenada = robot.getCoordenada();

    }

    public Zona getZona() {
        return zona;
    }

    private void setZona(Zona zona) {
        this.zona = Objects.requireNonNull(zona, "La zona no puede ser nula.");
    }

    public Orientacion getOrientacion() {
        return orientacion;
    }

    private void setOrientacion(Orientacion orientacion) {
        this.orientacion = Objects.requireNonNull(orientacion, "La orientación no puede ser nula.");
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    private void setCoordenada(Coordenada coordenada) throws IllegalArgumentException {
        this.coordenada = Objects.requireNonNull(coordenada, "La coordenada no puede ser nula.");
        if (this.zona.pertenece(coordenada)) {
            this.coordenada = coordenada;
        } else {
            throw new IllegalArgumentException("La coordenada no pertenece a la zona.");
        }
    }

    public void avanzar() throws RobotExcepcion {

        int nuevaCoordenadaX = coordenada.x();
        int nuevaCoordenadaY = coordenada.y();


        switch (orientacion) {


            case NORTE -> nuevaCoordenadaY++;

            case NORESTE -> {
                nuevaCoordenadaX++;
                nuevaCoordenadaY++;
            }

            case ESTE -> nuevaCoordenadaX++;

            case SURESTE -> {
                nuevaCoordenadaX++;
                nuevaCoordenadaY--;
            }

            case SUR -> nuevaCoordenadaY--;

            case SUROESTE -> {
                nuevaCoordenadaX--;
                nuevaCoordenadaY--;
            }

            case OESTE -> nuevaCoordenadaX--;

            case NOROESTE -> {
                nuevaCoordenadaX--;
                nuevaCoordenadaY++;
            }

        }
        try {
            setCoordenada(new Coordenada(nuevaCoordenadaX, nuevaCoordenadaY));
        } catch (IllegalArgumentException iae) {
            throw new RobotExcepcion("No se puede avanzar ya que se sale de la zona");
        }

    }

    public void girarALaDerecha() {
        switch (orientacion) {
            case NORTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.SUR);
            case SUR -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.NORTE);
        }


    }

    public void girarALaIzquierda() {

        switch (orientacion) {
            case NORTE -> setOrientacion(Orientacion.NOROESTE);
            case NOROESTE -> setOrientacion(Orientacion.OESTE);
            case OESTE -> setOrientacion(Orientacion.SUROESTE);
            case SUROESTE -> setOrientacion(Orientacion.SUR);
            case SUR -> setOrientacion(Orientacion.SURESTE);
            case SURESTE -> setOrientacion(Orientacion.ESTE);
            case ESTE -> setOrientacion(Orientacion.NORESTE);
            case NORESTE -> setOrientacion(Orientacion.NORTE);
        }


    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Robot robot = (Robot) o;
        return Objects.equals(zona, robot.zona) && Objects.equals(coordenada, robot.coordenada) && orientacion == robot.orientacion;
    }

    @Override
    public int hashCode() {
        return Objects.hash(zona, coordenada, orientacion);
    }

    @Override
    public String toString() {
        return "Robot[" +
                "zona=" + zona +
                ", coordenada=" + coordenada +
                ", orientacion=" + orientacion +
                ']';
    }
}
