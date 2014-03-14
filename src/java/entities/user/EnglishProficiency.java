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
public class EnglishProficiency implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long englishProficiencyId;

    private String readWriteAbility;
    private String speakingAbility;
    private String listeningAbility;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="toeflId") 
    private TOEFL toefl;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="greId") 
    private GRE gre;
    @OneToOne (cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name="ieltsId") 
    private IELTS ielts;
    
    @OneToOne (mappedBy = "englishProficiency")
    private Applicant applicant;
    

    public Long getEnglishProficiencyId() {
        return englishProficiencyId;
    }

    public void setEnglishProficiencyId(Long englishProficiencyId) {
        this.englishProficiencyId = englishProficiencyId;
    }

    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;   }
    
   

    public String getReadWriteAbility() {
        return readWriteAbility;
    }

    public void setReadWriteAbility(String readWriteAbility) {
        this.readWriteAbility = readWriteAbility;
    }

    public String getSpeakingAbility() {
        return speakingAbility;
    }

    public void setSpeakingAbility(String speakingAbility) {
        this.speakingAbility = speakingAbility;
    }

    public String getListeningAbility() {
        return listeningAbility;
    }

    public void setListeningAbility(String listeningAbility) {
        this.listeningAbility = listeningAbility;
    }

    public TOEFL getToefl() {
        return toefl;
    }

    public void setToefl(TOEFL toefl) {
        this.toefl = toefl;
    }

    public GRE getGre() {
        return gre;
    }

    public void setGre(GRE gre) {
        this.gre = gre;
    }

    public IELTS getIelts() {
        return ielts;
    }

    public void setIelts(IELTS ielts) {
        this.ielts = ielts;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (englishProficiencyId != null ? englishProficiencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EnglishProficiency)) {
            return false;
        }
        EnglishProficiency other = (EnglishProficiency) object;
        if ((this.englishProficiencyId == null && other.englishProficiencyId != null) || (this.englishProficiencyId != null && !this.englishProficiencyId.equals(other.englishProficiencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.EnglishProficiency[ englishProficiencyId=" + englishProficiencyId + " ]";
    }
    
}
