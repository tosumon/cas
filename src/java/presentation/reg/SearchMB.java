/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation.reg;

import controller.SearchController;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



/**
 *
 * @author IS
 */
@ManagedBean(name = "searchMB")
@RequestScoped
public class SearchMB {    
     
    @EJB
    private SearchController searchControl;
    
    
     private String keyword;
    private String searchBy;
    private List results;
    
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

    public List search() {
        switch (this.getSearchBy()) {
            case "firstname":
                results =searchControl.searchByName(this.keyword);
            case "country":
                results =searchControl.searchByCountry(this.keyword);
            case "email":
                results =searchControl.searchByEmail(this.keyword);
            default:
                results =searchControl.searchByAppStatus(this.keyword);
        }
        return results;
    }    
   
}
