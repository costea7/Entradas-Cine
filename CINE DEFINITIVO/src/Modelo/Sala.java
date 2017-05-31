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
  ArrayList<Sesion> sesiones = new ArrayList<>();
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
      System.out.println(sesiones.size() + " Tamaño");
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
  public void generarMapaOcupacion(int idSesion) throws FileNotFoundException{
     Sesion sesion = buscarSesion(idSesion); 
     System.out.println(idSesion + " id Sesion en sala");
   
     sesion.generarMapaOcupacion();
  }
	
  public int devuelveNumero() {
    return numero;
  }
  
  public String devuelveMapaAsientos() {
    return mapaAsientos;
  }
  
  public Platea devuelvePlatea(int idSesion){
    for (int i=0; i<sesiones.size();i++) {
        Sesion sesion=sesiones.get(i);
          if (sesion.devuelveId() == idSesion){
            return sesion.devuelvePlatea();
      }
    }
  return null;
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
  public void comprarEntrada(int idSesion, int fila, 
          int numero) {  
      Sesion sesion = buscarSesion(idSesion);   

  }	
}








//package Modelo;
//
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.List;
//
///**
//* Sala
//*
//* @author Alex Costea y Aitor Mari
//*/
//public class Sala {
//	
//  private final int numero;
//  
//  ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
//  Iterator<Sesion> nueva = sesiones.iterator();
//  
// // private List<Sesion> sesiones;
//  
//  private int numSesiones;
//  public int MAX_SESIONES = 500;
//  static final String msgError = "Error! Sesión no existe: ";
//  
//  /**
//   * Crea una sala
//   * 
//   * @param numero
//   */
//  public Sala(int numero) {	
//    this.numero = numero;
//   
//  }
//
//  /**
//   * Crea una sesion para una sala
//   * 
//   */
//  public boolean nuevaSesion(Sesion sesion){
//   
//      sesiones.add(numSesiones++, sesion);
//
//      return true;
//    
//
//  }
//	
//  /**
//   * Dado un entero, busca una platea que
//   * lo tenga como id
//   * 
//   */
//  public Sesion buscarSesion(int idSesion){	
//    nueva = sesiones.iterator();
//    while(nueva.hasNext()){
//	Sesion elemento = nueva.next();
//        if (elemento.devuelveId() == idSesion){
//            return elemento;
//        }
//    }
//    /*
//    for (int i = 0; i < numSesiones; i++) {	
//      if(sesiones.equals(idSesion)){
//        return sesiones.;
//      }
//    }*/
//  return null;
//  }
//	
//  /**
//   * Crea una platea para una sesion
//   * 
//   * @param idSesion
//   * @param platea
//   * @return 
//   */
//  public boolean nuevaPlatea(int idSesion, Platea platea) {        
//    Sesion sesion = buscarSesion(idSesion);
//    if (sesion != null){
//      sesion.nuevaPlatea(platea);
//      return true;		
//    }
//    return false;
//  }
//	
//  /**
//   * Diseña el mapa de ocupación de los asientos creados de una platea
//   * de una sesion
//   *
//   * @param idSesion
//   * @param nombrePlatea
//   * @return 
//   * 
//   */
//  public String generarMapaOcupacion(int idSesion, String nombrePlatea){
//    String s = "Sala " + devuelveNumero() +  "\n";
//    Sesion sesion = buscarSesion(idSesion);
//    if(sesion != null){
//      s = s + sesion.generarMapaOcupacion(nombrePlatea);
//    }
//    return s;
//  }
//	
//  public int devuelveNumero() {
//    return numero;
//  }
//
//  /**
//   * String devuelve entrada
//   * 
//   * @param idSesion
//   * @param nombrePlatea
//   * @param fila
//   * @param numero 
//   * @return 
//   */
//   public String comprarEntrada(int idSesion,String nombrePlatea, int fila, 
//          int numero) {
//    String s = "";         
//    try{        
//      Sesion sesion = buscarSesion(idSesion);   
//      s = s + devuelveNumero() + "\n";
//      s = s + sesion.comprarEntrada(idSesion,nombrePlatea, fila, numero);
//      }
//    catch(NullPointerException e) {
//      return "\n" + msgError + idSesion;
//    }
//    return s;
//  }	
//}