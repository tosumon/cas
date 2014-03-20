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
 * @author atinkut
 */
@Stateless
public class SearchController {

    @EJB
    private ApplicantFacade appFacade;

    public ApplicantFacade getAppFacade() {
        return appFacade;
    }
    
     public Applicant searchById(Long appid) {
        return appFacade.searchById(appid);
    }

    public  List<Applicant> searchByEmail(String email) {
        return appFacade.findApplicantsByEmail(email);
    }

    public List<Applicant> searchByName(String name) {

        return appFacade.findApplicantsByName(name);
    }
    

    public List<Applicant> searchByCountry(String country) {
        return appFacade.findApplicantsByCountry(country);
    }
    
     public List<Applicant> searchByAppStatus(String appStatus) {
        return appFacade.findApplicantsByAppStatus(appStatus);
    }
     
     public List<Applicant> searchByEvlStatus(String evlStatus) {
        return appFacade.findApplicantsByEvlStatus(evlStatus);
    }
    
     
}
