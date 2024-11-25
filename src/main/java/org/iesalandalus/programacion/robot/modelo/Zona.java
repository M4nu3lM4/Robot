package org.iesalandalus.programacion.robot.modelo;

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
    private static void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("Ancho no válido");
        }
    }
/**3º CREAMOS EL CONSTRUCTOR QUE VALIDA EL ALTO **/
    private static void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("Alto no válido");
        }
    }
    /**4º CREAMOS EL METODO QUE DEVUELVE EL CENTRO DE LA ZONA **/
    public Coordenada getCentro() {
        int CoordenadaX
        return new Coordenada(ancho / 2, alto / 2);
    }
    /**5º CREAMOS EL METODO QUE DEVUELVE SI LA COORDENADA PERTENECE A LA ZONA **/
    public boolean pertenece(Coordenada coordenada) {
       if (coordenada == null) {
           throw new NullPointerException("La coordenada no puede ser nula") ;
       }
/**
        boolean perteneceX = this.perteneceX(coordenada.x());
        boolean perteneceY = this.perteneceY(coordenada.y());

        if (perteneceX == true && perteneceY == true) {
            return true;
        } else {
            return false;
        }
    }
 **/
return this.perteneceX(coordenada.x()) && this.perteneceY(coordenada.y());

    }
/**6ºCREAMOS EL METODO QUE DEVUELVE EL ANCHO DE LA ZONA **/
    private boolean perteneceX(int x) {

    if ( x >= 0 && x < this.ancho) {
        return true;
    }else {
        return false;
    }

    }
/**7ºCREAMOS EL METODO QUE DEVUELVE EL ALTO DE LA ZONA **/
    private boolean perteneceY(int y) {
        if (y >= 0 && y < this.alto) {
            return true;
        } else {
            return false;
        }
    }


}
