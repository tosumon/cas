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
 //-------{Put your code here----   
     // Saves the applicant and then returns the string "ApplicationSubmitConfMsg.xhtml"
    public String submitApplicaton(){
       this.applicantFacade.create(applicant);
       return "ApplicationSubmitConfMsg";
    }
//-------Put your code here}----   
    
// -------------- {All Getter Setter------
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
    //---------All Getter Setter}-----------
    
   
    

    
    
}
