/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quangminhnguyen
 */
@Entity
@Table(name = "EMPRUNT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Emprunt.findAll", query = "SELECT e FROM Emprunt e"),
    @NamedQuery(name = "Emprunt.findByEmpruntId", query = "SELECT e FROM Emprunt e WHERE e.empruntId = :empruntId"),
    @NamedQuery(name = "Emprunt.findByDateEmprunt", query = "SELECT e FROM Emprunt e WHERE e.dateEmprunt = :dateEmprunt")})
public class Emprunt implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPRUNT_ID")
    private Integer empruntId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATE_EMPRUNT")
    @Temporal(TemporalType.DATE)
    private Date dateEmprunt;
    @JoinColumn(name = "MEDIA_ID", referencedColumnName = "MEDIA_ID")
    @ManyToOne
    private Media mediaId;
    @JoinColumn(name = "MEMBRE_ID", referencedColumnName = "MEMBRE_ID")
    @ManyToOne
    private Membre membreId;
    @OneToMany(mappedBy = "empruntId")
    private Collection<Blocage> blocageCollection;

    public Emprunt() {
    }

    public Emprunt(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public Emprunt(Integer empruntId, Date dateEmprunt) {
        this.empruntId = empruntId;
        this.dateEmprunt = dateEmprunt;
    }

    public Integer getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Integer empruntId) {
        this.empruntId = empruntId;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Media getMediaId() {
        return mediaId;
    }

    public void setMediaId(Media mediaId) {
        this.mediaId = mediaId;
    }

    public Membre getMembreId() {
        return membreId;
    }

    public void setMembreId(Membre membreId) {
        this.membreId = membreId;
    }

    @XmlTransient
    public Collection<Blocage> getBlocageCollection() {
        return blocageCollection;
    }

    public void setBlocageCollection(Collection<Blocage> blocageCollection) {
        this.blocageCollection = blocageCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (empruntId != null ? empruntId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Emprunt)) {
            return false;
        }
        Emprunt other = (Emprunt) object;
        if ((this.empruntId == null && other.empruntId != null) || (this.empruntId != null && !this.empruntId.equals(other.empruntId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Emprunt[ empruntId=" + empruntId + " ]";
    }
    
}
