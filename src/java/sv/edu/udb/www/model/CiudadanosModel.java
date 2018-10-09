package sv.edu.udb.www.model;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import sv.edu.udb.www.entities.CiudadanosEntity;

@Stateless
public class CiudadanosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;


    public int ingresarCiudadanos(CiudadanosEntity ciudadanos){
        try{
            em.persist(ciudadanos);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
