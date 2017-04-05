package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class TestCine {
		
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		 
		 
		 Cine cine = new Cine("Cine Rialto");
		 
		 Sala sala = new Sala(1);		 
		 
		 Sesion sesion1 = new Sesion(1, "src/practica1/sesion1.txt");
		 Sesion sesion2 = new Sesion(2, "src/practica1/sesion2.txt");
		 
		 Platea platea1 = new Platea("platea1", "src/practica1/array.txt");
		 Platea platea2 = new Platea("platea2", "src/practica1/array.txt");
		 
		 
		 cine.nuevaSala(sala);
		 
		 cine.nuevaSesion(1, sesion1);
		 cine.nuevaSesion(1, sesion2); 
		 
		 cine.nuevaPlatea(1,1, platea1); 
		 cine.nuevaPlatea(1,2, platea2);
		 
	
		  
		 
		 FileWriter fichero1 = new FileWriter("src/practica1/entrada1.txt");
		 
		 PrintWriter pw1 = new PrintWriter(fichero1);
		 pw1.println(cine.comprarEntrada(1, 1, "platea1", 1, 5)
				 	+cine.comprarEntrada(1, 1, "platea1", 1, 6)
				 	+cine.comprarEntrada(1, 1, "platea1", 5, 1)
				 	+cine.comprarEntrada(1, 1, "platea1", 7, 3)
				 	+cine.comprarEntrada(1, 1, "platea1", 3, 8)
				 	+cine.comprarEntrada(1, 1, "platea1", 8, 7)
				 	+cine.comprarEntrada(1, 1, "platea1", 9, 14)
				 	+cine.comprarEntrada(1, 1, "platea1", 9, 15)
				 	+cine.comprarEntrada(1, 1, "platea1", 1, 2));
		 
		 PrintWriter pw2 = new PrintWriter(fichero1);
		 pw2.println(cine.comprarEntrada(1, 2, "platea2", 1, 11));
	 
		 fichero1.close();
		 
		 Scanner mapa = new Scanner(new File("src/practica1/array.txt"));
		 FileWriter mapaOcupacion = new FileWriter("src/practica1/mapaOcupacion.txt");
		 
		 PrintWriter pw3 = new PrintWriter(mapaOcupacion);
		 pw3.println(cine.verMapaOcupacion(1, 1, "platea1", mapa));
	 
		 mapaOcupacion.close();

		          
	}
}



