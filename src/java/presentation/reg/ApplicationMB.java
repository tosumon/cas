/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;

import boundary.user.EnglishProficiencyFacade;
import boundary.user.PersonalDataFacade;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Atik
 */
@ManagedBean(name = "ApplicationMB")
@RequestScoped
public class ApplicationMB {
    @EJB
    private EnglishProficiencyFacade englishProficiencyFacade;
    @EJB
    private PersonalDataFacade personalDataFacade;

    /**
     * Creates a new instance of ApplicationMB
     */
    public ApplicationMB() {
    }
    
}
