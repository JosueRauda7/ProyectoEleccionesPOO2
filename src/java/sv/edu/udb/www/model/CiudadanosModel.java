package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.DepartamentosEntity;
import sv.edu.udb.www.entities.MunicipiosEntity;

@Stateless
public class CiudadanosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    // Métodos para listar
    public List<CiudadanosEntity> listarCiudadanos() {
        Query query = em.createNamedQuery("CiudadanosEntity.findAll");
        return query.getResultList();
    }

    public List<DepartamentosEntity> listarDepartamentos() {
        Query query = em.createNamedQuery("DepartamentosEntity.findAll");
        return query.getResultList();
    }

    public List<MunicipiosEntity> listarMunicipios() {
        Query query = em.createNamedQuery("MunicipiosEntity.findAll");
        return query.getResultList();
    }
    
    public List<CentrovotacionEntity> listarCentros(){
        Query query = em.createNamedQuery("CentrovotacionEntity.findAll");
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

    
<<<<<<< HEAD
    public List<CentrovotacionEntity> listaCentrosIdMunicip(int idMunicipio){
        /*Query query = em.createNativeQuery("SELECT IdCentroVotacion, CentroVotacion FROM centrovotacion WHERE IdMunicipio=?", CentrovotacionEntity.class);
        query.setParameter(1, idMunicipio);
        return query.getResultList();*/
                
        List<CentrovotacionEntity> centro;
        centro = m.getCentrovotacionEntityList();
        return centro;
=======

    public List<CentrovotacionEntity> listaCentrosIdMunicip(int idmunicipio){
          List<CentrovotacionEntity> lista = null;
          MunicipiosEntity municipio = new MunicipiosEntity();
          municipio=em.find(MunicipiosEntity.class, idmunicipio);
          lista=municipio.getCentrovotacionEntityList();
          return lista;
>>>>>>> 7ed9aed8a82e3f00b35ddd64bff10303b1b39e76
    }
}
