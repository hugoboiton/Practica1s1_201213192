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
public class Cola {
    NodoPersonajes primero;
    NodoPersonajes ultimo;
    int cantidad;
    
    public Cola(){
    primero=ultimo=null;
    cantidad=0;
    
    }
    public Boolean ColaVacia(){
    return primero==null;
    }
    public void enqueue(NodoPersonajes nodo){
    if(ColaVacia()){
        cantidad++;
    primero=ultimo=nodo;
    }else{
    ultimo=ultimo.siguiente=nodo;
    cantidad++;
    }
    
    }
    public NodoPersonajes dequeue(){
    NodoPersonajes actual=null;
        
    if(!ColaVacia()){
    actual=primero;
    if (primero==ultimo){
    primero=ultimo=null;
    
    }
    else{
    primero=primero.siguiente;
    
    }
    }
    return actual;
    }
     public Graphviz Draw()
    {
        Graphviz g = new Graphviz();
        g.addln(g.start_graph());
        g.addln("rankdir = LR;");
        NodoPersonajes n = primero;
        String c=primero.getNombre();
        g.add(""+c);
      
        n= primero.siguiente;
        while (n!=null){
          
          g.add("->"+n.getNombre());
          n= n.siguiente;
      
        }
               
       
        g.add(";");        
        
        g.addln(g.end_graph());
        
        return g;
    }
    
}
