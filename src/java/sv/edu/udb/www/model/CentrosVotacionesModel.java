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
import sv.edu.udb.www.entities.CentrovotacionEntity;

/**
 *
 * @author admi
 */
@Stateless
public class CentrosVotacionesModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<CentrovotacionEntity> listarCentrosVotacion() {
        Query query = em.createNamedQuery("CentrovotacionEntity.findAll");
        return query.getResultList();
    }

    public CentrovotacionEntity obtenerCentroVotacion(int id) {
        return em.find(CentrovotacionEntity.class, id);
    }

    public int insertarCentroVotacion(CentrovotacionEntity centro) {
        try {
            em.persist(centro);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
}
