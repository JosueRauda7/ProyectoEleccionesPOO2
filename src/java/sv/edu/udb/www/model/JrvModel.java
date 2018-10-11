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
import sv.edu.udb.www.entities.JrvEntity;

/**
 *
 * @author admi
 */
@Stateless
public class JrvModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<JrvEntity> listarJRVs(){
        Query query = em.createNamedQuery("JrvEntity.findAll");
        return query.getResultList();
    }
    
    public int insertarJRV(JrvEntity jrv){
        try{
            em.persist(jrv);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
