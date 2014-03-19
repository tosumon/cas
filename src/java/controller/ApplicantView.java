/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import boundary.UserFacade;
import boundary.user.TokenFacade;
import entities.user.Token;
import entities.user.User;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.RandomPasswordGenerator;
import util.SendEmail;

/**
 *
 * @author Nickberkey
 */
@ManagedBean(name = "ApplicantView")
@RequestScoped
public class ApplicantView {
    @EJB
    private TokenFacade tokenFacade;
    @EJB
    private UserFacade userFacade;
    
    private User user;
    
    private Token token;

    public User getUser() {
        return user;
    }
    
    private String retypeEmail;
    private String emailForgetPass;

    public String getEmailForgetPass() {
        return emailForgetPass;
    }

    public void setEmailForgetPass(String emailForgetPass) {
        this.emailForgetPass = emailForgetPass;
    }

    public String getRetypeEmail() {
        return retypeEmail;
    }

    public void setRetypeEmail(String retypeEmail) {
        this.retypeEmail = retypeEmail;
    }
    
    
    /**
     * Creates a new instance of ApplicantView
     */
    public ApplicantView() {
        this.user = new User();
        //this.applicantFacade  = new ApplicantFacade();
        this.tokenFacade = new TokenFacade();
        this.token = new Token();
    }
    
    public String createUser(){
        //this.user.setPassword(retypeEmail);
        //this.applicantFacade.create(user);
        
        if(this.retypeEmail == null ? this.user.getEmail() == null : this.retypeEmail.equals(this.user.getEmail())){
            try {
            String password = RandomPasswordGenerator.generatePswd(6, 20, 2, 2, 2).toString();
            this.user.setPassword(password);
            this.userFacade.create(user);
            SendEmail sendE = new SendEmail();
            
            sendE.createEmailMessage(this.user.getEmail(), password);
            return "createUserSuccess";
            }
            catch (Exception ex) {
                Logger.getLogger(ApplicantView.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return "createUserFail";
    }
    
    
    public String submitEmailForgetPass(){
        
        List<User> listApp = this.userFacade.findAll();
        for(User app:listApp){
            if(this.emailForgetPass.equals(app.getEmail())){
                
                    
                    // Create Token String
                    String tokenString = RandomPasswordGenerator.generatePswd(6, 6, 0, 6, 0).toString();
                    //String tokenString = "khanh";
                    
                    
                    // Create Token Entity and Save
                    
                    token.setEmail(app.getEmail());
                    token.setToken(tokenString);
                    token.setBeUsed(0);
                    token.setIdApplicant(app.getUserId());
                    
                    this.tokenFacade.create(token);
                    
                    //tokenFacade.edit(token);
                    
                            
                    //app.setToken(tokenString);
                    this.userFacade.edit(app);
                   try {
                    SendEmail sendE = new SendEmail();            
                    sendE.createEmailToken(app.getEmail(), tokenString);

                    return "ReceiveEmailForgetPass";
                }
                catch (Exception ex) {
                    Logger.getLogger(ApplicantView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }                 
        }
        
        return "ReceiveEmailForgetPass";
    }
    
    
}
