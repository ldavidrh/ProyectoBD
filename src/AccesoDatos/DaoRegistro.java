/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Registro;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juandavid
 */
public class DaoRegistro {
    
    FachadaBD fachada;

    public DaoRegistro() {
        fachada = new FachadaBD();
    }

    public String guardarRegistro(Registro r) {
        String sql_guardar;
        sql_guardar = "INSERT INTO registro VALUES('" + 
                r.getNum_historia() + "', '" + r.getCodigo_causa() + "', '" + r.getId_persona() + "', '" 
                + r.getFecha() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_guardar)) {
                return "Registro guardado exitosamente";
            } else {
                return "No se pudo guardar el Registro";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al guardar el Registro";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al crear el Registro";
        }
    }
    
    
    
    
    public String[] consultarRegistro(String id_persona) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM registro WHERE id_persona = '" + id_persona + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_consultar);

            if (tabla.next()) {
                consulta[0] = tabla.getString(1);
                consulta[1] = tabla.getString(2);
                consulta[2] = tabla.getString(3);
                consulta[3] = tabla.getString(4);
            } else {
                consulta = null;
            }
            return consulta;
        } catch (SQLException e) {
            System.out.print(e);
            return null;
        }

    }

    public String eliminarRegistro(Registro r) {
        String sql_eliminar;
        sql_eliminar = "DELETE FROM registro WHERE num_historia = '" + r.getNum_historia() + 
                "' AND codigo_causa ='" + r.getCodigo_causa() + "' AND id_persona ='" + r.getId_persona() + 
                "' AND fecha ='" + r.getFecha() + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_eliminar)) {
                return "Registro eliminado existosamente";
            } else {
                return "No existe ese registro";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar Registro";
        }
    }

    

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
}
