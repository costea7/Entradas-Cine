package practica1;

public class Sesion {

	private int id;
	private String pelicula;
	private String horaInicio, horaFin, fecha;
	private Platea[] plateas;
	private int asientosLibres;	
	private int numPlateas;
	
	public Sesion(int id, String pelicula, String horaInicio, String horaFin,String fecha) {

		this.id = id;
		this.pelicula = pelicula;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
		plateas = new Platea[100];
	}

	public void verMapaOcupacion(){
		
	}
	
	boolean comprarEntrada(String nombrePlatea, int fila, int numero){
		Platea platea = buscarPlatea(nombrePlatea);
		if(platea != null) {	
			if(platea.ocupar(fila, numero)){
				return true;	
			}
		}	
		return false;
	}
	
	boolean nuevoAsiento(String nombrePlatea, Asiento asiento) {
		Platea platea = buscarPlatea(nombrePlatea);
		if(platea != null){		
			platea.nuevo(asiento);
			return true;
		}
		return false;
	}
	
	boolean nuevaPlatea(Platea platea) {	
		if (numPlateas < plateas.length) {
			plateas[numPlateas++] = platea;
			return true;
		}
		return false;
	}
	
	Platea buscarPlatea(String nombre){	
		for (int i = 0; i < numPlateas; i++) {	
			if (plateas[i].getNombre().equals(nombre))
				return plateas[i];	
		}
		return null;
	}
	
	//Metodos get/set
	
	public int getId() {
		return id;
	}	
	public String getPelicula() {
		return pelicula;
	}
	
	public void cambiarPelicula(String pelicula){
		this.pelicula = pelicula;
	}
	
	public String toString(String nombrePlatea,  int fila, int numero) {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		Platea platea = buscarPlatea(nombrePlatea);
		s = s + platea.toString(fila, numero);
		return s;
	}
}