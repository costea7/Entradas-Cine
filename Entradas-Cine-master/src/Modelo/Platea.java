package Modelo;

import Modelo.Asiento;

import Vista.CineVista;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Observable;
import java.util.Scanner;

/**
* Platea
*
* @author Alex Costea y Aitor Mari
*/
public class Platea extends Observable implements Serializable{

  private final String nombre;
  private int numAsientos;
  private int asientosTotales = 0;
  private int asientosLibres;
  private final String mapa;
  private final Asiento[] asientos;
  
  private Asiento[][] fichas;
  private int filas=1;
  private int columnas;
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
  public Platea(String nombre, String mapa, CineVista vista) throws FileNotFoundException {		
    this.asientosLibres = 0;
    this.nombre = nombre;
    this.mapa = mapa;
    asientos = new Asiento[MAX_ASIENTOS];
    fichas = new Asiento[200][200]; 
    generarMapaOcupacion();
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
        filas++;
      }else if(filaActual<2){
        columnas++;      
      }
      if(numero != 0){ 
        Asiento asiento = new Asiento(fila, numero);
	asientos[numAsientos++] = asiento;
      
	asientosTotales++;  
          
        asiento = buscarAsiento(fila, numero);
   
        if(!(asiento.estaOcupado())){
          
        // fichas[fila][numero] = "x";
         
        }else{
           
         // fichas[fila][numero] = "-";
        }	
      }else{
          
         // fichas[fila][numero] = " ";
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
  
  public int devuelveNumFilas() {
    return filas;
  }

  
  public int devuelveNumColumnas() {
    return columnas;
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