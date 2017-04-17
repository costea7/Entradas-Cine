package practica1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class Cine{
	
  private final String nombre;
  private final Sala[] salas;
  private int numSalas;
	
  public int MAX_SALAS = 500;
	           
  public Cine(String nombre) {
    this.nombre = nombre;
      salas = new Sala[MAX_SALAS];	
  }
	
  boolean nuevaSala(Sala sala) {
    if (numSalas < salas.length) {
      salas[numSalas++] = sala;
      return true;
    }
  return false;
  }
	
  public Sala buscarSala(int numero) {
    for (int i = 0; i < numSalas; i++) {
      if (salas[i].devuelveNumero()==numero) {
        return salas[i];
      }
    }
    return null;
  }

  boolean nuevaSesion(int numeroSala, Sesion sesion ){
    Sala sala = buscarSala(numeroSala);
      if (sala != null){
        sala.nuevaSesion(sesion);
          return true;		
        }
    return false;
  }
	
  boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
    Sala sala = buscarSala(numeroSala);
      if (sala != null){
        sala.nuevaPlatea(idSesion, platea);
        return true;		
      }
    return false;
  }

  public String generarMapaOcupacion(int numeroSala, int idSesion, 
          String nombrePlatea){
      
    String s = devuelveNombre() + "\n";
      Sala sala = buscarSala(numeroSala);
      if(sala != null){
        s = s + sala.generarMapaOcupacion(idSesion, nombrePlatea)+"\n";
          
        FileWriter mapaOcupacion = null;
        try {
          mapaOcupacion = new FileWriter("src/practica1/mapaOcupacion.txt");
          PrintWriter pw3 = new PrintWriter(mapaOcupacion);
	pw3.println(s);
        
        mapaOcupacion.close();
        }catch (IOException ex) {
          System.out.println("Fallo con los ficheros"+ ex.getMessage());} 
      }
    return s;      
  }
	
  public String devuelveNombre(){
    return nombre;
  }
	
  public String comprarEntrada(int numeroSala, int idSesion, 
          String nombrePlatea, int fila, int numero) {	
      
    String s = "";         
    try {
      Sala sala = buscarSala(numeroSala); 
        
      sala.buscarSesion(idSesion);
      s = s + "---------------------------------\n" + devuelveNombre() + "\n";
      s = s + sala.comprarEntrada( idSesion,nombrePlatea, fila, numero);
      
      FileWriter fichero1 = null;
        try {
          fichero1 = new FileWriter("src/practica1/entrada1.txt",true); 
          PrintWriter pw1 = new PrintWriter(fichero1);
          pw1.println(s);
          
          fichero1.close();
        }catch (IOException ex) {
          System.out.println("Fallo con los ficheros"+ ex.getMessage());
        }
    }	
    catch(NullPointerException e){
      return "Error! La sala " + numeroSala + " no existe.";
    }	
    return s;
  }
}