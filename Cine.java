package practica1;

public class Cine {
	
	private String nombre;
	private Sala[] salas;
	//private Sesion[] sesiones;
	//private Platea[] plateas;
	
	
	private int numSalas;
	
	
	/**
	 * Construye un Cine
	 * 
	 */            
	public Cine(String nombre, int maxSalas) {
		this.nombre = nombre;
		salas = new Sala[maxSalas];
		
	}
	
	boolean nuevaSala(Sala sala) {
		if (numSalas < salas.length) {
			salas[numSalas++] = sala;
			return true;
		}
		return false;
	}
		
	public String toString() {
	    String s = nombre + "\n";
	    
	    for (int i = 0; i < numSalas; i++) {
	        s = s + salas[i].toString() + "\n";
	      }
	    return s;
	  }
	
}

