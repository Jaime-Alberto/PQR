/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JComboBox;
import vista.registroPQR;


/**
 *
 * @author Administrador
 */
public class sqlPQR extends Conexion{
    
    
         public boolean registrarPQR (pqr pqr){
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO pqr (usuario, tipo_pqr, asunto_pqr, estado, fecha_creacion, fecha_limite) VALUES(?,?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, pqr.getUsuario());
            ps.setString(2, pqr.getTipo_pqr());
            ps.setString(3, pqr.getAsunto_pqr());
            ps.setString(4, pqr.getEstado());
            ps.setString(5, pqr.getFecha_creacion());
            ps.setString(6, pqr.getFecha_limite());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
        
        
}
         
        public boolean modificarPQR (pqr pqr){
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "UPDATE pqr SET usuario=?, tipo_pqr=?, asunto_pqr=?, estado=?, fecha_creacion=?, fecha_limite=? WHERE id=? ";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, pqr.getUsuario());
            ps.setString(2, pqr.getTipo_pqr());
            ps.setString(3, pqr.getAsunto_pqr());
            ps.setString(4, pqr.getEstado());
            ps.setString(5, pqr.getFecha_creacion());
            ps.setString(6, pqr.getFecha_limite());
            ps.setInt(7, pqr.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
            }
        
        
           public boolean eliminarPQR (pqr pqr){
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "DELETE FROM pqr WHERE id=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, pqr.getId());
            ps.execute();
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
           }
           
           
        public boolean buscarPQR (pqr pqr){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT * FROM pqr WHERE usuario=?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setInt(1, pqr.getId());
            rs = ps.executeQuery();
            
            if(rs.next()){
                pqr.setId(Integer.parseInt(rs.getString("id")));
              
            }
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
           }
        
        
        public boolean mostrarUsu (JComboBox JComboUsu){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT usuario FROM usuarios";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ResultSet result = ps.executeQuery();
           
            JComboUsu.addItem("Seleccione una opcion");
            
            while(result.next()){
                JComboUsu.addItem(result.getString("usuario"));
            }
            return true;
        } catch (Exception e) {
            System.err.println(e);
            return false;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
           }
        
    
}
