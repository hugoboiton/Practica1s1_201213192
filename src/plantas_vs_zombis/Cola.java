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
    private int cantidad;
    
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
    cantidad=   getCantidad()-1;
    }
    else{
    primero=primero.siguiente;
    cantidad=   getCantidad()-1;
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
         int m=1;
         String b=Integer.toOctalString(m); 
        String c=primero.getNombre();
        g.add(""+c+b);
      
        n= primero.siguiente;
        m++;
        while (n!=null){
           b=Integer.toOctalString(m); 
          c=n.getNombre();
          g.add("->"+c+b);
          n= n.siguiente;
          m++;
        }
               
       
        g.add(";");        
        
        g.addln(g.end_graph());
        
        return g;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }
    
}
