package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.JrvEntity;

@Stateless
public class PresidentejrvModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public String nombrePresidente(int idvalor) {
        Query query = em.createNativeQuery("SELECT CONCAT(SUBSTRING_INDEX(c.NombresCiudadano, ' ', 1), ' ' , SUBSTRING_INDEX(c.ApellidosCiudadano, ' ', 1)) as nombre FROM miembrojrv j INNER JOIN ciudadanos c on j.DuiCiudadano = c.DuiCiudadano WHERE j.IdMiembroJrv =?");
        query.setParameter(1, idvalor);
        Object valor = query.getSingleResult();
        return (String) valor;
    }

    public List<EleccionesEntity> listaEleccionPresidente(int valor) {

        Query query = em.createNativeQuery("SELECT e.* FROM miembrojrv m INNER JOIN jrv j ON m.IdJrv = j.IdJrv INNER JOIN elecciones e on j.IdEleccion = e.IdEleccion WHERE m.IdMiembroJrv = ?", EleccionesEntity.class);
        query.setParameter(1, valor);
        return query.getResultList();
    }

    public List<CentrovotacionEntity> obtenerCentroPresidente(int valor) {
        Query query = em.createNativeQuery("SELECT c.* FROM miembrojrv m INNER JOIN jrv j on m.IdJrv = j.IdJrv INNER JOIN centrovotacion c on j.IdCentroVotacion=c.IdCentroVotacion WHERE m.IdMiembroJrv = ?", CentrovotacionEntity.class);
        query.setParameter(1, valor);
        return query.getResultList();
    }

    public JrvEntity obtenerJrv(int idvalor) {
        try {
            Integer valor2;
            Query query = em.createNativeQuery("SELECT IdJrv FROM miembrojrv WHERE IdMiembroJrv = ?");
            query.setParameter(1, idvalor);
            Object valor = query.getSingleResult();
            valor2 = (Integer) valor;
            return em.find(JrvEntity.class, valor2);
        } catch (Exception e) {
            return null;
        }
    }

    public int activarJrv(JrvEntity jrv) {
        try {
            em.merge(jrv);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public CiudadanosEntity verificarCiudadano(String codigo, int idjrv) {
        try {
            Query query = em.createNativeQuery("SELECT c.DuiCiudadano FROM ciudadanos c INNER JOIN ciudadanojrv cj on c.DuiCiudadano = cj.duiCiudadano WHERE cj.duiCiudadano = ? AND cj.idJrv = ?");
            query.setParameter(1, codigo);
            query.setParameter(2, idjrv);
            String valor = (String) query.getSingleResult();
            Query query2 = em.createNativeQuery("SELECT c.* FROM ciudadanos c INNER JOIN conteovotantes cv ON c.DuiCiudadano = cv.DuiCiudadano WHERE cv.DuiCiudadano = ?", CiudadanosEntity.class);
            query2.setParameter(1, valor);
            return (CiudadanosEntity) query2.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
