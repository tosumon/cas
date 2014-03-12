/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;


import controller.RegisterEJB;
import entities.user.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author atinkut
 */
@Named
@ManagedBean
@RequestScoped
public class RegisterMB {

    public RegisterMB() {
    }
  
    @EJB
    private RegisterEJB registerEJB;
    private User user=new User();
   
   public String makeRegistration() throws Exception{
         return registerEJB.makeRegisteration(user);
         
    }
    
     public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user= user;
    }
     
    
    
    
}
