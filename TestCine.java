package practica1;

import java.io.FileNotFoundException;
import java.io.IOException;

public class TestCine {
		
  public static void main(String[] args) throws FileNotFoundException,
          IOException {	 
      	 
    Cine cine = new Cine("Cine Rialto");	 
		 		 
    cine.nuevaSala(new Sala(1));
		 
    cine.nuevaSesion(1, new Sesion(1, "src/practica1/sesion1.txt"));
    cine.nuevaSesion(1, new Sesion(2, "src/practica1/sesion2.txt")); 
		 
    cine.nuevaPlatea(1,1, new Platea("platea1", "src/practica1/array.txt")); 
    cine.nuevaPlatea(1,2, new Platea("platea2", "src/practica1/array.txt"));
	
    cine.comprarEntrada(1, 1, "platea1", 1, 1);
    cine.comprarEntrada(1, 1, "platea1", 1, 2);
        
    cine.comprarEntrada(1, 2, "platea2", 1, 11);
      
    cine.generarMapaOcupacion(1, 1, "platea1");	     
  }
}