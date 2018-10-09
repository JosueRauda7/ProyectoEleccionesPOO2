/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.DepartamentosEntity;
import sv.edu.udb.www.entities.MunicipiosEntity;
import sv.edu.udb.www.model.DepartamentosModel;
import sv.edu.udb.www.model.MunicipiosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "municipiosBean")
@RequestScoped
public class MunicipiosBean {

    @EJB
    private DepartamentosModel departamentosModel;

    @EJB
    private MunicipiosModel municipiosModel;  
    
    private MunicipiosEntity municipio = new MunicipiosEntity();
    
    private List<DepartamentosEntity> listaDepartamentos;
    
    public MunicipiosBean() {
    }

    public MunicipiosEntity getMunicipio() {
        return municipio;
    }

    public void setMunicipio(MunicipiosEntity municipio) {
        this.municipio = municipio;
    }
    
    public List<MunicipiosEntity> getListaMunicipios(){
        return municipiosModel.listarMunicipios();
    }

    public List<DepartamentosEntity> getListaDepartamentos() {
        listaDepartamentos = departamentosModel.listarDepartamentos();
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<DepartamentosEntity> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }
    
    //metodos
    public String guardarMunicipio(){
        if(municipiosModel.insertarMunicipio(municipio)==0){
            JsfUtils.addErrorMessage("idMunicipio", "Ya existe ese municipio.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Municipio agregado exitosamente.");
        return "/administradorGeneral/listaMunicipios?faces-redirect=true";
    }
}
