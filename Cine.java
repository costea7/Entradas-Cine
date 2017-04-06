package practica1;

public class Cine {
	
	private String nombre;
	private Sala[] salas;
	private int numSalas;
	
	public int MAX_SALAS = 500;
	           
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
	

	Sala buscarSala(int numero) {
		for (int i = 0; i < numSalas; i++) {
			if (salas[i].devuelveNumero()==numero)
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
	
	
	
	boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
		Sala sala = buscarSala(numeroSala);
		if (sala != null){
				sala.nuevaPlatea(idSesion, platea);
				return true;		
		}
		return false;
	}

	
	public String generarMapaOcupacion(int numeroSala, int idSesion, String nombrePlatea){
		String s = devuelveNombre() + "\n";
		Sala sala = buscarSala(numeroSala);
		if(sala != null){
			s = s + sala.generarMapaOcupacion(idSesion, nombrePlatea)+"\n";
		}
		
		return s;
	}
	
	
	String comprarEntrada(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero){
		Sala sala = buscarSala(numeroSala);
		 String s = nombre + "\n";
			if(sala != null){
				if(sala.comprarEntrada(idSesion, nombrePlatea, fila, numero)){
					return  s = s + sala.generarEntrada(idSesion, nombrePlatea, fila, numero)+"\n";			
				}
			}
		return "ERROR \n\n";
	}
	
	public String generarEntrada(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero) {
		String s = nombre + "\n";
		Sala sala = buscarSala(numeroSala);
		s = s + sala.generarEntrada(idSesion, nombrePlatea, fila, numero)+"\n";
		return s;
	}
	
	public String devuelveNombre(){
		return nombre;
	}
	
	
	
	
	
	public String comprarT(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero){
		String s = devuelveNombre() + "\n";
		Sala sala = buscarSala(numeroSala);
		
		if (sala != null){
			s = s + sala.comprarT( idSesion,nombrePlatea, fila, numero);
		}
		
		
		return s;
	}
}













