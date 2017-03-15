package practica1;

public class Sesion {

	private int id;
	private String pelicula;
	private String horaInicio, horaFin, fecha;
	private Platea mapaOcupacion;
	private int asientosLibres;	
	
	public Sesion(int id, String pelicula, String horaInicio, String horaFin,String fecha, Platea mapaOcupacion) {

		this.id = id;
		this.pelicula = pelicula;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
		this.mapaOcupacion = mapaOcupacion;
	}

	public Platea verMapaOcupacion(){
		return mapaOcupacion;
	}
	
	
	boolean comprarEntrada(String nombre, int  fila, int numero){
		Platea mapaOcupacion = buscarPlatea(nombre);
		if(mapaOcupacion != null) {				
			if(mapaOcupacion.ocupar(fila, numero)){
				return true;	
			}
		}	
		return false;
	}
	
	Platea buscarPlatea(String nombre){		
			if (mapaOcupacion.getNombre().equals(nombre)){
				return mapaOcupacion;	
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
	
	public String toString() {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		return s;
	}
}