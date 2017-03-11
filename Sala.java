package practica1;


public class Sala {
	
	private Sesion[] sesiones;
	private int numero;
	private Platea[] plateas;
	
	
	public int MAX_SESIONES = 10;
	public int MAX_PLATEAS = 10;
	private int numSesiones = 0;
	
	private int numPlateas;
	
	
	public Sala(int numero, int max_plateas) {
		
		this.numero = numero;
		plateas = new Platea[max_plateas];
		//sesiones = new Sesion[MAX_SESIONES];
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
	
	public int getNumero() {
		return numero;
	}
	
	public String toString() {
		String s = numero + " " +  "\n";
		s = s + "Nombre platea : ";
		for (int i = 0; i < numPlateas; i++) {
			s = s + plateas[i].toString() + " ";
		}
		return s;
	}	
}
