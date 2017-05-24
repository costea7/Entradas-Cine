/**
 * TableroVista.java
 * 03/2017
 * @author ccatalan
 */
package Vista;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JPanel;


import Modelo.Asiento;
import Controlador.OyenteVista;
import Modelo.Platea;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;

/**
 * Vista Swing del tablero
 * 
 */
public class PlateaVista extends JPanel {
  private static final int ALTURA_FILA = 90;
  private static final int ANCHURA_COLUMNA = 20;
  private AsientoVista asientos[][];
  private CineVista tableroVista;
  private OyenteVista oyenteVista;
 
  public static final boolean RECIBIR_EVENTOS_RATON = true;
  public static final boolean NO_RECIBIR_EVENTOS_RATON = false;
  
  private ImageIcon icono;
  
  private Platea platea;
  
  
  PlateaVista(final CineVista vista, int filas, int columnas, 
                boolean recibe_eventos_raton) { 
      
    this.tableroVista = vista;
   
    setLayout(new GridLayout(filas, columnas));
    
    Border raisedbevel = BorderFactory.createRaisedBevelBorder();
    Border loweredbevel = BorderFactory.createLoweredBevelBorder();
   
    //setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
    
    
    asientos = new AsientoVista[filas][columnas];
            for(int fil = 0; fil < filas ; fil++)
                for(int col = 0; col < columnas; col++){        
                    asientos[fil][col] = new AsientoVista(new Asiento(fil, col));  
       
                    add(asientos[fil][col]); //adds button to grid
                     
        if (recibe_eventos_raton) {
          asientos[fil][col].addMouseListener(new MouseAdapter() { 
          @Override
            public void mousePressed(MouseEvent e) {               
              AsientoVista casilla = (AsientoVista)e.getSource();
              vista.notificacion(OyenteVista.Evento.RESERVAR_ASIENTO, 
                                     casilla.devuelveAsiento()); 
              System.out.println(casilla.devuelveAsiento().comprarEntrada());
            }
 	  });
        }        
    } 
    this.setPreferredSize(new Dimension(filas * ALTURA_FILA + 100, 
                                        columnas * ANCHURA_COLUMNA + 100));
    
    
  }
  
  public void notificacion(OyenteVista.Evento evento, Object obj) {
    oyenteVista.notificacion(evento, obj);    
  }
  
  public Platea devuelvePlatea(){
      return platea;
  }

  /**
   * Devuelve el tamaño del tablero
   * 
   */  
  public Dimension dimensionCasilla() {
    return asientos[0][0].getSize();
  }
  
  /**
   * Pone un icono en la casilla de la posición indicada
   * 
   */   
  public void ponerIconoCasilla(Asiento asiento, Icon icono) {     
    asientos[asiento.devuelveFila()][asiento.devuelveNumero()].setIcon(icono);
  }
  

}
