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
    private Long id;
    
    private String companyName;
    private String companyWebSite;
    private String city;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date formDate;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date toDate;
    private String position;
    private int programmingTaskPercent;
    private int dataStructureTaskPercent;
    private int networkingTaskPercent;
    private int dbAdminTaskPercent;
    private int teachingTrainingTaskPercent;
    private int managementTaskPercent;
    private int othersName;
    private int othersTaskPercent;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getFormDate() {
        return formDate;
    }

    public void setFormDate(Date formDate) {
        this.formDate = formDate;
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

    public int getOthersName() {
        return othersName;
    }

    public void setOthersName(int othersName) {
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProfessionalExperience)) {
            return false;
        }
        ProfessionalExperience other = (ProfessionalExperience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "boundary.user.ProfessionalExperience[ id=" + id + " ]";
    }
    
}
