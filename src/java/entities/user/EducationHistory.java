/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.validation.constraints.Size;

/**
 *
 * @author Atik
 */
@Entity
public class EducationHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long educationHistoryId;

    private String instituteName;
    @Size(min = 2, message = "Please select degree" )
    private String degree;
    @Size(min = 2, message = "Please select subject Area" )
    private String subjectArea;
    @Size(min = 2, message = "Please select country" )
    private String country;
    private String city;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fromDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toDate;
    @Size(min = 2, message = "Please select grading" )
    private String grading;
    private double finalGpa;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "csCourseId")    
    private CsCourse csCourse;    
    
    @OneToOne (mappedBy = "educationHistory")
    private Applicant applicant;

    public Long getEducationHistoryId() {
        return educationHistoryId;
    }

    public void setEducationHistoryId(Long educationHistoryId) {
        this.educationHistoryId = educationHistoryId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    
    public String getInstituteName() {
        return instituteName;
    }

    public void setInstituteName(String instituteName) {
        this.instituteName = instituteName;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getSubjectArea() {
        return subjectArea;
    }

    public void setSubjectArea(String subjectArea) {
        this.subjectArea = subjectArea;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getGrading() {
        return grading;
    }

    public void setGrading(String grading) {
        this.grading = grading;
    }

    public double getFinalGpa() {
        return finalGpa;
    }

    public void setFinalGpa(double finalGpa) {
        this.finalGpa = finalGpa;
    }

    
    public CsCourse getCsCourse() {
        return csCourse;
    }

    public void setCsCourse(CsCourse csCourse) {
        this.csCourse = csCourse;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationHistoryId != null ? educationHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the educationHistoryId fields are not set
        if (!(object instanceof EducationHistory)) {
            return false;
        }
        EducationHistory other = (EducationHistory) object;
        if ((this.educationHistoryId == null && other.educationHistoryId != null) || (this.educationHistoryId != null && !this.educationHistoryId.equals(other.educationHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundary.user.EducationHistory[ educationHistoryId=" + educationHistoryId + " ]";
    }
    
}
