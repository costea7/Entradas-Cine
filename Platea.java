package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Platea
*
* @author Alex Costea y Aitor Mari
*/
public class Platea {

  private final String nombre;
  private int numAsientos;
  private int asientosTotales = 0;
  private int asientosLibres;
  private final String mapa;
  private final Asiento[] asientos;
  
  static final int MAX_ASIENTOS = 500;
  static final String LIBRE = "- ";
  static final String OCUPADO = "X ";
  static final String msgOcupado = "\nError! Asiento ocupado. Fila/Número: ";

  /**
   * Construye una platea
   * 
   * @param nombre
   * @param mapa
   * @throws java.io.FileNotFoundException
   */
  public Platea(String nombre, String mapa) throws FileNotFoundException {		
    this.asientosLibres = 0;
    this.nombre = nombre;
    this.mapa = mapa;
    asientos = new Asiento[MAX_ASIENTOS];
    crearAsientos();
  }

  /**
   * Lee el archivo .txt para crear los asientos
   * 
   */
  private void crearAsientos() throws FileNotFoundException{
    Scanner scanner = new Scanner(new File(mapa));
    int asientoTemp;
    while(scanner.hasNextInt()){
      int fila;
      int numero;
      //almacena enteros(4 dígitos) del txt en una variable temporal
      asientoTemp = scanner.nextInt();
	
      //obtiene fila y numero del asiento
      //los primeros 2 dígitos indican la fila y las ultimas 2 el numero
      fila  = asientoTemp / 100;
      numero  = asientoTemp % 100;
	
      if (numero != 0){ 
	Asiento asiento = new Asiento(fila, numero);
	nuevoAsiento(asiento);	
	asientosTotales++;
      }
    }
  }

  /**
   * Almacena un asiento en el vector de asientos, mientras no esté lleno
   * 
   * @param asiento
   * @return 
   */
  public boolean nuevoAsiento(Asiento asiento){
    if(numAsientos < asientos.length){
      asientos[numAsientos++] = asiento;
      return true;
    }
    return false;
  }

  /**
   * Diseña el mapa de ocupación de los asientos creados para una platea
   * Inicialmente todos estarán libres
   * 
   * @return 
   * @throws java.io.FileNotFoundException
   */
  public String generarMapaOcupacion() throws FileNotFoundException{
	
    Scanner scanner = new Scanner(new File(mapa));

    String s = " ";
    int asientoTemp;
    int filaActual = 1;
    while(scanner.hasNextInt()){
      int fila = 1;
      int numero = 1;
	 
      asientoTemp = scanner.nextInt();

      fila  = asientoTemp / 100;
      numero  = asientoTemp % 100;
 	
      if (filaActual != fila){
        s = s + "\n";
        filaActual++;
      }
      if(numero != 0){ 
        Asiento asiento = buscarAsiento(fila, numero);
        if(!(asiento.estaOcupado())){
          s = s + LIBRE;
        }else{
          s = s + OCUPADO;
        }	
      }else{
        s = s + " ";
      }
    }
    return s;
  }
	
  /**
   * Dado un asiento, cambia su estado a ocupado
   * 
   * @param fila
   * @param numero
   * @return 
   */
  public boolean ocuparAsiento(int fila, int numero){
    Asiento asiento = buscarAsiento(fila,numero);
    if (asiento != null){	
      if(!(asiento.estaOcupado())){
        asiento.ocupar();
        return true;	
      }
    }
    return false;
  }
	
  /**
   * Dadas una fila y un número, busca el asiento correspondiente
   * en la platea
   * 
   * @param fila
   * @param numero
   * @return 
   */
  public Asiento buscarAsiento(int fila, int numero){	
    for (int i = 0; i < numAsientos; i++) {	
      if ((asientos[i].devuelveFila() == fila) && 
              (asientos[i].devuelveNumero() == numero)) {
	return asientos[i];	
      }
    }
    return null;
  }
	
  public String devuelveNombre() {
    return nombre;
  }
	
  public int devuelveAsientosLibres(){
    for(int i = 0; i < numAsientos; i++){
      if(!(asientos[i].estaOcupado())){
	    asientosLibres++;
      }
    }
    return asientosLibres;
  }
	
  public int devuelveAsientosTotales(){
    return asientosTotales;
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
    Asiento asiento = buscarAsiento(fila, numero);
    if(!(asiento.estaOcupado())){
      asiento.ocupar();
      return asiento.comprarEntrada();	
    }
    return msgOcupado + fila + "/" + numero;
  }
}