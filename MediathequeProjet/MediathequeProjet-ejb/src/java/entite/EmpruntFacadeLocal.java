/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author quangminhnguyen
 */
@Local
public interface EmpruntFacadeLocal {

    void create(Emprunt emprunt);

    void edit(Emprunt emprunt);

    void remove(Emprunt emprunt);

    Emprunt find(Object id);

    List<Emprunt> findAll();

    List<Emprunt> findRange(int[] range);

    int count();
    
    List<Media> findMediaEmpruntesEnCours(Membre membre, List<Media> mediaList);
    
    void insertEmprunt(int membre, int media);
    
    boolean estEmpruntAutorise(int membre);
    
    List<Emprunt> findEmpruntsEnCours(Membre membre);
    
    void deleteEmprunt(int emprunt);
}
