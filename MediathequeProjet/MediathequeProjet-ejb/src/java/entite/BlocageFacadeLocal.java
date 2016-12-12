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
public interface BlocageFacadeLocal {

    void create(Blocage blocage);

    void edit(Blocage blocage);

    void remove(Blocage blocage);

    Blocage find(Object id);

    List<Blocage> findAll();

    List<Blocage> findRange(int[] range);

    int count();
    
}
