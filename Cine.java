package practica1;

public class Cine {
	
	private String nombre;
	private Sala[] salas;
	private Sesion[] sesiones;   
	
	private int numSalas;
	
	/**
	 * Construye un Cine
	 * 
	 */            
	public Cine(String nombre, int maxSalas) {
		this.nombre = nombre;
		salas = new Sala[maxSalas];
	}
	
	boolean nueva(Sala sala) {
		if (numSalas < salas.length) {
			salas[numSalas++] = sala;
			return true;
		}
		return false;
	}
}

