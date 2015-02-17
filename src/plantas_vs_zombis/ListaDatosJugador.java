/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantas_vs_zombis;

/**
 *
 * @author HUGO
 */
public class ListaDatosJugador {
    NodoDatosJugador primero;
    NodoDatosJugador ultimo;
    
    public ListaDatosJugador(){
    primero=ultimo=null;
    
    }
    public Boolean vacio(){
    return primero==null;
    }
    
    public void insertar(String nom,String inf){
    if (vacio()){
    
    primero=ultimo=new NodoDatosJugador(nom , inf);
    }else{
    
    ultimo=ultimo.Siguiente=new NodoDatosJugador(nom , inf);
    }
    
    }
    
     public void imprimir(){
  NodoDatosJugador aux;
  aux=primero;
  if(!vacio()){
  while(aux!=null){
  System.out.println(aux.getInformacionCampo());
  aux=aux.Siguiente;
  }
  System.out.println("-------");
  }
  else{
  System.out.println("NO hay datos del nodo");
  System.out.println("-------");
  }
  }
       public String imprimirG(){
  NodoDatosJugador aux;
  aux=primero;
  String cadena="";
  cadena=primero.getInformacionCampo()+"__"+primero.getInformacionCampo();
  if(!vacio()){
  while(aux!=null){
  System.out.println();
  
  cadena=cadena+""+aux.getNombreCampo()+"__"+aux.getInformacionCampo()+"->";
  aux=aux.Siguiente;
  }
  System.out.println("-------");
  }
  else{
  System.out.println("NO hay datos del nodo");
  System.out.println("-------");
  }
    return cadena; 
}
    
}
