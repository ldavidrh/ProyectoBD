/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import AccesoDatos.DaoAsiste;
import Modelo.Asiste;

/**
 *
 * @author juandavid
 */
public class ControlAsiste {
    DaoAsiste daoAsiste;

    public ControlAsiste(){
        daoAsiste = new DaoAsiste();
    }
    
    public String insertarAsiste(String id_persona, String codigo_campana, int descuento){
        Asiste a = new Asiste(id_persona, codigo_campana, descuento);
        return daoAsiste.guardarAsiste(a);
    }
    
    public String[] consultarAsiste(String id_persona, String codigo_campana){
        return daoAsiste.consultarAsiste(id_persona, codigo_campana);
    }
    
    public String modificarAsiste(String id_persona, String codigo_campana, int descuento){
        Asiste a = new Asiste(id_persona, codigo_campana, descuento);
        return daoAsiste.modificarAsiste(a);
    }
    
    public String eliminarAsiste(String id_persona, String codigo_campana){
        return daoAsiste.eliminarAsiste(id_persona, codigo_campana);
    }
    
    public void cerrarConexionBD(){
        daoAsiste.cerrarConexionBD();
    }
}
