package sv.edu.udb.www.model;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.TipoeleccionesEntity;


@Stateless
public class EleccionesModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    //Tipo de elecciones
    public List<TipoeleccionesEntity> listarTipoElecciones(){
        Query query = em.createNamedQuery("TipoeleccionesEntity.findAll",TipoeleccionesEntity.class);
        return query.getResultList();
    }
    
    public TipoeleccionesEntity obtenerTipoEleccion(int id){
        return em.find(TipoeleccionesEntity.class, id);
    }
    //Fin tipo elecciones
    
    public List<EleccionesEntity> listarElecciones(){
        Query query = em.createNamedQuery("EleccionesEntity.findAll",EleccionesEntity.class);
        return query.getResultList();
    }
    
    public int insertarEleccion(EleccionesEntity eleccion){
        try{
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            eleccion.setIdEleccion("ELEC"+anio);
            em.persist(eleccion);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    
    public EleccionesEntity obtenerEleccion(String id){
        return em.find(EleccionesEntity.class, id);
    }

    

}
