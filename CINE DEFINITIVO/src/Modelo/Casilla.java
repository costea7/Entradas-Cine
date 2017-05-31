/**
 * Ficha.java
 * 03/2017
 * @author ccatalan
 */
package Modelo;

/**
 *  Ficha del juego de tablero
 * 
 */
public enum Casilla {
  VACIA, LIBRE, OCUPADA;
      
  /**
   *  Factoria de ficha
   * 
   */   

    
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
     return " ";
   }     
}
