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
public interface MediaFacadeLocal {

    void create(Media media);

    void edit(Media media);

    void remove(Media media);

    Media find(Object id);

    List<Media> findAll();

    List<Media> findRange(int[] range);

    int count();
    
    void insertMedia(String titre, String categorie, String annee, String description, int jours, int stock);
}
