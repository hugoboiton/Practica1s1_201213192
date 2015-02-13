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
public class NodoDatosJugador {
    private String NombreCampo;
    private String InformacionCampo;
    NodoDatosJugador Siguiente;

    public NodoDatosJugador(String Nombre, String Info){
    this.NombreCampo=Nombre;
    this.InformacionCampo=Info;
    Siguiente=null;
    }
    
    /**
     * @return the NombreCampo
     */
    public String getNombreCampo() {
        return NombreCampo;
    }

    /**
     * @param NombreCampo the NombreCampo to set
     */
    public void setNombreCampo(String NombreCampo) {
        this.NombreCampo = NombreCampo;
    }

    /**
     * @return the InformacionCampo
     */
    public String getInformacionCampo() {
        return InformacionCampo;
    }

    /**
     * @param InformacionCampo the InformacionCampo to set
     */
    public void setInformacionCampo(String InformacionCampo) {
        this.InformacionCampo = InformacionCampo;
    }
}
