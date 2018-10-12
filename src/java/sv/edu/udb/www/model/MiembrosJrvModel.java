/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.MiembrojrvEntity;
import sv.edu.udb.www.entities.TipomiembroEntity;
import sv.edu.udb.www.entities.TipousuarioEntity;
import sv.edu.udb.www.entities.UsuariosEntity;

/**
 *
 * @author admi
 */
@Stateless
public class MiembrosJrvModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;
    
    public TipomiembroEntity obtenerTipoMiembro(int id){
        return em.find(TipomiembroEntity.class, id);
    }
    
    public MiembrojrvEntity obtenerMiembroJRV(int id){
        return em.find(MiembrojrvEntity.class, id);
    }

    public int insertarMiembroJRV(MiembrojrvEntity miembro){
        try{
            em.persist(miembro);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
    
    
    
    
}
