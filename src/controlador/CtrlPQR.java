/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import modelo.pqr;
import modelo.sqlPQR;
import vista.registroPQR;
import vista.ConsultasQuejas;

/**
 *
 * @author Administrador
 */
public class CtrlPQR implements ActionListener{
    private pqr mod;
    private sqlPQR modC;
    private registroPQR frm;
    private ConsultasQuejas frmCQ;
    
    public CtrlPQR(pqr mod, sqlPQR modC, registroPQR frm, ConsultasQuejas frmCQ ){
        this.mod = mod;
        this.modC = modC;
        this.frm = frm;
        this.frmCQ = frmCQ;
        this.frm.btnGuardar.addActionListener(this);
        this.frm.btnModificar.addActionListener(this);
        this.frm.btnEliminar.addActionListener(this);
        this.frm.btnLimpiar.addActionListener(this);
        this.frm.btnBuscar.addActionListener(this);
        this.frmCQ.btnConsultar.addActionListener(this);
    }
    
    public void iniciar(){
        frm.setTitle("PQR");
        frm.setLocationRelativeTo(null);
        frm.txtId.setVisible(false);
        frmCQ.setTitle("Consulatas de Quejas");
        frmCQ.setLocationRelativeTo(null);
        frmCQ.txtId.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == frm.btnGuardar){
            //mod.setCedula(frm.txtCedula.getText());
            mod.setUsuario(frm.jComboUsuario.getSelectedItem().toString());
            mod.setTipo_pqr( frm.jComboTipoPQR.getSelectedItem().toString());
            mod.setAsunto_pqr(frm.txtAsunto.getText());
            mod.setEstado(frm.jComboEstado.getSelectedItem().toString());
            mod.setFecha_creacion(((JTextField)frm.FechaCreacion.getDateEditor().getUiComponent()).getText());
            mod.setFecha_limite(((JTextField)frm.FechaLimite.getDateEditor().getUiComponent()).getText());
            
            if(modC.registrarPQR(mod)){
                JOptionPane.showMessageDialog(null, "registro guardado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "registro guardado");
            }
           
        }  
        
        if(e.getSource() == frm.btnModificar){
            
         if("Nuevo".equals(mod.getEstado())){
            if ("Cerrado".equals(frm.jComboEstado.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(null, "No puede cambiar el estado a cerrado");
            }else{
            
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            //mod.setCedula(frm.txtCedula.getText());
            mod.setUsuario(frm.jComboUsuario.getSelectedItem().toString());
            mod.setTipo_pqr( frm.jComboTipoPQR.getSelectedItem().toString());
            mod.setAsunto_pqr(frm.txtAsunto.getText());
            mod.setEstado(frm.jComboEstado.getSelectedItem().toString());
            mod.setFecha_creacion(((JTextField)frm.FechaCreacion.getDateEditor().getUiComponent()).getText());
            mod.setFecha_limite(((JTextField)frm.FechaLimite.getDateEditor().getUiComponent()).getText());
            
            if(modC.modificarPQR(mod)){
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error modificar");
            }
                
            }
            
        }else if("En ejecucion".equals(mod.getEstado())){
            
            if ("Nuevo".equals(frm.jComboEstado.getSelectedItem().toString())){
                JOptionPane.showMessageDialog(null, "No puede cambiar el estado a Nuevo");
            }else{
                
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            //mod.setCedula(frm.txtCedula.getText());
            mod.setUsuario(frm.jComboUsuario.getSelectedItem().toString());
            mod.setTipo_pqr( frm.jComboTipoPQR.getSelectedItem().toString());
            mod.setAsunto_pqr(frm.txtAsunto.getText());
            mod.setEstado(frm.jComboEstado.getSelectedItem().toString());
            mod.setFecha_creacion(((JTextField)frm.FechaCreacion.getDateEditor().getUiComponent()).getText());
            mod.setFecha_limite(((JTextField)frm.FechaLimite.getDateEditor().getUiComponent()).getText());
            
            if(modC.modificarPQR(mod)){
                JOptionPane.showMessageDialog(null, "registro modificado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error modificar");
            }
                
            }
            
        }else{
            
            if (frm.jComboEstado.getSelectedItem().toString() != "Cerrado"){
                JOptionPane.showMessageDialog(null, "No puede cambiar el estado a otro");
            }
            
        }   
            
           
        }
        
        
        if(e.getSource() == frm.btnEliminar){
            mod.setId(Integer.parseInt(frm.txtId.getText()));
            
            if(modC.eliminarPQR(mod)){
                JOptionPane.showMessageDialog(null, "registro eliminado");
                limpiar();
            }else{
                JOptionPane.showMessageDialog(null, "error eliminar");
            }
           
        }
        
        
        if(e.getSource() == frm.btnBuscar){
            mod.setUsuario(frm.jComboUsuario.getSelectedItem().toString());
            
            if(modC.buscarPQR(mod)){
                
                frm.txtId.setText(String.valueOf(mod.getId()));
                frm.jComboUsuario.setSelectedItem(mod.getUsuario());
                frm.jComboTipoPQR.setSelectedItem(mod.getTipo_pqr());
                frm.txtAsunto.setText(mod.getAsunto_pqr());
                frm.jComboEstado.setSelectedItem(mod.getEstado());
                frm.txtFechaCreacion.setText(mod.getFecha_creacion());
                frm.txtFechaLimite.setText(mod.getFecha_limite());
                
             
            
            }else{
                JOptionPane.showMessageDialog(null, "no se encontro registro");
                limpiar();
            
            }
           
        }
        
        if(e.getSource() == frm.btnLimpiar){
            limpiar();
        }
        
     if(e.getSource() == frmCQ.btnConsultar){
            mod.setUsuario(frmCQ.txtUsuario.getText());
            
            if(modC.buscarPQR(mod)){
                
                frmCQ.txtId.setText(String.valueOf(mod.getId()));
                frmCQ.txtUsuario.setText(mod.getUsuario());
                frmCQ.jComboTipoPQR.setSelectedItem(mod.getTipo_pqr());
                frmCQ.txtAsunto.setText(mod.getAsunto_pqr());
                frmCQ.jComboEstado.setSelectedItem(mod.getEstado());
                frmCQ.txtFechaCreacion.setText(mod.getFecha_creacion());
                frmCQ.txtFechaLimite.setText(mod.getFecha_limite());
                
             
            
            }else{
                JOptionPane.showMessageDialog(null, "no se encontro registro");
                limpiar();
            
            }
           
        }    
        
    }
    
    public void limpiar(){
        frm.txtId.setText(null);
        //frm.txtCedula.setText(null);
        frm.jComboUsuario.setSelectedItem(null);
        frm.jComboTipoPQR.setSelectedItem(null);
        frm.txtAsunto.setText(null);
        frm.jComboEstado.setSelectedItem(null);
    frm.txtFechaCreacion.setText(null);
        frm.txtFechaLimite.setText(null);
        
    }
    
    
}
 