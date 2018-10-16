package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.CiudadanosEntity;

@Stateless
public class CiudadanosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<CiudadanosEntity> listarCiudadanos() {
        Query query = em.createNamedQuery("CiudadanosEntity.findAll");
        return query.getResultList();
    }

    public int ingresarCiudadanos(CiudadanosEntity ciudadanos) {
        try {
            em.persist(ciudadanos);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public CiudadanosEntity obtenerCiudadano(String codigo) {
        return em.find(CiudadanosEntity.class, codigo);
    }

    public int modificarCiudadanos(CiudadanosEntity ciudadano) {
        try {
            em.merge(ciudadano);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public int eliminarCiudadanos(String codigo) {
        try {
            CiudadanosEntity ciudadano = em.find(CiudadanosEntity.class, codigo);

            if (ciudadano != null) {
                em.remove(ciudadano);
                em.flush();
                return 1;
            }
            return 0;
        } catch (Exception e) {
            return 0;
        }
    }
}
