package practica1;

public class Sala {
	
	private int numero;
	private Sesion[] sesiones;
	
	public int MAX_SESIONES = 500;
	private int numSesiones;
	
	
	
	public Sala(int numero) {
		
		this.numero = numero;
		sesiones = new Sesion[MAX_SESIONES];
	}

	boolean anadirSesion(Sesion sesion){
		if (numSesiones < sesiones.length) {
			sesiones[numSesiones++] = sesion;
			return true;
		}
		return false;
	}
	
	boolean eliminarSesion(Sesion sesion) {
		sesiones[numSesiones--] = sesion;
		return true;
	}
	/*
	boolean nuevaPlatea(Platea platea) {	
		if (numPlateas < plateas.length) {
			plateas[numPlateas++] = platea;
			return true;
		}
		return false;
	}	*/
	
	//se le pasa un nombre de la platea y un asiento
	boolean nuevoAsiento(int id, String nombrePlatea, Asiento asiento){
		Sesion sesion = buscarSesion(id);
		if(sesion != null){		
			sesion.nuevoAsiento(nombrePlatea,asiento);
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
	
	public int getNumero() {
		return numero;
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
	
	public String toString(int idSesion, String nombrePlatea, int fila, int numero) {
		String s = "Sala "+numero+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		s = s + sesion.toString(nombrePlatea,fila,numero);
		return s;
	}

		
}