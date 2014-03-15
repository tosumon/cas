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
public class PersonalData implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long personalDataId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String sex;
    private String maritalStatus;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateOfBirth;
    private String countryOfCitizenship;
    private String countryOfBirth;
    private String countryOfLiving;
    private String cityOfLiving;
    private String visaStatus;
    private String emailAddress;
    private String skypeId;
    private String phone;
    @OneToOne (mappedBy = "personalData")
    private Applicant applicant;

   
    public Long getPersonalDataId() {
        return personalDataId;
    }

    public void setPersonalDataId(Long personalDataId) {
        this.personalDataId = personalDataId;
    }   

    public String getFirstName() {        
        return firstName;
    }

    public void setFirstName(String firstName) {
        System.out.print("I am in First Name of PersonalData.java");
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getCountryOfCitizenship() {
        return countryOfCitizenship;
    }

    public void setCountryOfCitizenship(String countryOfCitizenship) {
        this.countryOfCitizenship = countryOfCitizenship;
    }

    public String getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(String countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public String getCountryOfLiving() {
        return countryOfLiving;
    }

    public void setCountryOfLiving(String countryOfLiving) {
        this.countryOfLiving = countryOfLiving;
    }

    public String getCityOfLiving() {
        return cityOfLiving;
    }

    public void setCityOfLiving(String cityOfLiving) {
        this.cityOfLiving = cityOfLiving;
    }

    public String getVisaStatus() {
        return visaStatus;
    }

    public void setVisaStatus(String visaStatus) {
        this.visaStatus = visaStatus;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getSkypeId() {
        return skypeId;
    }

    public void setSkypeId(String skypeId) {
        this.skypeId = skypeId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personalDataId != null ? personalDataId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the personalDataId fields are not set
        if (!(object instanceof PersonalData)) {
            return false;
        }
        PersonalData other = (PersonalData) object;
        if ((this.personalDataId == null && other.personalDataId != null) || (this.personalDataId != null && !this.personalDataId.equals(other.personalDataId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.PersonalData[ personalDataId=" + personalDataId + " ]";
    }
    
}
