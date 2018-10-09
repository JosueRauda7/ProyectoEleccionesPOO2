/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "miembrojrv")
@NamedQueries({
    @NamedQuery(name = "MiembrojrvEntity.findAll", query = "SELECT m FROM MiembrojrvEntity m")
    , @NamedQuery(name = "MiembrojrvEntity.findByIdMiembroJrv", query = "SELECT m FROM MiembrojrvEntity m WHERE m.idMiembroJrv = :idMiembroJrv")})
public class MiembrojrvEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idMiembroJrv;
    @JoinColumn(name = "DuiCiudadano", referencedColumnName = "DuiCiudadano")
    @ManyToOne(optional = false)
    private CiudadanosEntity duiCiudadano;
    @JoinColumn(name = "IdJrv", referencedColumnName = "IdJrv")
    @ManyToOne(optional = false)
    private JrvEntity idJrv;
    @JoinColumn(name = "IdTipoMiembro", referencedColumnName = "IdTipoMiembro")
    @ManyToOne(optional = false)
    private TipomiembroEntity idTipoMiembro;

    public MiembrojrvEntity() {
    }

    public MiembrojrvEntity(Integer idMiembroJrv) {
        this.idMiembroJrv = idMiembroJrv;
    }

    public Integer getIdMiembroJrv() {
        return idMiembroJrv;
    }

    public void setIdMiembroJrv(Integer idMiembroJrv) {
        this.idMiembroJrv = idMiembroJrv;
    }

    public CiudadanosEntity getDuiCiudadano() {
        return duiCiudadano;
    }

    public void setDuiCiudadano(CiudadanosEntity duiCiudadano) {
        this.duiCiudadano = duiCiudadano;
    }

    public JrvEntity getIdJrv() {
        return idJrv;
    }

    public void setIdJrv(JrvEntity idJrv) {
        this.idJrv = idJrv;
    }

    public TipomiembroEntity getIdTipoMiembro() {
        return idTipoMiembro;
    }

    public void setIdTipoMiembro(TipomiembroEntity idTipoMiembro) {
        this.idTipoMiembro = idTipoMiembro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMiembroJrv != null ? idMiembroJrv.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MiembrojrvEntity)) {
            return false;
        }
        MiembrojrvEntity other = (MiembrojrvEntity) object;
        if ((this.idMiembroJrv == null && other.idMiembroJrv != null) || (this.idMiembroJrv != null && !this.idMiembroJrv.equals(other.idMiembroJrv))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.MiembrojrvEntity[ idMiembroJrv=" + idMiembroJrv + " ]";
    }
    
}
