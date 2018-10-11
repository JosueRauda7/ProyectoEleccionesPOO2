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
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.model.PresidentejrvModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author Emerson Torres
 */
@Named(value = "presidentejrvBean")
@RequestScoped
public class PresidentejrvBean {

    @EJB
    private PresidentejrvModel presidentejrvModel;

    
    HttpServletRequest request = JsfUtils.getRequest();
    EleccionesEntity eleccion = new EleccionesEntity();
    
    public PresidentejrvBean() {
        request.getSession().setAttribute("valor",1);
    }

    
    
    public List<EleccionesEntity> getObtenerEleccion(){
    
    return presidentejrvModel.listaEleccionPresidente(1);
    }
    
}
