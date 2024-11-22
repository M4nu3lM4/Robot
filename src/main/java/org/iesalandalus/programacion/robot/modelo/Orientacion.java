package org.iesalandalus.programacion.robot.modelo;

public enum Orientacion {
    NORTE("Norte"),
    NOROESTE("Noroeste"),
    NORESTE("Noreste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    SURESTE("Sureste"),
    ESTE("Este"),
    OESTE("Oeste");

   private final String nombre;

   Orientacion(String nombre) {
       this.nombre = nombre;
   }

    @Override
    public String toString() {
        return nombre;
    }
}
