/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_beans;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.CandidatosEntity;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.PartidosEntity;
import sv.edu.udb.www.model.CandidatosModel;
import sv.edu.udb.www.model.EleccionesModel;
import sv.edu.udb.www.model.PartidosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "candidatosBean")
@RequestScoped
public class CandidatosBean {

    @EJB
    private PartidosModel partidosModel;

    @EJB
    private EleccionesModel eleccionesModel;

    @EJB
    private CandidatosModel candidatosModel;
    
    private String dui;
    
    private CandidatosEntity candidato = new CandidatosEntity();
    
    private List<EleccionesEntity> listaEleccionesPresidenciales;
    
    private List<EleccionesEntity> listaEleccionesMunicipales;
    
    private List<PartidosEntity> listaPartidos;
    
    public CandidatosBean() {
    }

    public CandidatosEntity getCandidato() {
        return candidato;
    }

    public void setCandidato(CandidatosEntity candidato) {
        this.candidato = candidato;
    }
    
    public List<CandidatosEntity> getListaCandidatosPresidenciales(){
        return candidatosModel.listarCandidatosPresidenciales();
    }
    
    public List<CandidatosEntity> getListaCandidatosConsejoMunicipal(){
        return candidatosModel.listarCandidatosCandidatos();
    }

    public List<EleccionesEntity> getListaEleccionesMunicipales() {
        return eleccionesModel.listarEleccionesConsejoMunicipal();
    }

    public void setListaEleccionesMunicipales(List<EleccionesEntity> listaEleccionesMunicipales) {
        this.listaEleccionesMunicipales = listaEleccionesMunicipales;
    }

    
    public String getDui() {
        return dui;
    }

    public void setDui(String dui) {
        this.dui = dui;
    }
    
    
    
    //Candidatos Presidenciales

    public List<EleccionesEntity> getListaEleccionesPresidenciales() {
        return eleccionesModel.listarEleccionesPresidenciales();
    }

    public void setListaEleccionesPresidenciales(List<EleccionesEntity> listaEleccionesPresidenciales) {
        this.listaEleccionesPresidenciales = listaEleccionesPresidenciales;
    }

    public List<PartidosEntity> getListaPartidos() {
        return partidosModel.listarPartidos();
    }

    public void setListaPartidos(List<PartidosEntity> listaPartidos) {
        this.listaPartidos = listaPartidos;
    }
    
    //metodos candidato presidenciales
    public String guardarCandidato(){
        candidato.setDuiCiudadano(candidatosModel.obtenerCiudadano(dui));
        if(candidatosModel.insertarCandidato(candidato)==0){
            JsfUtils.addErrorMessage("idCandidato", "Ya existe ese candidato.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Candidato agregado exitosamente.");
        return "/administradorGeneral/listaCandidatos?faces-redirect=true";
    }
    
    //metodos candidato consejo municipal
    public String guardarCandidatoMunicipal(){
        candidato.setDuiCiudadano(candidatosModel.obtenerCiudadano(dui));
        if(!candidato.getIdEleccion().getFechaRegistro().before(new Date()) && !candidato.getIdEleccion().getFechaFinRegistro().after(new Date())){
            JsfUtils.addErrorMessage("idCandidato", "Agregue el candidato entre las fechas de registro.");
            return null;
        }
        if(candidatosModel.insertarCandidato(candidato)==0){
            JsfUtils.addErrorMessage("idCandidato", "Ya existe ese candidato.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Candidato agregado exitosamente.");
        return "/administradorDepartamental/listaCandidatosConsejoMunicipal?faces-redirect=true";
    }
    
}
