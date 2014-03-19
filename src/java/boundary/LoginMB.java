/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary;


import controller.LoginEJB;
import entities.user.User;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import util.SessionUtil;

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
    String loggedName;
    
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

    public String getLoggedName() {
        return loggedName;
    }
    
     //HttpSession session;
    public String authenticate() throws NoSuchAlgorithmException{
        System.out.println("LoginMB" +user.getUserName());
        System.out.println("LoginMB"+user.getPassword());
        Boolean isUserExist=loginEJB.makeAuthentication(user);
        System.out.println(isUserExist);
        if(isUserExist)
            {
                loggedName=loginEJB.getUserFromDB().getFname();  
                System.out.println("logged user"+loggedName);
                 HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("User", loginEJB.getUserFromDB());
                //session.s
                 
                 if(loginEJB.getUserFromDB().getUserType().equalsIgnoreCase("Admin")){
                     return "/admin/adHome";
                 }else{
                     System.out.println(" normal user !!!!");
                  return "/login_return";
                 }
             
             }
             
            
         else
         return "/login/login_error";
    
}
    //String loggedName=loginEJB.getUserFromDB().getFname();
     public String logout() {
      HttpSession session = SessionUtil.getSession();
      session.invalidate();
      return "/index.xhtml";
   }
      //get application status and evaluation status 
     public String applicationStatus(){
      return loginEJB.applicationStatus(user.getUserName());

} 
     public String evaluationStatus(){
          return loginEJB.evaluationStatus(user.getUserName());
}
    
}
