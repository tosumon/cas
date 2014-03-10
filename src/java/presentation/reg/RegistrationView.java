/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;

import boundary.user.UserBeanFacade;
import controller.RegistrationController;
import entities.user.UserBean;
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
    private RegistrationController regController;
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
    
     public String addUser() {

        regController.addUser(userBean);
        return "";

    }
    
}
