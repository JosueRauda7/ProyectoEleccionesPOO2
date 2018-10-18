package sv.edu.udb.www.managed_beans;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import static jdk.nashorn.internal.objects.NativeError.getFileName;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.DepartamentosEntity;
import sv.edu.udb.www.entities.MunicipiosEntity;
import sv.edu.udb.www.model.CiudadanosModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "ciudadanosBean")
@RequestScoped
public class CiudadanosBean {

    @EJB
    private CiudadanosModel ciudadanosModel;

    private CiudadanosEntity ciudadanos = new CiudadanosEntity();
    private DepartamentosEntity departamentos = new DepartamentosEntity();
    private MunicipiosEntity municipios = new MunicipiosEntity();
    private Part file;

    public CiudadanosBean() {
    }
    
    public CiudadanosEntity getCiudadanos() {
        return ciudadanos;
    }

    public void setCiudadanos(CiudadanosEntity ciudadanos) {
        this.ciudadanos = ciudadanos;
    }

    public DepartamentosEntity getDepartamentos() {
        return departamentos;
    }

    public void setDepartamentos(DepartamentosEntity departamentos) {
        this.departamentos = departamentos;
    }

    public MunicipiosEntity getMunicipios() {
        return municipios;
    }

    public void setMunicipios(MunicipiosEntity municipios) {
        this.municipios = municipios;
    }
    
    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }
        
    // Métodos
    
    public List<CiudadanosEntity> getListaCiudadanos() {
        return ciudadanosModel.listarCiudadanos();
    }

    public List<DepartamentosEntity> getListaDepartamentos(){
        return ciudadanosModel.listarDepartamentos();
    }
    
    public List<MunicipiosEntity> getListaMunicipios(){
        return ciudadanosModel.listarMunicipios();
    }
    
    public String ingresarCiudadano() {        
        try {
            file.write("fotos/" + getFileName(file.getContentType()));
            
            String nombreArchivo = (String) getFileName(file.getContentType());
            ciudadanos.setUrlFoto(nombreArchivo);
            
            if (ciudadanosModel.ingresarCiudadanos(ciudadanos) == 0) {
                JsfUtils.addErrorMessage("fracaso", "Ya existe ese departamento.");
                return null;
            }
            JsfUtils.addFlashMessage("exito", "Ciudadano insertado exitosamente");
            return "/gestionVotantes/ingresarCiudadano?faces-redirect=true";
        } catch (IOException ex) {
            Logger.getLogger(CiudadanosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
    
    public void obtenerIdDepartamento(String idDepartamento){
        System.out.println("ID: " + idDepartamento);
    }

}
