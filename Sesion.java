package practica1;

public class Sesion {

	private int id;
	private String pelicula;
	private String horaInicio, horaFin, fecha;
	private Platea[] plateas;
	private int asientosLibres;	
	private int numPlateas;
	public int MAX_PLATEAS = 500;
	
	public Sesion(int id, String pelicula, String horaInicio, String horaFin,String fecha) {

		this.id = id;
		this.pelicula = pelicula;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.fecha = fecha;
		plateas = new Platea[MAX_PLATEAS ];
	}

	boolean nuevaPlatea(Platea platea) {	
		if (numPlateas < plateas.length) {
			plateas[numPlateas++] = platea;
			return true;
		}
		return false;
	}
	
	boolean eliminarPlatea(Platea platea) {
		plateas[numPlateas--] = platea;
		return true;
	}
	
	Platea buscarPlatea(String nombre){	
		for (int i = 0; i < numPlateas; i++) {	
			if (plateas[i].getNombre().equals(nombre))
				return plateas[i];	
		}
		return null;
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
	
	
	public int getId() {
		return id;
	}	
	
	public String toString(String nombrePlatea,  int fila, int numero) {
		String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
		Platea platea = buscarPlatea(nombrePlatea);
		s = s + platea.toString(fila, numero);
		return s;
	}
}