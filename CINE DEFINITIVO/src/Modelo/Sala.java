package Modelo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;

/**
* Sala
*
* @author Alex Costea y Aitor Mari
*/
public class Sala {
	
  private final int numero;
  ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
  Iterator<Sesion> nueva = sesiones.iterator();
  private String mapaAsientos;
  
  static final String msgError = "Error! Sesión no existe: ";
  
  /**
   * Crea una sala
   * 
   * @param numero
   */
  public Sala(int numero, String mapaAsientos) {	
    this.numero = numero;
    this.mapaAsientos = mapaAsientos;
  }

  /**
   * Crea una sesión para una sala
   * 
   */
  public boolean nuevaSesion(Sesion sesion) throws FileNotFoundException{
      sesiones.add(sesion);
      return true;
  }
	
  /**
   * Dado un entero, busca una platea que
   * lo tenga como id
   * 
   */
  public Sesion buscarSesion(int idSesion){	
    for (int i=0; i<sesiones.size();i++) {
        Sesion sesion=sesiones.get(i);
          if (sesion.devuelveId() == idSesion){
            return sesion;
      }
    }
  return null;
  }
	

	
  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   * de una sesión
   *
   * @param idSesion
   * @param nombrePlatea
   * @return 
   * 
   */
  public void generarMapaOcupacion(Sesion sesion) throws FileNotFoundException{
     sesion.generarMapaOcupacion();
  }
	
  public int devuelveNumero() {
    return numero;
  }
  
  public String devuelveMapaAsientos() {
    return mapaAsientos;
  }
  

  /**
   * String devuelve entrada
   * 
   * @param idSesion
   * @param nombrePlatea
   * @param fila
   * @param numero 
   * @return 
   */
  public String comprarEntrada(int idSesion, int fila, 
          int numero) {
    String s = "";         
    try{        
      Sesion sesion = buscarSesion(idSesion);   
      s = s + devuelveNumero() + "\n";
      s = s + sesion.comprarEntrada(fila, numero);
      }
    catch(NullPointerException e) {
      return "\n" + msgError + idSesion;
    }
    return s;
  }	
}