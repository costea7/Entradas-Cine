/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.OyenteVista;
import static Controlador.OyenteVista.Evento.VER_MAPA;
import Modelo.Asiento;
import Modelo.Platea;
import Modelo.Sesion;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
public class SesionesVista extends JPanel implements ActionListener{
  
    private CineVista cineVista;
    public static final boolean RECIBIR_EVENTOS_RATON = true;
    private OyenteVista oyenteVista;
    DefaultListModel modelSesiones, modelLogs;
    JList listSesiones;
    JList listLogs;
    JScrollPane paneSesiones, paneLogs;
    private static final String MOSTRAR_PLATEA = "platea";
    private JButton buttonVer,buttonComprar;
    String cadena = "";

   //setBorder(BorderFactory.createTitledBorder("Sesiones"));
    
    SesionesVista(final CineVista vista) throws FileNotFoundException {   
        
      this.cineVista = vista;
      
      setLayout(new BorderLayout());
      
      JPanel panelCentral = new JPanel(); 
      panelCentral.setLayout(new FlowLayout());     
      //panelCentral.setLayout(new BoxLayout(panelCentral, BoxLayout.PAGE_AXIS));
        
      buttonVer = new JButton("Ver platea");
      buttonVer.setPreferredSize(new Dimension(120, 30));
      buttonVer.addActionListener(this);
      
      buttonComprar = new JButton("Vender");
      buttonComprar.setPreferredSize(new Dimension(120, 30));
      buttonComprar.setEnabled(false);
      buttonComprar.addActionListener(this);
      
      JPanel panelNorte = new JPanel();
      panelNorte.setLayout(new GridLayout(1, 1));
      
      modelSesiones = new DefaultListModel();
      listSesiones = new JList(modelSesiones);
      paneSesiones = new JScrollPane(listSesiones);
      paneSesiones.setBorder(BorderFactory.createTitledBorder("Sesiones"));
      paneSesiones.setPreferredSize(new Dimension(120, 200));
      
      
    
      JPanel panelSur = new JPanel();
      panelSur.setLayout(new GridLayout(1, 1));

      modelLogs = new DefaultListModel();
      listLogs = new JList(modelLogs);         
      paneLogs = new JScrollPane(listLogs);          
      paneLogs.setBorder(BorderFactory.createTitledBorder("Logs"));
      paneLogs.setPreferredSize(new Dimension(120, 200));
  
      
      panelCentral.add(buttonVer);
      panelCentral.add(buttonComprar);
      panelSur.add(paneLogs);
      panelNorte.add(paneSesiones);
      
      add(paneSesiones,BorderLayout.NORTH);
      add(panelCentral,BorderLayout.CENTER);
      add(panelSur,BorderLayout.SOUTH);
  
      this.setPreferredSize(new Dimension(250,250));
      }
    
     /**
   * añade una sesion
   * 
   */   
  public void añadirSesion(final Sesion sesion,boolean recibe_eventos_raton)  throws FileNotFoundException  {    
       
      String datosSesion = sesion.devuelvePelicula()+ " - " + sesion.devuelveFecha() + " - " 
             + sesion.devuelveHoraInicio() + " - "  +sesion.devuelveNumSala();
 
       modelSesiones.addElement(datosSesion);
     
         

     this.setPreferredSize(new Dimension(250,250));
   
  }

    @Override
    public void actionPerformed(ActionEvent e) {
     if (e.getActionCommand().equals("Ver platea")) {

            int index = listSesiones.getSelectedIndex();
            
            if (index >= 0){

            String s = (String) listSesiones.getSelectedValue();
            String[] parts = s.split(" - ");
        
            String numSala = parts[3]; 
            
            int indice = index+1;
            cadena = numSala + "-" + indice;
            //System.out.println(cadena + "esta es!!");
            this.setPreferredSize(new Dimension(250,250));
            cineVista.notificacion(OyenteVista.Evento.VER_MAPA,cadena);
            buttonComprar.setEnabled(true);  
            }   
        }
    }
}





















///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package Vista;
//
//import Controlador.OyenteVista;
//import static Controlador.OyenteVista.Evento.VER_MAPA;
//import Modelo.Asiento;
//import Modelo.Platea;
//import Modelo.Sesion;
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import java.io.FileNotFoundException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.BorderFactory;
//import javax.swing.DefaultListModel;
//import javax.swing.Icon;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JList;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.ListSelectionModel;
//
///**
// *
// * @author Iulian
// */
//public class SesionesVista extends JPanel{
//  
//    private CineVista cineVista;
//    public static final boolean RECIBIR_EVENTOS_RATON = true;
//    private OyenteVista oyenteVista;
//    DefaultListModel model;
//    JList list;
//    JScrollPane pane;
//    private static final String MOSTRAR_PLATEA = "platea";
//    
//            
//    private JButton botonAbrir;
//   //setBorder(BorderFactory.createTitledBorder("Sesiones"));
//    
//    SesionesVista(final CineVista vista) throws FileNotFoundException {   
//        
//      this.cineVista = vista;
//      
//      
//      model = new DefaultListModel();
//  
//      setLayout(new BorderLayout());
//       
//      list = new JList(model);
//      
//      pane = new JScrollPane(list);
//      
//      pane.setBorder(BorderFactory.createTitledBorder("Sesiones"));
//     
//       
//      add(pane, BorderLayout.NORTH);
//      this.setPreferredSize(new Dimension(275,250));
//      
//      }
//    
//     /**
//   * añade una sesion
//   * 
//   */   
//  public void añadirSesion(int id, String fichero,boolean recibe_eventos_raton) throws FileNotFoundException {    
//   
//  Sesion sesion = new Sesion(id,fichero);
//    
//  String datosSesion = sesion.devuelvePelicula() + " - " + sesion.devuelveFecha() + " - " + sesion.devuelveHoraInicio();
//  sesion.generarMapaOcupacion();
//       model.addElement(datosSesion);
//      
//       //list = new JList(model);
//
//      if (recibe_eventos_raton) {
//          list.addMouseListener(new MouseAdapter() { 
//          @Override
//            public void mousePressed(MouseEvent e) {  
//              JList theList = (JList)e.getSource();
//              
//              int index = theList.locationToIndex(e.getPoint());
//               if (index >= 0) {
//            Object o = theList.getModel().getElementAt(index);
//            System.out.println("Double-clicked on: " + o.toString());
//            System.out.println(list.getSelectedIndex());
//              
//            oyenteVista.notificacion(OyenteVista.Evento.VER_MAPA,null ); 
//           
//   
//               }                 
//            }
// 	  });
//         
//        }           
//      this.setPreferredSize(new Dimension(275,250));
//   
//  }
//}