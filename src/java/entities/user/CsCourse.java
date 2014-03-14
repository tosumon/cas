/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Atik
 */
@Entity
public class CsCourse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long csCourseId;
    private String programmingTitle;
    private String programmingGrade;
    private List <String> programmingLanguage;
    private String dataStructureTitle;
    private String dataStructureGrade;
    private List <String> dataStructureLanguage;
    private String softwareEnggTitle;
    private String softwareEnggGrade;
    private String mathTitle;
    private String mathGrade;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "csCourse")
    private EducationHistory educationHistory;

    public Long getCsCourseId() {
        return csCourseId;
    }

    public void setCsCourseId(Long csCourseId) {
        this.csCourseId = csCourseId;
    }

    public EducationHistory getEducationHistory() {
        return educationHistory;
    }

    public void setEducationHistory(EducationHistory educationHistory) {
        this.educationHistory = educationHistory;
    } 
   

    public String getProgrammingTitle() {
        return programmingTitle;
    }

    public void setProgrammingTitle(String programmingTitle) {
        this.programmingTitle = programmingTitle;
    }

    public String getProgrammingGrade() {
        return programmingGrade;
    }

    public void setProgrammingGrade(String programmingGrade) {
        this.programmingGrade = programmingGrade;
    }

    public List<String> getProgrammingLanguage() {
        return programmingLanguage;
    }

    public void setProgrammingLanguage(List<String> programmingLanguage) {
        this.programmingLanguage = programmingLanguage;
    }

    public String getDataStructureTitle() {
        return dataStructureTitle;
    }

    public void setDataStructureTitle(String dataStructureTitle) {
        this.dataStructureTitle = dataStructureTitle;
    }

    public String getDataStructureGrade() {
        return dataStructureGrade;
    }

    public void setDataStructureGrade(String dataStructureGrade) {
        this.dataStructureGrade = dataStructureGrade;
    }

    public List<String> getDataStructureLanguage() {
        return dataStructureLanguage;
    }

    public void setDataStructureLanguage(List<String> dataStructureLanguage) {
        this.dataStructureLanguage = dataStructureLanguage;
    }

    public String getSoftwareEnggTitle() {
        return softwareEnggTitle;
    }

    public void setSoftwareEnggTitle(String softwareEnggTitle) {
        this.softwareEnggTitle = softwareEnggTitle;
    }

    public String getSoftwareEnggGrade() {
        return softwareEnggGrade;
    }

    public void setSoftwareEnggGrade(String softwareEnggGrade) {
        this.softwareEnggGrade = softwareEnggGrade;
    }

    public String getMathTitle() {
        return mathTitle;
    }

    public void setMathTitle(String mathTitle) {
        this.mathTitle = mathTitle;
    }

    public String getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(String mathGrade) {
        this.mathGrade = mathGrade;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (csCourseId != null ? csCourseId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the csCourseId fields are not set
        if (!(object instanceof CsCourse)) {
            return false;
        }
        CsCourse other = (CsCourse) object;
        if ((this.csCourseId == null && other.csCourseId != null) || (this.csCourseId != null && !this.csCourseId.equals(other.csCourseId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.NewEntity[ csCourseId=" + csCourseId + " ]";
    }
    
}
