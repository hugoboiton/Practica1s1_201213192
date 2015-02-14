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
public class NodoJugador {
    private String Jugador;
    private String nombre;
    private String cantidad;
    NodoJugador siguiente;
    ListaDatosJugador apuntadorJugadorDatos=null;
    public NodoJugador( String Jugador , String nombre , String catidad){
    this.Jugador=Jugador;
    this.nombre=nombre;
    this.cantidad= catidad;
    siguiente=null;
    apuntadorJugadorDatos= new ListaDatosJugador();
    }

    /**
     * @return the Jugador
     */
    public String getJugador() {
        return Jugador;
    }

    /**
     * @param Jugador the Jugador to set
     */
    public void setJugador(String Jugador) {
        this.Jugador = Jugador;
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
     * @return the cantidad
     */
    public String getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
