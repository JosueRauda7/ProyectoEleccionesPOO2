/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "municipios")
@NamedQueries({
    @NamedQuery(name = "MunicipiosEntity.findAll", query = "SELECT m FROM MunicipiosEntity m")
    , @NamedQuery(name = "MunicipiosEntity.findByIdMunicipio", query = "SELECT m FROM MunicipiosEntity m WHERE m.idMunicipio = :idMunicipio")
    , @NamedQuery(name = "MunicipiosEntity.findByMunicipio", query = "SELECT m FROM MunicipiosEntity m WHERE m.municipio = :municipio")})
public class MunicipiosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idMunicipio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String municipio;
    @JoinColumn(name = "IdDepartamento", referencedColumnName = "IdDepartamento")
    @ManyToOne(optional = false)
    private DepartamentosEntity idDepartamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMunicipio")
    private List<CentrovotacionEntity> centrovotacionEntityList;

    public MunicipiosEntity() {
    }

    public MunicipiosEntity(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public MunicipiosEntity(Integer idMunicipio, String municipio) {
        this.idMunicipio = idMunicipio;
        this.municipio = municipio;
    }

    public Integer getIdMunicipio() {
        return idMunicipio;
    }

    public void setIdMunicipio(Integer idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public DepartamentosEntity getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(DepartamentosEntity idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public List<CentrovotacionEntity> getCentrovotacionEntityList() {
        return centrovotacionEntityList;
    }

    public void setCentrovotacionEntityList(List<CentrovotacionEntity> centrovotacionEntityList) {
        this.centrovotacionEntityList = centrovotacionEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipio != null ? idMunicipio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MunicipiosEntity)) {
            return false;
        }
        MunicipiosEntity other = (MunicipiosEntity) object;
        if ((this.idMunicipio == null && other.idMunicipio != null) || (this.idMunicipio != null && !this.idMunicipio.equals(other.idMunicipio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.MunicipiosEntity[ idMunicipio=" + idMunicipio + " ]";
    }
    
}
