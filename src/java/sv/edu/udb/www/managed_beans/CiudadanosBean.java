package sv.edu.udb.www.managed_beans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import sv.edu.udb.www.entities.CentrovotacionEntity;
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

    private int idDepartamento;
    private int idMunicipio;
    private int idCentro;

    private CiudadanosEntity ciudadanos = new CiudadanosEntity();
    private DepartamentosEntity departamentos = new DepartamentosEntity();
    private MunicipiosEntity municipios = new MunicipiosEntity();
    private CentrovotacionEntity centro = new CentrovotacionEntity();
    private Part file;

    private List<DepartamentosEntity> listaDepartamentos;
    private List<MunicipiosEntity> listaMunicipios;
    private List<MunicipiosEntity> listaNuevaMunicipios;
    private List<CentrovotacionEntity> listaCentros;
    private List<CentrovotacionEntity> listaNuevaCentros;

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

    public CentrovotacionEntity getCentro() {
        return centro;
    }

    public void setCentro(CentrovotacionEntity centro) {
        this.centro = centro;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public int getIdCentro() {
        return idCentro;
    }

    public void setIdCentro(int idCentro) {
        this.idCentro = idCentro;
    }

    public List<MunicipiosEntity> getListaNuevaMunicipios() {
        return listaNuevaMunicipios;
    }

    public void setListaNuevaMunicipios(List<MunicipiosEntity> listaNuevaMunicipios) {
        this.listaNuevaMunicipios = listaNuevaMunicipios;
    }

    public List<CentrovotacionEntity> getListaNuevaCentros() {
        return listaNuevaCentros;
    }

    public void setListaNuevaCentros(List<CentrovotacionEntity> listaNuevaCentros) {
        this.listaNuevaCentros = listaNuevaCentros;
    }

    public List<DepartamentosEntity> getListaDepartamentos() {
        listaDepartamentos = ciudadanosModel.listarDepartamentos();
        return listaDepartamentos;
    }

    public void setListaDepartamentos(List<DepartamentosEntity> listaDepartamentos) {
        this.listaDepartamentos = listaDepartamentos;
    }

    public List<MunicipiosEntity> getListaMunicipios() {
        listaMunicipios = ciudadanosModel.listarMunicipios();
        return listaMunicipios;
    }

    public void setListaMunicipios(List<MunicipiosEntity> listaMunicipios) {
        this.listaMunicipios = listaMunicipios;
    }

<<<<<<< HEAD
=======
    public List<CentrovotacionEntity> getListaNuevaCentros() {
        this.listaNuevaCentros = ciudadanosModel.listaCentrosIdMunicip(this.idMunicipio);

        return listaNuevaCentros;
    }

    public void setListaNuevaCentros(List<CentrovotacionEntity> listaNuevaCentros) {
        this.listaNuevaCentros = listaNuevaCentros;
    }

>>>>>>> 7ed9aed8a82e3f00b35ddd64bff10303b1b39e76
    public List<CentrovotacionEntity> getListaCentros() {
        listaCentros = ciudadanosModel.listarCentros();
        return listaCentros;
    }

    public void setListaCentros(List<CentrovotacionEntity> listaCentros) {
        this.listaCentros = listaCentros;
    }

    // Métodos
    public List<CiudadanosEntity> getListaCiudadanos() {
        return ciudadanosModel.listarCiudadanos();
    }

    
    public String ingresarCiudadano() {
        try {
            this.idDepartamento = 0;
            this.idMunicipio = 0;

            file.write("fotos/" + getFileName(file));

            String nombreArchivo = (String) getFileName(file);

            ciudadanos.setUrlFoto(nombreArchivo);

            /*InputStream in = file.getInputStream();

            File f = new File("fotos/" + file.getSubmittedFileName());
            f.createNewFile();
            FileOutputStream out = new FileOutputStream(f);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }

            out.close();
            in.close();*/
            CentrovotacionEntity objCentro = new CentrovotacionEntity();

            objCentro.setIdCentroVotacion((Integer) this.idCentro);

            ciudadanos.setIdCentroVotacion(objCentro);

            if (ciudadanosModel.ingresarCiudadanos(ciudadanos) == 0) {
                JsfUtils.addErrorMessage("fracaso", "Ya existe ese departamento.");
                return null;
            }
            JsfUtils.addFlashMessage("exito", "Ciudadano insertado exitosamente");
            return "/gestionVotantes/listaCiudadanos?faces-redirect=true";
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

        CentrovotacionEntity objCentro = new CentrovotacionEntity();

        objCentro.setIdCentroVotacion((Integer) this.idCentro);

        ciudadanos.setIdCentroVotacion(objCentro);

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

    

    public void nuevaListaCentros() {
<<<<<<< HEAD

=======
        
>>>>>>> 7ed9aed8a82e3f00b35ddd64bff10303b1b39e76
        this.listaNuevaCentros = ciudadanosModel.listaCentrosIdMunicip(this.idMunicipio);

    }

}
