package Modelo;

/**
* Asiento
*
* @author Alex Costea y Aitor Mari
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
  
  /**
   * Cambiar el estado de un asiento a ocupado
   * 
   */
  public void ocupar(){
    ocupado = true;
  }

  /**
   * Cambiar el estado de un asiento a libre
   * 
   */
  public void liberar(){
    ocupado = false;
  }

  /**
   * Devuelve estado asiento
   * 
   * @return 
   */
  public boolean estaOcupado(){
    return ocupado;
  }

  public int devuelveFila() {
    return fila;
  }

  public int devuelveNumero() {
    return numero;
  }

  /**
   * String devuelve entrada
   * 
   * @return 
   */
  public String comprarEntrada() {
    String s = ("Asiento Fila: " + devuelveFila() + 
            " Numero: " + devuelveNumero());
    return s;
  }
}