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
	public Cine(String nombre, Sala sala) {
		this.nombre = nombre;
		salas = new Sala[20];
		
	}
	
	boolean nuevaSala(Sala sala) {
		if (numSalas < salas.length) {
			salas[numSalas++] = sala;
			return true;
		}
		return false;
	}
	
	boolean nuevaPlatea(int numeroSala, Platea platea){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
			sala.nuevaPlatea(platea);
			return true;
		}
		return false;
	}
		
	boolean nuevoAsiento(int numeroSala, String nombrePlatea, Asiento asiento){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
			sala.nuevoAsiento(nombrePlatea, asiento);
			return true;
		}
		return false;
	}
	
	Sala buscarSala(int numeroSala){	
		for (int i = 0; i < numSalas; i++) {
			if (salas[i].getNumero()==numeroSala)
				return salas[i];
		}
		return null;
	}
	
	public String toString() {
	    String s = nombre + "\n";
	    
	    for (int i = 0; i < numSalas; i++) {
	        s = s + salas[i].toString() + "\n";
	      }
	    return s;
	  }
	
	
}

