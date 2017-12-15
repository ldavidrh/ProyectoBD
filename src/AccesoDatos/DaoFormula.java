/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Formula;
import java.sql.*;
/**
 *
 * @author User
 */
public class DaoFormula {
    FachadaBD fachada;
    
    public DaoFormula(){
        fachada= new FachadaBD();
    }
    
    public String guardarFormula(Formula f){
        String sql_guardar;
        sql_guardar = "INSERT INTO formula VALUES('" + f.getId_formula() +
                       "', '" + f.getId_medico() + "', '" + f.getId_paciente() 
                      + "', '" + f.getFecha() + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Fórmula creada correctamente";
            }else{
                return "Error: No se insertó la fórmula";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ya se creó una fórmula médica en esta hora";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al guardar la fórmula";
        }        
    }
    
    public String guardarMedicamentos(String codigo_formula, String codigo_medicamento){
        String sql_guardar;
        sql_guardar = "INSERT INTO medicamentos_formula VALUES('" + codigo_formula
                      + "', '" + codigo_medicamento + "')";
        try{
            Connection conn= fachada.conectar();
            Statement sentencia = conn.createStatement();             
            if(sentencia.executeUpdate(sql_guardar)==1){
                return "Medicamento guardado correctamente";
            }else{
                return "Error: No se insertó el medicamento";
            }
        }catch(SQLException ex){
            System.out.println(ex);
            return "Ya se agregó ese medicamento a la fórmula";
        }
        catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al guardar el medicamento";
        }        
    }
    
    
    public String[] consultarFormula(String id){
        String sql_select;        
        String consulta[] = new String[4];
        sql_select = "SELECT * FROM formula WHERE id_formula = '" + id + "'";
        try{
            Connection conn= fachada.getConnetion();            
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);   
            
            if(tabla.next()){
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);                        
            }else{
                consulta = null;
            }
            return consulta;
        }catch(Exception e){
            System.out.println(e);
            return null;
        }
    }   
    
    public void cerrarConexionBD(){
        fachada.closeConection(fachada.getConnetion());
    }
}
