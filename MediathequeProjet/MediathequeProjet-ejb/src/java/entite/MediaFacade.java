/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author quangminhnguyen
 */
@Stateless
public class MediaFacade extends AbstractFacade<Media> implements MediaFacadeLocal {
    @PersistenceContext(unitName = "MediathequeProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MediaFacade() {
        super(Media.class);
    }
    
     @Override
    public void insertMedia(String titre, String categorie, String annee, String description, int jours, int stock) {
        String requete = "INSERT INTO MEDIA(titre, categorie, annee, description, jours_pret, stock) VALUES(?, ?, ?, ?, ?, ?)";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, titre);
        query.setParameter(2, categorie);
        query.setParameter(3, annee);
        query.setParameter(4, description);
        query.setParameter(5, jours);
        query.setParameter(6, stock);
        query.executeUpdate();
    }
}

