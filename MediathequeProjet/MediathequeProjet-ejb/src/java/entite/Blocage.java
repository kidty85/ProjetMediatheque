/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author quangminhnguyen
 */
@Entity
@Table(name = "BLOCAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Blocage.findAll", query = "SELECT b FROM Blocage b"),
    @NamedQuery(name = "Blocage.findByBlocageId", query = "SELECT b FROM Blocage b WHERE b.blocageId = :blocageId"),
    @NamedQuery(name = "Blocage.findByFinBlocage", query = "SELECT b FROM Blocage b WHERE b.finBlocage = :finBlocage")})
public class Blocage implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "BLOCAGE_ID")
    private Integer blocageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FIN_BLOCAGE")
    @Temporal(TemporalType.DATE)
    private Date finBlocage;
    @JoinColumn(name = "EMPRUNT_ID", referencedColumnName = "EMPRUNT_ID")
    @ManyToOne
    private Emprunt empruntId;
    @JoinColumn(name = "MEMBRE_ID", referencedColumnName = "MEMBRE_ID")
    @ManyToOne
    private Membre membreId;

    public Blocage() {
    }

    public Blocage(Integer blocageId) {
        this.blocageId = blocageId;
    }

    public Blocage(Integer blocageId, Date finBlocage) {
        this.blocageId = blocageId;
        this.finBlocage = finBlocage;
    }

    public Integer getBlocageId() {
        return blocageId;
    }

    public void setBlocageId(Integer blocageId) {
        this.blocageId = blocageId;
    }

    public Date getFinBlocage() {
        return finBlocage;
    }

    public void setFinBlocage(Date finBlocage) {
        this.finBlocage = finBlocage;
    }

    public Emprunt getEmpruntId() {
        return empruntId;
    }

    public void setEmpruntId(Emprunt empruntId) {
        this.empruntId = empruntId;
    }

    public Membre getMembreId() {
        return membreId;
    }

    public void setMembreId(Membre membreId) {
        this.membreId = membreId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (blocageId != null ? blocageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Blocage)) {
            return false;
        }
        Blocage other = (Blocage) object;
        if ((this.blocageId == null && other.blocageId != null) || (this.blocageId != null && !this.blocageId.equals(other.blocageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Blocage[ blocageId=" + blocageId + " ]";
    }
    
}
