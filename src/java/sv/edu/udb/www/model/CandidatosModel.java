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
import sv.edu.udb.www.entities.CandidatosEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.EstadocandidatoEntity;

/**
 *
 * @author admi
 */
@Stateless
public class CandidatosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;
    
    public List<CandidatosEntity> listarCandidatosPresidenciales(){
        Query query = em.createQuery("select c from CandidatosEntity c where c.idEleccion.idTipoEleccion.idTipoEleccion = 1");
        return query.getResultList();
    }
    
    public List<CandidatosEntity> listarCandidatosCandidatos(){
        Query query = em.createQuery("select c from CandidatosEntity c where c.idEleccion.idTipoEleccion.idTipoEleccion = 2");
        return query.getResultList();
    }

    //Buscar ciudadano con dui
    public CiudadanosEntity obtenerCiudadano(String id){
        return em.find(CiudadanosEntity.class, id);
    }
    
    public int insertarCandidato(CandidatosEntity candidato){
        try{
            //Estado activo
            EstadocandidatoEntity estado = new EstadocandidatoEntity();
            estado.setIdEstado((Integer) 1);
            estado.setEstado("Activo");
            
            candidato.setIdEstado(estado);
            
            em.persist(candidato);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
   
}
