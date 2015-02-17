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
   public Graphviz Draw()
    {
        Graphviz g = new Graphviz();
        g.addln(g.start_graph());
        g.addln("rankdir = LR;");
        NodoJugador n = primero;
        String c=primero.getJugador()+"__"+primero.getNombre();
        g.add(""+c);
        NodoDatosJugador aux=primero.apuntadorJugadorDatos.primero;
        String b=aux.getNombreCampo();
        g.add("->"+b);
       aux= aux.Siguiente;
        while (aux!=null){
            b=aux.getNombreCampo();
       g.add(" ->"+b);
        aux=  aux.Siguiente;
       }
       g.add(";"+c);
        
        n = primero.siguiente;
        while(n!= null)
        {
            c=n.getJugador()+"__"+n.getNombre();
            g.add(" -> " +c);
         aux=n.apuntadorJugadorDatos.primero;
            if(aux!=null){
        
         b=aux.getNombreCampo();
         g.add("->"+b);
         aux= aux.Siguiente;
        while (aux!=null){
            b=aux.getNombreCampo();
       g.add(" ->"+b);
        aux=  aux.Siguiente;
       }
       g.add(";"+c);
            }
            n = n.siguiente;
           
        }
        g.add(";");        
        
        g.addln(g.end_graph());
        
        return g;
    }
}
