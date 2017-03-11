package practica1;

public class Sala {
	
	private int numero;
	private Sesion[] sesiones;
	private Platea[] plateas;
	
	
	public int MAX_SESIONES = 50;
	public int MAX_PLATEAS = 10;
	private int numSesiones;
	private int numPlateas;
	
	
	public Sala(int numero) {
		
		this.numero = numero;
		plateas = new Platea[MAX_PLATEAS];
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
	
	boolean nuevaPlatea(Platea platea) {	
		if (numPlateas < plateas.length) {
			plateas[numPlateas++] = platea;
			return true;
		}
		return false;
	}	
	
	//se le pasa un nombre de la platea y un asiento
	boolean nuevoAsiento(String nombre, Asiento asiento){
		Platea platea = buscarPlatea(nombre);
		if(platea != null){		
			platea.nuevo(asiento);
			return true;
		}
		return false;
	}
	
	//busca si existe dicha platea
	Platea buscarPlatea(String nombre){	
		for (int i = 0; i < numPlateas; i++) {	
			if (plateas[i].getNombre().equals(nombre))
				return plateas[i];	
		}
		return null;
	}
	
	Sesion buscarSesion(int idSesion){	
		for (int i = 0; i < numSesiones; i++) {	
			if (sesiones[i].getId() == idSesion)
				return sesiones[i];	
		}
		return null;
	}
	
	public int getNumero() {
		return numero;
	}
	
	boolean comprarEntrada(int idSesion, String nombrePlatea, int fila, int numero){
		Sesion sesion = buscarSesion(idSesion);
		Platea platea = buscarPlatea(nombrePlatea);
		if((sesion != null) && (platea != null)){
			if(platea.comprarEntrada(fila, numero)){
				return true;
			}
		}
		return false;
	}
	
	public String toString(int idSesion, String nombrePlatea, int fila, int numero) {
		String s = "Sala "+numero+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		Platea platea = buscarPlatea(nombrePlatea);
		s = s + sesion.toString() + platea.toString(fila, numero);
		return s;
	}	
}
