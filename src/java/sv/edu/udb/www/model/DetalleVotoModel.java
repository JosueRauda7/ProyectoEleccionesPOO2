package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.DetallevotoEntity;

@Stateless
public class DetalleVotoModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<DetallevotoEntity> obtenerResultados(){
        Query query = em.createNamedQuery("DetallevotoEntity.findAll");
        return query.getResultList();
    }
    

}
