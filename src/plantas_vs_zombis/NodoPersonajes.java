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
public class NodoPersonajes {
    private String nombre;
    private String PutosAtque;
    private String PuntosDefensa;
    private String Ataque;
    private String per;
    private String foto;
    NodoPersonajes siguiente;
    NodoPersonajes anterior;
    
    
    public NodoPersonajes(String nom,String pa,String pd,String a,String per,String foto){
   this. nombre=nom;
    this.PutosAtque=pa;
    this.PuntosDefensa=pd;
    this.Ataque=a;
    this.per=per;
    this.foto=foto;
    siguiente=anterior=null;
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
}
