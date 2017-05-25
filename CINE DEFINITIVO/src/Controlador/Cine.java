package Controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import Modelo.Sala;
import Modelo.Sala;
import Modelo.Sesion;
import Vista.CineVista;
import Controlador.OyenteVista;

/**
* Cine
*
* @author Alex Costea y Aitor Mari
*/
public class Cine implements OyenteVista{
	
  private final String nombre = "Rialto";
  ArrayList<Sala> salas = new ArrayList<Sala>();
  Iterator<Sala> nueva = salas.iterator();
  
  private int numeroEntrada = 1; //variable para nombrar los .txt	
  static final String msgError = "Error! Sala no existe: ";
  static final String RUTAMAPA = "mapaOcupacion.txt";
  static final String MAPA = "mapaAsientos.txt";
  static final String MAPA1 = "mapaAsientos1.txt";
  private String ficheroSesion;
  private CineVista vista;
  
	  
  /**
   * Crea un cine
   */
  public Cine() throws FileNotFoundException {

    nuevaSala(1, MAPA);
    nuevaSala(2, MAPA1);
    nuevaSala(3, MAPA);
    
    vista = CineVista.instancia(this, 10, 21); 
    
  }
	
  /**
   * Crea una sala para un cine
   */
  boolean nuevaSala(int numero, String mapaAsientos) {
    salas.add(new Sala(numero, mapaAsientos));
    return true;
  }
	
  /**
   * Dado un entero, busca una platea que
   * lo tenga como número de sala
   */
  public Sala buscarSala(int numero) {
      for (int i=0; i<salas.size();i++) {
        Sala sala=salas.get(i);
          if (sala.devuelveNumero() == numero){
            return sala;
      }
    }
  return null;
  }
	
  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   * de una sesión de una sala
   *
   * @param numeroSala
   * @param idSesion
   * @param nombrePlatea
   * @return 
   */
  public void generarMapaOcupacion(Sesion sesion) throws FileNotFoundException{
     int numSala = sesion.devuelveNumSala();
     Sala sala = buscarSala(numSala);
     sala.generarMapaOcupacion(sesion);
     vista.iniciarTableroVista(sesion.devuelvePlatea());
     
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
  public String comprarEntrada(int numeroSala, int idSesion, int fila, int numero) {	
      
    String s = "";         
    try{
      Sala sala = buscarSala(numeroSala); 
        
      sala.buscarSesion(idSesion);
      s = s + "---------------------------------\n" + devuelveNombre() + "\n";
      s = s + sala.comprarEntrada( idSesion, fila, numero);
      
      FileWriter fichero1 = null;
      try{
    	String rutaEntrada = "entrada" + numeroEntrada + ".txt";
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
  
   private void añadirSesion() throws FileNotFoundException{
     ficheroSesion = vista.seleccionarFichero(vista.ABRIR_FICHERO);
    if (ficheroSesion != null) {
        Scanner scanner = new Scanner(new File(ficheroSesion));
        int numSala = scanner.nextInt();
        Sala sala = buscarSala(numSala);
         try {
             Sesion sesion = new Sesion(1, ficheroSesion, sala.devuelveMapaAsientos());
             sala.nuevaSesion(sesion);
             vista.añadirSesion(sesion);
         } catch (FileNotFoundException e1) {
             vista.mensajeDialogo(vista.FICHERO_NO_ENCONTRADO);
         } 
     }  
  }
  
  public void salir() {
    System.exit(0);    
  }
  
  @Override
 public void notificacion(Evento evento, Object obj){    
     switch(evento) {
         case NUEVA:
     {
         try {
             añadirSesion();
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
             break;                
             
         case SALIR: 
             //salir();
             break; 
             
         case VER_MAPA:
     {
         try {
             generarMapaOcupacion((Sesion)obj);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
             break;
                        
         case COMPRAR_ENTRADA:
             //comprarEntrada();
             break;
     }
  }
   
  public static void main(String[] args) throws FileNotFoundException {          
    new Cine();
  }
}