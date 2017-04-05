package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Platea {
	
	private String nombre;
	private int numAsientos;
	private int asientosTotales =0;
	private int asientosLibres =0;
	private Asiento[] asientos;
	
	public int MAX_ASIENTOS = 500;
	
	public Platea(String nombre, String fichero) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(fichero));
		
		this.nombre = nombre;
		asientos = new Asiento[MAX_ASIENTOS];
		crearAsientos(scanner);
	}
	
	public void crearAsientos(Scanner scanner){
		
		int [] asientos = new int [MAX_ASIENTOS];
		while(scanner.hasNextInt()){
			
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
			 	asientosTotales++;
		 	}
		}
	}
	
	public boolean nuevo(Asiento asiento){
		if(numAsientos<asientos.length){
			asientos[numAsientos++] = asiento;
			return true;
		}
		return false;
	}
	
	public String contarAsientos(){
		for(int i=0;i<numAsientos;i++){
			if(!(asientos[i].estaOcupado())){
				asientosLibres++;
			}
		}
		return "Asientos totales: "+asientosTotales+" libres: "+asientosLibres;
	}
	
	public String dibujarMapa(Scanner mapa){
		String s = "";
		int [] asientos = new int [MAX_ASIENTOS];
		int filaActual=1;
		while(mapa.hasNextInt()){
			 int i = 0; 
			 int fila=1;
			 int numero=1;
			 
		 	i++;
		 	asientos[i] = mapa.nextInt();
		
		 	fila  = asientos[i] / 100;
		 	numero  = asientos[i] % 100;
		 	
		 
	
		 	if (filaActual != fila){
		 		s = s+"\n";
		 		filaActual++;
		 	}
		 	
		 	if(numero != 0){ 
		 		
			 	Asiento asiento = buscarAsiento(fila, numero);
			 	if(!(asiento.estaOcupado())){
			 		s = s+"- ";
			 	}else{
			 		s = s+"X ";
			 	}
			 	
		 	}else{
		 		s = s+"  ";
		 	}
		}
		
		return s;
	}
	
	public boolean ocupar(int fila, int numero){
		
		Asiento asiento = buscarAsiento(fila,numero);
		
		if (asiento!=null){
			
			if(!(asiento.estaOcupado())){
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
		
		for (int i = 0; i < numAsientos; i++) {	

			if (asientos[i].devuelveFila() == fila && asientos[i].devuelveNumero() == numero)
				return asientos[i];	
		}
		return null;
	}
	
	public String imprimirEntrada(int fila, int numero) {
		Asiento asiento = buscarAsiento(fila, numero);
		String s = asiento.imprimirEntrada();
		return s;
	}
	
	public String imprimirMapa(Scanner mapa) {
		
		String s =contarAsientos()+"\n\n"+dibujarMapa(mapa);
		return s;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}