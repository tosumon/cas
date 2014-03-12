/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Atik
 */
@ManagedBean(name = "YearGenerator")
@RequestScoped
public class YearGenerator {

    //private Map<Integer, Integer> years = new HashMap<Integer, Integer>();
    private Map<String, String> years = new HashMap<String, String>();
    int year = Calendar.getInstance().get(Calendar.YEAR);
    public YearGenerator() {
       for (int i = year -10; i<=year;i++){
           //years.put(new Integer(1), new Integer(2));
            years.put(""+i, ""+i);
       }
           
    }

    public Map<String, String> getYears() {
        return years;
    }

    public void setYears(Map<String, String> years) {
        this.years = years;
    }

    
    

    

}
