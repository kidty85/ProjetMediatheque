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
public interface MembreFacadeLocal {

    void create(Membre membre);

    void edit(Membre membre);

    void remove(Membre membre);

    Membre find(Object id);

    List<Membre> findAll();

    List<Membre> findRange(int[] range);

    int count();
    
    boolean checkLogin(String mail, String mdp);
    
    boolean checkMail(String mail);
    
    boolean isAdmin(String mail);
    
    void insertMembre(String nom, String prenom, String mail, String mdp);
    
    Membre findbyEmail(String email);
    
}
