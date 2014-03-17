/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.reg;

import controller.SearchController;
import entities.user.Applicant;
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
    
    
     private String keyword;
    private String searchBy;
    
    public String getSearchBy() {
        return searchBy;
    }

    public void setSearchBy(String searchBy) {
        this.searchBy = searchBy;
    }       

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {        
       this.keyword=keyword;
    }

    public SearchController getController() {
        return searchControl;
    }

   public SearchMB() {
    }

    public DataModel<Applicant> search() {
        switch (this.getSearchBy()) {
            case "firstname":
                return (DataModel<Applicant>) searchControl.searchByName(this.keyword);
            case "country":
                return (DataModel<Applicant>) searchControl.searchByCountry(this.keyword);
            case "email":
                return (DataModel<Applicant>) searchControl.searchByEmail(this.keyword);
            default:
                return (DataModel<Applicant>) searchControl.searchByAppStatus(this.keyword);
        }
    }    
   
}
