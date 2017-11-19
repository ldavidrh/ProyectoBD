/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;
import Modelo.Paciente;
import java.util.Vector;
import AccesoDatos.*;
/**
 *
 * @author invitado
 */
public class ControlPaciente {
    DaoPaciente daoPaciente;
    
    public ControlPaciente(){
        daoPaciente = new DaoPaciente();
    }
    
    public int insertarPaciente(String id_persona, String num_historia, String seguridad_social, String fecha_nacimiento, String actividad_economica){
        Paciente pac = new Paciente();
        
        pac.setId_persona(id_persona);
        pac.setNum_historia(num_historia);
        pac.setSeguridad_social(seguridad_social);
        pac.setFecha_nacimiento(fecha_nacimiento);
        pac.setActividad_economica(actividad_economica);
        
        //Se llama al dao para guardar
        System.out.println("Se va a insertar un paciente");
        
        int result =daoPaciente.guardarPaciente(pac);

        System.out.println("Se  insertó  un  nuevo paciente");
        
        return result;
    }
    
    public Paciente consultarPaciente(String id){
        Vector v= new Vector();

        Paciente pac = new Paciente();
        System.out.println("Se va a consultar un paciente");
        pac= daoPaciente.consultarPrograma(id);
      
       return pac;
    }
    
    public int  modificarPaciente(String id_persona, String num_historia, String seguridad_social, String fecha_nacimiento, String actividad_economica){
        Paciente pac = new Paciente();        

        pac.setId_persona(id_persona);
        pac.setNum_historia(num_historia);
        pac.setSeguridad_social(seguridad_social);
        pac.setFecha_nacimiento(fecha_nacimiento);
        pac.setActividad_economica(actividad_economica);
        
        System.out.println("Se va a modificar un paciente");
        
        int result =daoPaciente.modificarPaciente(pac);

        System.out.println("Se  modificó  un  paciente");
        
        return result;

    }
    
    public boolean borraPaciente(String id){

        boolean pac;
        
         System.out.println("Se va a borrar un programa");

        pac = daoPaciente.borrarPaciente(id);
      
       return pac;
    }
    
    public void cerrarConexionBD(){
        daoPaciente.cerrarConexionBD();
    }   
}