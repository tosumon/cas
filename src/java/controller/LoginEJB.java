/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.LoginMB;
import boundary.UserFacade;
import boundary.user.ApplicantFacade;
import entities.user.Applicant;
import entities.user.User;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
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
@Stateful
public class LoginEJB {

    @EJB
    UserFacade userFacade;
    @EJB
     ApplicantFacade applicantFacade;
    //String firstName;
    User userFromDB;
    public Boolean makeAuthentication(User user) throws NoSuchAlgorithmException{
   
            System.out.println("method is called"); 
            String password=user.getPassword();
            String  hashedPwd=HashAndSalting.get_SHA_1_SecurePassword(password, HashAndSalting.getSalt());
            user.setPassword(hashedPwd);
             System.out.println("method is called"+hashedPwd); 
             //query the password in DB
            userFromDB=this.findByUserName(user.getUserName());
            System.out.println("method is called"+userFromDB.getEmail()); 
             //to display the name of the logged in user
             //firstName=userFromDB.getFname();
          
             return hashedPwd.equals(userFromDB.getPassword());
            /* if(hashedPwd.equals(userFromDB.getPassword())){
                    
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
         return "/login/login_error";*/
    }
    
   
   //retrive application status
    public String applicationStatus(String email){
    Applicant applicant=(Applicant)applicantFacade.find(email);
        if(applicant==null)
           return "/application";
          //email exists means applicant started application
             //check for the status of the application form
        else if(applicant.getApplicationStatus().equalsIgnoreCase("submitted"))
               return "/applicationSubmitted";
        else if(applicant.getApplicationStatus().equalsIgnoreCase("saved")){
            //retrive the saved application form for editting and return it
            
         }
        return "";
  }
 //retrive evaluation status
    String emailTocheck="";
   public String evaluationStatus(String email){
       emailTocheck=email;
        Applicant applicant=(Applicant)applicantFacade.find(email);
             if(applicant==null)
                   return "/application";//application form is returned above in application status for null, no need to return again
           //email exists means application started
            //check for the evaluation status
           if(applicant.getApplicationStatus().equalsIgnoreCase("saved"))
                 return "";//return the saved application, since it is not yet submitted
             else//status could be determined and returned
              return "login_evaluation_status";

               }
 
   public String evalStatus(){
   Applicant applicant=(Applicant) applicantFacade.find(emailTocheck);
   return applicant.getEvaluationStatus();
   } 


 public User findByUserName(String usr){
     
         return userFacade.find(usr);
 }

    
    public User getUserFromDB() {
        return userFromDB;
    }
    
    
    public String logout() {
      HttpSession session = SessionUtil.getSession();
      session.invalidate();
      return "/login/login";
   }
 
}
