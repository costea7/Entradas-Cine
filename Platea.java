package practica1;


public class Platea {
	
	private String nombre;
	private int asientosTotales;
	private Asiento[] asientos;
	
	//public int MAX_ASIENTOS = 500;
	
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
	
	public boolean ocupar(int fila, int numero){
		Asiento asiento = buscarAsiento(fila,numero);
		if (asiento!=null){
			if((asiento.getEstado()== false)){
				asiento.ocupar();
				return true;	
			}
		}
		return false;
	}
	
	public void liberar(Asiento asiento){
		asiento.liberar();
	}
	
	Asiento buscarAsiento(int fila, int numero){	
		for (int i = 0; i < asientosTotales; i++) {	
			if (asientos[i].getFila() == fila && asientos[i].getNumero() == numero)
				return asientos[i];	
		}
		return null;
	}
	
	public String toString(int fila, int numero) {
		Asiento asiento = buscarAsiento(fila, numero);
		String s = asiento.toString();
		return s;
	}
	
}