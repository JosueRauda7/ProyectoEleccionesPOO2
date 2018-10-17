package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.DepartamentosEntity;

@Stateless
public class DepartamentosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<DepartamentosEntity> listarDepartamentos() {
        Query query = em.createNamedQuery("DepartamentosEntity.findAll");
        return query.getResultList();
    }
    
    public List<DepartamentosEntity> listarNombreDepartamentos(){
        Query query = em.createNamedQuery("DepartamentosEntity.nombres");
        return query.getResultList();
    }

    public int insertarDepartamento(DepartamentosEntity departamento){
        try{
            em.persist(departamento);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    public DepartamentosEntity obtenerDepartamento(int id){
        return em.find(DepartamentosEntity.class, id);
    }
    
    public int modificarDepartamento(DepartamentosEntity departamento){
        try{
            em.merge(departamento);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
