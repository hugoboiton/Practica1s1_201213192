/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantas_vs_zombis;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.event.AncestorListener;

/**
 *
 * @author HUGO
 */
public class NodoMatriz extends JLabel   {
    
   NodoMatriz Siguiente;
   NodoMatriz Anterior;
   NodoMatriz Ariba;
   NodoMatriz Abajo;
   int x;
   int y;
    public NodoMatriz(int x,int y){
    Siguiente=null;
    Anterior=null;
    Ariba=null;
    Abajo=null;
    this.x=x;
    this.y=y;
    
    this.setText(x+""+y);
    this.setVerticalTextPosition(JLabel.BOTTOM);
   Border border = LineBorder.createGrayLineBorder();
    this.setBorder(border);
    
    }

    

   
   
    
    
 
    
}
