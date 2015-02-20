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
public class ListaPersonajes {
    NodoPersonajes primero;
    NodoPersonajes ultimo;
    static int cantidad;
    
    public ListaPersonajes(){
    primero=ultimo=null;
    cantidad=0;
    
    }
    public Boolean Vacio(){
    return primero==null;
    
    }
    
    public void insertar(String nombre,String pta,String pde,String tipo,String per ,String foto){
        
        if(Vacio()){
        primero=ultimo=new NodoPersonajes(nombre,pta,pde,tipo,per,foto);
        
        cantidad++;
        }else{
            NodoPersonajes aux;
            aux=ultimo;
            ultimo=ultimo.siguiente=new NodoPersonajes(nombre,pta,pde,tipo,per,foto);
            ultimo.anterior=aux;
          cantidad++;
        }
          
    }
    public NodoPersonajes Buscar(String para){
     NodoPersonajes temp;
     temp=primero;
     while(temp!=null){
     
     if (temp.getNombre().equals(para)){
         return temp;
     }else{
     temp=temp.siguiente;
     }
       
     }
       return null;
     }
    
    public void Eliminar(String para){
    NodoPersonajes temp=primero;
        if (temp.getNombre().equals(para)){
         
        
            temp=temp.siguiente;
           temp.anterior=null;
        primero=temp;
        }else{
        temp=temp.siguiente;
        while(temp!=null){
        if (temp.getNombre().equals(para)){
            if(temp.siguiente!=null){
            
              NodoPersonajes aux;
              aux=temp.anterior;
              temp=temp.siguiente;
              aux.siguiente=temp;
              temp.anterior=aux;
            } else{
            temp=temp.anterior;
            temp.siguiente=null;
            
            }
                     
        }
        else{
             temp=temp.siguiente;
        }
        
        }
         }
       }
      public int tamaño(){
      
      return cantidad;
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
          n=  n.siguiente;
      
        }
               
       
        g.add(";");        
        
        g.addln(g.end_graph());
        
        return g;
    }
}
