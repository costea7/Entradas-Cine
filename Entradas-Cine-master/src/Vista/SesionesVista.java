/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.OyenteVista;
import static Controlador.OyenteVista.Evento.CARGAR_MAPA;
import Modelo.Asiento;
import Modelo.Platea;
import Modelo.Sesion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Iulian
 */
public class SesionesVista extends JPanel{
  
    private CineVista cineVista;
    public static final boolean RECIBIR_EVENTOS_RATON = true;
    private OyenteVista oyenteVista;
    DefaultListModel model;
    JList list;
    JScrollPane pane;
    private static final String MOSTRAR_PLATEA = "platea";
    
            
    private JButton botonAbrir;
   //setBorder(BorderFactory.createTitledBorder("Sesiones"));
    
    SesionesVista(final CineVista vista) throws FileNotFoundException {   
        
      this.cineVista = vista;
      
      
      model = new DefaultListModel();
  
      setLayout(new BorderLayout());
       
      list = new JList(model);
      
      pane = new JScrollPane(list);
      
      pane.setBorder(BorderFactory.createTitledBorder("Sesiones"));
     
       
      add(pane, BorderLayout.NORTH);
      this.setPreferredSize(new Dimension(250,250));
      }
    
     /**
   * añade una sesion
   * 
   */   
  public void añadirSesion(int id, String fichero,boolean recibe_eventos_raton) throws FileNotFoundException {    
   
  Sesion sesion = new Sesion(id,fichero);
  //model.addElement("prueba"); //toString();
  
  //arrayList donde guardo los identificadores
  
 // Platea platea = new Platea("platea1", fichero, vista);
 
    
  String datosSesion = sesion.devuelvePelicula() + " - " + sesion.devuelveFecha() + " - " + sesion.devuelveHoraInicio();
  sesion.generarMapaOcupacion("platea1");
       model.addElement(datosSesion);
      
       //list = new JList(model);

      if (recibe_eventos_raton) {
          list.addMouseListener(new MouseAdapter() { 
          @Override
            public void mousePressed(MouseEvent e) {  
              JList theList = (JList)e.getSource();
              
              int index = theList.locationToIndex(e.getPoint());
               if (index >= 0) {
            Object o = theList.getModel().getElementAt(index);
            System.out.println("Double-clicked on: " + o.toString());
              System.out.println(list.getSelectedIndex());
              

//arrayList.get()

            
            oyenteVista.notificacion(OyenteVista.Evento.CARGAR_MAPA,null ); 
           
   
   //        botonAbrir.addActionListener((ActionListener) e);
     //      botonAbrir.setActionCommand(MOSTRAR_PLATEA);
               }                 
            }
 	  });
         
        }
    
      
           
      this.setPreferredSize(new Dimension(250,250));
   
  }
}