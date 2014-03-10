/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.user.UserBeanFacade;
import entities.user.UserBean;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import util.ShowMessage;

/**
 *
 * @author habib
 */
@Stateless
public class RegistrationController {
    @EJB
    private UserBeanFacade userFacade;
    
    public String addUser(UserBean userBean) {

        ShowMessage.showMessage("User Registration Successful!!!", "User Registration message.", FacesMessage.SEVERITY_INFO);
      
        this.userFacade.create(userBean);
        return "";

    }
    
}
