/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.model;

import java.util.List;
import java.util.UUID;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sv.edu.udb.www.entities.MiembrojrvEntity;
import sv.edu.udb.www.entities.TipousuarioEntity;
import sv.edu.udb.www.entities.UsuariosEntity;

/**
 *
 * @author admi
 */
@Stateless
public class UsuariosModel {

    @PersistenceContext(unitName = "ProyectoPooPeriodo2PU")
    private EntityManager em;

    public TipousuarioEntity obtenerTipoUsuario(int id) {
        return em.find(TipousuarioEntity.class, id);
    }

    //administrador general
    public List<UsuariosEntity> listarAdministradoresGenerales() {
        Query query = em.createQuery("select u from UsuariosEntity u where u.idTipoUsuario.idTipoUsuario=1");
        return query.getResultList();
    }

    public int insertarAdministradorGeneral(UsuariosEntity usuario) {
        try {
            Query query = em.createNamedQuery("UsuariosEntity.findAll");
            int contador = query.getResultList().size();
            if (contador == 0) {
                usuario.setIdUsuario("G0001");
            } else if (contador > 0 && contador < 9) {
                contador = contador + 1;
                usuario.setIdUsuario("G000" + contador);
            }else if (contador>=9&&contador<99) {
                contador = contador + 1;
                usuario.setIdUsuario("G00"+ contador);
            }else if (contador>=99&&contador<999) {
                contador = contador + 1;
                usuario.setIdUsuario("G0"+ contador);
            }
            else if (contador>=999) {
                contador = contador + 1;
                usuario.setIdUsuario("G"+ contador);
            }
            em.persist(usuario);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    //administrador departamental
    public List<UsuariosEntity> listarAdministradoresDepartamentales() {
        Query query = em.createQuery("select u from UsuariosEntity u where u.idTipoUsuario.idTipoUsuario=2");
        return query.getResultList();
    }
    
    public int insertarAdministradorDepartamental(UsuariosEntity usuario) {
        try {
            Query query = em.createNamedQuery("UsuariosEntity.findAll");
            int contador = query.getResultList().size();
            if (contador == 0) {
                usuario.setIdUsuario("D0001");
            } else if (contador > 0 && contador < 9) {
                contador = contador + 1;
                usuario.setIdUsuario("D000" + contador);
            }else if (contador>=9&&contador<99) {
                contador = contador + 1;
                usuario.setIdUsuario("D00"+ contador);
            }else if (contador>=99&&contador<999) {
                contador = contador + 1;
                usuario.setIdUsuario("D0"+ contador);
            }
            else if (contador>=999) {
                contador = contador + 1;
                usuario.setIdUsuario("D"+ contador);
            }
            em.persist(usuario);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }

    //presidente jrv
    public List<UsuariosEntity> listarPresidentesJRV() {
        Query query = em.createQuery("select u from UsuariosEntity u where u.idTipoUsuario.idTipoUsuario=3");
        return query.getResultList();
    }

    //empleado rnpn
    public List<UsuariosEntity> listarEmpleadosRNPN() {
        Query query = em.createQuery("select u from UsuariosEntity u where u.idTipoUsuario.idTipoUsuario=4");
        return query.getResultList();
    }
    
    public int insertarEmpleadoRNPN(UsuariosEntity usuario) {
        try {
            Query query = em.createNamedQuery("UsuariosEntity.findAll");
            int contador = query.getResultList().size();
            if (contador == 0) {
                usuario.setIdUsuario("R0001");
            } else if (contador > 0 && contador < 9) {
                contador = contador + 1;
                usuario.setIdUsuario("R000" + contador);
            }else if (contador>=9&&contador<99) {
                contador = contador + 1;
                usuario.setIdUsuario("R00"+ contador);
            }else if (contador>=99&&contador<999) {
                contador = contador + 1;
                usuario.setIdUsuario("R0"+ contador);
            }
            else if (contador>=999) {
                contador = contador + 1;
                usuario.setIdUsuario("R"+ contador);
            }
            em.persist(usuario);
            em.flush();
            return 1;
        } catch (Exception e) {
            return 0;
        }
    }
    
    
    public UsuariosEntity insertarPresidenteJRV(MiembrojrvEntity miembro) {
        UsuariosEntity usuario = new UsuariosEntity();
        try {
            Query query = em.createNamedQuery("UsuariosEntity.findAll");
            int contador = query.getResultList().size();
            if (contador == 0) {
                usuario.setIdUsuario("P0001");
            } else if (contador > 0 && contador < 9) {
                contador = contador + 1;
                usuario.setIdUsuario("P000" + contador);
            }else if (contador>=9&&contador<99) {
                contador = contador + 1;
                usuario.setIdUsuario("P00"+ contador);
            }else if (contador>=99&&contador<999) {
                contador = contador + 1;
                usuario.setIdUsuario("P0"+ contador);
            }
            else if (contador>=999) {
                contador = contador + 1;
                usuario.setIdUsuario("P"+ contador);
            }
            usuario.setNombreUsuario(miembro.getDuiCiudadano().getNombresCiudadano());
            usuario.setApellidoUsuario(miembro.getDuiCiudadano().getApellidosCiudadano());
            String correo = usuario.getNombreUsuario() + usuario.getApellidoUsuario()+ contador + "@eleccionsv.com";
            usuario.setCorreo(correo);
            String cadenaAleatoria = UUID.randomUUID().toString();
            usuario.setContrasena(cadenaAleatoria.substring(0, 8));
            usuario.setIdDepartamento(miembro.getDuiCiudadano().getIdCentroVotacion().getIdMunicipio().getIdDepartamento());
            TipousuarioEntity tipoUsuario = new TipousuarioEntity();
            tipoUsuario.setIdTipoUsuario((Integer)3);
            tipoUsuario.setTipoUsuario("Presidente JRV");
            usuario.setIdTipoUsuario(tipoUsuario);
            em.persist(usuario);
            em.flush();
            return usuario;
        } catch (Exception e) {
            return null;
        }
    }
}
