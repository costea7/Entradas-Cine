package practica1;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Sesion {

  private int id;
  private String pelicula;
  private String horaInicio, horaFin, fecha;
  private Platea[] plateas; 
  private int numPlateas;
  private int MAX_PLATEAS = 500;

  public Sesion(int id, String fichero) throws FileNotFoundException {
		
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(new File(fichero));

    this.id = id;
	this.pelicula = scanner.nextLine();
    this.horaInicio = scanner.nextLine();
	this.horaFin = scanner.nextLine();
	this.fecha = scanner.nextLine();
	plateas = new Platea[MAX_PLATEAS ];
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
	    if (plateas[i].devuelveNombre().equals(nombre))
		  return plateas[i];	
		}
	return null;
	}	
	
  public String generarMapaOcupacion(String nombrePlatea){
   String s = devuelvePelicula() + "\n" + "Sesion "+ 
              devuelveHoraInicio() +  " - " + 
	  	      devuelveHoraFin() + " - " + 
              devuelveHoraFin()+"\n";
   Platea platea = buscarPlatea(nombrePlatea);
   if(platea != null) {
     try {
	   s = s + "Asientos totales: " + platea.devuelveAsientosTotales() +
			   "Asientos libres: " + platea.devuelveAsientosLibres() +
			   "\n" + platea.generarMapaOcupacion();
	 }catch (FileNotFoundException e) {
	     e.printStackTrace();
	  }
	}
  return s;
  }
	
  public String generarEntrada(String nombrePlatea,  int fila, int numero) {
    String s = pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
    Platea platea = buscarPlatea(nombrePlatea);
    s = s + platea.generarEntrada(fila, numero);
  return s;
  }
	
  boolean comprarEntrada(String nombrePlatea, int fila, int numero){
    Platea platea = buscarPlatea(nombrePlatea);
      if(platea != null) {
	    if(platea.ocuparAsiento(fila, numero)){
		  return true;	
		}
	  }	
	return false;
	}

  public int devuelveId() {
	return id;
  }	
  public String devuelvePelicula() {
	return pelicula;
  }
  public String devuelveHoraInicio() {
	return horaInicio;
  }
  public String devuelveHoraFin() {
	return horaFin;
  }
  public String devuelveFecha() {
	return fecha;
  }

public String comprarT(int idSesion, String nombrePlatea, int fila, int numero) {
	
	Platea platea = buscarPlatea(nombrePlatea);
	 String s = "";
	 try{
            s = s + pelicula + "\n" + "Sesion "+ horaInicio + " - " + horaFin + " - " + fecha+"\n";
            
            s = s + platea.comprarT( idSesion,nombrePlatea, fila, numero);
            return s;
		}
         catch(NullPointerException e) {
            return  "Error no hay platea\n";
         }	
}
}