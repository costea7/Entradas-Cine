package practica1;

/**
* Asiento
*
*/
public class Asiento {

  private boolean ocupado = false;
  private final int fila;
  private final int numero;

  /**
   * Construye un asiento
   * 
   * @param fila
   * @param numero
   */
  public Asiento(int fila, int numero) {
    this.fila = fila;
    this.numero = numero;
  }

  public void ocupar(){
    ocupado = true;
  }

  public void liberar(){
    ocupado = false;
  }

  public boolean estaOcupado(){
    return ocupado;
  }

  public int devuelveFila() {
    return fila;
  }

  public int devuelveNumero() {
    return numero;
  }

  public String comprarEntrada() {
    String s =("Asiento Fila: "+devuelveFila()+" Numero: "+devuelveNumero());
	return s;
  }
}