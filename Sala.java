package practica1;

public class Sala {
	
	private int numero;
	private Sesion[] sesiones;
	private int numSesiones;
	
	public int MAX_SESIONES = 500;
	
	public Sala(int numero) {
		
		this.numero = numero;
		sesiones = new Sesion[MAX_SESIONES];
	}

	boolean nuevaSesion(Sesion sesion){
		if (numSesiones < sesiones.length) {
			sesiones[numSesiones++] = sesion;
			return true;
		}
		return false;
	}
	
	
	Sesion buscarSesion(int idSesion){	
		for (int i = 0; i < numSesiones; i++) {	
			if (sesiones[i].devuelveId() == idSesion)
				return sesiones[i];	
		}
		return null;
	}
	
	public boolean nuevaPlatea(int idSesion, Platea platea) {
		Sesion sesion = buscarSesion(idSesion);
		if (sesion != null){
			sesion.nuevaPlatea(platea);
			return true;		
		}
		return false;
	}
	
	

	
	public String generarMapaOcupacion(int idSesion, String nombrePlatea){
		String s = "Sala "+devuelveNumero()+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		if((sesion != null)){
			s = s + sesion.generarMapaOcupacion(nombrePlatea);
		}
		
		return s;
	}
	
	
	
	public String generarEntrada(int idSesion, String nombrePlatea, int fila, int numero) {
		String s = "Sala "+idSesion+  "\n";
		Sesion sesion = buscarSesion(idSesion);
		s = s + sesion.generarEntrada(nombrePlatea,fila,numero);
		return s;
	}

	boolean comprarEntrada(int idSesion, String nombrePlatea, int fila, int numero){
		Sesion sesion = buscarSesion(idSesion);
		if((sesion != null)){
			if(sesion.comprarEntrada(nombrePlatea, fila, numero)){
				return true;
			}
		}
		return false;
	}
	
	public int devuelveNumero() {
		return numero;
	}

	public String comprarT(int idSesion,String nombrePlatea, int fila, int numero) {
		String s = ""; 
                Sesion sesion = buscarSesion(idSesion);
                 
		try{
                   //sesion.buscarPlatea(nombrePlatea);
                    s = s + devuelveNumero() + "\n";
			s = s + sesion.comprarT( idSesion,nombrePlatea, fila, numero);
		}
		catch(NullPointerException e) {
                     return  "\nError no hay sesion\n";
                }
		return s;
	}	
}