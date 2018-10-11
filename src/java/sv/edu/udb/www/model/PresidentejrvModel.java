
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.EleccionesEntity;

@Stateless
public class PresidentejrvModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<EleccionesEntity> listaEleccionPresidente(int valor){
    Query query = em.createNativeQuery("SELECT e.* FROM miembrojrv m INNER JOIN jrv j ON m.IdJrv = j.IdJrv INNER JOIN elecciones e on j.IdEleccion = e.IdEleccion WHERE m.IdMiembroJrv = :valor");
    query.setParameter("valor", valor);
    return query.getResultList();
    }
    
}
