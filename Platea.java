package practica1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Platea {

  private String nombre;
  private int numAsientos;
  private int asientosTotales =0;
  private int asientosLibres =0;
  private String mapa;
  private Asiento[] asientos;
  public int MAX_ASIENTOS = 500;

  public Platea(String nombre, String mapa) throws FileNotFoundException {		
	this.nombre = nombre;
	this.mapa = mapa;
	asientos = new Asiento[MAX_ASIENTOS];
	crearAsientos();
  }

  public void crearAsientos() throws FileNotFoundException{
    @SuppressWarnings("resource")
    Scanner scanner = new Scanner(new File(mapa));
    int asientoTemp;
    while(scanner.hasNextInt()){
	  int fila;
      int numero;
	
	  asientoTemp = scanner.nextInt();
	
	  fila  = asientoTemp / 100;
	  numero  = asientoTemp % 100;
	
	   if (numero != 0){ 
	     Asiento asiento = new Asiento(fila, numero);
	     nuevoAsiento(asiento);	
	     asientosTotales++;
	   }
    }
  }

  public boolean nuevoAsiento(Asiento asiento){
    if(numAsientos<asientos.length){
	  asientos[numAsientos++] = asiento;
	  return true;
    }
  return false;
  }

  public String generarMapaOcupacion() throws FileNotFoundException{
	
  @SuppressWarnings("resource")
  Scanner scanner = new Scanner(new File(mapa));

  String s = "";
  int asientoTemp;
  int filaActual=1;
  while(scanner.hasNextInt()){
	int fila=1;
	int numero=1;
	 
  	asientoTemp = scanner.nextInt();

 	fila  = asientoTemp / 100;
 	numero  = asientoTemp % 100;
 	
 	if (filaActual != fila){
 	  s = s+"\n";
	  filaActual++;
    }

    if(numero != 0){ 
 	  Asiento asiento = buscarAsiento(fila, numero);
 	  if(!(asiento.estaOcupado())){
 		s = s+"- ";
      }else{
	    s = s+"X ";
 	  }
 	
    }else{
	  s = s+"  ";
	}
  }
  return s;
}
	
  public boolean ocuparAsiento(int fila, int numero){
    Asiento asiento = buscarAsiento(fila,numero);
	  if (asiento!=null){	
	    if(!(asiento.estaOcupado())){
		  asiento.ocupar();
		    return true;	
	    }
	  }
	return false;
  }
	
  public Asiento buscarAsiento(int fila, int numero){	
    for (int i = 0; i < numAsientos; i++) {	
	  if (asientos[i].devuelveFila() == fila && asientos[i].devuelveNumero() == numero)
	    return asientos[i];	
	  }
	return null;
  }
	
  public String generarEntrada(int fila, int numero) {
	Asiento asiento = buscarAsiento(fila, numero);
	String s = asiento.generarEntrada();
	return s;
  }
	
  public String devuelveNombre() {
    return nombre;
  }
	
  public int devuelveAsientosLibres(){
    for(int i=0;i<numAsientos;i++){
	  if(!(asientos[i].estaOcupado())){
	    asientosLibres++;
	  }
	}
	return asientosLibres;
  }
	
  public int devuelveAsientosTotales(){
	return asientosTotales;
  }

public String comprarT(int idSesion, String nombrePlatea, int fila, int numero) {
	Asiento asiento = buscarAsiento(fila,numero);
	if(!(asiento.estaOcupado())){
		  asiento.ocupar();
		    return asiento.generarEntrada();	
	    }
       
	return "El asiento esta ocupado";
}
  
}