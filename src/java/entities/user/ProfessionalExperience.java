/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Atik
 */
@Entity
public class ProfessionalExperience implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long professionalExperienceId;
    
    private String companyName;
    private String companyWebSite;
    private String city;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fromDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toDate;
    private String position;
    private int programmingTaskPercent;
    private int dataStructureTaskPercent;
    private int networkingTaskPercent;
    private int dbAdminTaskPercent;
    private int teachingTrainingTaskPercent;
    private int managementTaskPercent;
    private String othersName;
    private int othersTaskPercent;
    
    
    @OneToOne (mappedBy = "professionalExperience")
    private Applicant applicant;

    public Long getProfessionalExperienceId() {
        return professionalExperienceId;
    }

    public void setProfessionalExperienceId(Long professionalExperienceId) {
        this.professionalExperienceId = professionalExperienceId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }
    
    
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyWebSite() {
        return companyWebSite;
    }

    public void setCompanyWebSite(String companyWebSite) {
        this.companyWebSite = companyWebSite;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getProgrammingTaskPercent() {
        return programmingTaskPercent;
    }

    public void setProgrammingTaskPercent(int programmingTaskPercent) {
        this.programmingTaskPercent = programmingTaskPercent;
    }

    public int getDataStructureTaskPercent() {
        return dataStructureTaskPercent;
    }

    public void setDataStructureTaskPercent(int dataStructureTaskPercent) {
        this.dataStructureTaskPercent = dataStructureTaskPercent;
    }

    public int getNetworkingTaskPercent() {
        return networkingTaskPercent;
    }

    public void setNetworkingTaskPercent(int networkingTaskPercent) {
        this.networkingTaskPercent = networkingTaskPercent;
    }

    public int getDbAdminTaskPercent() {
        return dbAdminTaskPercent;
    }

    public void setDbAdminTaskPercent(int dbAdminTaskPercent) {
        this.dbAdminTaskPercent = dbAdminTaskPercent;
    }

    public int getTeachingTrainingTaskPercent() {
        return teachingTrainingTaskPercent;
    }

    public void setTeachingTrainingTaskPercent(int teachingTrainingTaskPercent) {
        this.teachingTrainingTaskPercent = teachingTrainingTaskPercent;
    }

    public int getManagementTaskPercent() {
        return managementTaskPercent;
    }

    public void setManagementTaskPercent(int managementTaskPercent) {
        this.managementTaskPercent = managementTaskPercent;
    }

    public String getOthersName() {
        return othersName;
    }

    public void setOthersName(String othersName) {
        this.othersName = othersName;
    }

    
    public int getOthersTaskPercent() {
        return othersTaskPercent;
    }

    public void setOthersTaskPercent(int othersTaskPercent) {
        this.othersTaskPercent = othersTaskPercent;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (professionalExperienceId != null ? professionalExperienceId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the professionalExperienceId fields are not set
        if (!(object instanceof ProfessionalExperience)) {
            return false;
        }
        ProfessionalExperience other = (ProfessionalExperience) object;
        if ((this.professionalExperienceId == null && other.professionalExperienceId != null) || (this.professionalExperienceId != null && !this.professionalExperienceId.equals(other.professionalExperienceId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundary.user.ProfessionalExperience[ professionalExperienceId=" + professionalExperienceId + " ]";
    }
    
}
