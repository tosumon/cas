/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.admin;


import controller.AdminController;
import entities.user.Applicant;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


/**
 *
 * @author habib
 */
@ManagedBean(name="adminMB")
@RequestScoped
public class AdminMB {    
    @EJB
    private AdminController adminController;    

    private Applicant applicant;
    
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }    
    
    public AdminMB() {
       
    }
    
    public String getApplicantInfo(){
     Applicant app=  adminController.getApplicantInfo(new Long(101));
     if(null!=app){
         this.applicant=app;
         return "appInfo";
     }
        return "error";
    }
    
     
    
}
