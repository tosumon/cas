/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;


import controller.DeleteApplicantEJB;
import entities.user.User;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author atinkut
 */
@Named
@ManagedBean(name = "deleteApplicantMB")
@SessionScoped
public class DeleteApplicantMB {

    @EJB
    private DeleteApplicantEJB deleteEJB;
    private User user = new User();

    public DeleteApplicantMB() {

    }

    public void retriveUser(ActionEvent ae) {

        this.getUserToDelete();
    }
public String cancelDelete(){

    return "/login/login_return?faces-redirect=true";
}
   /* public final void onCostoBrutoChange(final AjaxBehaviorEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        String id = context.getApplication().evaluateExpressionGet(context, "#{myId}", String.class);
    }*/

    public User getUserToDelete() {
        System.out.println(user.getEmail());
        if (null == user.getEmail()) {
            return user;
        }
       // System.out.println("user email" + user.getEmail());
        return deleteEJB.fetch(user.getEmail());
        

    }

    public String confirmDelete() {
        return deleteEJB.delete(user.getEmail());
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
