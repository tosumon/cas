/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.user;

import entities.user.GRE;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Atik
 */
@Stateless
public class GREFacade extends AbstractFacade<GRE> {
    @PersistenceContext(unitName = "ComproPUMySQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GREFacade() {
        super(GRE.class);
    }
    
}
