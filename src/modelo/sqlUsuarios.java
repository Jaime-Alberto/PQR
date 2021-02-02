/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 *
 * @author Administrador
 */
public class sqlUsuarios extends Conexion{
    
    public boolean registrar (usuarios usr){
        PreparedStatement ps = null;
        Connection con = (Connection) getConexion();
        
        String sql = "INSERT INTO usuarios (usuario, password, id_tipo, nombre, correo) VALUES(?,?,?,?,?)";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            ps.setString(2, usr.getPassword());
            ps.setInt(3, usr.getId_tipo());
            ps.setString(4, usr.getNombre());
            ps.setString(5, usr.getCorreo());
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
    
    
    public boolean login (usuarios usr){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT u.id, u.usuario, u.password, u.id_tipo, t.nombre FROM usuarios AS u  INNER JOIN tipo_usuario AS t ON u.id_tipo=t.id WHERE usuario = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();
            
            if(rs.next()){
                if (usr.getPassword().equals(rs.getString(3))){
                    usr.setId(rs.getInt(1));
                    usr.setId_tipo(rs.getInt(4));
                    usr.setNombre_tipo(rs.getString(5));
                    return true;
                }else{
                    return false;
                }
            }
            
            return false;
            
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
    
    
     public int existeUsuario (String usuario){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = (Connection) getConexion();
        
        String sql = "SELECT count(id) FROM usuarios WHERE usuario = ?";
        try {
            ps = (PreparedStatement) con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            if(rs.next()){
                return rs.getInt(1);
            }
            
            return 1;
            
        } catch (Exception e) {
            System.err.println(e);
            return 1;
        }finally{
            try {
                con.close();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
        
     }
        public boolean esEmail(String correo){
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            
            Matcher mather = pattern.matcher(correo);
            
            return mather.find();
        }
         
}
