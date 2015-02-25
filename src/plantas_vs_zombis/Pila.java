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
public class Pila {
    NodoPersonajes primero;
    NodoPersonajes ultimo;
    private int cantidad;
    
    public Pila(){
    primero=ultimo=null;
    cantidad=0;
    
    }
    public Boolean PilaVacia(){
    return primero==null;
    }
    public NodoPersonajes Pop(){
          NodoPersonajes info=null;
        if(!PilaVacia()){
          info =ultimo;
        
        if(ultimo==primero){
        primero=ultimo=null;
        cantidad=cantidad-1;
        } else{
        NodoPersonajes actual=primero;
        while(actual.anterior!=ultimo){
        actual=actual.anterior;
        
        }
        ultimo=actual;
        actual.anterior=null;
         cantidad=cantidad-1;
        }
        }
       return info;
    }
    
    public void Push(NodoPersonajes nodo){
    
    if(PilaVacia()){
    cantidad++;
    primero=ultimo=nodo;
    } else{
    cantidad++;
    ultimo=ultimo.anterior=nodo;
    }
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
      m++;
        n= primero.anterior;
        while (n!=null){
           b=Integer.toOctalString(m); 
          c=n.getNombre();
          g.add("->"+c+b);
          n= n.anterior;
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
