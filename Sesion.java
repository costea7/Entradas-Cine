package practica1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sesion {

	private int id;
	private String pelicula;
	private String horaInicio, horaFin, fecha;
	private Platea[] plateas; 
	private int numPlateas;
	private int MAX_PLATEAS = 500;
	
	public Sesion(int id, String fichero) throws FileNotFoundException {
		
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(new File(fichero));

		this.id = id;
		this.pelicula = scanner.nextLine();
		this.horaInicio = scanner.nextLine();
		this.horaFin = scanner.nextLine();
		this.fecha = scanner.nextLine();
		plateas = new Platea[MAX_PLATEAS ];
	}

	boolean nuevaPlatea(Platea platea) {	
		if (numPlateas < plateas.length) {
			plateas[numPlateas++] = platea;
			return true;
		}
		return false;
	}
	
	
	Platea buscarPlatea(String nombre){	
		for (int i = 0; i < numPlateas; i++) {	
			if (plateas[i].getNombre().equals(nombre))
				return plateas[i];	
		}
		return null;
	}	
	
	public String imprimirMapa(String nombrePlatea, Scanner mapa) {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		Platea platea = buscarPlatea(nombrePlatea);
		s = s + platea.imprimirMapa(mapa);
		return s;
	}
	
	boolean verMapaOcupacion(String nombrePlatea){
		Platea platea = buscarPlatea(nombrePlatea);
		if(platea != null) {
			return true;	
		}	
		return false;
	}
	
	public String imprimirEntrada(String nombrePlatea,  int fila, int numero) {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		Platea platea = buscarPlatea(nombrePlatea);
		s = s + platea.imprimirEntrada(fila, numero);
		return s;
	}
	
	boolean comprarEntrada(String nombrePlatea, int fila, int numero){
		Platea platea = buscarPlatea(nombrePlatea);
		if(platea != null) {
			if(platea.ocupar(fila, numero)){
				return true;	
			}
		}	
		return false;
	}

	
	
	
	
	public int getId() {
		return id;
	}		
}