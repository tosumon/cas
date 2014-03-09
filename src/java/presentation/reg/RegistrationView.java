/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;

import boundary.reg.UserBeanFacade;
import entities.reg.UserBean;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import util.ShowMessage;

/**
 *
 * @author habib
 */
@ManagedBean(name="regView")
@RequestScoped
public class RegistrationView {

    @EJB
    private UserBeanFacade userFacade;
    
    private UserBean userBean;
    
    public UserBean getUserBean(){
        return userBean;
    }
    /**
     * Creates a new instance of RegistrationView
     */
    public RegistrationView() {
        this.userBean=new UserBean();
    }
    
    /* private void addMessage(FacesMessage message) {

        FacesContext.getCurrentInstance().addMessage(
                null, message);

    }*/

    public String addUser() {

      /*addMessage(
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "User Registration Successful!!!",
                        null
                ));*/
      
        ShowMessage.showMessage("User Registration Successful!!!", "User Registration message.", FacesMessage.SEVERITY_INFO);
      
        this.userFacade.create(userBean);
        return "";

    }
    
}
