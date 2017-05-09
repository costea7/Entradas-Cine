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
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Vista Swing del tablero
 * 
 */
public class PlateaVista extends JPanel {
  private static final int ALTURA_FILA = 70;
  private static final int ANCHURA_COLUMNA = 20;
  private AsientoVista asientos[][];
  private CineVista tableroVista;
  private ImageIcon icono;
  public static final boolean RECIBIR_EVENTOS_RATON = true;
  public static final boolean NO_RECIBIR_EVENTOS_RATON = false;
  
  
  PlateaVista(final CineVista vista, int filas, int columnas, 
                boolean recibe_eventos_raton) {   
    this.tableroVista = vista;
    
    icono = new ImageIcon(
           this.getClass().getResource("/vista/recursos/asiento.PNG"));
    
    setLayout(new GridLayout(filas, columnas));
    
    asientos = new AsientoVista[filas][columnas];
         
            for(int x = 0; x < filas ; x++)
                for(int y = 0; y < columnas; y++){        
                    asientos[x][y] = new AsientoVista(new Asiento(x, y));  
                    asientos[x][y].setIcon(icono);
                    add(asientos[x][y]); //adds button to grid
                     
        if (recibe_eventos_raton) {
          asientos[x][y].addMouseListener(new MouseAdapter() { 
          @Override
            public void mousePressed(MouseEvent e) {               
              AsientoVista casilla = (AsientoVista)e.getSource();
              vista.notificacion(OyenteVista.Evento.RESERVAR_ASIENTO, 
                                     casilla.devuelvePosicion());              
            }
 	  });
        }        
    } 
    this.setPreferredSize(new Dimension(filas * ALTURA_FILA + 100, 
                                        columnas * ANCHURA_COLUMNA + 100));
    
    
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
    asientos[1][1].setIcon(icono);
  }
}
