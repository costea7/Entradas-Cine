package practica1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;


public class TestCine {
		
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		 
		 Scanner scanner = new Scanner(new File("src/array.txt"));

		 Cine cine = new Cine("Cine Rialto");
		 
		 Sala sala = new Sala(1);		 
		 
		 Sesion sesion1 = new Sesion(1, "Master and Commander", "17:00", "19:30", "25/02/2017");
		 Sesion sesion2 = new Sesion(2,"Otra peli","20:00", "21:30", "25/02/2017");
		 
		 Platea platea1 = new Platea("platea1", 220, scanner);
		 Platea platea2 = new Platea("platea2", 220, scanner);
		 Platea platea3 = new Platea("platea3", 220, scanner);
		 
		 cine.nuevaSala(sala);
		 
		 cine.nuevaSesion(1, sesion1);
		 cine.nuevaSesion(1, sesion2); 
		 
		 cine.nuevaPlatea(1,1, platea1); 
		 cine.nuevaPlatea(1,2, platea3);
		 
	
		  
		 
		 FileWriter fichero1 = new FileWriter("src/practica1/entrada1.txt");
		 
		 PrintWriter pw1 = new PrintWriter(fichero1);
		 pw1.println(cine.comprarEntrada(1, 1, "platea1", 1, 5));
		 
		 PrintWriter pw2 = new PrintWriter(fichero1);
		 pw2.println(cine.comprarEntrada(1, 2, "platea1", 1, 6));
/*
		 PrintWriter pw3 = new PrintWriter(fichero1);
		 pw3.println(cine.comprarEntrada(1, 1, "platea1", 1, 6));
		 
		 PrintWriter pw4 = new PrintWriter(fichero1);
		 pw4.println(cine.comprarEntrada(1, 2, "platea2", 1, 6));
	*/	 
		 fichero1.close();

		          
	}
}



