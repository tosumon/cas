/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.RegisterMB;
import boundary.user.UserFacade;
import entities.user.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import util.HashAndSalting;
import util.RandomPasswordGenerator;
import util.SendEmail;

/**
 *
 * @author atinkut
 */
@Named
@Stateless
public class RegisterEJB {

    @EJB
    private UserFacade userFacade;
    private SendEmail sendEmail=new SendEmail();
    String passTest;
    
    public String makeRegisteration(User user){
        //retrive email if it exist
         User u=this.findByEmail(user.getEmail());
         if(u==null){//no entry is found for that email
             //generate the password and send through email
             //Generate password with minimum length of 6 and max 10, 1 Capital, 1 digit and 1 special character
    char[] pswd = RandomPasswordGenerator.generatePswd(6,10,1,1,1);
    String password= new String(pswd);
    passTest=password;
    
            try {
                
                String hashedPassword=HashAndSalting.get_SHA_1_SecurePassword(password, HashAndSalting.getSalt());
                user.setUserName(user.getEmail());
                user.setPassword(hashedPassword);
                user.setUserType("Applicant");
                //this.setLogin(login);
              
                //send email to the applicant
               userFacade.create(user);
               sendEmail.createEmailMessage(user.getEmail(), password);
                
            } catch (Exception ex) {
                Logger.getLogger(RegisterMB.class.getName()).log(Level.SEVERE, null, ex);
            }
             
         }
         else
             return "/register/userExist.xhtml";
        FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO, "Registartion is made successfully. Email has been sent to "+user.getEmail(),"Registartion is made successfully"));
        return "/register/register_success.xhtml";
    
    }
     public User findByEmail(String email){
       
         return userFacade.find(email);
         
     }
     public String getPassTest() {
        return passTest;
    }
}
