/**
 * TresEnRayaVista.java
 * 03/2017
 * @author ccatalan
 * 
 */
package Vista;

import Controlador.Cine;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.*;
import java.util.Observer;
import java.util.Observable;


import java.awt.Color;
import java.awt.Dimension;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import Modelo.Asiento;
import Modelo.Platea;
import Modelo.Sala;
import Modelo.Sesion;
import Controlador.OyenteVista;
import Modelo.Butaca;
import Modelo.Tupla;

import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Paint;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * Vista Swing del Tres en Raya
 * 
 */
public class CineVista extends JFrame implements ActionListener, Observer {  
  private static CineVista instancia = null;  // es singleton
  private OyenteVista oyenteVista;
  private PlateaVista plateaVista;
  private SesionesVista sesionesVista;
  private JLabel estadoTablero;
  private ImageIcon icono, iconoAsiento;
  private JButton botonAbrir;
  
  private Cine cine;
  

  public static final int ABRIR_FICHERO = 0;
  public static final int OPCION_SI = JOptionPane.YES_OPTION;
  
  /** Identificadores de textos dependientes del idioma */
  private static final String TITULO = "Cine Rialto";
  private static final String AUTOR = "Alex Costea y Aitor Mari";
  private static final String VERSION = "05/2017";
  

  private static final String MENU_FICHERO = "Fichero";
  private static final String MENU_ITEM_NUEVA = "Nueva sesion"; //abrir una sesion
  private static final char ATAJO_MENU_ITEM_NUEVA = 'N';

  private static final String MENU_ITEM_SALIR = "Salir";
  private static final char ATAJO_MENU_ITEM_SALIR = 'S';
  private static final String MENU_AYUDA = "Ayuda";
  private static final String MENU_ITEM_ACERCA_DE = "Acerca de...";
  private static final char ATAJO_ITEM_ACERCA_DE = 'A';
  
  
  
  private static final String ESTADO_INICIAL = "Sesión actual";
  

  public static final String FICHERO_NO_ENCONTRADO = "Fichero no encontrado";
    
 


    
  private static final String RUTA_RECURSOS = "/Vista/recursos/";
  private static final String ICONO_APLICACION = "icono.png";
  private static final String ICONO_ASIENTO = "asiento1.PNG";
  private static final String ICONO_CIRCULO = "circulo.PNG";
   private static final String ICONO_NUEVA = "nueva.png"; 
    
  /** Constantes para redimensionamiento */
  private static final int MARGEN_HORIZONTAL = 50;
  private static final int MARGEN_VERTICAL = 100;
  
  
  public static final String EXT_FICHERO_PARTIDA = ".txt";
  public static final String FILTRO_PARTIDAS = "Sesiones";
    
