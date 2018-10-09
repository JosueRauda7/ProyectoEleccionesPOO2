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
import sv.edu.udb.www.entities.PartidosEntity;
import sv.edu.udb.www.model.PartidosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "partidosBean")
@RequestScoped
public class PartidosBean {

    @EJB
    private PartidosModel partidosModel;
    
    private PartidosEntity partido = new PartidosEntity();
    
    public PartidosBean() {
    }
    
    public List<PartidosEntity> getListaPartidos(){
        return partidosModel.listarPartidos();
    }

    public PartidosEntity getPartido() {
        return partido;
    }

    public void setPartido(PartidosEntity partido) {
        this.partido = partido;
    }
    
    //metodos
    public String guardarPartido(){
        if(partidosModel.insertarPartido(partido)==0){
            JsfUtils.addErrorMessage("codigoPartido", "Ya existe ese partido.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Partido agregado exitosamente.");
        return "/administradorGeneral/listaPartidos?faces-redirect=true";
    }
}
