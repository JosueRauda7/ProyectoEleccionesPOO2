/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.managed_beans;

import java.util.Calendar;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.servlet.http.HttpServletRequest;
import sv.edu.udb.www.entities.CentrovotacionEntity;
import sv.edu.udb.www.entities.CiudadanosEntity;
import sv.edu.udb.www.entities.EleccionesEntity;
import sv.edu.udb.www.entities.JrvEntity;
import sv.edu.udb.www.model.PresidentejrvModel;
import sv.edu.udb.www.utils.JsfUtils;

/**
 *
 * @author Emerson Torres
 */
@Named(value = "presidentejrvBean")
@RequestScoped
public class PresidentejrvBean {

    @EJB
    private PresidentejrvModel presidentejrvModel;

    HttpServletRequest request = JsfUtils.getRequest();
    EleccionesEntity eleccion = new EleccionesEntity();
    CiudadanosEntity ciudadano = new CiudadanosEntity();
    JrvEntity jrv = new JrvEntity();

    public PresidentejrvBean() {
        request.getSession().setAttribute("valor", 1);
    }

    public CiudadanosEntity getCiudadano() {
        return ciudadano;
    }

    public void setCiudadano(CiudadanosEntity ciudadano) {
        this.ciudadano = ciudadano;
    }

    public List<EleccionesEntity> getObtenerEleccion() {
        return presidentejrvModel.listaEleccionPresidente((int) request.getSession().getAttribute("valor"));
    }

    public String nombrePresidente() {
        return presidentejrvModel.nombrePresidente((int) request.getSession().getAttribute("valor"));
    }

    public List<CentrovotacionEntity> getListaCentro() {
        return presidentejrvModel.obtenerCentroPresidente((int) request.getSession().getAttribute("valor"));
    }

    public String activarVotacion() {
        try {
            Calendar c = Calendar.getInstance();
            String horas, minutos, segundos, hora;
            horas = Integer.toString(c.get(Calendar.HOUR_OF_DAY));
            minutos = Integer.toString(c.get(Calendar.MINUTE));
            segundos = Integer.toString(c.get(Calendar.SECOND));
            hora = horas + ":" + minutos + ":" + segundos;
            jrv = presidentejrvModel.obtenerJrv((int) request.getSession().getAttribute("valor"));
            DateFormat hora2 = new SimpleDateFormat("HH:mm:ss");
            Date convertido = hora2.parse(hora);
            jrv.setHoraApertura(convertido);
            if (presidentejrvModel.activarJrv(jrv) == 0) {
                return null;
            } else {
                return "verificarVotante";
            }
        } catch (ParseException ex) {
            Logger.getLogger(PresidentejrvBean.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }

    public String verificarCiudadano() {
         jrv = presidentejrvModel.obtenerJrv((int) request.getSession().getAttribute("valor"));
        ciudadano = presidentejrvModel.verificarCiudadano(ciudadano.getDuiCiudadano(),jrv.getIdJrv());
        if (ciudadano == null) {
            JsfUtils.addErrorMessage("duiCiudadano","El dui ingresado no pertenece a esta urna o ya ha emitido su voto");
            return null;
        } else {
            return "procesoVoto";
        }
    }
}
