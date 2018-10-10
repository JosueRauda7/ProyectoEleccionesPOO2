package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.validation.constraints.Size;

@Entity
@Table(name = "ciudadanos")
@NamedQueries({
    @NamedQuery(name = "CiudadanosEntity.findAll", query = "SELECT c FROM CiudadanosEntity c")
    , @NamedQuery(name = "CiudadanosEntity.findByDuiCiudadano", query = "SELECT c FROM CiudadanosEntity c WHERE c.duiCiudadano = :duiCiudadano")
    , @NamedQuery(name = "CiudadanosEntity.findByNombresCiudadano", query = "SELECT c FROM CiudadanosEntity c WHERE c.nombresCiudadano = :nombresCiudadano")
    , @NamedQuery(name = "CiudadanosEntity.findByApellidosCiudadano", query = "SELECT c FROM CiudadanosEntity c WHERE c.apellidosCiudadano = :apellidosCiudadano")
    , @NamedQuery(name = "CiudadanosEntity.findByFechaNacimiento", query = "SELECT c FROM CiudadanosEntity c WHERE c.fechaNacimiento = :fechaNacimiento")
    , @NamedQuery(name = "CiudadanosEntity.findByDireccion", query = "SELECT c FROM CiudadanosEntity c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "CiudadanosEntity.findByUrlFoto", query = "SELECT c FROM CiudadanosEntity c WHERE c.urlFoto = :urlFoto")})
public class CiudadanosEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String duiCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String nombresCiudadano;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    private String apellidosCiudadano;
    @Basic(optional = false)
    @NotNull
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "Url_Foto")
    private String urlFoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duiCiudadano")
    private List<CandidatosEntity> candidatosEntityList;
    @JoinColumn(name = "IdCentroVotacion", referencedColumnName = "IdCentroVotacion")
    @ManyToOne(optional = false)
    private CentrovotacionEntity idCentroVotacion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duiCiudadano")
    private List<MiembrojrvEntity> miembrojrvEntityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "duiCiudadano")
    private List<ConteovotantesEntity> conteovotantesEntityList;

    public CiudadanosEntity() {
    }

    public CiudadanosEntity(String duiCiudadano) {
        this.duiCiudadano = duiCiudadano;
    }

    public CiudadanosEntity(String duiCiudadano, String nombresCiudadano, String apellidosCiudadano, Date fechaNacimiento, String direccion, String urlFoto) {
        this.duiCiudadano = duiCiudadano;
        this.nombresCiudadano = nombresCiudadano;
        this.apellidosCiudadano = apellidosCiudadano;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.urlFoto = urlFoto;
    }

    public String getDuiCiudadano() {
        return duiCiudadano;
    }

    public void setDuiCiudadano(String duiCiudadano) {
        this.duiCiudadano = duiCiudadano;
    }

    public String getNombresCiudadano() {
        return nombresCiudadano;
    }

    public void setNombresCiudadano(String nombresCiudadano) {
        this.nombresCiudadano = nombresCiudadano;
    }

    public String getApellidosCiudadano() {
        return apellidosCiudadano;
    }

    public void setApellidosCiudadano(String apellidosCiudadano) {
        this.apellidosCiudadano = apellidosCiudadano;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    public List<CandidatosEntity> getCandidatosEntityList() {
        return candidatosEntityList;
    }

    public void setCandidatosEntityList(List<CandidatosEntity> candidatosEntityList) {
        this.candidatosEntityList = candidatosEntityList;
    }

    public CentrovotacionEntity getIdCentroVotacion() {
        return idCentroVotacion;
    }

    public void setIdCentroVotacion(CentrovotacionEntity idCentroVotacion) {
        this.idCentroVotacion = idCentroVotacion;
    }

    public List<MiembrojrvEntity> getMiembrojrvEntityList() {
        return miembrojrvEntityList;
    }

    public void setMiembrojrvEntityList(List<MiembrojrvEntity> miembrojrvEntityList) {
        this.miembrojrvEntityList = miembrojrvEntityList;
    }

    public List<ConteovotantesEntity> getConteovotantesEntityList() {
        return conteovotantesEntityList;
    }

    public void setConteovotantesEntityList(List<ConteovotantesEntity> conteovotantesEntityList) {
        this.conteovotantesEntityList = conteovotantesEntityList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (duiCiudadano != null ? duiCiudadano.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CiudadanosEntity)) {
            return false;
        }
        CiudadanosEntity other = (CiudadanosEntity) object;
        if ((this.duiCiudadano == null && other.duiCiudadano != null) || (this.duiCiudadano != null && !this.duiCiudadano.equals(other.duiCiudadano))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.CiudadanosEntity[ duiCiudadano=" + duiCiudadano + " ]";
    }
    
}
