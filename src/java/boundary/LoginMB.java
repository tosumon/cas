/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;


import controller.LoginEJB;
import entities.user.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author atinkut
 */
@Named
@ManagedBean
@SessionScoped
public class LoginMB {
   
    @EJB
    private LoginEJB loginEJB;
    private User user=new User();
    public LoginMB() {
    }
    
     public User getUser() {
        return user;
    }

    public String getHashedPwd() {
        return hashedPwd;
    }
     String hashedPwd;
     String password;
     String userNameFromDB;
     String firstName;

    public String getFirstName() {
        return firstName;
    }
     

    public String getUserNameFromDB() {
        return userNameFromDB;
    }
     

    public String getPassword() {
        return password;
    }
    String username=user.getUserName();

    public String getUsername() {
        return username;
    }
    User userFromDB;

    public User getUserFromDB() {
        return userFromDB;
    }
    
    public String authenticate(){
       return loginEJB.makeAuthentication(user);
    
}
}