  /**
   * Construye la vista del tablero de filas x columnas con el oyente para
   * eventos de la interfaz de usuario indicado
   * 
   */
  private CineVista(final OyenteVista oyenteVista, int filas, int columnas) throws FileNotFoundException {  
    super(TITULO);
    
    this.oyenteVista = oyenteVista;
    
    
    addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        oyenteVista.notificacion(OyenteVista.Evento.SALIR, null);
      }
    });
    
    setLayout(new BorderLayout());
    
    
    JPanel panelNorte = new JPanel();
    panelNorte.setLayout(new GridLayout(2, 1));
    
    // creamos elementos
    creaMenus(panelNorte);
    creaBarraHerramientas(panelNorte);
    add(panelNorte, BorderLayout.NORTH);
    
    JPanel panelCentral = new JPanel();
    panelCentral.setLayout(new FlowLayout());
    
    
    creaTablero(panelCentral, filas, columnas);
    
    add(panelCentral, BorderLayout.CENTER);
    
    
    estadoTablero = new JLabel(ESTADO_INICIAL);
    add(estadoTablero, BorderLayout.SOUTH);
    
    //creacion panel este con la jlist de las sesiones 
    JPanel panelEste = new JPanel(); 
    panelEste.setLayout(new GridLayout());
  
    panelEste.setMaximumSize(new Dimension(20,20));

      
    creaListaSesiones(panelEste);
  
    add(panelEste, BorderLayout.EAST);
    //añadirSesion(1,a);
  //  añadirSesion(2,b);
    
    icono = new ImageIcon(
        this.getClass().getResource(RUTA_RECURSOS + ICONO_APLICACION));
        setIconImage(icono.getImage());
    
    iconoAsiento = new ImageIcon(
        this.getClass().getResource(RUTA_RECURSOS + ICONO_ASIENTO));
    
    
    // hacemos visible con el tamaño y la posición deseados     
    setResizable(false);
    setSize((int)(plateaVista.dimensionCasilla().getWidth() * 
                   + MARGEN_HORIZONTAL), 
            (int)(plateaVista.dimensionCasilla().getHeight() * 
                   + MARGEN_VERTICAL));
      
    pack();  // ajusta ventana y sus componentes
    setVisible(true);
    setLocationRelativeTo(null);  // centra en la pantalla
  } 
  
  /**
   * Devuelve la instancia de la vista del tablero
   * 
   */        
  public static synchronized CineVista instancia(
          OyenteVista oyenteIU, int numFilTab, int numColTab) throws FileNotFoundException {
    if (instancia == null)
      instancia = new CineVista(oyenteIU,numFilTab, numColTab);    
    return instancia;
  } 
  
  private void creaMenus(JPanel panelNorte) {
    
    JMenu menuFichero = new JMenu(MENU_FICHERO);
    
    

    JMenuItem menuFicheroNueva = 
      new JMenuItem(MENU_ITEM_NUEVA, ATAJO_MENU_ITEM_NUEVA);
    menuFicheroNueva.addActionListener(this);
    menuFicheroNueva.setActionCommand(MENU_ITEM_NUEVA);
    menuFichero.add(menuFicheroNueva);
      
      
  JMenuItem menuFicheroSalir = 
      new JMenuItem(MENU_ITEM_SALIR, ATAJO_MENU_ITEM_SALIR);
    menuFicheroSalir.addActionListener(this);
    menuFicheroSalir.setActionCommand(MENU_ITEM_SALIR);
    menuFichero.add(menuFicheroSalir);
    
    
    JMenu menuAyuda = new JMenu(MENU_AYUDA);
    
    JMenuItem menuAyudaAcercaDe = 
      new JMenuItem(MENU_ITEM_ACERCA_DE, ATAJO_ITEM_ACERCA_DE);
    menuAyudaAcercaDe.addActionListener(this);
    menuAyudaAcercaDe.setActionCommand(MENU_ITEM_ACERCA_DE);
    menuAyuda.add(menuAyudaAcercaDe);    

   JMenuBar menuPrincipal = new JMenuBar();
   menuPrincipal.add(menuFichero);   
   menuPrincipal.add(menuAyuda);
    
     panelNorte.add(menuPrincipal);
     
   
  }
  
  /**
   * Crea barra de herramientas
   * 
   */ 
  private void creaBarraHerramientas(JPanel panelNorte) {
      
      
    JToolBar barra = new JToolBar();
    barra.setFloatable(false);
    
  
    botonAbrir = new JButton(new ImageIcon(
       this.getClass().getResource(RUTA_RECURSOS + ICONO_NUEVA))); 
    botonAbrir.setToolTipText(MENU_ITEM_NUEVA);
    botonAbrir.addActionListener(this);
    botonAbrir.setActionCommand(MENU_ITEM_NUEVA);
   
    barra.add(botonAbrir);
    
    panelNorte.add(barra);
  }
  
  /**
   * Crea la vista del tablero
   * 
   */   
  private void creaTablero(JPanel panel, int numFilTab, int numColTab) {
    plateaVista = new PlateaVista(this, numFilTab, numColTab, 
                                    PlateaVista.RECIBIR_EVENTOS_RATON);
  
    panel.add(plateaVista);
    panel.add(new JPanel());
  }
  
  
  private void creaListaSesiones(JPanel panelEste) throws FileNotFoundException{  
    sesionesVista = new SesionesVista(this);
    
   
    panelEste.add(sesionesVista);
    
  }
  
   /**
   * Selecciona fichero de partida
   * 
   */  
  public String seleccionarFichero(int operacion) {
    String nombreFichero = null;
    
    
    JFileChooser dialogoSeleccionar = new JFileChooser(new File("."));
    FileNameExtensionFilter filtro = 
         new FileNameExtensionFilter(FILTRO_PARTIDAS, 
                                     EXT_FICHERO_PARTIDA.substring(1));
    
    dialogoSeleccionar.setFileFilter(filtro);
    int resultado = 0;
    
    if (operacion == ABRIR_FICHERO) {
      resultado = dialogoSeleccionar.showOpenDialog(this);
    } else {
      resultado = dialogoSeleccionar.showSaveDialog(this);
    }
    if(resultado == JFileChooser.APPROVE_OPTION) {
      nombreFichero = dialogoSeleccionar.getSelectedFile().getName();
   
    }
    return nombreFichero;
  }
  
  
  /**
   * Sobreescribe actionPerformed
   * 
   */
  @Override
  public void actionPerformed(ActionEvent e) {
    switch(e.getActionCommand()) {
        case MENU_ITEM_NUEVA:
           oyenteVista.notificacion(OyenteVista.Evento.NUEVA, null); 
           break;   
           
//        case MOSTRAR_PLATEA:
//           oyenteVista.notificacion(OyenteVista.Evento.CARGAR_MAPA,null);
//           break;
           
        case MENU_ITEM_SALIR:
           oyenteVista.notificacion(OyenteVista.Evento.SALIR, null);
           break;
           
        case MENU_ITEM_ACERCA_DE:
           JOptionPane.showMessageDialog(this,
           TITULO + "\n" + AUTOR + "\n" + VERSION, 
           MENU_ITEM_ACERCA_DE, JOptionPane.INFORMATION_MESSAGE,  icono);   
           break;
        
    }
  }
  
  /**
   * Pone Icono del color indicado en la posición indicada
   * 
   */  
  public void ponerIconoCasilla(Asiento asiento, Butaca butaca) {
    
      if (butaca != Butaca.VACIA) {
      if (butaca == Butaca.LIBRE) {
         plateaVista.ponerIconoCasilla(asiento, iconoAsiento);   
      } 
      else if (butaca == Butaca.OCUPADA) {
         plateaVista.ponerIconoCasilla(asiento, iconoAsiento);   
      }
    } else {
      plateaVista.ponerIconoCasilla(asiento, null);   
    }  
      } 
  
  public void añadirSesion(int id, String fichero) throws FileNotFoundException{
        sesionesVista.añadirSesion(id, fichero,SesionesVista.RECIBIR_EVENTOS_RATON);
        
       
  }
  
  
   /**
   * Inicia Tablero Vista
   * 
   */   
  public void iniciarTableroVista(Platea platea) {
  
     for (int fila = 0; fila < platea.devuelveNumFilas(); fila++) {
           
        for (int columna = 0; columna < platea.devuelveNumColumnas(); columna++) { 
       
          // if (platea.devuelveButaca(fila, columna) != Butaca.VACIA){
             Asiento asiento = new Asiento(fila, columna);
             ponerIconoCasilla(asiento, platea.devuelveFicha(asiento));
        //   }     
        }     
     }  
  }
  
  /**
   * Notificación de un evento de la interfaz de usuario
   * 
   */
  public void notificacion(OyenteVista.Evento evento, Object obj) {
    oyenteVista.notificacion(evento, obj);    
  }
  
   /**
   * Sobreescribe update para recibir eventos del tablero observado
   * 
   */  
  
  public void update(Observable obj, Object arg) {
    Tupla tupla;
    
    if (arg instanceof Tupla) {
      tupla = (Tupla)arg;
      ponerIconoCasilla((Asiento)tupla.b, ((Butaca)tupla.a));
    } 
  }
  
}