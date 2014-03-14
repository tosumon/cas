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
public class GRE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long greId;
    
    private int year;
    private int verbalScore;
    private int quantitiveScore;
    private int analyticalScore;
    
    @OneToOne (mappedBy = "gre")
    private EnglishProficiency englishProficiency;

    public Long getGreId() {
        return greId;
    }

    public void setGreId(Long greId) {
        this.greId = greId;
    }

    public EnglishProficiency getEnglishProficiency() {
        return englishProficiency;
    }

    public void setEnglishProficiency(EnglishProficiency englishProficiency) {
        this.englishProficiency = englishProficiency;
    }    

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getVerbalScore() {
        return verbalScore;
    }

    public void setVerbalScore(int verbalScore) {
        this.verbalScore = verbalScore;
    }

    public int getQuantitiveScore() {
        return quantitiveScore;
    }

    public void setQuantitiveScore(int quantitiveScore) {
        this.quantitiveScore = quantitiveScore;
    }

    public int getAnalyticalScore() {
        return analyticalScore;
    }

    public void setAnalyticalScore(int analyticalScore) {
        this.analyticalScore = analyticalScore;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (greId != null ? greId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the greId fields are not set
        if (!(object instanceof GRE)) {
            return false;
        }
        GRE other = (GRE) object;
        if ((this.greId == null && other.greId != null) || (this.greId != null && !this.greId.equals(other.greId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.GRE[ greId=" + greId + " ]";
    }
    
}
