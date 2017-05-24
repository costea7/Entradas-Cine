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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;



/**
 * Vista de una casilla del tablero a partir de un JLabel
 * 
 */
public class AsientoVista extends JButton {
  private Asiento asiento;
 
  /**
   * Construye una vista con el icono indicado de la casilla en una posición 
   * 
   */
  AsientoVista(Asiento asiento, Icon icono) {
    this.asiento = asiento;
    setIcon(icono);
    setBackground(Color.WHITE);
   
    setHorizontalAlignment(SwingConstants.CENTER);
   // setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
   // setBorder(BorderFactory.createEtchedBorder());
    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
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
  public Asiento devuelveAsiento() {
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
      
      