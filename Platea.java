package practica1;

public class Platea {
	
	private String nombre;
	private Asiento[][] asientos;
	private int asientosTotales;
	
	public Platea(String nombre) {
		this.nombre = nombre;
	}
	
	public void ocupar(Asiento asiento){
		asiento.ocupar();
	}
	
	public void liberar(Asiento asiento){
		asiento.liberar();
	}
	
	public void setAsientosTotales(int asientosTotales) {
        this.asientosTotales = asientosTotales;
    }
	
}
