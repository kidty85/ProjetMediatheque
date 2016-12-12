/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
public class EmpruntFacade extends AbstractFacade<Emprunt> implements EmpruntFacadeLocal {

    @PersistenceContext(unitName = "MediathequeProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EmpruntFacade() {
        super(Emprunt.class);
    }

    @Override
    public List<Media> findMediaEmpruntesEnCours(Membre membre, List<Media> mediaList) {
        List<Emprunt> empruntList = this.findAll();
        List<Media> mediaEmpruntEnCours = new ArrayList<>();
        Date dateRetour;
        for (Media media : mediaList) {
            for (Emprunt emprunt : empruntList) {
                dateRetour = emprunt.getDateEmprunt();
                dateRetour.setDate(emprunt.getDateEmprunt().getDate() + media.getJoursPret());
                Date dateNow = new Date();
                if (emprunt.getMembreId().getMembreId() == membre.getMembreId()
                        && emprunt.getMediaId().getMediaId() == media.getMediaId()
                        && dateRetour.after(dateNow)) {
                    mediaEmpruntEnCours.add(media);
                }
            }
        }
        return mediaEmpruntEnCours;
    }

    @Override
    public void insertEmprunt(int membre, int media) {
        String requete = "INSERT INTO EMPRUNT(media_id, membre_id, date_emprunt) VALUES(?, ?, ?)";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, media);
        query.setParameter(2, membre);
        query.setParameter(3, new Date());
        query.executeUpdate();
    }

    @Override
    public boolean estEmpruntAutorise(int membre) {
        List<Emprunt> empruntList = this.findAll();
        Date dateRetour;
        int nbEmprunts = 0;
        for (Emprunt emprunt : empruntList) {
            if (emprunt.getMembreId().getMembreId() == membre) {
                
                dateRetour = emprunt.getDateEmprunt();
                dateRetour.setDate(emprunt.getDateEmprunt().getDate() + emprunt.getMediaId().getJoursPret());
                Date dateNow = new Date();

                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                
                Calendar c = Calendar.getInstance();
                Calendar cc = Calendar.getInstance();
                c.set(emprunt.getDateEmprunt().getYear(), emprunt.getDateEmprunt().getMonth(), emprunt.getDateEmprunt().getDate());
                c.add(Calendar.DATE, emprunt.getMediaId().getJoursPret());
                if(!c.after(cc)){
                    nbEmprunts++;
                }

                System.out.println("emprunt id:"
                        + emprunt.getEmpruntId() + "__"
                        + c.getTime() );

            }
        }
        return !(nbEmprunts > 5);
    }
    
    public List<Emprunt> findEmpruntsEnCours(Membre membre){
        List<Emprunt> empruntList = this.findAll();
        List<Emprunt> empruntMembre = new ArrayList<>();
        for(Emprunt emprunt : empruntList){
            if(emprunt.getMembreId().getMembreId() == membre.getMembreId()){
                empruntMembre.add(emprunt);
            }
        }
        return empruntMembre;
    }
    
    @Override
    public void deleteEmprunt(int emprunt){
        String requete = "DELETE FROM EMPRUNT WHERE emprunt_id = ?";
        Query query = em.createNativeQuery(requete);
        query.setParameter(1, emprunt);
        query.executeUpdate();
    }
}
