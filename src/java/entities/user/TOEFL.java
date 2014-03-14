/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities.user;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author Atik
 */
@Entity
public class TOEFL implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long toeflId;
    private int year;
    private int score;
    
    @OneToOne (mappedBy = "toefl")
    private EnglishProficiency englishProficiency;

    public Long getToeflId() {
        return toeflId;
    }

    public void setToeflId(Long toeflId) {
        this.toeflId = toeflId;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (toeflId != null ? toeflId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TOEFL)) {
            return false;
        }
        TOEFL other = (TOEFL) object;
        if ((this.toeflId == null && other.toeflId != null) || (this.toeflId != null && !this.toeflId.equals(other.toeflId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.TOEFL[ toeflId=" + toeflId + " ]";
    }
    
}
