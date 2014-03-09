/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author habib
 */
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("passwordValidator")
public class PasswordValidator implements Validator {

    /**
     * Validate method.
     * @param fc
     * @param c
     * @param o
     */
    @Override
    public void validate(FacesContext fc, UIComponent c, Object o) throws ValidatorException {
        // No value is not ok
        if (o == null || "".equals((String) o)) {
            
            ShowMessage.showValidatorException("No password value!", "Password Validation Error", FacesMessage.SEVERITY_ERROR);
            
        }
        
        if (o.toString().length()<6) {
            
            ShowMessage.showValidatorException("Password should be minimum 6 digit !", "Password Validation Error", FacesMessage.SEVERITY_ERROR);
            
        }
        
        // Obtain the component and submitted value of the confirm password component.
        UIInput confEmail = (UIInput) c.getAttributes().get("confirmPass");
        Object confirm = confEmail.getSubmittedValue();
        if(null==confirm || !(o.toString().equalsIgnoreCase(confirm.toString()))){
            ShowMessage.showValidatorException("Confirm Password not equal to password!", "Email Validation Error", FacesMessage.SEVERITY_ERROR);
        }
    }
}
