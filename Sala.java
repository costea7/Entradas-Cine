package practica1;


public class Sala {
	
	private Sesion[] sesiones;
	private int numero;
	private Platea[] plateas;
	
	
	public int MAX_SESIONES = 10;
	public int MAX_PLATEAS = 10;
	private int numSesiones = 0;
	private int numPlateas=0;
	
	
	public Sala(int numero, Platea platea) {
		
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
	
	public String toString() {
	    String s = numero + " " +  "\n";
	    s = s + "Asientos : ";
	    for (int i = 0; i < numPlateas; i++) {
	      s = s + plateas[i].toString() + " ";
	    }
	    return s;
	  }
}
