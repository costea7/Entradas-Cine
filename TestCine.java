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
		 
		 Scanner scanner = new Scanner(new File("src/practica1/array.txt"));
		 Scanner scanner2 = new Scanner(new File("src/practica1/array.txt"));
		 Scanner scanner3 = new Scanner(new File("src/practica1/sesion1.txt"));
		 Scanner scanner4 = new Scanner(new File("src/practica1/sesion2.txt"));
		 

		 Cine cine = new Cine("Cine Rialto");
		 
		 Sala sala = new Sala(1);		 
		 
		 Sesion sesion1 = new Sesion(1, scanner3);
		 Sesion sesion2 = new Sesion(2, scanner4);
		 
		 
		 Platea platea1 = new Platea("platea1", scanner);
		 Platea platea2 = new Platea("platea2", scanner2);
		 
		 
		 cine.nuevaSala(sala);
		 
		 cine.nuevaSesion(1, sesion1);
		 cine.nuevaSesion(1, sesion2); 
		 
		 cine.nuevaPlatea(1,1, platea1); 
		 cine.nuevaPlatea(1,2, platea2);
		 
	
		  
		 
		 FileWriter fichero1 = new FileWriter("src/practica1/entrada1.txt");
		 
		 PrintWriter pw1 = new PrintWriter(fichero1);
		 pw1.println(cine.comprarEntrada(1, 1, "platea1", 1, 5));
		 
		 PrintWriter pw2 = new PrintWriter(fichero1);
		 pw2.println(cine.comprarEntrada(1, 1, "platea1", 1, 5));

		 PrintWriter pw3 = new PrintWriter(fichero1);
		 pw3.println(cine.comprarEntrada(1, 1, "platea1", 1, 6));
		 
		 PrintWriter pw4 = new PrintWriter(fichero1);
		 pw4.println(cine.comprarEntrada(1, 2, "platea2", 1, 6));
	 
		 fichero1.close();

		          
	}
}



