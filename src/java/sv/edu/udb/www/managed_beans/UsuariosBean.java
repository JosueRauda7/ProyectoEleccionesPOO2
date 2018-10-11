/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_beans;

import java.util.List;
import java.util.UUID;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.DepartamentosEntity;
import sv.edu.udb.www.entities.TipousuarioEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.model.DepartamentosModel;
import sv.edu.udb.www.model.UsuariosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "usuariosBean")
@RequestScoped
public class UsuariosBean {

    @EJB
    private DepartamentosModel departamentosModel;

    @EJB
    private UsuariosModel usuariosModel;

    private UsuariosEntity administradorGeneral = new UsuariosEntity();

    private UsuariosEntity administradorDepartamental = new UsuariosEntity();

    private UsuariosEntity presidenteJRV = new UsuariosEntity();

    private UsuariosEntity empleadoRNPN = new UsuariosEntity();
    
    private List<DepartamentosEntity> listaDepartamentos;

    public List<DepartamentosEntity> getListaDepartamentos() {
        return departamentosModel.listarDepartamentos();
    }

    public void setListaDepartamentos(List<DepartamentosEntity> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }
    
    

    public UsuariosBean() {
    }

    public UsuariosEntity getAdministradorGeneral() {
        return administradorGeneral;
    }

    public void setAdministradorGeneral(UsuariosEntity administradorGeneral) {
        this.administradorGeneral = administradorGeneral;
    }

    public UsuariosEntity getAdministradorDepartamental() {
        return administradorDepartamental;
    }

    public void setAdministradorDepartamental(UsuariosEntity administradorDepartamental) {
        this.administradorDepartamental = administradorDepartamental;
    }

    public UsuariosEntity getPresidenteJRV() {
        return presidenteJRV;
    }

    public void setPresidenteJRV(UsuariosEntity presidenteJRV) {
        this.presidenteJRV = presidenteJRV;
    }

    public UsuariosEntity getEmpleadoRNPN() {
        return empleadoRNPN;
    }

    public void setEmpleadoRNPN(UsuariosEntity empleadoRNPN) {
        this.empleadoRNPN = empleadoRNPN;
    }
    
    
    

    //Administrador General
    
    
    public List<UsuariosEntity> getListaAdministradorGeneral() {
        return usuariosModel.listarAdministradoresGenerales();
    }

    public String guardarAdministradorGeneral() {
        //datos adicionales
        String cadenaAleatoria = UUID.randomUUID().toString();
        administradorGeneral.setContrasena(cadenaAleatoria.substring(0, 8));
        TipousuarioEntity tipoUsuario = new TipousuarioEntity();
        tipoUsuario.setIdTipoUsuario((Integer)1);
        tipoUsuario.setTipoUsuario("Administrador General");
        administradorGeneral.setIdTipoUsuario(tipoUsuario);
        if(usuariosModel.insertarAdministradorGeneral(administradorGeneral)==0){
            JsfUtils.addErrorMessage("idUsuario", "Ya existe ese usuario.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Administrador General agregado exitosamente.");
        return "/administradorGeneral/listaAdministradorGeneral?faces-redirect=true";
    }

    //Administrador Departamental
    public List<UsuariosEntity> getListaAdministradorDepartamental() {
        return usuariosModel.listarAdministradoresDepartamentales();
    }
    
    public String guardarAdministradorDepartamental() {
        //datos adicionales
        String cadenaAleatoria = UUID.randomUUID().toString();
        administradorDepartamental.setContrasena(cadenaAleatoria.substring(0, 8));
        TipousuarioEntity tipoUsuario = new TipousuarioEntity();
        tipoUsuario.setIdTipoUsuario((Integer)2);
        tipoUsuario.setTipoUsuario("Administrador Departamental");
        administradorDepartamental.setIdTipoUsuario(tipoUsuario);
        if(usuariosModel.insertarAdministradorDepartamental(administradorDepartamental)==0){
            JsfUtils.addErrorMessage("idUsuario", "Ya existe ese usuario.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Administrador Departamental agregado exitosamente.");
        return "/administradorGeneral/listaAdministradorDepartamental?faces-redirect=true";
    }
    //Presidentes JRV
    public List<UsuariosEntity> getListaPresidentesJRV() {
        return usuariosModel.listarPresidentesJRV();
    }

    //Empleados RNPN
    public List<UsuariosEntity> getListaEmpleadosRNPN() {
        return usuariosModel.listarEmpleadosRNPN();
    }
    
    public String guardarEmpleadoRNPN() {
        //datos adicionales
        String cadenaAleatoria = UUID.randomUUID().toString();
        empleadoRNPN.setContrasena(cadenaAleatoria.substring(0, 8));
        TipousuarioEntity tipoUsuario = new TipousuarioEntity();
        tipoUsuario.setIdTipoUsuario((Integer)4);
        tipoUsuario.setTipoUsuario("Empleado RNPN");
        empleadoRNPN.setIdTipoUsuario(tipoUsuario);
        if(usuariosModel.insertarAdministradorDepartamental(empleadoRNPN)==0){
            JsfUtils.addErrorMessage("idUsuario", "Ya existe ese usuario.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Empleado RNPN agregado exitosamente.");
        return "/administradorGeneral/listaEmpleadosRNPN?faces-redirect=true";
    }
}
