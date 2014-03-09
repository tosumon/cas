/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.reg;

import boundary.AbstractFacade;
import entities.reg.UserBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author habib
 * @date
 */
@Stateless
public class UserBeanFacade extends AbstractFacade<UserBean> {
    @PersistenceContext(unitName = "ComproPUMySQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UserBeanFacade() {
        super(UserBean.class);
    }
    
}
