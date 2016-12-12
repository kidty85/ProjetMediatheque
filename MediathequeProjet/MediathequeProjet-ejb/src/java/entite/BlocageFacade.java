/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author quangminhnguyen
 */
@Stateless
public class BlocageFacade extends AbstractFacade<Blocage> implements BlocageFacadeLocal {
    @PersistenceContext(unitName = "MediathequeProjet-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BlocageFacade() {
        super(Blocage.class);
    }
    
}
