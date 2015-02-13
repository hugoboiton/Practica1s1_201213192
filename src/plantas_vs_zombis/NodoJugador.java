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
    NodoJugador siguiente;
    ListaDatosJugador apuntadorJugadorDatos=null;
    public NodoJugador( String Jugador){
    this.Jugador=Jugador;
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
}
