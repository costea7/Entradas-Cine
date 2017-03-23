package practica1;

import java.util.Scanner;

import javax.swing.SingleSelectionModel;

public class Platea {
	
	private String nombre;
	private int asientosTotales;
	private Asiento[] asientos;
	
	
	public Platea(String nombre, int asientosTotales, Scanner scanner) {
		this.nombre = nombre;
		asientos = new Asiento[asientosTotales];
		crearAsientos(scanner, asientosTotales);
		
	}
	
	public void crearAsientos(Scanner scanner, int asientosTotales){
		while(scanner.hasNextInt()){
			
			int [] asientos = new int [asientosTotales];
			
			 int i = 0; 
			 int fila=1;
			 int numero=1;
			
		 	i++;
		 	asientos[i] = scanner.nextInt();
		
		 	fila  = asientos[i] / 100;
		 	numero  = asientos[i] % 100;
		 
		 	
		 	if (numero != 0){ 
			 	Asiento asiento = new Asiento(fila, numero);
			 	nuevo(asiento);	
			 		
			 	
		 	}	 
		}
	}
	
	public boolean nuevo(Asiento asiento){
		if(asientosTotales<asientos.length){
			asientos[asientosTotales++] = asiento;
			return true;
		}
		return false;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean ocupar(int fila, int numero){
		
		Asiento asiento = buscarAsiento(fila,numero);
		
		if (asiento!=null){
			
			if((asiento.getEstado()== false)){
				asiento.ocupar();
				return true;	
			}
		}
		return false;
	}
	
	public void liberar(Asiento asiento){
		asiento.liberar();
	}
	
	Asiento buscarAsiento(int fila, int numero){
		
		for (int i = 0; i < asientosTotales; i++) {	
			System.out.println(numero);
			if (asientos[i].getFila() == fila && asientos[i].getNumero() == numero)
				return asientos[i];	
		}
		return null;
	}
	
	public String toString(int fila, int numero) {
		Asiento asiento = buscarAsiento(fila, numero);
		String s = asiento.toString();
		return s;
	}
	
}