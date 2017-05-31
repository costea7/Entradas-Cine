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
  //static final String MAPA1 = "mapaAsientos1.txt";
  private String ficheroSesion;
  private CineVista vista;
  int idSesion=1;
  Sesion sesion;
  
	  
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
  public void generarMapaOcupacion(Object idSes) throws FileNotFoundException{
    
   String string = (String) idSes;
   String[] parts = string.split("-");
   String part1 = parts[0]; 
   String part2 = parts[1]; 
     
   int nusal = Integer.parseInt(part1);
   int isesio = Integer.parseInt(part2);
      
   Sala sala = buscarSala(nusal);

   System.out.println("Estas en sala/sesion: " + nusal + "/" + isesio);
   sala.generarMapaOcupacion(isesio);
   vista.iniciarTableroVista(nusal,isesio, sala.devuelvePlatea(isesio));
     
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
  public void comprarEntrada(int numeroSala, int idSesion, int fila, int numero) {	
      
       
    try{
      Sala sala = buscarSala(numeroSala); 
        
      sala.buscarSesion(idSesion);
      sala.comprarEntrada(idSesion, fila, numero);
      
      FileWriter fichero1 = null;
      try{
    	String rutaEntrada = "entrada" + numeroEntrada + ".txt";
    	numeroEntrada++;
    	
        fichero1 = new FileWriter(rutaEntrada,true); 
        PrintWriter pw1 = new PrintWriter(fichero1);
     
          
        fichero1.close();
      }catch(IOException ex) {
        System.out.println("Fallo con los ficheros" + ex.getMessage());
      }
    }	
    catch(NullPointerException e){
   
    }	
   
  }
  
   private void añadirSesion() throws FileNotFoundException{
    ficheroSesion = vista.seleccionarFichero(vista.ABRIR_FICHERO);
    if (ficheroSesion != null) {
        Scanner scanner = new Scanner(new File(ficheroSesion));
        int numSala = scanner.nextInt();
        Sala sala = buscarSala(numSala);
       
         try {
             sesion = new Sesion(idSesion, ficheroSesion, sala.devuelveMapaAsientos());  
                  
            
            // if (sala.devuelveNumero() == numSala){
                 idSesion++; 
            // }
                 
                 
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
             salir();
             break; 
             
         case VER_MAPA:
     {
         try {
             generarMapaOcupacion(obj);
         } catch (FileNotFoundException ex) {
             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
   
             break;
                        
         case COMPRAR_ENTRADA:
           //  comprarEntrada();
             break;
     }
  }
   
  public static void main(String[] args) throws FileNotFoundException {          
    new Cine();
  }
}























//package Controlador;
//
//import Modelo.Platea;
//import Modelo.Sala;
//import Vista.CineVista;
//import Modelo.Sesion;
//
//import java.io.FileNotFoundException;
//
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//
//
///**
//* Cine
//*
//* @author Alex Costea y Aitor Mari
//*/
//public class Cine implements OyenteVista{
//	
//  private final String nombre;
//  private Sala[] salas;
//  private int numSalas;
//  private int numeroEntrada = 1; //variable para nombrar los .txt
//	
//  public int MAX_SALAS = 500;
//  static final String msgError = "Error! Sala no existe: ";
//  static final String RUTAMAPA = "mapaOcupacion.txt";
//  
//  static CineVista vista;
//  
//  //Rutas de los archivos de texto
//  static final String MAPA = "mapaAsientos.txt";
//  static final String SESION1 = "sesion1.txt";
//  static final String SESION2 = "sesion2.txt";
// 
//  int t=0;
//  private String ficheroSesion;
//	  
//  /**
//   * Crea un cine
//   * 
//   * @param nombre
//   */
//  public Cine(String nombre) throws FileNotFoundException {
//    this.nombre = nombre;
//    salas = new Sala[MAX_SALAS];
//    
//    vista = CineVista.instancia(this, 10,21); 
//    
//   
//   
//  }
//	
//  /**
//   * Crea una sala para un cine
//   * 
//   */
//  void nuevaSala(Sala sala) {
//      salas[numSalas++] = sala;
//      //sala = new Sala(numero);
//      /*
//    if (numSalas < salas.length) {
//      salas[numSalas++] = sala;
//      return true;
//    }
//  return false;*/
//  }
//  
//  /**
//   *  Abrir sesion
//   * 
//   */ 
//  public void abrirSesion() throws FileNotFoundException{
//     
//   ficheroSesion = vista.seleccionarFichero(vista.ABRIR_FICHERO);
//  // vista.iniciarTableroVista(platea);
//   
//   if (ficheroSesion != null) {
//
//       try {
//             t++; 
//             Platea platea = new Platea("platea1", MAPA, vista);
//             vista.iniciarTableroVista(platea);
//             vista.añadirSesion(t, ficheroSesion);
//              
//         } catch (FileNotFoundException ex) {
//             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }  
//  }
//  
//  public void cargaMapa() throws FileNotFoundException {
//
//    Platea platea = new Platea("platea1", MAPA, vista);
//    vista.iniciarTableroVista(platea);
//  }
//  
//  /**
//   *  Salir del programa
//   * 
//   */      
//  public void salir() {
//    System.exit(0);    
//  }
//	
//  /**
//   * Dado un entero, busca una platea que
//   * lo tenga como número de sala
//   * 
//   * @param numero
//   * @return 
//   */
//  public Sala buscarSala(int numero) {
//    for (int i = 0; i < numSalas; i++) {
//      if (salas[i].devuelveNumero() == numero) {
//        return salas[i];
//      }
//    }
//    return null;
//  }
//
//  /**
//   * Crea una sesión para una sala
//   * 
//   * @param idSesion
//   * @param platea
//   * @return 
//   */
//  boolean nuevaSesion(int numeroSala, Sesion sesion){
//    Sala sala = buscarSala(numeroSala);
//    if (sala != null){
//      sala.nuevaSesion(sesion);
//      return true;		
//    }
//    return false;
//  }
//	
//  /**
//   * Crea una platea para una sesión de una sala
//   * 
//   * @param idSesion
//   * @param platea
//   * @return 
//   */
//  boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
//    Sala sala = buscarSala(numeroSala);
//    if (sala != null){
//      sala.nuevaPlatea(idSesion, platea);
//      return true;		
//    }
//    return false;
//  }
//
//  /**
//   * Diseña el mapa de ocupación de los asientos creados de una platea
//   * de una sesión de una sala
//   *
//   * @param numeroSala
//   * @param idSesion
//   * @param nombrePlatea
//   * @return 
//   */
//  public boolean generarMapaOcupacion(int numeroSala, int idSesion)
//  {
//      
//    String s = devuelveNombre() + "\n";
//    Sala sala = buscarSala(numeroSala);
//    if(sala != null){
//      s = s + sala.generarMapaOcupacion(idSesion)+"\n";
//          
//      FileWriter mapaOcupacion = null;
//      try{
//        mapaOcupacion = new FileWriter(RUTAMAPA);
//        PrintWriter pw = new PrintWriter(mapaOcupacion);
//	pw.println(s);  //dibuja el mapa en un fichero
//	System.out.println(s); //dibuja el mapa por consola
//        
//        mapaOcupacion.close();
//      }catch(IOException ex) {
//        System.out.println("Fallo con los ficheros"+ ex.getMessage());
//      } 
//    }   
//    return false;
//  }
//	
//  public String devuelveNombre(){
//    return nombre;
//  }
//	
//  
//  /**
//   * String devuelve entrada
//   * 
//   * @param numeroSala
//   * @param idSesion
//   * @param nombrePlatea
//   * @param fila
//   * @param numero 
//   * @return 
//   */
//  public String comprarEntrada(int numeroSala, int idSesion, 
//          String nombrePlatea, int fila, int numero) throws FileNotFoundException {	
//      
//    String s = "";         
//    try{
//      Sala sala = buscarSala(numeroSala); 
//      
//      sala.buscarSesion(idSesion);
//      s = s + "---------------------------------\n" + devuelveNombre() + "\n";
//      s = s + sala.comprarEntrada( idSesion,nombrePlatea, fila, numero);
//      
//      
//      FileWriter fichero1 = null;
//      try{
//    	String rutaEntrada = "entrada" + numeroEntrada + ".txt";
//    	numeroEntrada++;
//    	
//        fichero1 = new FileWriter(rutaEntrada); 
//        PrintWriter pw1 = new PrintWriter(fichero1);
//        pw1.println(s);
//          
//        fichero1.close();
//      }catch(IOException ex) {
//        System.out.println("Fallo con los ficheros" + ex.getMessage());
//      }
//    }	
//    catch(NullPointerException e){
//      return "\n" + msgError + numeroSala;
//    }	
//    return s;
//  }
//
//     /**
//   *  Llamado desde vista para notificar evento de la interfaz de usuario
//   * 
//   */  
//  @Override
//  public void notificacion(OyenteVista.Evento evento, Object obj) {     
//     switch(evento) {
//        
//         case NUEVA:
//     {
//         try {
//             abrirSesion();
//         } catch (FileNotFoundException ex) {
//             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
//             break;
//             
//         case VER_MAPA:
//     {
//         try {
//             cargaMapa();
//         } catch (FileNotFoundException ex) {
//             Logger.getLogger(Cine.class.getName()).log(Level.SEVERE, null, ex);
//         }
//     }
//             break;
//             
//         case SALIR: 
//             salir();
//             break;
//     }
//  }
//  
// 
//  
//  public static void main(String[] args) throws FileNotFoundException,
//          IOException {	 
//	
//    Cine cine = new Cine("Cine Rialto");	
//
//	/*	 		 
//    cine.nuevaSala(new Sala(1));
//  		 
//    cine.nuevaSesion(1, new Sesion(1, SESION1));
//    cine.nuevaSesion(1, new Sesion(2, SESION2)); 
//		 
//   // cine.nuevaPlatea(1,1, new Platea("platea1", MAPA, vista)); 
//    //cine.nuevaPlatea(1,2, new Platea("platea2", MAPA, vista));
//	
//    cine.comprarEntrada(1, 1, "platea1", 1, 1);
//    cine.comprarEntrada(1, 1, "platea1", 2, 1);
//    cine.comprarEntrada(1, 1, "platea1", 1, 2);
//        
//    //cine.comprarEntrada(1, 2, "platea2", 1, 11);
//      
//    cine.generarMapaOcupacion(1, 1, "platea1");	 
//    
//   
//*/
//  }
//  
//  
//  }
//  
//  
//   
