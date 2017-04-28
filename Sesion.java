package practica1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
* Sesión
*
* @author Alex Costea y Aitor Mari
*/
public class Sesion {

  private int id;
  private String pelicula;
  private String horaInicio, horaFin, fecha;
  private Platea[] plateas; 
  private int numPlateas;
  
  private int MAX_PLATEAS = 500;
  static final String msgError = "Error! Platea no existe: ";

  /**
   * Crea una sesión
   * 
   * @param id
   * @param fichero
   * @throws java.io.FileNotFoundException
   */
  public Sesion(int id, String fichero) throws FileNotFoundException {	
    try{
      Scanner scanner = new Scanner(new File(fichero));
      
      this.id = id;
      this.pelicula = scanner.nextLine();
      this.horaInicio = scanner.nextLine();
      this.horaFin = scanner.nextLine();
      this.fecha = scanner.nextLine();
      
      plateas = new Platea[MAX_PLATEAS];
    }catch(IOException ex){
      System.out.println("Fallo con los ficheros " + ex.getMessage());
    }
  }
  
  /**
   * Crea una platea
   * 
   */
  boolean nuevaPlatea(Platea platea) {
    if (numPlateas < plateas.length) {
      plateas[numPlateas++] = platea;
      return true;
    }
    return false;
  }
	
  /**
   * Dada una cadena de caracteres, busca una platea que
   * la tenga como nombre
   * 
   */
  Platea buscarPlatea(String nombre){	
    for (int i = 0; i < numPlateas; i++) {	
      if (plateas[i].devuelveNombre().equals(nombre))
        return plateas[i];	
      }
    return null;
  }	
	
  /**
   * Diseña el mapa de ocupación de los asientos creados de una platea
   *
   * @param nombrePlatea
   * @return 
   * 
   */
  public String generarMapaOcupacion(String nombrePlatea){
    String s = devuelvePelicula() + "\n" + "Sesion "+ 
               devuelveHoraInicio() +  " - " + 
	       devuelveHoraFin() + " - \t" + 
               devuelveFecha() + "\n";
    Platea platea = buscarPlatea(nombrePlatea);
    if(platea != null) {
      try { 
        s = s + "Asientos totales:" + platea.devuelveAsientosTotales() +
	        "\tAsientos libres:" + platea.devuelveAsientosLibres() +
	        "\n\n" + platea.generarMapaOcupacion();
      }catch (FileNotFoundException e) {
        e.getMessage();
      }
    }
    return s;
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

  /**
   * String devuelve entrada
   * 
   * @param idSesion
   * @param nombrePlatea
   * @param fila
   * @param numero 
   * @return 
   */
  public String comprarEntrada(int idSesion, String nombrePlatea, int fila,
          int numero) {
    String s = "";
    try{
      Platea platea = buscarPlatea(nombrePlatea);
      s = s + devuelvePelicula() + "\n" + "Sesion "+ 
              devuelveHoraInicio() + " - " + 
    	      devuelveHoraFin() + " - " + 
	      devuelveFecha()+ "\n" +     
      platea.comprarEntrada( idSesion,nombrePlatea, fila, numero);
      return s;
    }catch(NullPointerException e) {
      return "\n" + msgError + nombrePlatea;
    }	
  }
}