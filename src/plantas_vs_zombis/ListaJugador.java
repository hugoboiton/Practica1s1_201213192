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
public class ListaJugador {
    NodoJugador primero;
    NodoJugador ultimo;
    public ListaJugador(){
    primero =ultimo=null;
    
    }
  public  Boolean vacio(){
        return primero==null;
             }
  public void insertar( String Jugador){
  
  if (vacio()){
  primero=ultimo= new NodoJugador(Jugador);
  }else{
  
   ultimo=ultimo.siguiente= new NodoJugador(Jugador);
  }    
  
  }
  public void imprimir(){
  NodoJugador aux;
  aux=primero;
  
  while(aux!=null){
  System.out.println(aux.getJugador());
  aux=aux.siguiente;
  }
  
  }
}
