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
		 int fila=1;
		 int numero=1;
		 
		
		 
		 Platea platea = new Platea("platea", 250);
		 
		 Sala sala = new Sala(1, 250);
		 
		 Cine cine = new Cine("Cinema", sala);
		 	 
		 cine.nuevaSala(sala);
		 cine.nuevaPlatea(1, platea);
		
		 while(scanner.hasNextInt()){
			 i++;
			 asientos[i] = scanner.nextInt();
			
			 fila  = asientos[i] / 100;
			 numero  = asientos[i] % 100;
			 		 
			 if (numero != 0){ 
					 
				 //Esto no será así		
				 Asiento asiento = new Asiento(fila, numero);
				 cine.nuevoAsiento(1, "platea", asiento);
			
			 }
		 } 
		 System.out.println(cine.toString());
	 }	 	         
}