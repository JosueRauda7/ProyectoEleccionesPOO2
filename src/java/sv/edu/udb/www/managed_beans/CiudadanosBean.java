package sv.edu.udb.www.managed_beans;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.model.CiudadanosModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "ciudadanosBean")
@RequestScoped
public class CiudadanosBean {

    @EJB
    private CiudadanosModel ciudadanosModel;
    
    private CiudadanosEntity ciudadanos = new CiudadanosEntity();
    
    
    public CiudadanosBean() {
    }

    public CiudadanosEntity getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(CiudadanosEntity ciudadanos) {
        this.ciudadanos = ciudadanos;
    }
    
    //Métodos
    
    public String ingresarCiudadano(){
        if(ciudadanosModel.ingresarCiudadanos(ciudadanos) == 0){
                        JsfUtils.addErrorMessage("idDepartamento", "Ya existe ese departamento.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Ciudadano insertado exitosamente");
        return "/gestionVotantes/ingresarCiudadano?faces-redirect=true";
    }
    
}
