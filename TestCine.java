/***********************************************
 * 				               *
 * ESCUELA UNIVERSITARIA POLITÉCNICA DE TERUEL *
 * 					       *
 * GRADO DE INGENIERÍA INFORMÁTICA             *
 * ASIGNATURA: TECNOLOGÍA DE LA PROGRAMACIÓN   *
 *                                             *
 * PRÁCTICA 1                                  *
 * AUTORES: <ALEX COSTEA> <AIOTR MARI>         *
 *                                             *
 ***********************************************/


package practica1;

import java.io.FileNotFoundException;
import java.io.IOException;


public class TestCine {
  //Rutas de los archivos de texto
  static final String MAPA = "src/practica1/array.txt";
  static final String SESION1 = "src/practica1/sesion1.txt";
  static final String SESION2 = "src/practica1/sesion2.txt";
  
  public static void main(String[] args) throws FileNotFoundException,
          IOException {	 
	
    Cine cine = new Cine("Cine Rialto");	 
		 		 
    cine.nuevaSala(new Sala(1));
  		 
    cine.nuevaSesion(1, new Sesion(1, SESION1));
    cine.nuevaSesion(1, new Sesion(2, SESION2)); 
		 
    cine.nuevaPlatea(1,1, new Platea("platea1", MAPA)); 
    cine.nuevaPlatea(1,2, new Platea("platea2", MAPA));
	
    cine.comprarEntrada(1, 1, "platea1", 1, 1);
    cine.comprarEntrada(1, 1, "platea1", 2, 1);
    cine.comprarEntrada(1, 1, "platea1", 1, 2);
        
    cine.comprarEntrada(1, 2, "platea2", 1, 11);
      
    cine.generarMapaOcupacion(1, 1, "platea1");	     
  }
}