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
    
    public String insertarAsiste(String id_persona, String codigo_campana){
        Asiste a = new Asiste(id_persona, codigo_campana, '0');
        return daoAsiste.guardarAsiste(a);
    }
    
    public String consultarAsistencia(String codigo_campana){
        return daoAsiste.consultarAsistencia(codigo_campana);
    }       
    
    public int generarPrecioCita(String id_paciente){
        return daoAsiste.generarPrecioCita(id_paciente);
    }
    
    public void cerrarConexionBD(){
        daoAsiste.cerrarConexionBD();
    }
}
