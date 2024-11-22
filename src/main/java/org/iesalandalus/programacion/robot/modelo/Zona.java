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

    public Zona() {
        this(ANCHO_MINIMO, ALTO_MINIMO);
    }

    private static void validarAncho(int ancho) {
        if (ancho < ANCHO_MINIMO || ancho > ANCHO_MAXIMO) {
            throw new IllegalArgumentException("El ancho debe estar entre " + ANCHO_MINIMO + " y " + ANCHO_MAXIMO);
        }
    }

    private static void validarAlto(int alto) {
        if (alto < ALTO_MINIMO || alto > ALTO_MAXIMO) {
            throw new IllegalArgumentException("El alto debe estar entre " + ALTO_MINIMO + " y " + ALTO_MAXIMO);
        }
    }

    public boolean pertenece(Coordenada coordenada) {
        return coordenada != null &&
                coordenadaXValida(coordenada.x()) &&
                coordenadaYValida(coordenada.y());
    }

    private boolean coordenadaXValida(int x) {
        return x >= 0 && x < ancho;
    }

    private boolean coordenadaYValida(int y) {
        return y >= 0 && y < alto;
    }

    public Coordenada getCentro() {
        return new Coordenada(ancho / 2, alto / 2);
    }
}
