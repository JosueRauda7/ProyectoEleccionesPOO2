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
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.JrvEntity;
import sv.edu.udb.www.model.CentrosVotacionesModel;
import sv.edu.udb.www.model.EleccionesModel;
import sv.edu.udb.www.model.JrvModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "jrvsBean")
@RequestScoped
public class JrvsBean {

    @EJB
    private EleccionesModel eleccionesModel;

    @EJB
    private CentrosVotacionesModel centrosVotacionesModel;

    @EJB
    private JrvModel jrvModel;

    private JrvEntity jrv = new JrvEntity();
    
    private List<EleccionesEntity> listaElecciones;
    
    private List<CentrovotacionEntity> listaCentrosVotaciones;
    
    public JrvsBean() {
    }

    public List<EleccionesEntity> getListaElecciones() {
        return eleccionesModel.listarElecciones();
    }

    public void setListaElecciones(List<EleccionesEntity> listaElecciones) {
        this.listaElecciones = listaElecciones;
    }

    public List<CentrovotacionEntity> getListaCentrosVotaciones() {
        return centrosVotacionesModel.listarCentrosVotacion();
    }

    public void setListaCentrosVotaciones(List<CentrovotacionEntity> listaCentrosVotaciones) {
        this.listaCentrosVotaciones = listaCentrosVotaciones;
    }
    
    

    public JrvEntity getJrv() {
        return jrv;
    }

    public void setJrv(JrvEntity jrv) {
        this.jrv = jrv;
    }
    
    public List<JrvEntity> getListaJRV(){
        return jrvModel.listarJRVs();
    }
    
    //metodos
    public String guardarJRV(){
        jrv.setEstadoFinalizado((Integer)0);
        if (jrvModel.insertarJRV(jrv) == 0) {
            JsfUtils.addErrorMessage("idEleccion", "Ya existe un ID con esa JRV.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "JRV agregado exitosamente.");
        return "/administradorGeneral/listaJRV?faces-redirect=true";
    }
}
