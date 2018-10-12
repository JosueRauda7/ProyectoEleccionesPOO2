/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_beans;

import java.util.UUID;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.JrvEntity;
import sv.edu.udb.www.entities.MiembrojrvEntity;
import sv.edu.udb.www.entities.TipomiembroEntity;
import sv.edu.udb.www.entities.TipousuarioEntity;
import sv.edu.udb.www.entities.UsuariosEntity;
import sv.edu.udb.www.model.CiudadanosModel;
import sv.edu.udb.www.model.JrvModel;
import sv.edu.udb.www.model.MiembrosJrvModel;
import sv.edu.udb.www.model.UsuariosModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author admi
 */
@Named(value = "miembrosJrvBean")
@RequestScoped
public class MiembrosJrvBean {

    @EJB
    private UsuariosModel usuariosModel;

    @EJB
    private CiudadanosModel ciudadanosModel;

    @EJB
    private JrvModel jrvModel;

    @EJB
    private MiembrosJrvModel miembrosJrvModel;

    private String duiPresidente;

    private String duiSecretario;

    private String duiVocal;

    private JrvEntity jrv = new JrvEntity();

    private TipomiembroEntity tipoPresidente = new TipomiembroEntity();

    private TipomiembroEntity tipoVocal = new TipomiembroEntity();

    private TipomiembroEntity tipoSecretario = new TipomiembroEntity();

    private MiembrojrvEntity presidente = new MiembrojrvEntity();

    private MiembrojrvEntity vocal = new MiembrojrvEntity();

    private MiembrojrvEntity secretario = new MiembrojrvEntity();

    public MiembrosJrvBean() {
    }

    public String getDuiPresidente() {
        return duiPresidente;
    }

    public void setDuiPresidente(String duiPresidente) {
        this.duiPresidente = duiPresidente;
    }

    public String getDuiSecretario() {
        return duiSecretario;
    }

    public void setDuiSecretario(String duiSecretario) {
        this.duiSecretario = duiSecretario;
    }

    public String getDuiVocal() {
        return duiVocal;
    }

    public void setDuiVocal(String duiVocal) {
        this.duiVocal = duiVocal;
    }

    public TipomiembroEntity getTipoPresidente() {
        return tipoPresidente;
    }

    public void setTipoPresidente(TipomiembroEntity tipoPresidente) {
        this.tipoPresidente = tipoPresidente;
    }

    public TipomiembroEntity getTipoVocal() {
        return tipoVocal;
    }

    public void setTipoVocal(TipomiembroEntity tipoVocal) {
        this.tipoVocal = tipoVocal;
    }

    public TipomiembroEntity getTipoSecretario() {
        return tipoSecretario;
    }

    public void setTipoSecretario(TipomiembroEntity tipoSecretario) {
        this.tipoSecretario = tipoSecretario;
    }

    public MiembrojrvEntity getPresidente() {
        return presidente;
    }

    public void setPresidente(MiembrojrvEntity presidente) {
        this.presidente = presidente;
    }

    public MiembrojrvEntity getVocal() {
        return vocal;
    }

    public void setVocal(MiembrojrvEntity vocal) {
        this.vocal = vocal;
    }

    public MiembrojrvEntity getSecretario() {
        return secretario;
    }

    public void setSecretario(MiembrojrvEntity secretario) {
        this.secretario = secretario;
    }

    public JrvEntity getJrv() {
        return jrv;
    }

    public void setJrv(JrvEntity jrv) {
        this.jrv = jrv;
    }

    public String obtenerJRV() {
        HttpServletRequest request = JsfUtils.getRequest();
        int id = Integer.parseInt(request.getParameter("codigo"));
        jrv = jrvModel.obtenerJRV((Integer) id);
        return "/administradorDepartamental/nuevosMiembrosJRV";
    }

    public String guardarMiembros() {
        //datos adicionales
        presidente.setIdTipoMiembro(miembrosJrvModel.obtenerTipoMiembro(1));
        secretario.setIdTipoMiembro(miembrosJrvModel.obtenerTipoMiembro(2));
        vocal.setIdTipoMiembro(miembrosJrvModel.obtenerTipoMiembro(3));

        presidente.setIdJrv(jrvModel.obtenerJRV(jrv.getIdJrv()));
        secretario.setIdJrv(jrvModel.obtenerJRV(jrv.getIdJrv()));
        vocal.setIdJrv(jrvModel.obtenerJRV(jrv.getIdJrv()));

        presidente.setDuiCiudadano(ciudadanosModel.obtenerCiudadano(this.getDuiPresidente()));
        secretario.setDuiCiudadano(ciudadanosModel.obtenerCiudadano(this.getDuiSecretario()));
        vocal.setDuiCiudadano(ciudadanosModel.obtenerCiudadano(this.getDuiVocal()));

        if (miembrosJrvModel.insertarMiembroJRV(presidente) == 0) {
            JsfUtils.addErrorMessage("duiPresidente", "Presidente ya ha sido asignado anteriormente.");
            return null;
        }
        if (miembrosJrvModel.insertarMiembroJRV(secretario) == 0) {
            JsfUtils.addErrorMessage("duiSecretario", "Secretario ya ha sido asignado anteriormente.");
            return null;
        }
        if (miembrosJrvModel.insertarMiembroJRV(vocal) == 0) {
            JsfUtils.addErrorMessage("duiVocal", "Vocal ya ha sido asignado anteriormente.");
            return null;
        }

        //crear usuario presidente  
        jrv=jrvModel.obtenerJRV(jrv.getIdJrv());
        jrv.setIdUsuario(usuariosModel.insertarPresidenteJRV(miembrosJrvModel.obtenerMiembroJRV(presidente.getIdMiembroJrv())));
        if (jrv.getIdUsuario() == null) {
            JsfUtils.addErrorMessage("duiPresidente", "Presidente ya tiene su cuenta.");
            return null;
        }
        //fin de crear usuario presidente
        //asignar presidente a jrv
        if (jrvModel.asignarPresidenteJRV(jrv) == 0) {
            JsfUtils.addErrorMessage("duiPresidente", "Presidente ya pertenece a una JRV.");
            return null;
        }
        //fin asignar presidente a jrv

        JsfUtils.addFlashMessage("exito", "Miembros de JRV han sido asignados exitosamente.");
        return "/administradorDepartamental/listaJRV?faces-redirect=true";
    }

}
