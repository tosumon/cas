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
       
        return  em.createQuery("SELECT c FROM Applicant c WHERE c.personalData.countryOfCitizenship LIKE :fname").setParameter("fname", country).setMaxResults(100).getResultList();
    }
    
     public List<Applicant> findApplicantsByName(String fname) {          
              
       return  em.createQuery("SELECT c FROM Applicant c WHERE c.personalData.firstName LIKE :fname").setParameter("fname", fname).setMaxResults(100).getResultList();

    }
     
      public List<Applicant> findApplicantsByEmail(String email) {         
       
       return  em.createQuery("SELECT c FROM Applicant c WHERE c.personalData.emailAddress LIKE :fname").setParameter("fname", email).setMaxResults(100).getResultList();
    }
      
       public List<Applicant> findApplicantsByAppStatus(String appStatus) {         
       
        return  em.createQuery("SELECT c FROM Applicant c WHERE c.applicationStatus LIKE :fname").setParameter("fname", appStatus).setMaxResults(100).getResultList();
    }
       
        public List<Applicant> findApplicantsByEvlStatus(String evlStatus) {         
       return  em.createQuery("SELECT c FROM Applicant c WHERE c.evaluationStatus LIKE :fname").setParameter("fname", evlStatus).setMaxResults(100).getResultList();
    }
        
        
      public Applicant searchById(Long id) {         
       return  (Applicant)em.createQuery("SELECT c FROM Applicant c WHERE c.applicantId = :fname").setParameter("fname", id).getResultList().get(0);
    }
    
}
