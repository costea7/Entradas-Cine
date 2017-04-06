package practica1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class TestCine {
		
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		 
		 
		 Cine cine = new Cine("Cine Rialto");	 
		 		 
		 cine.nuevaSala(new Sala(1));
		 
		 cine.nuevaSesion(1, new Sesion(1, "src/practica1/sesion1.txt"));
		 cine.nuevaSesion(1, new Sesion(2, "src/practica1/sesion2.txt")); 
		 
		 cine.nuevaPlatea(1,1, new Platea("platea1", "src/practica1/array.txt")); 
		 cine.nuevaPlatea(1,2, new Platea("platea2", "src/practica1/array.txt"));
		 
	
		 FileWriter fichero1 = new FileWriter("src/practica1/entrada1.txt");
		 
		 PrintWriter pw1 = new PrintWriter(fichero1);
		 pw1.println(cine.comprarT(1, 1, "platea1", 10, 5) +
				 cine.comprarT(1, 2, "platea1", 10, 5));
		 
		 
		 PrintWriter pw2 = new PrintWriter(fichero1);
		 pw2.println(cine.comprarEntrada(1, 2, "platea2", 1, 11));
	 
		 fichero1.close();
		 
		 
		 FileWriter mapaOcupacion = new FileWriter("src/practica1/mapaOcupacion.txt");
		 
		 PrintWriter pw3 = new PrintWriter(mapaOcupacion);
		 pw3.println(cine.generarMapaOcupacion(1, 1, "platea1"));
	 
		 mapaOcupacion.close();

		          
	}
}
