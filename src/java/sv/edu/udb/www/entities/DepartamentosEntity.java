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
@Table(name = "departamentos")
@NamedQueries({
    @NamedQuery(name = "DepartamentosEntity.findAll", query = "SELECT d FROM DepartamentosEntity d")
    , @NamedQuery(name = "DepartamentosEntity.findByIdDepartamento", query = "SELECT d FROM DepartamentosEntity d WHERE d.idDepartamento = :idDepartamento")
    , @NamedQuery(name = "DepartamentosEntity.findByDepartamento", query = "SELECT d FROM DepartamentosEntity d WHERE d.departamento = :departamento")})
public class DepartamentosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer idDepartamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String departamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<MunicipiosEntity> municipiosEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idDepartamento")
    private List<UsuariosEntity> usuariosEntityList;

    public DepartamentosEntity() {
    }

    public DepartamentosEntity(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public DepartamentosEntity(Integer idDepartamento, String departamento) {
        this.idDepartamento = idDepartamento;
        this.departamento = departamento;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public List<MunicipiosEntity> getMunicipiosEntityList() {
        return municipiosEntityList;
    }

    public void setMunicipiosEntityList(List<MunicipiosEntity> municipiosEntityList) {
        this.municipiosEntityList = municipiosEntityList;
    }

    public List<UsuariosEntity> getUsuariosEntityList() {
        return usuariosEntityList;
    }

    public void setUsuariosEntityList(List<UsuariosEntity> usuariosEntityList) {
        this.usuariosEntityList = usuariosEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDepartamento != null ? idDepartamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DepartamentosEntity)) {
            return false;
        }
        DepartamentosEntity other = (DepartamentosEntity) object;
        if ((this.idDepartamento == null && other.idDepartamento != null) || (this.idDepartamento != null && !this.idDepartamento.equals(other.idDepartamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.DepartamentosEntity[ idDepartamento=" + idDepartamento + " ]";
    }
    
}
