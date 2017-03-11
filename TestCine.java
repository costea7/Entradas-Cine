package practica1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class TestCine {
	
	
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		 
		 int asientosTotales=0;
            
		 //FileInputStream fstream = new FileInputStream("src/array.txt");
		 // DataInputStream in = new DataInputStream(fstream);
		 //BufferedReader br = new BufferedReader(new InputStreamReader(in));
		 
		 Scanner scanner = new Scanner(new File("src/array.txt"));
		

		 int [] asientos = new int [220];
		
		 int i = 0;
		 
		 int fila=0;
		 int numero=0;
		 
		 
		 while(scanner.hasNextInt()){
			 i++;
			 asientos[i] = scanner.nextInt();
			
			 fila  = asientos[i] / 100;
			 numero  = asientos[i] % 100;
			 Cine cine;
			 
			// Asiento asiento;
			 
			 if (numero != 0){ 
				
				 cine = new Cine("Cinema", 2);
				 
				 //Esto no es así
				 cine.nuevaSala(new Sala(1,new Platea("platea1", 230))); 
				 				 
				 System.out.println(cine.toString());
				
				
			 }
			 
		 } 
	 }	 	         
}