package Modelo;
import Vista.CineVista;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
* Sesión
*
* @author Alex Costea y Aitor Mari
*/
public class Sesion {

  private int id, numSala;
  private String pelicula;
  private String horaInicio, horaFin, fecha;
  private Platea platea; 

  /**
   * Crea una sesión
   * 
   * @param id
   * @param fichero
   * @throws java.io.FileNotFoundException
   */
  public Sesion(int id, String ficheroSesion, String mapaAsientos) throws FileNotFoundException {	
    try{
      Scanner scanner = new Scanner(new File(ficheroSesion));
      
      this.id = id;
      this.numSala = scanner.nextInt();
      scanner.nextLine();
      this.pelicula = scanner.nextLine();
      this.horaInicio = scanner.nextLine();
      this.horaFin = scanner.nextLine();
      this.fecha = scanner.nextLine();
      platea = new Platea(mapaAsientos);
      
    }catch(IOException ex){
      System.out.println("Fallo con los ficheros " + ex.getMessage());
    }
  }
	
  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   *
   * @param nombrePlatea
   * @return 
   * 
   */
  public void generarMapaOcupacion() throws FileNotFoundException{
        
        platea.generarMapaOcupacion();
  }
	
  public int devuelveId() {
    return id;
  }
  
  public String devuelvePelicula() {
    return pelicula;
  }
  
  public String devuelveHoraInicio() {
    return horaInicio;
  }
  
  public String devuelveHoraFin() {
    return horaFin;
  }
  
  public String devuelveFecha() {
    return fecha;
  }
  
  public int devuelveNumSala() {
    return numSala;
  }
  
  public Platea devuelvePlatea(){
    return platea;
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
  public void comprarEntrada(int fila,
          int numero) throws FileNotFoundException {
      
      platea.comprarEntrada(fila, numero);
   
	
  }
}





//package Modelo;
//import Vista.CineVista;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Iterator;
//import java.util.Scanner;
//
///**
//* Sesión
//*
//*/
//public class Sesion {
//
//  private int id;
//  private String pelicula;
//  private String horaInicio, horaFin, fecha;
//
//  
//  private int numPlateas;
//  private int MAX_PLATEAS = 500;
//  static final String msgError = "Error! Platea no existe: ";
//  
//  ArrayList<Platea> plateas = new ArrayList<Platea>();
//  Iterator<Platea> nueva = plateas.iterator();
//  private String fichero;
//
//  /**
//   * Crea una sesion
//   * 
//   * @param id
//   * @param fichero
//   * @throws java.io.FileNotFoundException
//   */
//  public Sesion(int id, String fichero) throws FileNotFoundException {	
//    try{
//      Scanner scanner = new Scanner(new File(fichero));
//      
//      this.id = id;
//      this.pelicula = scanner.nextLine();
//      this.horaInicio = scanner.nextLine();
//      this.horaFin = scanner.nextLine();
//      this.fecha = scanner.nextLine();
//      
//      this.plateas = plateas;
//      
//    
//      
//    }catch(IOException ex){
//      System.out.println("Fallo con los ficheros " + ex.getMessage());
//    }
//  }
//  
//  
//  /**
//   * Crea una platea
//   * 
//   */
//  boolean nuevaPlatea(Platea platea) {
//      
//    plateas.add(numPlateas++, platea);
//
//    return true;  
//   
//  }
//	
//  /**
//   * Dado una cadena de carácteres, busca una platea que
//   * la tenga como nombre
//   * 
//   */
//  Platea buscarPlatea(String nombre){	
//
//    nueva = plateas.iterator();
//    while(nueva.hasNext()){
//      Platea elemento = nueva.next();
//      if (elemento.devuelveNombre().equals(nombre)){
//            return elemento;
//        }
//    }
//    /*  
//    for (int i = 0; i < numPlateas; i++) {	
//      if (plateas[i].devuelveNombre().equals(nombre))
//        return plateas[i];	
//      }*/
//    return null;
//  }	
//	
//  /**
//   * Diseña el mapa de ocupación de los asientos creados de una platea
//   *
//   * @param nombrePlatea
//   * @return 
//   * 
//   */
//  public String generarMapaOcupacion(){
//    String s = devuelvePelicula() + "\n" + "Sesion "+ 
//               devuelveHoraInicio() +  " - " + 
//	       devuelveHoraFin() + " - \t" + 
//               devuelveFecha() + "\n";
//   // Platea platea = buscarPlatea();
////    if(platea != null) {
////      try { 
////        s = s + "Asientos totales:" + platea.devuelveAsientosTotales() +
////	        "\t Asientos libres:" + platea.devuelveAsientosLibres() +
////	        "\n\n" + platea.generarMapaOcupacion();
////      }catch (FileNotFoundException e) {
////        e.getMessage();
////      }
////    }
//    return s;
//  }
//	
//  public int devuelveId() {
//    return id;
//  }
//  
//  public String devuelvePelicula() {
//    return pelicula;
//  }
//  
//  public String devuelveHoraInicio() {
//    return horaInicio;
//  }
//  
//  public String devuelveHoraFin() {
//    return horaFin;
//  }
//  
//  public String devuelveFecha() {
//    return fecha;
//  }
//  public String devuelveFichero(){
//    return fichero;
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
//   public String comprarEntrada(int idSesion, String nombrePlatea, int fila,
//          int numero) {
//    String s = "";
//    try{
//      Platea platea = buscarPlatea(nombrePlatea);
//      s = s + devuelvePelicula() + "\n" + "Sesion "+ 
//              devuelveHoraInicio() + " - " + 
//    	      devuelveHoraFin() + " - " + 
//	      devuelveFecha()+ "\n" +     
//      platea.comprarEntrada( idSesion,nombrePlatea, fila, numero);
//      return s;
//    }catch(NullPointerException e) {
//      return "\n" + msgError + nombrePlatea;
//    }	
//  }
//}