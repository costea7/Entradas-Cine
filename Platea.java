package practica1;

public class Platea {
	
	private String nombre;
	private Asiento[] asientos;
	private int asientosTotales;
	public int MAX_ASIENTOS = 500;
	private int fila;
	private int numero;
	
	public Platea(String nombre, int asientosTotales) {
		this.nombre = nombre;
		asientos = new Asiento[asientosTotales];
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	boolean nuevo(Asiento asiento) {
		if (asientosTotales < asientos.length) {
			asientos[asientosTotales++] = asiento;
			return true;
		}
		return false;
	}
	
	public void ocupar(Asiento asiento){
		asiento.ocupar();
	}
	
	public void liberar(Asiento asiento){
		asiento.liberar();
	}
	
	public String toString() {
	    String s = nombre + " " +  "\n";
	    s = s + "Asientos : ";
	  
	    for (int i = 0; i < asientosTotales; i++) {
	    	s = s + asientos[i].toString() + " ";
	    }
	    return s;
	  }
	
}
