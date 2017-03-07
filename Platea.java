package practica1;

public class Platea {
	
	private String nombre;
	private Asiento[][] asientos;
	private int asientosTotales;
	
	public Platea(String nombre, int asientosTotales) {
		this.nombre = nombre;
		this.asientosTotales = asientosTotales;
	}
	
	public void ocupar(Asiento asiento){
		asiento.ocupar();
	}
	
	public void liberar(Asiento asiento){
		asiento.liberar();
	}
	
	
	
}
