/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sv.edu.udb.www.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author admi
 */
@Entity
@Table(name = "sequence")
@NamedQueries({
    @NamedQuery(name = "SequenceEntity.findAll", query = "SELECT s FROM SequenceEntity s")
    , @NamedQuery(name = "SequenceEntity.findBySeqName", query = "SELECT s FROM SequenceEntity s WHERE s.seqName = :seqName")
    , @NamedQuery(name = "SequenceEntity.findBySeqCount", query = "SELECT s FROM SequenceEntity s WHERE s.seqCount = :seqCount")})
public class SequenceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "SEQ_NAME")
    private String seqName;
    @Column(name = "SEQ_COUNT")
    private BigInteger seqCount;

    public SequenceEntity() {
    }

    public SequenceEntity(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return seqName;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public BigInteger getSeqCount() {
        return seqCount;
    }

    public void setSeqCount(BigInteger seqCount) {
        this.seqCount = seqCount;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (seqName != null ? seqName.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SequenceEntity)) {
            return false;
        }
        SequenceEntity other = (SequenceEntity) object;
        if ((this.seqName == null && other.seqName != null) || (this.seqName != null && !this.seqName.equals(other.seqName))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sv.edu.udb.www.entities.SequenceEntity[ seqName=" + seqName + " ]";
    }
    
}
