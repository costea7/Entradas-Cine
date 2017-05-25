package Modelo;

import Modelo.Asiento;
import Modelo.Asiento;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* Platea
*
* @author Alex Costea y Aitor Mari
*/
public class Platea {

  private int asientosTotales = 0;
  private int asientosLibres;
  private final String mapa;
  private final Asiento[][] asientos;
  private final Casilla[][] casillas;
  private int filas = 1;
  private int columnas = 0;
  
  static final String LIBRE = "- ";
  static final String OCUPADO = "X ";
  static final String msgOcupado = "\nError! Asiento ocupado. Fila/Número: ";
  
  static final int FILAS = 11;
  static final int COLUMNAS = 24;

  /**
   * Construye una platea
   * 
   * @param nombre
   * @param mapa
   * @throws java.io.FileNotFoundException
   */
  public Platea(String mapa) throws FileNotFoundException {		
    this.asientosLibres = 0;
    this.mapa = mapa;
    asientos = new Asiento[FILAS][COLUMNAS];
    casillas = new Casilla[FILAS][COLUMNAS];
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
	nuevoAsiento(asiento, fila, numero);	
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
  public boolean nuevoAsiento(Asiento asiento, int fila, int numero){
      asientos[fila][numero] = asiento;
      return true;
  }

  /**
   * Diseña el mapa de ocupación de los asientos creados para una platea
   * Inicialmente todos estarán libres
   * 
   * @return 
   * @throws java.io.FileNotFoundException
   */
  public void generarMapaOcupacion() throws FileNotFoundException{
	
    Scanner scanner = new Scanner(new File(mapa));

    int asientoTemp;
    int filaActual = 1;
    while(scanner.hasNextInt()){
      int fila = 1;
      int numero = 1;
	 
      asientoTemp = scanner.nextInt();

      fila  = asientoTemp / 100;
      numero  = asientoTemp % 100;
 	
      if (filaActual != fila){
          filas++;
          filaActual++;
          columnas=1;
      }
      else{
             columnas++;     
      }
      
      if(numero != 0){ 
          casillas[filas -1][columnas -1] = Casilla.LIBRE;
       	
      }else{
        casillas[filas -1][columnas -1] = Casilla.VACIA;
    }
  }
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
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; i < COLUMNAS; i++) {
             if ((asientos[i][j].devuelveFila() == fila) && 
                 (asientos[i][j].devuelveNumero() == numero)) {
            return asientos[i][j];	
        }
      }
    }
    return null;
  }
	
  public int devuelveAsientosLibres(){
      
      
    for(int i = 0; i < FILAS; i++){
      for(int j = 0; i < COLUMNAS; i++){
        if(!(asientos[i][j].estaOcupado())){
	    asientosLibres++;
        }
      }
    }
    return asientosLibres;
  }
	
  public Casilla devuelveEstadoCasilla(Asiento asiento){
      return casillas[asiento.devuelveFila()][asiento.devuelveNumero()];
  }
  
  public int devuelveAsientosTotales(){
    return asientosTotales;
  }
  
  public int devuelveNumFilas(){
    return FILAS;
  }
  
  public int devuelveNumColumnas(){
    return COLUMNAS;
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
  public String comprarEntrada(int fila,int numero) { 
    Asiento asiento = buscarAsiento(fila, numero);
    if(!(asiento.estaOcupado())){
      asiento.ocupar();
      return asiento.comprarEntrada();	
    }
    return msgOcupado + fila + "/" + numero;
  }
}