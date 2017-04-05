package practica1;

import java.util.Scanner;

public class Sala {
	
	private int numero;
	private Sesion[] sesiones;
	private int numSesiones;
	
	public int MAX_SESIONES = 500;
	
	public Sala(int numero) {
		
		this.numero = numero;
		sesiones = new Sesion[MAX_SESIONES];
	}

	boolean nuevaSesion(Sesion sesion){
		if (numSesiones < sesiones.length) {
			sesiones[numSesiones++] = sesion;
			return true;
		}
		return false;
	}
	
	
	Sesion buscarSesion(int idSesion){	
		for (int i = 0; i < numSesiones; i++) {	
			if (sesiones[i].getId() == idSesion)
				return sesiones[i];	
		}
		return null;
	}
	
	public boolean nuevaPlatea(int idSesion, Platea platea) {
		Sesion sesion = buscarSesion(idSesion);
		if (sesion != null){
			sesion.nuevaPlatea(platea);
			return true;		
		}
		return false;
	}
	
	
	boolean verMapaOcupacion(int idSesion, String nombrePlatea){
		Sesion sesion = buscarSesion(idSesion);
		if((sesion != null)){
			if(sesion.verMapaOcupacion(nombrePlatea)){
				return true;
			}
		}
		
		return false;
	}
	
	public String imprimirMapa(int idSesion, String nombrePlatea, Scanner mapa) {
		String s = "Sala "+idSesion+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		s = s + sesion.imprimirMapa(nombrePlatea, mapa);
		return s;
	}
	
	
	
	
	
	
	public String imprimirEntrada(int idSesion, String nombrePlatea, int fila, int numero) {
		String s = "Sala "+idSesion+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		s = s + sesion.imprimirEntrada(nombrePlatea,fila,numero);
		return s;
	}

	boolean comprarEntrada(int idSesion, String nombrePlatea, int fila, int numero){
		Sesion sesion = buscarSesion(idSesion);
		if((sesion != null)){
			if(sesion.comprarEntrada(nombrePlatea, fila, numero)){
				return true;
			}
		}
		return false;
	}
	
	
	
	
	
	
	
	public String toString(){
		return "sala: "+numero;
	}
	
	public int getNumero() {
		return numero;
	}	
}