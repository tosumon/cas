/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author habib
 */
public class ShowMessage {
    public static void showValidatorException(String summery, String detail,FacesMessage.Severity severity){
        
         FacesMessage msg = new FacesMessage(summery, detail);
            msg.setSeverity(severity);
            throw new ValidatorException(msg);

    }
    
    public static void showMessage(String summery, String detail,FacesMessage.Severity severity){
        
         FacesMessage msg = new FacesMessage(summery, detail);
            msg.setSeverity(severity);
            FacesContext.getCurrentInstance().addMessage(
                null, msg);

    }
}
