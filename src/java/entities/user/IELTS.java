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

/**
 *
 * @author Atik
 */
@Entity
public class IELTS implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int year;
    private double overallScore;
    private double listeningScore;
    private double readingScore;
    private double writingScore;
    private double speakingScore;

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

    public double getOverallScore() {
        return overallScore;
    }

    public void setOverallScore(double overallScore) {
        this.overallScore = overallScore;
    }

    public double getListeningScore() {
        return listeningScore;
    }

    public void setListeningScore(double listeningScore) {
        this.listeningScore = listeningScore;
    }

    public double getReadingScore() {
        return readingScore;
    }

    public void setReadingScore(double readingScore) {
        this.readingScore = readingScore;
    }

    public double getWritingScore() {
        return writingScore;
    }

    public void setWritingScore(double writingScore) {
        this.writingScore = writingScore;
    }

    public double getSpeakingScore() {
        return speakingScore;
    }

    public void setSpeakingScore(double speakingScore) {
        this.speakingScore = speakingScore;
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
        if (!(object instanceof IELTS)) {
            return false;
        }
        IELTS other = (IELTS) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.user.IELTS[ id=" + id + " ]";
    }
    
}
