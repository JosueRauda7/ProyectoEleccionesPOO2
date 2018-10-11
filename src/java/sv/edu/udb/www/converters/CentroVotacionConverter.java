/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.model.CentrosVotacionesModel;

/**
 *
 * @author admi
 */
@FacesConverter(forClass=CentrovotacionEntity.class)
public class CentroVotacionConverter implements Converter {

    CentrosVotacionesModel centrosVotacionesModel = lookupCentrosVotacionesModelBean();

    
    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
            return null;
        }
        return centrosVotacionesModel.obtenerCentroVotacion(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof CentrovotacionEntity){
            return ((CentrovotacionEntity) value).getIdCentroVotacion().toString();
        }
        return "";
    }

    private CentrosVotacionesModel lookupCentrosVotacionesModelBean() {
        try {
            Context c = new InitialContext();
            return (CentrosVotacionesModel) c.lookup("java:global/ProyectoPooPeriodo2/CentrosVotacionesModel!sv.edu.udb.www.model.CentrosVotacionesModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
}
