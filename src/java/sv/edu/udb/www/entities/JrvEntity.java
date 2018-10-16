/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "jrv")
@NamedQueries({
    @NamedQuery(name = "JrvEntity.findAll", query = "SELECT j FROM JrvEntity j")
    , @NamedQuery(name = "JrvEntity.findByIdJrv", query = "SELECT j FROM JrvEntity j WHERE j.idJrv = :idJrv")
    , @NamedQuery(name = "JrvEntity.findByHoraApertura", query = "SELECT j FROM JrvEntity j WHERE j.horaApertura = :horaApertura")
    , @NamedQuery(name = "JrvEntity.findByHoraCierre", query = "SELECT j FROM JrvEntity j WHERE j.horaCierre = :horaCierre")
    , @NamedQuery(name = "JrvEntity.findByEstadoFinalizado", query = "SELECT j FROM JrvEntity j WHERE j.estadoFinalizado = :estadoFinalizado")})
public class JrvEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idJrv;
    @Temporal(TemporalType.TIME)
    private Date horaApertura;
    @Temporal(TemporalType.TIME)
    private Date horaCierre;
    @Basic(optional = false)
    @NotNull
    private int estadoFinalizado;
    @JoinColumn(name = "IdCentroVotacion", referencedColumnName = "IdCentroVotacion")
    @ManyToOne(optional = false)
    private CentrovotacionEntity idCentroVotacion;
    @JoinColumn(name = "IdEleccion", referencedColumnName = "IdEleccion")
    @ManyToOne(optional = false)
    private EleccionesEntity idEleccion;
    @JoinColumn(name = "IdUsuario", referencedColumnName = "IdUsuario")
    @ManyToOne
    private UsuariosEntity idUsuario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJrv")
    private List<CiudadanojrvEntity> ciudadanojrvEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJrv")
    private List<MiembrojrvEntity> miembrojrvEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idJrv")
    private List<DetallevotoEntity> detallevotoEntityList;

    public JrvEntity() {
    }

    public JrvEntity(Integer idJrv) {
        this.idJrv = idJrv;
    }

    public JrvEntity(Integer idJrv, int estadoFinalizado) {
        this.idJrv = idJrv;
        this.estadoFinalizado = estadoFinalizado;
    }

    public Integer getIdJrv() {
        return idJrv;
    }

    public void setIdJrv(Integer idJrv) {
        this.idJrv = idJrv;
    }

    public Date getHoraApertura() {
        return horaApertura;
    }

    public void setHoraApertura(Date horaApertura) {
        this.horaApertura = horaApertura;
    }

    public Date getHoraCierre() {
        return horaCierre;
    }

    public void setHoraCierre(Date horaCierre) {
        this.horaCierre = horaCierre;
    }

    public int getEstadoFinalizado() {
        return estadoFinalizado;
    }

    public void setEstadoFinalizado(int estadoFinalizado) {
        this.estadoFinalizado = estadoFinalizado;
    }

    public CentrovotacionEntity getIdCentroVotacion() {
        return idCentroVotacion;
    }

    public void setIdCentroVotacion(CentrovotacionEntity idCentroVotacion) {
        this.idCentroVotacion = idCentroVotacion;
    }

    public EleccionesEntity getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(EleccionesEntity idEleccion) {
        this.idEleccion = idEleccion;
    }

    public UsuariosEntity getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(UsuariosEntity idUsuario) {
        this.idUsuario = idUsuario;
    }

    public List<CiudadanojrvEntity> getCiudadanojrvEntityList() {
        return ciudadanojrvEntityList;
    }

    public void setCiudadanojrvEntityList(List<CiudadanojrvEntity> ciudadanojrvEntityList) {
        this.ciudadanojrvEntityList = ciudadanojrvEntityList;
    }

    public List<MiembrojrvEntity> getMiembrojrvEntityList() {
        return miembrojrvEntityList;
    }

    public void setMiembrojrvEntityList(List<MiembrojrvEntity> miembrojrvEntityList) {
        this.miembrojrvEntityList = miembrojrvEntityList;
    }

    public List<DetallevotoEntity> getDetallevotoEntityList() {
        return detallevotoEntityList;
    }

    public void setDetallevotoEntityList(List<DetallevotoEntity> detallevotoEntityList) {
        this.detallevotoEntityList = detallevotoEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idJrv != null ? idJrv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof JrvEntity)) {
            return false;
        }
        JrvEntity other = (JrvEntity) object;
        if ((this.idJrv == null && other.idJrv != null) || (this.idJrv != null && !this.idJrv.equals(other.idJrv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.JrvEntity[ idJrv=" + idJrv + " ]";
    }
    
}
