/**
 * OyenteVista.java
 * 03/2017
 * @author ccatalan
 */
package Controlador;

/**
 *  Interfaz de oyente para recibir eventos de la interfaz de usuario
 * 
 */
public interface OyenteVista {
   public enum Evento { NUEVA, SALIR, COMPRAR_ENTRADA, VER_MAPA }
  
   /**
    *  Llamado para notificar un evento de la interfaz de usuario
    * 
    */ 
   public void notificacion(Evento evento, Object obj);
}
