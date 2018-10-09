/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.MunicipiosEntity;

/**
 *
 * @author admi
 */
@Stateless
public class MunicipiosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;
    
    public List<MunicipiosEntity> listarMunicipios(){
        Query query = em.createNamedQuery("MunicipiosEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarMunicipio(MunicipiosEntity municipio){
        try{
            em.persist(municipio);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    public MunicipiosEntity obtenerMunicipio(int id){
        return em.find(MunicipiosEntity.class, id);
    }
    
}
