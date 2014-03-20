/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import boundary.user.ApplicantFacade;
import entities.user.Applicant;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author habib
 */
@Stateless
public class AdminController {
    @EJB
    ApplicantFacade applicantFacade;
    
     public Applicant getApplicantInfo(Long id){
         System.out.println("function called");
         //List<Applicant> applicants= applicantFacade.findAll();

         Applicant applicant= applicantFacade.searchById(id);
       
//System.out.println(applicant.getPersonalData().getCityOfLiving());
       return applicant;
     }
     
     public String updateApplicaton(Applicant applicant){
        applicantFacade.edit(applicant);
     return "adHome";   
    }
    
}
