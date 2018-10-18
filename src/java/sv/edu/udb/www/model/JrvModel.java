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
import sv.edu.udb.www.entities.CiudadanojrvEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.JrvEntity;

/**
 *
 * @author admi
 */
@Stateless
public class JrvModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<JrvEntity> listarJRVs() {
        Query query = em.createNamedQuery("JrvEntity.findAll");
        return query.getResultList();
    }

    public int insertarJRV(JrvEntity jrv) {
        try {
            em.persist(jrv);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public JrvEntity obtenerJRV(int id) {
        return em.find(JrvEntity.class, id);
    }

    public int asignarPresidenteJRV(JrvEntity presidente) {
        try {
            em.merge(presidente);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    public JrvEntity obtenerJRVporCentroVotacion(CentrovotacionEntity centroVotacion) {
        Query query = em.createQuery("select j from JrvEntity j where j.idCentroVotacion.idCentroVotacion = ?1");
        query.setParameter(1,centroVotacion.getIdCentroVotacion());
        return (JrvEntity) query.getSingleResult();
    }

    public int generarJRVs(EleccionesEntity eleccion, List<CentrovotacionEntity> listaCentroVotacion) {
        
            int cantidadCiudadanos = 0;
            double cantidadJRVs = 0;
            for (int i = 0; i <= listaCentroVotacion.size(); i++) {
                List<CiudadanosEntity> listaCiudadanos;
                JrvEntity jrv = new JrvEntity();
                
                CentrovotacionEntity centroVotacion = new CentrovotacionEntity();
                centroVotacion = listaCentroVotacion.get(i);

                jrv.setIdCentroVotacion(centroVotacion);
                jrv.setIdEleccion(eleccion);
                jrv.setEstadoFinalizado((Integer) 0);

                listaCiudadanos = centroVotacion.getCiudadanosEntityList();
                cantidadCiudadanos = listaCiudadanos.size();
                //Math.ceil para redondear todos los decimales a su valor entero mas proximo
                cantidadJRVs = Math.ceil((double)cantidadCiudadanos /(double) 200);
                for (int j = 1; j <= cantidadJRVs; j++) {
                    //insertar jrv
                    em.persist(jrv);
                    em.flush();
                    jrv = this.obtenerJRVporCentroVotacion(centroVotacion);
                    for (int k = (200 * (j - 1)); (k < (200 * j)); k++) {
                        CiudadanosEntity ciudadano = new CiudadanosEntity();
                        CiudadanojrvEntity ciudadanoJRV = new CiudadanojrvEntity();
                        if(k==cantidadCiudadanos){
                            k=(200 * j);
                            return 1;
                        }
                        ciudadano = listaCiudadanos.get(k);
                        ciudadanoJRV.setDuiCiudadano(ciudadano);
                        ciudadanoJRV.setIdJrv(jrv);
                        em.persist(ciudadanoJRV);
                        em.flush();
                    }
                }
            }
            return 1;
        
    }
}
