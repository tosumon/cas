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
import javax.faces.bean.ManagedProperty;
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
   
    @ManagedProperty("#{param.updateId}")
    private int updateId;

    public int getUpdateId() {
        return updateId;
    }

    public void setUpdateId(int updateId) {
        this.updateId = updateId;
    }
    
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }    
    
    public AdminMB() {
        applicant=new Applicant();
       
    }
    
    public String getApplicantInfo(){
      
     Applicant app=  adminController.getApplicantInfo(new Long(this.updateId));
     if(null!=app){
         this.applicant=app;
         return "/admin/appInfo";
     }
        return "/admin/error";
    }
    
    public String getApplicantInfo(Applicant app){     
    
     if(null!=app){
         this.applicant=app;
         return "/admin/appInfo";
     }
        return "/admin/error";
    }
    
    public String updateApplicaton(){
        
       Applicant app=  adminController.getApplicantInfo(new Long(this.updateId));
        System.out.println("iddd "+this.updateId);
        System.out.println(" value "+app.getPersonalData().getEmailAddress());
        
       app.setEvaluationStatus(this.applicant.getEvaluationStatus());
       app.setApplicationStatus(this.applicant.getApplicationStatus());
        System.out.println(" status "+app.getEvaluationStatus());
        
       adminController.updateApplicaton(app);
       
       return "/admin/search/search";   
    }
    
}
