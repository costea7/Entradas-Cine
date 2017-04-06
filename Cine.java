package practica1;

public class Cine {
	
  private String nombre;
  private Sala[] salas;
  private int numSalas;
	
  public int MAX_SALAS = 500;
	           
  public Cine(String nombre) {
    this.nombre = nombre;
	salas = new Sala[MAX_SALAS];	
  }
	
  boolean nuevaSala(Sala sala) {
    if (numSalas < salas.length) {
	  salas[numSalas++] = sala;
	  return true;
	}
	  return false;
  }
	
  public Sala buscarSala(int numero) {
	for (int i = 0; i < numSalas; i++) {
	  if (salas[i].devuelveNumero()==numero)
	    return salas[i];
	  }
		return null;
  }

  boolean nuevaSesion(int numeroSala, Sesion sesion ){
    Sala sala = buscarSala(numeroSala);
      if (sala != null){
	    sala.nuevaSesion(sesion);
		  return true;		
	  }
	return false;
  }
	
  boolean nuevaPlatea(int numeroSala, int idSesion, Platea platea){
    Sala sala = buscarSala(numeroSala);
	  if (sala != null){
	    sala.nuevaPlatea(idSesion, platea);
		  return true;		
		}
	  return false;
  }

  public String generarMapaOcupacion(int numeroSala, int idSesion, String nombrePlatea){
    String s = devuelveNombre() + "\n";
	Sala sala = buscarSala(numeroSala);
	if(sala != null){
	  s = s + sala.generarMapaOcupacion(idSesion, nombrePlatea)+"\n";
	}
	return s;
  }
	
  public String devuelveNombre(){
	return nombre;
  }
	
  public String comprarEntrada(int numeroSala, int idSesion, String nombrePlatea, int fila, int numero) {	
    Sala sala = buscarSala(numeroSala);            
	String s = "";            
    try {
      sala.buscarSesion(idSesion).buscarPlatea(nombrePlatea).buscarAsiento(fila, numero);
      s = s +"\n" + devuelveNombre() + "\n";
      s = s + sala.comprarEntrada( idSesion,nombrePlatea, fila, numero);
    }	
    catch(NullPointerException e){
      return "\nError\n";
    }	
	return s;
  }
}