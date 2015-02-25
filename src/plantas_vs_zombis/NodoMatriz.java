/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantas_vs_zombis;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author HUGO
 */
public class NodoMatriz extends JButton  {
    
   NodoMatriz Siguiente;
   NodoMatriz Anterior;
   NodoMatriz Ariba;
   NodoMatriz Abajo;
   ListasNodoMatriz listadenodo;
   JLabel label;
   int x;
   int y;
    public NodoMatriz(int x,int y){
    Siguiente=null;
    Anterior=null;
    Ariba=null;
    Abajo=null;
    this.x=x;
    this.y=y;
    listadenodo=new ListasNodoMatriz();
    this.setBounds(0, 0, 100, 100);
    this.setBackground(Color.GREEN);
    this.setLabel(x +""+y);
    Border border = LineBorder.createBlackLineBorder();
    this.setBorder(border);
    
    }
public void ponerPersonaje (String per){
           System.out.println(per);
           ImageIcon perso = new ImageIcon(per);
           this.setIcon(perso);
}
public void ArgregarPersonaje (NodoPersonajes nodo){
 listadenodo.insertar(nodo);
 System.out.println(listadenodo.tamano());
}
 
}
