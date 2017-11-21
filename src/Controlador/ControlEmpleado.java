/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Empleado;
import AccesoDatos.*;
/**
 *
 * @author User
 */
public class ControlEmpleado {
    DaoEmpleado daoEmpleado;

    public ControlEmpleado(){
        daoEmpleado = new DaoEmpleado();
    }
    
    public String insertarEmpleado(String id_persona, String cargo, float salario, String email, String codigo_area, String id_jefe){
        Empleado e = new Empleado(id_persona, cargo, salario, email, codigo_area, id_jefe);
        return daoEmpleado.guardarEmpleado(e);
    }
    
    public String[] consultarEmpleado(String id){
        return daoEmpleado.consultarEmpleado(id);
    }
    
    public String modificarEmpleado(String id_persona, String cargo, float salario, String email, String codigo_area, String id_jefe){
        Empleado e = new Empleado(id_persona, cargo, salario, email, codigo_area, id_jefe);
        return daoEmpleado.modificarEmpleado(e);
    }
    
    public String eliminarEmpleado(String id){
        return daoEmpleado.eliminarEmpleado(id);
    }
    
    public void cerrarConexionBD(){
        daoEmpleado.cerrarConexionBD();
    }
}