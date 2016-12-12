/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author quangminhnguyen
 */
@Stateless
public class MembreFacade extends AbstractFacade<Membre> implements MembreFacadeLocal {

    @PersistenceContext(unitName = "MediathequeProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MembreFacade() {
        super(Membre.class);
    }

    @Override
    public boolean checkLogin(String mail, String mdp) {
        String requete = "SELECT COUNT(*) FROM membre WHERE mail = ? AND mdp = ?";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, mail);
        query.setParameter(2, mdp);

        if ((int) query.getSingleResult() == 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean checkMail(String mail) {
        String requete = "SELECT COUNT(*) FROM membre WHERE mail = ?";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, mail);

        if ((int) query.getSingleResult() != 0) {
            return false;
        }
        return true;
    }

    @Override
    public boolean isAdmin(String mail) {
        String requete = "SELECT est_admin FROM membre WHERE mail = ?";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, mail);
        //System.out.println(query.getSingleResult());
        return (boolean) query.getSingleResult();

    }

    @Override
    public void insertMembre(String nom, String prenom, String mail, String mdp) {
        String requete = "INSERT INTO MEMBRE(nom, prenom, mail, mdp) VALUES(?, ?, ?, ?)";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, nom);
        query.setParameter(2, prenom);
        query.setParameter(3, mail);
        query.setParameter(4, mdp);
        query.executeUpdate();
    }

    @Override
    public Membre findbyEmail(String email) {
        List<Membre> membreList = this.findAll();
        for (Membre membre : membreList) {
            if (membre.getMail().equals(email)) {
                return membre;
            }
        }
        return null;
    }
}
