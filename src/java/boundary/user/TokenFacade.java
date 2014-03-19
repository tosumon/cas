/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.user;

import entities.user.Token;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Nickberkey
 */
@Stateless
public class TokenFacade extends AbstractFacade<Token> {
    @PersistenceContext(unitName = "ComproPUMySQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TokenFacade() {
        super(Token.class);
    }
    
}
