package sv.edu.udb.www.managed_beans;

import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import sv.edu.udb.www.entities.DepartamentosEntity;
import sv.edu.udb.www.model.DepartamentosModel;
import sv.edu.udb.www.utils.JsfUtils;


@Named(value = "departamentosBean")
@RequestScoped
public class DepartamentosBean {

    @EJB
    private DepartamentosModel departamentosModel;
    
    private DepartamentosEntity departamento = new DepartamentosEntity();
    
    public DepartamentosBean() {
    }
    
    public DepartamentosEntity getDepartamento() {
        return departamento;
    }

    public void setDepartamento(DepartamentosEntity departamento) {
        this.departamento = departamento;
    }
    
    public List<DepartamentosEntity> getListaDepartamentos(){
        return departamentosModel.listarDepartamentos();
    }
    
    //metodos
    public String guardarDepartamento(){
        if(departamentosModel.insertarDepartamento(departamento)==0){
            JsfUtils.addErrorMessage("idDepartamento", "Ya existe ese departamento.");
            return null;
        }
        JsfUtils.addFlashMessage("exito", "Elección agregado exitosamente.");
        return "/administradorGeneral/listaDepartamentos?faces-redirect=true";
    }
    
}
