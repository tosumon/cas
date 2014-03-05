/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;

import boundary.reg.RegistrationBeanFacade;
import entities.reg.RegistrationBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author habib
 */
@ManagedBean(name="regView")
@RequestScoped
public class RegistrationView {

    @EJB
    private RegistrationBeanFacade regFacade;
    
    private RegistrationBean regBean;
    
    public RegistrationBean getRegBean(){
        return regBean;
    }
    /**
     * Creates a new instance of RegistrationView
     */
    public RegistrationView() {
        this.regBean=new RegistrationBean();
    }
    
     private void addMessage(FacesMessage message) {

        FacesContext.getCurrentInstance().addMessage(
                null, message);

    }

    public String addUser() {

      addMessage(
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "User Registration Successful!!!",
                        null
                ));
        this.regFacade.create(regBean);
        return "";

    }
    
}
