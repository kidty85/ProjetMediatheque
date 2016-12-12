/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author quangminhnguyen
 */
@Entity
@Table(name = "MEMBRE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Membre.findAll", query = "SELECT m FROM Membre m"),
    @NamedQuery(name = "Membre.findByMembreId", query = "SELECT m FROM Membre m WHERE m.membreId = :membreId"),
    @NamedQuery(name = "Membre.findByNom", query = "SELECT m FROM Membre m WHERE m.nom = :nom"),
    @NamedQuery(name = "Membre.findByPrenom", query = "SELECT m FROM Membre m WHERE m.prenom = :prenom"),
    @NamedQuery(name = "Membre.findByMail", query = "SELECT m FROM Membre m WHERE m.mail = :mail"),
    @NamedQuery(name = "Membre.findByMdp", query = "SELECT m FROM Membre m WHERE m.mdp = :mdp"),
    @NamedQuery(name = "Membre.findByEstAdmin", query = "SELECT m FROM Membre m WHERE m.estAdmin = :estAdmin")})
public class Membre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEMBRE_ID")
    private Integer membreId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MDP")
    private String mdp;
    @Basic(optional = false)
    @NotNull
    @Column(name = "EST_ADMIN")
    private Boolean estAdmin;
    @OneToMany(mappedBy = "membreId")
    private Collection<Emprunt> empruntCollection;
    @OneToMany(mappedBy = "membreId")
    private Collection<Blocage> blocageCollection;

    public Membre() {
    }

    public Membre(Integer membreId) {
        this.membreId = membreId;
    }

    public Membre(Integer membreId, String nom, String prenom, String mail, String mdp, Boolean estAdmin) {
        this.membreId = membreId;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.mdp = mdp;
        this.estAdmin = estAdmin;
    }

    public Integer getMembreId() {
        return membreId;
    }

    public void setMembreId(Integer membreId) {
        this.membreId = membreId;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Boolean getEstAdmin() {
        return estAdmin;
    }

    public void setEstAdmin(Boolean estAdmin) {
        this.estAdmin = estAdmin;
    }

    @XmlTransient
    public Collection<Emprunt> getEmpruntCollection() {
        return empruntCollection;
    }

    public void setEmpruntCollection(Collection<Emprunt> empruntCollection) {
        this.empruntCollection = empruntCollection;
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
        hash += (membreId != null ? membreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Membre)) {
            return false;
        }
        Membre other = (Membre) object;
        if ((this.membreId == null && other.membreId != null) || (this.membreId != null && !this.membreId.equals(other.membreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Membre[ membreId=" + membreId + " ]";
    }
    
}
