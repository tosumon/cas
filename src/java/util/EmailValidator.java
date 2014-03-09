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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator {

    private final static String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private final static Pattern EMAIL_COMPILED_PATTERN = Pattern.compile(EMAIL_PATTERN);

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
            
            ShowMessage.showValidatorException("No email value!", "Email Validation Error", FacesMessage.SEVERITY_ERROR);
            
        }

        // The email matcher
        Matcher matcher = EMAIL_COMPILED_PATTERN.matcher((String) o);

        if (!matcher.matches()) {   // Email doesn't match
            
            ShowMessage.showValidatorException("Invalid email value!", "Email Validation Error", FacesMessage.SEVERITY_ERROR);
            
        }
        
          // Obtain the component and submitted value of the confirm password component.
        UIInput confEmail = (UIInput) c.getAttributes().get("confirm");
        Object confirm = confEmail.getSubmittedValue();
        if(null==confirm || !(o.toString().equalsIgnoreCase(confirm.toString()))){
            ShowMessage.showValidatorException("Confirm email not equal to email!", "Email Validation Error", FacesMessage.SEVERITY_ERROR);
        }
        

    }
}
