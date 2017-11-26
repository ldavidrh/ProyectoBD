/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Formula;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlFormula {
    DaoFormula daoFormula;

    public ControlFormula(){
        daoFormula = new DaoFormula();
    }
    
    public String insertarFormula(String id_formula, String codigo_medicamente, String id_medico, String id_paciente){
        Formula f = new Formula(id_formula, codigo_medicamente, id_medico, id_paciente);
        return daoFormula.guardarFormula(f);
    }
    
    public void cerrarConexionBD(){
        daoFormula.cerrarConexionBD();
    }
}
