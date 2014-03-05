/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.reg;

import boundary.AbstractFacade;
import entities.reg.RegistrationBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author habib
 */
@Stateless
public class RegistrationBeanFacade extends AbstractFacade<RegistrationBean> {
    @PersistenceContext(unitName = "ComproPUMySQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RegistrationBeanFacade() {
        super(RegistrationBean.class);
    }
    
}
