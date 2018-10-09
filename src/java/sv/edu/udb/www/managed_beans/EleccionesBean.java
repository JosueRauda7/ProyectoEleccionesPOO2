package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.TipoeleccionesEntity;
import sv.edu.udb.www.model.EleccionesModel;
import sv.edu.udb.www.utils.JsfUtils;

@Named(value = "eleccionesBean")
@RequestScoped
public class EleccionesBean {

    @EJB
    private EleccionesModel eleccionesModel;

    private EleccionesEntity eleccion = new EleccionesEntity();

    private List<TipoeleccionesEntity> listaTiposElecciones;

    private List<EleccionesEntity> listaElecciones;

    public EleccionesBean() {
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
    public String guardarEleccion() {
        if (eleccionesModel.insertarEleccion(eleccion) == 0) {
            JsfUtils.addErrorMessage("idEleccion", "Ya existe un ID con esa elección.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Elección agregado exitosamente.");
        return "/administradorGeneral/listaElecciones?faces-redirect=true";
    }
}
