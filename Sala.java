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

	boolean nuevaSesion(Sesion sesion){
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
	
	public boolean eliminarPlatea(int idSesion, Platea platea) {
		Sesion sesion = buscarSesion(idSesion);
		if (sesion != null){
			sesion.eliminarPlatea(platea);
			return true;		
		}
		return false;
	}
	
	boolean buscarPlatea(int idSesion, String nombrePlatea){
		Sesion sesion = buscarSesion(idSesion);
		if (sesion != null){
				sesion.buscarPlatea(nombrePlatea);
				return true;		
		}
		return false;
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
		String s = "Sala "+idSesion+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		s = s + sesion.toString(nombrePlatea,fila,numero);
		return s;
	}
	
	public int getNumero() {
		return numero;
	}

		
}