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
import sv.edu.udb.www.entities.DetallevotoEntity;
import sv.edu.udb.www.model.DetalleVotoModel;

/**
 *
 * @author VlRoque
 */
@Named(value = "detalleVotoBean")
@RequestScoped
public class DetalleVotoBean {

    @EJB
    private DetalleVotoModel detalleVotoModel;

    private DetallevotoEntity detalle = new DetallevotoEntity();
    
    private List<DetallevotoEntity> listaResultados;
    
    public DetalleVotoBean() {
    }

    public DetallevotoEntity getDetalle() {
        return detalle;
    }

    public void setDetalle(DetallevotoEntity detalle) {
        this.detalle = detalle;
    }

    public List<DetallevotoEntity> getListaResultados() {
        return listaResultados;
    }

    public void setListaResultados(List<DetallevotoEntity> listaResultados) {
        this.listaResultados = listaResultados;
    }
    
        
    public List<DetallevotoEntity> obtenerResultados(){
        listaResultados = detalleVotoModel.obtenerResultados();
        return listaResultados;       
    }
    
}
