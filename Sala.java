package practica1;


public class Sala {
	
	private Sesion[] sesiones;
	private int numero;
	private Platea platea;
	
	public int MAX_SESIONES = 10;
	private int numSesiones = 0;
	
	
	
	public Sala(int numero, Platea platea) {
		
		this.numero = numero;
		this.platea = platea;
		sesiones = new Sesion[MAX_SESIONES];
	}

	boolean anadir(Sesion sesion){
		if (numSesiones < sesiones.length) {
			sesiones[numSesiones++] = sesion;
		      return true;
		}
		return false;
	}
	
	boolean eliminar(Sesion sesion) {
		sesiones[numSesiones--] = sesion;
		return true;
	}
	
	
}
