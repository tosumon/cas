/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package presentation.reg;


import boundary.user.ApplicantFacade;
import entities.user.Applicant;
import entities.user.CsCourse;
import entities.user.EducationHistory;
import entities.user.EnglishProficiency;
import entities.user.GRE;
import entities.user.IELTS;
import entities.user.PersonalData;
import entities.user.ProfessionalExperience;
import entities.user.TOEFL;
import entities.user.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Atik
 */
@ManagedBean(name = "ApplicationMB")
@RequestScoped
public class ApplicationMB {
    @EJB
    private ApplicantFacade applicantFacade;    
    
    private Applicant applicant;
    private CsCourse csCourse;
    private EducationHistory educationHistory;
    private EnglishProficiency englishProficiency;
    private GRE gre;
    private IELTS ielts;
    private PersonalData personalData;
    private ProfessionalExperience professionalExperience;
    private TOEFL toefl;
    
    private User user;

    public ApplicationMB() {
        applicant=new Applicant();
        csCourse = new CsCourse();
        educationHistory = new EducationHistory();
        englishProficiency = new EnglishProficiency();
        gre = new GRE();
        ielts = new IELTS();
        toefl = new TOEFL();
        personalData = new PersonalData();
        professionalExperience = new ProfessionalExperience();
        
        //toefl.setYear(1230);
        englishProficiency.setGre(gre);
        englishProficiency.setIelts(ielts);
        englishProficiency.setToefl(toefl);
        
        educationHistory.setCsCourse(csCourse);
        
        applicant.setEducationHistory(educationHistory);
        applicant.setEnglishProficiency(englishProficiency);
        applicant.setPersonalData(personalData);
        applicant.setProfessionalExperience(professionalExperience);
        
        
        
    }         
 //{-------Put your code here----   
     // Saves the applicant and then returns the string "ApplicationSubmitConfMsg.xhtml"
    public String submitApplicaton(){
       //{--- taking evaluation decision---
       int totalPoints = this.getTotalPoint();//maximum totalpoint is 50
       if(totalPoints>=25){
           applicant.setEvaluationStatus("Accepted");
       }else if(totalPoints<20){
           applicant.setEvaluationStatus("Rejected");
       }else{
           applicant.setEvaluationStatus("Undecided");
       }
       System.out.print(totalPoints);
       //--- taking evaluation decision---}
       //{--- taking Applicaton Status decision---
       applicant.setApplicationStatus("Submitted");
       //--- taking Applicaton Status decision---}
       this.applicantFacade.create(applicant);
       return "ApplicationSubmitConfMsg";
    }
    
    public boolean checkForSavedApplication(){
        if(applicantFacade.find(user.getEmail())==null){
            return false;
        }
        return true;
    }
    
    public int getTotalPoint(){
        int totalPoint = 0;
        //{-----gpa----
        int gpaPercentage = 0;
        switch (applicant.getEducationHistory().getGrading()) {
            case "0 to 4":
                gpaPercentage = (int)((applicant.getEducationHistory().getFinalGpa()/4)*100);
                break;
            case "0 to 5":
                gpaPercentage = (int)((applicant.getEducationHistory().getFinalGpa()/5)*100);
                break;
            case "0 to 10":
                gpaPercentage = (int)((applicant.getEducationHistory().getFinalGpa()/10)*100);
                break;
        }
        if(gpaPercentage>=60){
            totalPoint+=(int)((gpaPercentage/10)*2);
        }else{
            return 0;
        }
        //------gpa------}
        //{------english----
        Map<String,Integer> skill = new HashMap<>();
        skill.put("Excelent", new Integer(2));
        skill.put("Fair", new Integer(1));
        skill.put("Bad", new Integer(0));
        
        totalPoint+=skill.get(applicant.getEnglishProficiency().getListeningAbility());
        totalPoint+=skill.get(applicant.getEnglishProficiency().getReadWriteAbility());
        totalPoint+=skill.get(applicant.getEnglishProficiency().getSpeakingAbility());
        
        if(applicant.getEnglishProficiency().getIelts().getOverallScore()>0){
            if(applicant.getEnglishProficiency().getIelts().getOverallScore()>=7){
                totalPoint+=3;
            }else if(applicant.getEnglishProficiency().getIelts().getOverallScore()>=6){
                totalPoint+=2;
            }else{
                totalPoint+=1;
            }
        }else if(applicant.getEnglishProficiency().getGre().getAnalyticalScore()>0){
            int totalScore = applicant.getEnglishProficiency().getGre().getAnalyticalScore()+
                    applicant.getEnglishProficiency().getGre().getQuantitiveScore()+
                    applicant.getEnglishProficiency().getGre().getVerbalScore();
            if(totalScore>300){
                totalPoint+=3;
            }else if(totalScore>280){
                totalPoint+=2;
            }else {
                totalPoint+=1;
            }
        }else if(applicant.getEnglishProficiency().getToefl().getScore()>0){
            if(applicant.getEnglishProficiency().getToefl().getScore()>=500){
                totalPoint+=3;
            }else if(applicant.getEnglishProficiency().getToefl().getScore()>=400){
                totalPoint+=2;
            }else{
                totalPoint+=1;
            }                
        }            
        //------english----}
        //{------work exp-----
        //SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        Date d1 = applicant.getProfessionalExperience().getToDate();
        Date d2 = applicant.getProfessionalExperience().getFromDate();
        //in milliseconds
        long diff = d1.getTime() - d2.getTime();        
        long diffYears = diff / (365 * 24 * 60 * 60 * 1000);
        if (diffYears>5) diffYears = 5;
        totalPoint+= diffYears*3;
        //------work exp-----}
        return totalPoint;
    }
//-------Put your code here----}
    
// {-------------- All Getter Setter------
    public Applicant getApplicant() {
        return applicant;
    }

    public void setApplicant(Applicant applicant) {
        this.applicant = applicant;
    }  

    public CsCourse getCsCourse() {
        return csCourse;
    }

    public void setCsCourse(CsCourse csCourse) {
        this.csCourse = csCourse;
    }

    public EducationHistory getEducationHistory() {
        return educationHistory;
    }

    public void setEducationHistory(EducationHistory educationHistory) {
        this.educationHistory = educationHistory;
    }

    public EnglishProficiency getEnglishProficiency() {
        return englishProficiency;
    }

    public void setEnglishProficiency(EnglishProficiency englishProficiency) {
        this.englishProficiency = englishProficiency;
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

    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public void setProfessionalExperience(ProfessionalExperience professionalExperience) {
        this.professionalExperience = professionalExperience;
    }

    public TOEFL getToefl() {
        return toefl;
    }

    public void setToefl(TOEFL toefl) {
        this.toefl = toefl;
    }
    //---------All Getter Setter-----------}
    
   
    

    
    
}
