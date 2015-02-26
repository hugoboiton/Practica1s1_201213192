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
   private String foto="";
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
   
    Border border = LineBorder.createBlackLineBorder();
    this.setBorder(border);
    
    }
public void ponerPersonaje (String per){
           System.out.println(per);
           ImageIcon perso = new ImageIcon(per);
           this.setIcon(perso);
           System.out.println(x+" "+y);
           this.foto=per;
}
public void ArgregarPersonaje (NodoPersonajes nodo){
 listadenodo.insertar(nodo);
 System.out.println(listadenodo.tamano());
}
public String nombreP(){
String nom=Integer.toString(x)+Integer.toString(y);
return nom;
}

    /**
     * @return the foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * @param foto the foto to set
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }
 
}
