/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plantas_vs_zombis;

import javax.swing.ImageIcon;

/**
 *
 * @author HUGO
 */
public class NodoPersonajes extends Thread{
    private String nombre;
    private String PutosAtque;
    private String PuntosDefensa;
    private String Ataque;
    private String per;
    private String foto;
    private String personaje;
    private int numero;
    NodoPersonajes siguiente;
    NodoPersonajes anterior;
    NodoPersonajes yo;
    NodoMatriz nodo;
    int  segp = 0, dsp = 0,mp =0;
    String op="1";
     
    Thread t = new Thread();
     Thread t2 = new Thread();
    public NodoPersonajes(String nom,String pa,String pd,String a,String per,String foto,int numero,String peo){
   this. nombre=nom;
    this.PutosAtque=pa;
    this.PuntosDefensa=pd;
    this.Ataque=a;
    this.per=per;
    this.foto=foto;
    this.numero=numero;
    this.personaje=peo;
    siguiente=anterior=null;
    }
    public NodoPersonajes(NodoPersonajes nodo){
        this.nombre=nodo.getNombre();
        this.PutosAtque=Integer.toString(nodo.getPutosAtque());
        this.PuntosDefensa=Integer.toString(nodo.getPuntosDefensa());
        this.Ataque=nodo.getAtaque();
        this.per=nodo.getPer();
        this.foto=nodo.getFoto();
        this.numero=nodo.getNumero();
        this.personaje=nodo.personaje;
        siguiente=anterior=null;
     this.yo=nodo;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the PutosAtque
     */
    public int getPutosAtque() {
        return Integer.parseInt( PutosAtque);
    }

    /**
     * @param PutosAtque the PutosAtque to set
     */
    public void setPutosAtque(String PutosAtque) {
        this.PutosAtque = PutosAtque;
    }

    /**
     * @return the PuntosDefensa
     */
    public int getPuntosDefensa() {
        return Integer.parseInt(PuntosDefensa);
    }

    /**
     * @param PuntosDefensa the PuntosDefensa to set
     */
    public void setPuntosDefensa(String PuntosDefensa) {
        this.PuntosDefensa = PuntosDefensa;
    }

    /**
     * @return the Ataque
     */
    public String getAtaque() {
        return Ataque;
    }

    /**
     * @param Ataque the Ataque to set
     */
    public void setAtaque(String Ataque) {
        this.Ataque = Ataque;
    }

    /**
     * @return the per
     */
    public String getPer() {
        return per;
    }

    /**
     * @param per the per to set
     */
    public void setPer(String per) {
        this.per = per;
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

    /**
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * @param numero the numero to set
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public void NodoMatriz(NodoMatriz nodo){
    this.nodo=nodo;
   
    }
     
 
        @Override
        public void run() {
                    
            while(true){
            try{
                t.sleep(1000);
           
            
               
                 dsp=0;
                 if(personaje.equals("Zombies")){
                   if(nodo.Anterior!=null){
                   nodo.ponerPersonaje("");
                  nodo=nodo.Anterior;
                  nodo.ArgregarPersonaje(yo);
                  String foto =yo.getFoto();
                  nodo.ponerPersonaje(foto);
                  }
                  
                 }
                
                 if(personaje.equals("Plantas")){
                 if(nodo.Siguiente!=null){
                   if(Ataque.equals("Directo")){
                   nodo.ponerPersonaje("");
                  nodo=nodo.Siguiente;
                  nodo.ArgregarPersonaje(yo);
                  String foto =yo.getFoto();
                  nodo.ponerPersonaje(foto);
                  }   else{
                 
                   if(op.equals("1")){
                   nodo=nodo.Siguiente;
                 String foto ="src/ImajenesJuego/Plantas/p10.jpg";
                  nodo.ponerPersonaje(foto);
                  op="55";
                   }else {
                    nodo.ponerPersonaje("");   
                    nodo=nodo.Siguiente;
                 String foto ="src/ImajenesJuego/Plantas/p10.jpg";
                  nodo.ponerPersonaje(foto);
                   }   
                 
                  }
                 }
                         
                                
                 }
                 
             }
            catch (java.lang.InterruptedException ie) {
                System.out.println(ie.getMessage());
       
            }
            
             try {
            t.sleep(50);
        } catch (InterruptedException ie) {
              System.out.println(ie.getMessage());
        }
            }
                
            
        
        }

    /**
     * @return the personaje
     */
    public String getPersonaje() {
        return personaje;
    }

    /**
     * @param personaje the personaje to set
     */
    public void setPersonaje(String personaje) {
        this.personaje = personaje;
    }
      
   
}
