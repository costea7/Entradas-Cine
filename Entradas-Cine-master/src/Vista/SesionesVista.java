/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Asiento;
import Modelo.Sesion;
import java.awt.FlowLayout;
import java.io.FileNotFoundException;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

/**
 *
 * @author Iulian
 */
public class SesionesVista extends JPanel{
  
    private CineVista sesionesVista;
    public static final boolean RECIBIR_EVENTOS_RATON = true;
    
    SesionesVista(final CineVista vista, int id, String fichero, boolean recibe_eventos_raton) throws FileNotFoundException {   
      this.sesionesVista = vista;
      //String fichero = "sesion1.txt";
      Sesion sesion = new Sesion(id,fichero);
      
      //creacion lista sesiones
      
      JList lista = new JList();
      lista.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION); 
      Object[] seleccion = lista.getSelectedValues(); 
    
      int[] indices = lista.getSelectedIndices(); 
      JScrollPane barraDesplazamiento = new JScrollPane(lista);
      barraDesplazamiento.setBounds(10,30,200,110); 
      add(barraDesplazamiento); 
      }
    
     /**
   * añade una sesion
   * 
   */   
  public void añadirSesion(int id, String fichero) throws FileNotFoundException {    
    Sesion sesion = new Sesion(id,fichero);  
      
    DefaultListModel demoList = new DefaultListModel();
    demoList.addElement(sesion.devuelvePelicula());
    sesion.devuelvePelicula();
  
   
  }
}
