package practica1;

public class Asiento {

	private boolean ocupado = false;
	private int fila;
	private int numero;
	
	public Asiento(int fila, int numero) {
		this.fila = fila;
		this.numero = numero;
	}
	
	public void ocupar(){
		 
		ocupado = true;
	}
	
	public void liberar(){
		ocupado = false;
	}
	
	public boolean estado(){
		return ocupado;
	}

	// Metodos set/get
	
	public int getFila() {
		return fila;
	}

	public int getNumero() {
		return numero;
	}
	
	public boolean getEstado() {
		return ocupado;
	}
	
	public String toString() {
	    String s =("Asiento Fila: "+fila+" Numero: "+numero+"\n");
	    return s;
	}
}