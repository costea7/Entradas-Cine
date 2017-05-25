/**
 * Ficha.java
 * 03/2017
 * @author ccatalan
 */
package Modelo;

/**
 *  Casilla del juego de tablero
 * 
 */
public enum Casilla {
  VACIA, LIBRE, OCUPADA;
      
  /**
   *  Factoria de ficha
   * 
   */   
  public static Casilla instancia(String string) {
     switch(string) {
         case " ":
             return Casilla.VACIA;         
             
         case ".":
             return Casilla.LIBRE;
         
         case "x":
             return Casilla.OCUPADA;
     }  
     return null;
  }
    
  /**
   *  Sobreescribe toString
   * 
   */  
  @Override
  public String toString() {
     switch(this) {
         case VACIA:
             return " ";   
       
         case LIBRE:
             return ".";
       
         case OCUPADA: 
             return "x";
     }
     return "";
   }     
}
