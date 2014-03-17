/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.admin;

import controller.SearchController;
import entities.user.Applicant;
import entities.user.User;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;
import javax.inject.Named;


/**
 *
 * @author IS
 */
@ManagedBean(name = "searchMB")
@SessionScoped
public class SearchMB {    
     
    @EJB
    private SearchController searchControl;
    
    
    private Long id;
    private String firstName;
    private String country;
    private String appStatus;
    private String email;
    private String keyword;
    private String serchBy;

    public String getSerchBy() {
        return serchBy;
    }

    public void setSerchBy(String serchBy) {
        this.serchBy = serchBy;
    }
    public List<Applicant> getResults() {
        return results;
    } 
    

    public void setResults(List<Applicant> results) {
        this.results = results;
    }
    
    private List<Applicant> results = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }    

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {        
       this.keyword=keyword;
    }


    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAppStatus() {
        return appStatus;
    }

    public void setAppStatus(String appStatus) {
        this.appStatus = appStatus;
    }   

    public SearchController getController() {
        return searchControl;
    }

  

    public SearchMB() {
    }

    public String search() {
        System.out.println(this.getSerchBy()+" "+this.keyword);
        // results=searchControl.searchByEmail(this.keyword);
         //   System.out.println(this.keyword+" "+results.size());
        
        if (this.firstName != null) {
            //return (DataModel<Applicant>) searchControl.searchByName(this.keyword);
        } else if (this.country != null) {
            
            //return (DataModel<Applicant>) searchControl.searchByCountry(this.keyword);
        } else if (this.getSerchBy().equalsIgnoreCase("email")) {
            results=searchControl.searchByEmail(this.keyword);
            System.out.println(this.keyword+" "+results.size()+" "+this.email);
            //return (DataModel<Applicant>) searchControl.searchByEmail(this.keyword);
        } else {
            //return (DataModel<Applicant>) searchControl.searchByAppStatus(this.keyword);
        }
        return "";
    }      
   
}
