/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;

import Modelo.Asignada;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juandavid
 */
public class DaoAsignada {
    FachadaBD fachada;

    public DaoAsignada() {
        fachada = new FachadaBD();
    }

    public String guardarAsignada(Asignada asignada) {
        String sql_guardar;
        sql_guardar = "INSERT INTO asignada VALUES('" + asignada.getId_persona() + "', '" + asignada.getNum_cama() + "', '" 
                + asignada.getFecha_asignacion() + "', '" + asignada.getFecha_finalizacion() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sql_guardar)==1) {
                return "Asignación exitosa";
            } else {
                return "No se pudo asignar";
            }
        } catch (SQLException ex) {
            System.out.println(ex); 
            return "Ya existe ese registro";
        }catch(Exception ex){ 
            System.out.println(ex); 
            return "Ha ocurrido un error al asignar";
        }
    }  
    
    public String[] consultarAsignada(String num_cama) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM asignada WHERE num_cama = '" + num_cama + "';";

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

    public String eliminarAsignada(String num_cama) {
        String sql_eliminar;
        sql_eliminar = "DELETE FROM asignada WHERE num_cama = '" + num_cama + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.executeUpdate(sql_eliminar)==1) {
                return "asignada eliminada existosa";
            } else {
                return "No existe una cama asiganada con el numero: " + num_cama;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoAgenda.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar asignada";
        }
    }

    public String modificarAsignada(Asignada asignada) {
        String sql_modificar;
        sql_modificar = "UPDATE asignada SET id_persona ='" + asignada.getId_persona() + "', fecha_entrada ='"
                + asignada.getFecha_asignacion() + "', fecha_salida='" + asignada.getFecha_finalizacion() + "' WHERE num_cama = '" + asignada.getNum_cama() + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.executeUpdate(sql_modificar)==1) {
                return "asignada modificada exitosamente";
            } else {
                return "No existe una cama asiganada con el numero: " + asignada.getNum_cama();
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar la asignada";
        }

    }
    
    //-Verifica si ya se cumple la fecha de salida de un paciente, para setear el 
    //-estado de una cama de "Ocupada" a "Libre". Se usa un hilo para ello.
    public ArrayList verificarFechaSalida() {
        String sql_select;

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate actual = LocalDate.now();
        String fecha_actual = dtf.format(actual);         
        sql_select = "SELECT num_cama FROM asignada WHERE fecha_salida = '" + fecha_actual + "'";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            ResultSet tabla = sentencia.executeQuery(sql_select);
            ArrayList camas_libres_hoy = new ArrayList();
            
            while(tabla.next()){
                camas_libres_hoy.add(tabla.getString(1));
            }            
            return camas_libres_hoy;            
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
}
