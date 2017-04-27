package practica1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
* Cine
*
*/
public class Cine{
	
  private final String nombre;
  private final Sala[] salas;
  private int numSalas;
  private int numeroEntrada = 1;
	
  public int MAX_SALAS = 500;
  static final String msgError = "Error! Sala no existe: ";
	  
  /**
   * Crea un cine
   * 
   * @param nombre
   */
  public Cine(String nombre) {
    this.nombre = nombre;
    salas = new Sala[MAX_SALAS];	
  }
	
  /**
   * Crea una sala para un cine
   * 
   */
  boolean nuevaSala(Sala sala) {
    if (numSalas < salas.length) {
      salas[numSalas++] = sala;
      return true;
    }
  return false;
  }
	
  /**
   * Dado un entero, busca una platea que
   * lo tenga como numero de sala
   * 
   * @param numero
   * @return 
   */
  public Sala buscarSala(int numero) {
    for (int i = 0; i < numSalas; i++) {
      if (salas[i].devuelveNumero()==numero) {
        return salas[i];
      }
    }
    return null;
  }

  /**
   * Crea una sesion para una sala
   * 
   * @param idSesion
   * @param platea
   * @return 
   */
  boolean nuevaSesion(int numeroSala, Sesion sesion ){
    Sala sala = buscarSala(numeroSala);
    if (sala != null){
      sala.nuevaSesion(sesion);
      return true;		
    }
    return false;
  }
	
  /**
   * Crea una platea para una sesion de una sala
   * 
   * @param idSesion
   * @param platea
   * @return 
   */
  boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
    Sala sala = buscarSala(numeroSala);
    if (sala != null){
      sala.nuevaPlatea(idSesion, platea);
      return true;		
    }
    return false;
  }

  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   * de una sesion de una sala
   *
   * @param numeroSala
   * @param idSesion
   * @param nombrePlatea
   * @return 
   */
  public String generarMapaOcupacion(int numeroSala, int idSesion, 
          String nombrePlatea){
      
    String s = devuelveNombre() + "\n";
    Sala sala = buscarSala(numeroSala);
    if(sala != null){
      s = s + sala.generarMapaOcupacion(idSesion, nombrePlatea)+"\n";
          
      FileWriter mapaOcupacion = null;
      try{
        mapaOcupacion = new FileWriter("src/practica1/mapaOcupacion.txt");
        PrintWriter pw = new PrintWriter(mapaOcupacion);
	    pw.println(s);
	    System.out.println(s);
        
        mapaOcupacion.close();
      }catch(IOException ex) {
        System.out.println("Fallo con los ficheros"+ ex.getMessage());
      } 
    }
    return s;      
  }
	
  public String devuelveNombre(){
    return nombre;
  }
	
  
  /**
   * String devuelve entrada
   * 
   * @param numeroSala
   * @param idSesion
   * @param nombrePlatea
   * @param fila
   * @param numero 
   * @return 
   */
  public String comprarEntrada(int numeroSala, int idSesion, 
          String nombrePlatea, int fila, int numero) {	
      
    String s = "";         
    try{
      Sala sala = buscarSala(numeroSala); 
        
      sala.buscarSesion(idSesion);
      s = s + "---------------------------------\n" + devuelveNombre() + "\n";
      s = s + sala.comprarEntrada( idSesion,nombrePlatea, fila, numero);
      
      FileWriter fichero1 = null;
      try{
    	String rutaEntrada = "src/practica1/entrada" + numeroEntrada + ".txt";
    	numeroEntrada++;
    	
        fichero1 = new FileWriter(rutaEntrada,true); 
        PrintWriter pw1 = new PrintWriter(fichero1);
        pw1.println(s);
          
        fichero1.close();
      }catch(IOException ex) {
        System.out.println("Fallo con los ficheros" + ex.getMessage());
      }
    }	
    catch(NullPointerException e){
      return "\n" + msgError + numeroSala;
    }	
    return s;
  }
}