package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.model.CiudadanosModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "ciudadanosBean")
@RequestScoped
public class CiudadanosBean {

    @EJB
    private CiudadanosModel ciudadanosModel;

    //List<CiudadanosEntity> listaCiudadanos;
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
    public List<CiudadanosEntity> getListaCiudadanos() {
        return ciudadanosModel.listarCiudadanos();
    }

    public String ingresarCiudadano() {
        if (ciudadanosModel.ingresarCiudadanos(ciudadanos) == 0) {
            JsfUtils.addErrorMessage("fracaso", "Ya existe ese departamento.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Ciudadano insertado exitosamente");
        return "/gestionVotantes/ingresarCiudadano?faces-redirect=true";
    }

    public String obtenerCiudadano() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String codigo = request.getParameter("codigo");
        ciudadanos = ciudadanosModel.obtenerCiudadano(codigo);

        return "/gestionVotantes/modificarCiudadanos";
    }

    public String modificarCiudadano() {
        if (ciudadanosModel.modificarCiudadanos(ciudadanos) == 0) {
            JsfUtils.addErrorMessage("fracaso", "No se pudo modificar");
            return null;
        }

        JsfUtils.addFlashMessage("exito", "El registro del ciudadano se ha modificado");
        return "/gestionVotantes/listaEditoriales?faces-redirect=true";
    }

    public String eliminarCiudadano() {
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String codigo = request.getParameter("codigo");

        if (ciudadanosModel.eliminarCiudadanos(codigo) > 0) {
            JsfUtils.addFlashMessage("exito", "El registro del ciudadano se ha eliminado");
        } else {
            JsfUtils.addFlashMessage("fracaso", "No se puede eliminar el registro de este ciudadano");
        }
        return null;
    }
    
    /*public void listaDepartamentos(){
        ciudadanosModel.listaDepartamentos();
    }*/

}
