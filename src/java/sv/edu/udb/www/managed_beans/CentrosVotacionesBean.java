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
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.entities.MunicipiosEntity;
import sv.edu.udb.www.model.CentrosVotacionesModel;
import sv.edu.udb.www.model.MunicipiosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "centrosVotacionesBean")
@RequestScoped
public class CentrosVotacionesBean {

    @EJB
    private MunicipiosModel municipiosModel;

    @EJB
    private CentrosVotacionesModel centrosVotacionesModel;

    
    private CentrovotacionEntity centroVotacion = new CentrovotacionEntity();
    
    private List<MunicipiosEntity> listaMunicipios;
    
    public CentrosVotacionesBean() {
    }

    public CentrovotacionEntity getCentroVotacion() {
        return centroVotacion;
    }

    public void setCentroVotacion(CentrovotacionEntity centroVotacion) {
        this.centroVotacion = centroVotacion;
    }
    
    public List<CentrovotacionEntity> getListaCentrosVotacion(){
        return centrosVotacionesModel.listarCentrosVotacion();
    }

    public List<MunicipiosEntity> getListaMunicipios() {
        return municipiosModel.listarMunicipios();
    }

    public void setListaMunicipios(List<MunicipiosEntity> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }
    
    //metodos
    
    public String guardarCentroVotacion(){
        centroVotacion.setIdCentroVotacion((Integer)0);
        System.out.print(centroVotacion);
        if(centrosVotacionesModel.insertarCentroVotacion(centroVotacion)==0){
            JsfUtils.addErrorMessage("idCentroVotacion", "Ya existe ese centro de votación.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Centro de votación agregado exitosamente.");
        return "/administradorGeneral/listaCentrosVotaciones?faces-redirect=true";
    }

    
}
