package org.iesalandalus.programacion.robot.modelo;
/**1ºCREAMOS EL ENUMERADO DE LAS DIRECCIONES DEL ROBOT **/
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
