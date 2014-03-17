/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package boundary.user;

import entities.user.Applicant;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Atik
 */
@Stateless
public class ApplicantFacade extends AbstractFacade<Applicant> {
    @PersistenceContext(unitName = "ComproPUMySQL")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ApplicantFacade() {
        super(Applicant.class);
    }
    
     public List<Applicant> findApplicantsByCountry(String country) {          
       
        try {
           Query appQuery = em.createNamedQuery("Applicant.findByCountry");
            appQuery.setParameter("country", country);
            List<Applicant> foundApplicant = (List<Applicant>) appQuery.getResultList();           
            return  foundApplicant;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
     public List<Applicant> findApplicantsByName(String fname) {          
       
        try {
            Query appQuery = em.createNamedQuery("Applicant.findByName");
            appQuery.setParameter("firstName", fname);
            List<Applicant> foundApplicant = (List<Applicant>) appQuery.getResultList();           
            return  foundApplicant;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
     
      public List<Applicant> findApplicantsByEmail(String email) {         
       
        try {
            Query appQuery = em.createNamedQuery("Applicant.findByEmail");
            appQuery.setParameter("email", email);
            List<Applicant> foundApplicant = (List<Applicant>) appQuery.getResultList();           
            return  foundApplicant;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
      
       public List<Applicant> findApplicantsByAppStatus(String appStatus) {         
       
        try {
            Query appQuery = em.createNamedQuery("Applicant.findByApplicationStatus");
            appQuery.setParameter("applicationStatus", appStatus);
            List<Applicant> foundApplicant = (List<Applicant>) appQuery.getResultList();           
            return  foundApplicant;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
}
