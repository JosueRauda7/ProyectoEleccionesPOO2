package sv.edu.udb.www.converters;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import sv.edu.udb.www.entities.TipoeleccionesEntity;
import sv.edu.udb.www.model.EleccionesModel;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass=TipoeleccionesEntity.class)
public class TipoEleccionesConverter implements Converter {

    EleccionesModel eleccionesModel = lookupEleccionesModelBean();
    
    

    
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if(value==null || value.isEmpty()){
            return null;
        }
        return eleccionesModel.obtenerTipoEleccion(Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if(value==null){
            return "";
        }
        if(value instanceof TipoeleccionesEntity){
            return ((TipoeleccionesEntity) value).getIdTipoEleccion().toString();
        }
        return "";
    }

    private EleccionesModel lookupEleccionesModelBean() {
        try {
            Context c = new InitialContext();
            return (EleccionesModel) c.lookup("java:global/ProyectoPooPeriodo2/EleccionesModel!sv.edu.udb.www.model.EleccionesModel");
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }
    
    
    
}
