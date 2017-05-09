package Modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
* Sala
*
* @author Alex Costea y Aitor Mari
*/
public class Sala {
	
  private final int numero;
  
  ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
  Iterator<Sesion> nueva = sesiones.iterator();
  
 // private List<Sesion> sesiones;
  
  private int numSesiones;
  public int MAX_SESIONES = 500;
  static final String msgError = "Error! Sesión no existe: ";
  
  /**
   * Crea una sala
   * 
   * @param numero
   */
  public Sala(int numero) {	
    this.numero = numero;
   
  }

  /**
   * Crea una sesion para una sala
   * 
   */
  public boolean nuevaSesion(Sesion sesion){
   
      sesiones.add(numSesiones++, sesion);
      //numSesiones++; // igual sobra
      return true;
    
    // false;
  }
	
  /**
   * Dado un entero, busca una platea que
   * lo tenga como id
   * 
   */
  public Sesion buscarSesion(int idSesion){	
    nueva = sesiones.iterator();
    while(nueva.hasNext()){
	Sesion elemento = nueva.next();
        if (elemento.devuelveId() == idSesion){
            return elemento;
        }
    }
    /*
    for (int i = 0; i < numSesiones; i++) {	
      if(sesiones.equals(idSesion)){
        return sesiones.;
      }
    }*/
  return null;
  }
	
  /**
   * Crea una platea para una sesion
   * 
   * @param idSesion
   * @param platea
   * @return 
   */
  public boolean nuevaPlatea(int idSesion, Platea platea) {        
    Sesion sesion = buscarSesion(idSesion);
    if (sesion != null){
      sesion.nuevaPlatea(platea);
      return true;		
    }
    return false;
  }
	
  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   * de una sesion
   *
   * @param idSesion
   * @param nombrePlatea
   * @return 
   * 
   */
  public String generarMapaOcupacion(int idSesion, String nombrePlatea){
    String s = "Sala " + devuelveNumero() +  "\n";
    Sesion sesion = buscarSesion(idSesion);
    if(sesion != null){
      s = s + sesion.generarMapaOcupacion(nombrePlatea);
    }
    return s;
  }
	
  public int devuelveNumero() {
    return numero;
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
   public String comprarEntrada(int idSesion,String nombrePlatea, int fila, 
          int numero) {
    String s = "";         
    try{        
      Sesion sesion = buscarSesion(idSesion);   
      s = s + devuelveNumero() + "\n";
      s = s + sesion.comprarEntrada(idSesion,nombrePlatea, fila, numero);
      }
    catch(NullPointerException e) {
      return "\n" + msgError + idSesion;
    }
    return s;
  }	
}