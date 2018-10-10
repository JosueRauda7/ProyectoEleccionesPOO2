/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.Calendar;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.PartidosEntity;

/**
 *
 * @author admi
 */
@Stateless
public class PartidosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public List<PartidosEntity> listarPartidos(){
        Query query = em.createNamedQuery("PartidosEntity.findAll");
        return query.getResultList();
    }
    
    public PartidosEntity obtenerPartido(String id){
        return em.find(PartidosEntity.class, id);
    }

    public int insertarPartido(PartidosEntity partido){
        try{
            Query query = em.createNamedQuery("PartidosEntity.findAll");
            int contador = query.getResultList().size();
            System.out.print(contador);
            Calendar calendario = Calendar.getInstance();
            int anio = calendario.get(Calendar.YEAR);
            if(contador==0){
                partido.setCodigoPartido(partido.getNombrePartido().trim().substring(0, 3)+anio+"001");
            }else if(contador>0&&contador<9){
                contador=contador+1;
                partido.setCodigoPartido(partido.getNombrePartido().trim().substring(0, 3)+anio+"00"+contador);
            }else if(contador>=9&&contador<99){
                contador=contador+1;
                partido.setCodigoPartido(partido.getNombrePartido().trim().substring(0, 3)+anio+"0"+contador);
            }else if(contador>=99){
                contador=contador+1;
                partido.setCodigoPartido(partido.getNombrePartido().trim().substring(0, 3)+anio+""+contador);
            }
            em.persist(partido);
            em.flush();
            return 1;
        }catch(Exception e){
            return 0;
        }
    }
}
