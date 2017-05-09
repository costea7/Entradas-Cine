/**
 * CasillaVista.java
 * 03/2017
 * @author ccatalan
 * 
 */
package Vista;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

import Modelo.Asiento;
import javax.swing.JButton;


/**
 * Vista de una casilla del tablero a partir de un JLabel
 * 
 */
public class AsientoVista extends JLabel {
  private Asiento asiento;

  /**
   * Construye una vista con el icono indicado de la casilla en una posición 
   * 
   */
  AsientoVista(Asiento asiento, Icon icono) {
    this.asiento = asiento;

    setIcon(icono);
        
    setHorizontalAlignment(SwingConstants.CENTER);
    setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    //setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
  }
  
  
  
  /**
   * Construye una vista sin icono de la casilla en una posición 
   * 
   */
   AsientoVista(Asiento asiento) {
    this(asiento, null);
  }

  /**
   * Devuelve la posición de la casilla
   * 
   */
  public Asiento devuelvePosicion() {
    return asiento;
  }
    
  /**
   * Sobreescribe toString
   * 
   */  
  @Override
  public String toString() {
    return asiento.toString();
  }
}
      
      