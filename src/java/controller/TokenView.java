/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.UserFacade;
import boundary.user.ApplicantFacade;
import boundary.user.TokenFacade;
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
    
    public String submitToken() throws NoSuchAlgorithmException{
        List<Token> listToken = this.tokenFacade.findAll();
        for(Token T : listToken){
            if(this.token.getEmail().equals(T.getEmail()) && this.token.getToken().equals(T.getToken()) && T.getBeUsed() == 0){
               // Update status of Token
                T.setBeUsed(1);
                this.tokenFacade.edit(T);
                
                // ==================
                // Create new password for Applicant
                // Send email about new password
                // ==================
                
                User app = appFacade.find(T.getEmail());
                String newPass = RandomPasswordGenerator.generatePswd(6, 20, 2, 2, 2).toString();
                String hashedPassword=HashAndSalting.get_SHA_1_SecurePassword(newPass, HashAndSalting.getSalt());
                app.setPassword(hashedPassword);
                appFacade.edit(app);
                
                try{
                    SendEmail sendE = new SendEmail();

                    sendE.createEmailMessage(app.getEmail(), newPass);
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
}
