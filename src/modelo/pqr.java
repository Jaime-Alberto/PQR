/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Administrador
 */
public class pqr {
    
    private int id;
    private String usuario;
    private String tipo_pqr;
    private String asunto_pqr;
    private String estado;
    private String fecha_creacion;
    private String fecha_limite;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    public String getFecha_limite() {
        return fecha_limite;
    }

    public void setFecha_limite(String fecha_limite) {
        this.fecha_limite = fecha_limite;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo_pqr() {
        return tipo_pqr;
    }

    public void setTipo_pqr(String tipo_pqr) {
        this.tipo_pqr = tipo_pqr;
    }

    public String getAsunto_pqr() {
        return asunto_pqr;
    }

    public void setAsunto_pqr(String asunto_pqr) {
        this.asunto_pqr = asunto_pqr;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }
    
    
    
}
