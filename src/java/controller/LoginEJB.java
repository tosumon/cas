/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.LoginMB;
import boundary.UserFacade;
import entities.user.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import util.HashAndSalting;
import util.SessionUtil;

/**
 *
 * @author atinkut
 */
@Named
@Stateless
public class LoginEJB {

    @EJB
    UserFacade userFacade;
    String firstName;
    public String makeAuthentication(User user){
    try {
             
            String password=user.getPassword();
            String  hashedPwd=HashAndSalting.get_SHA_1_SecurePassword(password, HashAndSalting.getSalt());
            user.setPassword(hashedPwd);
             //query the password in DB
            User userFromDB=this.findByUserName(user.getUserName());
             //to display the name of the logged in user
             firstName=userFromDB.getFname();
          
             
             if(hashedPwd.equals(userFromDB.getPassword())){
                    
                HttpSession session=(HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
                session.setAttribute("userBean", userFromDB);
                 
                 if(userFromDB.getUserType().equalsIgnoreCase("Admin")){
                     return "/admin/adHome";
                 }else{
                  return "/login/login_return";
                 }
             
             }
             
            
         } catch (Exception ex) {
             Logger.getLogger(LoginMB.class.getName()).log(Level.SEVERE, null, ex);
         }
         return "/login/login_error";
    }
    

 public User findByUserName(String usr){
     
         return userFacade.find(usr);
 }

    public String getFirstName() {
        return firstName;
    }
    
    public String logout() {
      HttpSession session = SessionUtil.getSession();
      session.invalidate();
      return "/login/login";
   }
 
}
