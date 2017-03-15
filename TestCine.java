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
		 Sesion sesion = new Sesion(1, "Master and Commander", "17:00", "19:30", "25/02/2017", platea);
		 
		 Sesion sesion1 = new Sesion(2,"Otra peli","20:00", "21:30", "25/02/2017", platea);
		 
		 Sala sala = new Sala(1, platea);
		 Cine cine = new Cine("Cine Rialto", sala);
		 
		 cine.nuevaSala(sala);
		 cine.nuevaPlatea(1, platea);
		 
		 cine.nuevaSesion(1, sesion, "platea");
		 
		 cine.nuevaSesion(1, sesion1, "platea");
		 
		 
		
		 while(scanner.hasNextInt()){
			 i++;
			 asientos[i] = scanner.nextInt();
			
			 fila  = asientos[i] / 100;
			 numero  = asientos[i] % 100;
			 		 
			 if (numero != 0){ 
				 
				 //Esto no será así		
				 Asiento asiento = new Asiento(fila, numero);
				 cine.nuevoAsiento(1, "platea", asiento);	
				 
				// cine.comprarEntrada(1,1,"platea",1,1);
				// cine.comprarEntrada(1,2,"platea",1,2);
			 }
			 
			 
		 } 
		 
		 FileWriter fichero1 = new FileWriter("src/practica1/entrada1.txt");
		 PrintWriter pw1 = new PrintWriter(fichero1);
		 pw1.println(cine.comprarEntrada(1, 1, "platea", 1, 5));

		 PrintWriter pw2 = new PrintWriter(fichero1);
		 pw2.println(cine.comprarEntrada(1, 2, "platea", 1, 5));
		 
		 fichero1.close();

		          
	}
}



