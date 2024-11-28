package org.iesalandalus.programacion.robot.modelo;
/**1ºCREAMOS EL ENUMERADO DE LAS DIRECCIONES DEL ROBOT **/
public enum Orientacion {
    NORTE("Norte"),
    NORESTE("Noreste"),
    ESTE("Este"),
    SURESTE("Sureste"),
    SUR("Sur"),
    SUROESTE("Suroeste"),
    OESTE("Oeste"),
    NOROESTE("Noroeste");


   private final String nombre;

   Orientacion(String nombre) {
       this.nombre = nombre;
   }

    @Override
    public String toString() {
        return nombre;
    }

    /**2º Metodo para obtener el siguiente valor del enum**/
    public Orientacion next() {
        Orientacion[] valores = Orientacion.values(); // Obtener todos los valores del enum
        int currentIndex = this.ordinal(); // Obtener el índice del valor actual
        int nextIndex = (currentIndex + 1) % valores.length; // Calcular el siguiente índice (usando % para hacer circular)
        return valores[nextIndex]; // Devolver el siguiente valor
    }

    /**3º Metodo para obtener el valor anterior del enum**/
    public Orientacion previous() {
        Orientacion[] valores = Orientacion.values(); // Obtener todos los valores del enum
        int currentIndex = this.ordinal(); // Obtener el índice del valor actual
        int previousIndex = (currentIndex - 1 + valores.length) % valores.length; // Calcular el índice anterior (usando % para hacer circular)
        return valores[previousIndex]; // Devolver el valor anterior
    }
}
