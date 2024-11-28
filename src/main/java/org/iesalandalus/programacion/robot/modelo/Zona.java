package org.iesalandalus.programacion.robot.modelo;
import java.util.Objects;
import org.iesalandalus.programacion.robot.modelo.Coordenada;

import org.iesalandalus.programacion.robot.modelo.Orientacion;
public record Zona(int ancho, int alto) {

    public static final int ANCHO_MINIMO = 10;
    public static final int ANCHO_MAXIMO = 100;
    public static final int ALTO_MINIMO = 10;
    public static final int ALTO_MAXIMO = 100;

    public Zona {
        validarAncho(ancho);
        validarAlto(alto);
    }


    /**1º CREAMOS EL CONSTRUCTOR QUE RECIBE LOS VALORES MINIMOS Y MAXIMOS **/
    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }
    /**2º CREAMOS EL CONSTRUCTOR QUE VALIDA EL ANCHO **/
    private static void validarAncho(int ancho)  {

        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido.");
        }


    }
    /**3º CREAMOS EL CONSTRUCTOR QUE VALIDA EL ALTO **/
    private static void validarAlto(int alto) {

        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido.");
        }
    }
    /**4º CREAMOS EL METODO QUE DEVUELVE EL CENTRO DE LA ZONA **/
    public Coordenada getCentro() {

        int coordenadaX = ancho / 2;
        int coordenadaY = alto / 2;
        return new Coordenada(coordenadaX,coordenadaY);

    }
    /**5º CREAMOS EL METODO QUE DEVUELVE SI LA COORDENADA PERTENECE A LA ZONA **/
    public boolean pertenece(Coordenada coordenada) {
        if (coordenada == null) {
            throw new NullPointerException("La coordenada no puede ser nula");
        }
        return this.perteneceX(coordenada.x()) && this.perteneceY(coordenada.y());
    }

    private boolean perteneceX(int x) {

      return  x >= 0 && x < this.ancho;



    }
    private boolean perteneceY(int y) {

        return  y >= 0 && y < this.alto;


    }
}