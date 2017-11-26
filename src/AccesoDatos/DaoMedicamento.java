/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;
import Modelo.Medicamento;
import java.sql.*;
import java.util.logging.*;
/**
 *
 * @author Luis
 */
public class DaoMedicamento {
    FachadaBD fachada;
    public DaoMedicamento(){
        fachada = new FachadaBD();
    }
    
    public String guardarMedicamento(Medicamento m) {
        String sql_guardar;
        sql_guardar = "INSERT INTO medicamento VALUES('" + m.getCodigo_medicamento() + "', '" + m.getNombre() + "', '" + m.getDescripcion() + "', '" + m.getCosto() + "');";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_guardar)) {
                return "Medicamento guardado exitosamente";
            } else {
                return "No se pudo guardar el medicamento";
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMedicamento.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al guardar el Medicamento";
        }
    }

    public String[] consultarMedicamento(String codigo_medicamento) {
        String sql_consultar;
        String[] consulta = new String[4];

        sql_consultar = "SELECT * FROM medicamento WHERE codigo_medicamento = '" + codigo_medicamento + "';";

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

    public String eliminarMedicamento(String codigo_medicamento) {
        String sql_eliminar;
        sql_eliminar = "DELETE FROM Medicamento WHERE codigo_medicamento = '" + codigo_medicamento + "';";

        try {
            Connection conexion = fachada.getConnetion();
            Statement sentencia = conexion.createStatement();
            if (sentencia.execute(sql_eliminar)) {
                return "Medicamento eliminado existosamente";
            } else {
                return "No existe un medicamento con el número: " + codigo_medicamento;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DaoMedicamento.class.getName()).log(Level.SEVERE, null, ex);
            return "Error al eliminar Medicamento";
        }
    }

    public String modificarMedicamento(Medicamento m) {
        String sql_modificar;
        sql_modificar = "UPDATE medicamento SET nombre='" + m.getNombre() + "', descripcion ='"
                + m.getDescripcion() + "', costo = '" + m.getCosto() + "';";
        try {
            Connection conn = fachada.getConnetion();
            Statement sentencia = conn.createStatement();
            if (sentencia.execute(sql_modificar)) {
                return "Medicamento modificado exitosamente";
            } else {
                return "No existe un Medicamento con ese codigo";
            }
        } catch (Exception ex) {
            System.out.println(ex);
            return "Ha ocurrido un error al modificar el Medicamento";
        }

    }

    public void cerrarConexionBD() {
        fachada.closeConection(fachada.getConnetion());
    }
    
    
}
