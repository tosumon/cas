/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.reg;

import controller.SearchController;
import entities.user.Applicant;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import presentation.admin.AdminMB;

/**
 *
 * @author IS
 */
@ManagedBean(name = "searchMB")
@SessionScoped
public class SearchMB {

    @EJB
    private SearchController searchControl;

    private String fName;

    public String getCountryCtz() {
        return countryCtz;
    }

    public void setCountryCtz(String countryCtz) {
        this.countryCtz = countryCtz;
    }
    private String countryCtz;
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }
    private String email;
    private String evaluationStatus;
    private String applicationStatus;
    
    private String searchBy;
    private List<Applicant> results = new ArrayList<Applicant>();
    
   
    private int appId;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public List<Applicant> getResults() {
        this.search();
        return results;
    }

    public void setResults(List<Applicant> results) {
        this.results = results;
    }

    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }

   

    public SearchController getController() {
        return searchControl;
    }

    public SearchMB() {
        results = new ArrayList<Applicant>();
    }

    public String search() {

        System.out.println("size " + this.getSearchBy());
        if(this.getSearchBy()!=null){
        if (this.getSearchBy().equalsIgnoreCase("email")) {
            this.results = searchControl.searchByEmail(this.getEmail());
        }else if (this.getSearchBy().equalsIgnoreCase("country")) {
            this.results = searchControl.searchByCountry(this.getCountryCtz());
        }else if (this.getSearchBy().equalsIgnoreCase("firstname")) {
            this.results = searchControl.searchByName(this.getfName());
        }else if (this.getSearchBy().equalsIgnoreCase("evlStatus")) {
            this.results = searchControl.searchByEvlStatus(this.getEvaluationStatus());
        }else if (this.getSearchBy().equalsIgnoreCase("appStatus")) {
            this.results = searchControl.searchByAppStatus(this.getApplicationStatus());
        }
        }

        return "";
    }
    
    public String viewApp(Applicant app){
        AdminMB adminMB=new AdminMB();
        adminMB.setUpdateId(appId);
        
        System.out.println("appid "+app.getApplicantId());
        return "/admin/appInfo";
    }

}
