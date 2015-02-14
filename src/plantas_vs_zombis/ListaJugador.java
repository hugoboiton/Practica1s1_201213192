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
  public void insertar( String Jugador,String nom , String cat){
  
  if (vacio()){
  primero=ultimo= new NodoJugador(Jugador, nom,cat);
  }else{
  
   ultimo=ultimo.siguiente= new NodoJugador(Jugador,nom,cat);
  }    
  
  }
  
  public NodoJugador BuscarPunteroLista(String JugadorB){
  NodoJugador aux;
  aux=primero;
  while (aux!=null){
  if(aux.getNombre().equals(JugadorB)){
      
  break;
  }else{
  aux=aux.siguiente;
  }
  
  }
      
      return aux;
  }
  public void imprimir(){
  NodoJugador aux;
  aux=primero;

  if (!vacio()){
  while(aux!=null){
  System.out.print(aux.getJugador());
  System.out.print("  ");
  System.out.print(aux.getNombre());
  System.out.println();
  aux.apuntadorJugadorDatos.imprimir();
  aux=aux.siguiente;
  }
  System.out.println("-------------");
  }else{
      System.out.println("lista vacia XD");
  System.out.println("-------------");
  }
  }
}
