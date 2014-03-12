/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Atik
 */
@ManagedBean
@SessionScoped
public class ApplicationController implements Serializable {

    /**
     * Createsa new instance of CustomerController
     */
    public ApplicationController() {
    }

    public void saveApplication(ActionEvent actionEvent) {
//Ina real application, we would save the data,
//In this example we simply showa message.
        FacesMessage facesMessage = new FacesMessage("Data Saved Successfully");
        facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
        FacesContext.getCurrentInstance().addMessage(null, facesMessage);
    }
}
