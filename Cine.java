package practica1;


public class Cine {
	
	private String nombre;
	private Sala[] salas;
	public int MAX_SALAS = 500;
	private int numSalas;
	           
	public Cine(String nombre) {
		this.nombre = nombre;
		salas = new Sala[MAX_SALAS];
		
	}
	
	boolean nuevaSala(Sala sala) {
		if (numSalas < salas.length) {
			salas[numSalas++] = sala;
			return true;
		}
		return false;
	}
	
	boolean eliminarSala(Sala sala) {
		if (numSalas > 0) {
			salas[numSalas--] = sala;
			return true;
		}
		return false;
	}

	Sala buscarSala(int numero) {
		for (int i = 0; i < numSalas; i++) {
			if (salas[i].getNumero()==numero)
				return salas[i];
		}
		return null;
	}


	boolean nuevaSesion(int numeroSala, Sesion sesion ){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.nuevaSesion(sesion);
				return true;		
		}
		return false;
	}
	
	boolean eliminarSesion(int numeroSala, Sesion sesion ){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.eliminarSesion(sesion);
				return true;		
		}
		return false;
	}
	
	boolean buscarSesion(int numeroSala, int idSesion ){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.buscarSesion(idSesion);
				return true;		
		}
		return false;
	}
	
	
	boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.nuevaPlatea(idSesion, platea);
				return true;		
		}
		return false;
	}
	
	boolean elimiarPlatea(int numeroSala, int idSesion, Platea platea){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.eliminarPlatea(idSesion, platea);
				return true;		
		}
		return false;
	}
	
	boolean buscarPlatea(int numeroSala, int idSesion, String nombrePlatea ){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.buscarPlatea(idSesion, nombrePlatea);
				return true;		
		}
		return false;
	}
	
	public String toString(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero) {
	    String s = nombre + "\n";
	    Sala sala = buscarSala(numeroSala);
	    s = s + sala.toString(idSesion, nombrePlatea, fila, numero)+"\n";
	    return s;
	  }
	
	String comprarEntrada(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero){
		Sala sala = buscarSala(numeroSala);
			if(sala != null){
				if(sala.comprarEntrada(idSesion, nombrePlatea, fila, numero)){
					return toString(numeroSala, idSesion, nombrePlatea, fila, numero);			
				}
			}
		return "ERROR \n\n";
	}
	
}