/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import boundary.UserFacade;
import entities.user.User;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author atinkut
 */
@Named
@Stateless
public class DeleteApplicantEJB {
//first fetch the applicant info and show to the admin and then if he want to delete delelte it
   @EJB
   UserFacade userFacade;
    public User fetch(String email){
        return userFacade.find(email);
    
    }
    public String delete(String email){
        User user=(User)userFacade.find(email);
        userFacade.remove(user);
        return "/delete_applicant/delete_success";
        
        
    }
}
