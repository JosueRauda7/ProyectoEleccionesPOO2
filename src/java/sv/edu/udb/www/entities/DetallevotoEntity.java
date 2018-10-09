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
import javax.validation.constraints.NotNull;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "detallevoto")
@NamedQueries({
    @NamedQuery(name = "DetallevotoEntity.findAll", query = "SELECT d FROM DetallevotoEntity d")
    , @NamedQuery(name = "DetallevotoEntity.findByIdDetalleVoto", query = "SELECT d FROM DetallevotoEntity d WHERE d.idDetalleVoto = :idDetalleVoto")
    , @NamedQuery(name = "DetallevotoEntity.findByCantidadVoto", query = "SELECT d FROM DetallevotoEntity d WHERE d.cantidadVoto = :cantidadVoto")})
public class DetallevotoEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idDetalleVoto;
    @Basic(optional = false)
    @NotNull
    private int cantidadVoto;
    @JoinColumn(name = "IdCandidato", referencedColumnName = "IdCandidato")
    @ManyToOne(optional = false)
    private CandidatosEntity idCandidato;
    @JoinColumn(name = "IdJrv", referencedColumnName = "IdJrv")
    @ManyToOne(optional = false)
    private JrvEntity idJrv;

    public DetallevotoEntity() {
    }

    public DetallevotoEntity(Integer idDetalleVoto) {
        this.idDetalleVoto = idDetalleVoto;
    }

    public DetallevotoEntity(Integer idDetalleVoto, int cantidadVoto) {
        this.idDetalleVoto = idDetalleVoto;
        this.cantidadVoto = cantidadVoto;
    }

    public Integer getIdDetalleVoto() {
        return idDetalleVoto;
    }

    public void setIdDetalleVoto(Integer idDetalleVoto) {
        this.idDetalleVoto = idDetalleVoto;
    }

    public int getCantidadVoto() {
        return cantidadVoto;
    }

    public void setCantidadVoto(int cantidadVoto) {
        this.cantidadVoto = cantidadVoto;
    }

    public CandidatosEntity getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(CandidatosEntity idCandidato) {
        this.idCandidato = idCandidato;
    }

    public JrvEntity getIdJrv() {
        return idJrv;
    }

    public void setIdJrv(JrvEntity idJrv) {
        this.idJrv = idJrv;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleVoto != null ? idDetalleVoto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetallevotoEntity)) {
            return false;
        }
        DetallevotoEntity other = (DetallevotoEntity) object;
        if ((this.idDetalleVoto == null && other.idDetalleVoto != null) || (this.idDetalleVoto != null && !this.idDetalleVoto.equals(other.idDetalleVoto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.DetallevotoEntity[ idDetalleVoto=" + idDetalleVoto + " ]";
    }
    
}
