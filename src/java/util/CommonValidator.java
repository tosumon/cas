/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import static com.sun.codemodel.JExpr.component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author Atik
 */
@ManagedBean
@RequestScoped
public class CommonValidator {

    /**
     * Creates a new instance of CommonValidator
     */
    public CommonValidator() {
    }
     
    //---check precent task of 100---
    public void taskPercent(FacesContext context,UIComponent component, Object value){
        
        int sum =0;
        StringBuilder msg = new StringBuilder();
        
        UIInput ptp = (UIInput) component.findComponent("programmingTaskPercent");
        String programmingTaskPercent = ptp.getLocalValue() == null ? "0" : ptp.getLocalValue().toString();
        sum += Integer.parseInt(programmingTaskPercent);
        
        UIInput dstp = (UIInput) component.findComponent("dataStructureTaskPercent");
        String dataStructureTaskPercent = dstp.getLocalValue() == null ? "0" : dstp.getLocalValue().toString();
        sum += Integer.parseInt(dataStructureTaskPercent);
        
        UIInput ntp = (UIInput) component.findComponent("networkingTaskPercent");
        String networkingTaskPercent = ntp.getLocalValue() == null ? "0" : ntp.getLocalValue().toString();
        sum += Integer.parseInt(networkingTaskPercent);
        
        UIInput dbatp = (UIInput) component.findComponent("dbAdminTaskPercent");
        String dbAdminTaskPercent = dbatp.getLocalValue() == null ? "0" : dbatp.getLocalValue().toString();
        sum += Integer.parseInt(dbAdminTaskPercent);
        
        UIInput tttp = (UIInput) component.findComponent("teachingTrainingTaskPercent");
        String teachingTrainingTaskPercent = tttp.getLocalValue() == null ? "0" : tttp.getLocalValue().toString();
        sum += Integer.parseInt(teachingTrainingTaskPercent);
        
        UIInput mtp = (UIInput) component.findComponent("managementTaskPercent");
        String managementTaskPercent = mtp.getLocalValue() == null ? "0" : mtp.getLocalValue().toString();
        sum += Integer.parseInt(managementTaskPercent);
        
        UIInput otp=  (UIInput) component.findComponent("othersTaskPercent");
        String othersTaskPercent = otp.getLocalValue() == null ? "0" : otp.getLocalValue().toString();
        sum += Integer.parseInt(othersTaskPercent);

        if (sum != 100) {
            throw new ValidatorException(new FacesMessage("Total % (Must total 100%)"));
            //msg.append("Total % (Must total 100%)");
        }
    }
    
//-------------------------------------------------------------------------------------------------------------------------    
    //---check final GPA not exceed than Grading---    
    public void finalGpa(FacesContext context,UIComponent component, Object value){
//        UIInput fg = (UIInput) component.findComponent("finalGpa");
//        String fgStr = fg.getLocalValue() == null ? "0" : fg.getLocalValue().toString();
        String fgStr = value.toString();
        double finalGpa= Double.parseDouble(fgStr);
        
        UIInput grad = (UIInput) component.findComponent("grading");
        String grading = grad.getLocalValue() == null ? "0" : grad.getLocalValue().toString();        
        
        if((grading.equals("0 to 4") && (finalGpa<0 ||finalGpa > 4))||(grading.equals("0 to 5") && (finalGpa<0 ||finalGpa > 5))||(grading.equals("0 to 10") && (finalGpa<0 ||finalGpa > 10))){
            throw new ValidatorException(new FacesMessage("Plese enter correct GPA"));
        }
    }
    
    //--------------------------------------------------------------------------------------------------------------------
     public void formDateToDate(FacesContext context,UIComponent component, Object value) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");         
        System.out.print("i am in eduFromDate");
        UIInput efd = (UIInput) component.findComponent("eduFromDate");
        String efdStr = efd.getLocalValue() == null ? "10/10/10" : efd.getLocalValue().toString();        
        Date eduFromDate = format.parse(efdStr);
        System.out.print(eduFromDate);
                
        UIInput etd = (UIInput) component.findComponent("eduToDate");        
        String etdStr = etd.getLocalValue() == null ? "10/10/10" : etd.getLocalValue().toString();
        Date eduToDate = format.parse(efdStr);
        System.out.print(eduToDate);
                
        if(eduFromDate.getTime()>eduToDate.getTime()){
            throw new ValidatorException(new FacesMessage("Plese enter correct Education From Date and to Date"));
        }
    }
    
}
