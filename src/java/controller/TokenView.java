/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.UserFacade;
import boundary.user.TokenFacade;
import controller.ApplicantView;
import entities.user.Token;
import entities.user.User;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.HashAndSalting;
import util.RandomPasswordGenerator;
import util.SendEmail;

/**
 *
 * @author Nickberkey
 */
@ManagedBean (name = "TokenView")
@RequestScoped
public class TokenView {
    @EJB
    private TokenFacade tokenFacade;
   
    @EJB
    private UserFacade appFacade;
    
    private Token token;
    private String newPassInput;
    private String currentPass;

    public String getCurrentPass() {
        return currentPass;
    }

    public void setCurrentPass(String currentPass) {
        this.currentPass = currentPass;
    }

    public String getNewPassInput() {
        return newPassInput;
    }

    public void setNewPassInput(String newPassInput) {
        this.newPassInput = newPassInput;
    }

    public String getNewPassRetype() {
        return newPassRetype;
    }

    public void setNewPassRetype(String newPassRetype) {
        this.newPassRetype = newPassRetype;
    }
    private String newPassRetype;

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    /**
     * Creates a new instance of TokenView
     */
    public TokenView() {
        tokenFacade = new TokenFacade();
        token = new Token();
        appFacade = new UserFacade();
    }
    
    private boolean ValidationPass(String pass){
        // Length must at lest 6
        if(pass.length()<6)
            return false;
        return true;
    }
    
    public String submitToken() throws NoSuchAlgorithmException{
        List<Token> listToken = this.tokenFacade.findAll();
        for(Token T : listToken){
            // Check Token
            if(this.token.getEmail().equals(T.getEmail()) && this.token.getToken().equals(T.getToken()) && T.getBeUsed() == 0){
                // Check Password and Retype Password
                if(!this.newPassInput.equals(this.newPassRetype))
                    return "resetPassFail";           
                // Check Validation of Pass
                if(!ValidationPass(this.newPassInput))
                    return "resetPassFail";   
                
               // Update status of Token
                T.setBeUsed(1);
                this.tokenFacade.edit(T);
                
                // ==================
                // Create new password for Applicant
                // Send email about new password
                // ==================
                
                User app = appFacade.find(T.getEmail());
                String hashedPassword=HashAndSalting.get_SHA_1_SecurePassword(this.newPassInput, HashAndSalting.getSalt());
                app.setPassword(hashedPassword);
                appFacade.edit(app);
                
                try{
                    SendEmail sendE = new SendEmail();

                    sendE.createEmailMessage(app.getEmail(), this.newPassInput);
                }
                catch (Exception ex) {
                    Logger.getLogger(ApplicantView.class.getName()).log(Level.SEVERE, null, ex);
                    return "resetPassFail";
                }
                
                
                return "resetPassSuccess"; 
            }
        }
        return "resetPassFail";
    }
    
    public String createNewToken(){
        List<User> listApp = this.appFacade.findAll();
        String returnString = "/forgetpass/ReceiveEmailForgetPass";
        for(User app:listApp){
            if(this.token.getEmail().equals(app.getEmail())){
                
                    
                    // Create Token String
                    String tokenString = RandomPasswordGenerator.generatePswd(6, 6, 0, 6, 0).toString();
                    
                    // Create Token Entity and Save
                    
                    token.setEmail(app.getEmail());
                    token.setToken(tokenString);
                    token.setBeUsed(0);
                    token.setIdApplicant(app.getUserId());
                    
                    this.tokenFacade.create(token);
                    
                    this.appFacade.edit(app);
                   try {
                    SendEmail sendE = new SendEmail();            
                    sendE.createEmailToken(app.getEmail(), tokenString);

                    return returnString;
                }
                catch (Exception ex) {
                    Logger.getLogger(ApplicantView.class.getName()).log(Level.SEVERE, null, ex);
                    return returnString;
                }
            }                 
        }
        return returnString;
    }

}
