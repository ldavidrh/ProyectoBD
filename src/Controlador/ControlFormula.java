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
    
    public String insertarFormula(String id_formula, String id_medico, String id_paciente, String fecha){
        Formula f = new Formula(id_formula, id_medico, id_paciente, fecha);
        return daoFormula.guardarFormula(f);
    }
    
    public String insertarMedicamentos(String codigo_formula, String codigo_medicamento){
        return daoFormula.guardarMedicamentos(codigo_formula, codigo_medicamento);
    }
    
    public String consultaFormula(String id_paciente){
        return daoFormula.consultarFormula(id_paciente);
    }
    
    public void cerrarConexionBD(){
        daoFormula.cerrarConexionBD();
    }
}
