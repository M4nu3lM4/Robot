package org.iesalandalus.programacion.robot.modelo;

public record Zona(int ancho, int alto) {

    private static final int ANCHO_MINIMO = 10;
    private static final int ANCHO_MAXIMO = 100;
    private static final int ALTO_MINIMO = 10;
    private static final int ALTO_MAXIMO = 100;

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
            throw new IllegalArgumentException("El ancho debe estar entre " + ANCHO_MINIMO + " y " + ANCHO_MAXIMO);
        }
    }
/**3º CREAMOS EL CONSTRUCTOR QUE VALIDA EL ALTO **/
    private static void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("El alto debe estar entre " + ALTO_MINIMO + " y " + ALTO_MAXIMO);
        }
    }
    /**5º CREAMOS EL METODO QUE DEVUELVE SI LA COORDENADA PERTENECE A LA ZONA **/
    public boolean pertenece(Coordenada coordenada) {
        return coordenada != null &&
                coordenadaXValida(coordenada.x()) &&
                coordenadaYValida(coordenada.y());
    }
/**6ºCREAMOS EL METODO QUE DEVUELVE EL ANCHO DE LA ZONA **/
    private boolean coordenadaXValida(int x) {
        return x >= 0 && x < ancho;
    }
/**7ºCREAMOS EL METODO QUE DEVUELVE EL ALTO DE LA ZONA **/
    private boolean coordenadaYValida(int y) {
        return y >= 0 && y < alto;
    }
/**8º CREAMOS EL METODO QUE DEVUELVE EL CENTRO DE LA ZONA **/
    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }
}
