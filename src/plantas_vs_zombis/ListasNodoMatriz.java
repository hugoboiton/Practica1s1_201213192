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
public class ListasNodoMatriz {
 NodoPersonajes primero;
 NodoPersonajes ultimo;
 int tamaño;
 public ListasNodoMatriz(){
 primero=ultimo=null;
 tamaño=0;
 
 }
 public Boolean Vacio(){
return primero==null;
 
 }
 public void insertar(NodoPersonajes nodo){
     if(Vacio ()){
         tamaño++;
         primero=ultimo=nodo;
     
     }else {
         tamaño++;
            NodoPersonajes aux;
            aux=ultimo;
            ultimo=ultimo.siguiente=nodo;
            ultimo.anterior=aux;
              
     }
     
 
 }
 public NodoPersonajes BuscarNodo(NodoPersonajes nodo){
 NodoPersonajes temp=primero;
 NodoPersonajes Semueve=null;
 if(temp==nodo){
   Semueve=temp;   
   temp=temp.siguiente;
   temp.anterior=null;
   primero=temp;
   return Semueve;
 }else{
 while(temp!=null){
 if(temp==nodo){
 if(temp.siguiente!=null){
     
    Semueve=temp;   
    NodoPersonajes aux;
    aux=temp.anterior;
    temp=temp.siguiente;
    aux.siguiente=temp;
    temp.anterior=aux;
    return Semueve;
  }else{
   Semueve=temp;  
   temp=temp.anterior;
   temp.siguiente=null;
   return Semueve;
  }
 }else{
 temp=temp.siguiente;
 }
 }
 
 }
     return null;
  }
 public int tamano(){
 return tamaño;
 }
}
