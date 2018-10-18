package sv.edu.udb.www.managed_beans;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.JrvEntity;
import sv.edu.udb.www.entities.TipoeleccionesEntity;
import sv.edu.udb.www.model.CentrosVotacionesModel;
import sv.edu.udb.www.model.CiudadanosModel;
import sv.edu.udb.www.model.EleccionesModel;
import sv.edu.udb.www.model.JrvModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "eleccionesBean")
@RequestScoped
public class EleccionesBean {

    @EJB
    private CentrosVotacionesModel centrosVotacionesModel;

    @EJB
    private CiudadanosModel ciudadanosModel;

    @EJB
    private JrvModel jrvModel;

    @EJB
    private EleccionesModel eleccionesModel;

    private JrvEntity jrv = new JrvEntity();

    private EleccionesEntity eleccion = new EleccionesEntity();

    private List<TipoeleccionesEntity> listaTiposElecciones;

    private List<EleccionesEntity> listaElecciones;

    private Date fechaActual = new Date();

    public EleccionesBean() {
    }

    public JrvEntity getJrv() {
        return jrv;
    }

    public void setJrv(JrvEntity jrv) {
        this.jrv = jrv;
    }

    public EleccionesEntity getEleccion() {
        return eleccion;
    }

    public void setEleccion(EleccionesEntity eleccion) {
        this.eleccion = eleccion;
    }

    public List<TipoeleccionesEntity> getListaTiposElecciones() {
        listaTiposElecciones = eleccionesModel.listarTipoElecciones();
        return listaTiposElecciones;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public void setListaTiposElecciones(List<TipoeleccionesEntity> listaTiposElecciones) {
        this.listaTiposElecciones = listaTiposElecciones;
    }

    public List<EleccionesEntity> getListaElecciones() {
        listaElecciones = eleccionesModel.listarElecciones();
        return listaElecciones;
    }

    public void setListaElecciones(List<EleccionesEntity> listaElecciones) {
        this.listaElecciones = listaElecciones;
    }

    //metodos
    public String generarJRVs() {
        HttpServletRequest request = JsfUtils.getRequest();
        String id = request.getParameter("codigo");
        List<CentrovotacionEntity> listaCentroVotacion = centrosVotacionesModel.listarCentrosVotacion();
        eleccion = eleccionesModel.obtenerEleccion(id);
        if (jrvModel.generarJRVs(eleccion, listaCentroVotacion) == 0) {
            JsfUtils.addFlashMessage("fracaso", "JRVs no creados exitosamente.");
            return "/administradorGeneral/listaElecciones?faces-redirect=true";
        }
        JsfUtils.addFlashMessage("exito", "JRVs creados exitosamente.");
        return "/administradorGeneral/listaElecciones?faces-redirect=true";
    }

    public String guardarEleccion() {
        if (eleccionesModel.insertarEleccion(eleccion) == 0) {
            JsfUtils.addErrorMessage("idEleccion", "Ya existe un ID con esa elección.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Elección agregado exitosamente.");
        return "/administradorGeneral/listaElecciones?faces-redirect=true";
    }
}
