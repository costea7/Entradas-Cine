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

	public void cambiarPelicula(){
		
	}
	
	public Platea verMapaOcupacion(){
		return mapaOcupacion;
	}
	
	public void ocupar(Asiento asiento){
		mapaOcupacion.ocupar(asiento);
	}
	
	public void liberar(Asiento asiento){
		mapaOcupacion.liberar(asiento);
	}

	
	//Metodos get/set
	
	public int getId() {
		return id;
	}	
	public String getPelicula() {
		return pelicula;
	}
	
	public String toString() {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		return s;
	}
}
