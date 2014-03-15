/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Atik
 */
@Entity
public class Applicant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicantId;
    private String email;
    private String applicationStatus;
    private String evaluationStatus; 
    
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="personalDataId") 
    private PersonalData personalData;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="englishProficiencyId") 
    private EnglishProficiency englishProficiency;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="educationHistoryId") 
    private EducationHistory educationHistory;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="professionalExperienceId") 
    private ProfessionalExperience professionalExperience; 

   
    
    public Long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(Long applicantId) {
        this.applicantId = applicantId;
    }

    public String getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(String applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    public String getEvaluationStatus() {
        return evaluationStatus;
    }

    public void setEvaluationStatus(String evaluationStatus) {
        this.evaluationStatus = evaluationStatus;
    }

    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public EnglishProficiency getEnglishProficiency() {
        return englishProficiency;
    }

    public void setEnglishProficiency(EnglishProficiency englishProficiency) {
        this.englishProficiency = englishProficiency;
    }

    public EducationHistory getEducationHistory() {
        return educationHistory;
    }

    public void setEducationHistory(EducationHistory educationHistory) {
        this.educationHistory = educationHistory;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperience = professionalExperience;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (applicantId != null ? applicantId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the applicantId fields are not set
        if (!(object instanceof Applicant)) {
            return false;
        }
        Applicant other = (Applicant) object;
        if ((this.applicantId == null && other.applicantId != null) || (this.applicantId != null && !this.applicantId.equals(other.applicantId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.Applicant[ applicantId=" + applicantId + " ]";
    }
    
}
