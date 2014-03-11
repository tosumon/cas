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
public class GRE implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private int year;
    private int verbalScore;
    private int quantitiveScore;
    private int analyticalScore;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GRE)) {
            return false;
        }
        GRE other = (GRE) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.GRE[ id=" + id + " ]";
    }
    
}
