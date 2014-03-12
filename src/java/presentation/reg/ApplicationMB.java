/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;


import boundary.user.ApplicantFacade;
import entities.user.Applicant;
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
    private ApplicantFacade applicantFacade;
    
    
    private Applicant applicant;
    
    
    /**
     * Creates a new instance of ApplicationMB
     * @return 
     */
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

   
    

    
    
}
