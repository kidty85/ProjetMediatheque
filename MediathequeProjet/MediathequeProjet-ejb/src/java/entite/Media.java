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
@Table(name = "MEDIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Media.findAll", query = "SELECT m FROM Media m"),
    @NamedQuery(name = "Media.findByMediaId", query = "SELECT m FROM Media m WHERE m.mediaId = :mediaId"),
    @NamedQuery(name = "Media.findByCategorie", query = "SELECT m FROM Media m WHERE m.categorie = :categorie"),
    @NamedQuery(name = "Media.findByTitre", query = "SELECT m FROM Media m WHERE m.titre = :titre"),
    @NamedQuery(name = "Media.findByAnnee", query = "SELECT m FROM Media m WHERE m.annee = :annee"),
    @NamedQuery(name = "Media.findByDescription", query = "SELECT m FROM Media m WHERE m.description = :description"),
    @NamedQuery(name = "Media.findByJoursPret", query = "SELECT m FROM Media m WHERE m.joursPret = :joursPret"),
    @NamedQuery(name = "Media.findByStock", query = "SELECT m FROM Media m WHERE m.stock = :stock")})
public class Media implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MEDIA_ID")
    private Integer mediaId;
    @Size(max = 30)
    @Column(name = "CATEGORIE")
    private String categorie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITRE")
    private String titre;
    @Size(max = 4)
    @Column(name = "ANNEE")
    private String annee;
    @Size(max = 255)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "JOURS_PRET")
    private int joursPret;
    @Basic(optional = false)
    @NotNull
    @Column(name = "STOCK")
    private int stock;
    @OneToMany(mappedBy = "mediaId")
    private Collection<Emprunt> empruntCollection;

    public Media() {
    }

    public Media(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public Media(Integer mediaId, String titre, int joursPret, int stock) {
        this.mediaId = mediaId;
        this.titre = titre;
        this.joursPret = joursPret;
        this.stock = stock;
    }

    public Integer getMediaId() {
        return mediaId;
    }

    public void setMediaId(Integer mediaId) {
        this.mediaId = mediaId;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getJoursPret() {
        return joursPret;
    }

    public void setJoursPret(int joursPret) {
        this.joursPret = joursPret;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @XmlTransient
    public Collection<Emprunt> getEmpruntCollection() {
        return empruntCollection;
    }

    public void setEmpruntCollection(Collection<Emprunt> empruntCollection) {
        this.empruntCollection = empruntCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (mediaId != null ? mediaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Media)) {
            return false;
        }
        Media other = (Media) object;
        if ((this.mediaId == null && other.mediaId != null) || (this.mediaId != null && !this.mediaId.equals(other.mediaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entite.Media[ mediaId=" + mediaId + " ]";
    }
    
}
