/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Atik
 */
@ManagedBean(name = "CountryList")
@RequestScoped
public class CountryList {

    private Map<String, String> countriess = new HashMap<String, String>();
    private List<String> countries = new ArrayList<>();
    public CountryList() {
        countriess.put("Afghanistan", "Afghanistan");
        countriess.put("Albania", "Albania");
        countriess.put("Algeria", "Algeria");
        countriess.put("American Samoa", "American Samoa");
        countriess.put("Andorra", "Andorra");
        countriess.put("Angola", "Angola");
        countriess.put("Anguilla", "Anguilla");
        countriess.put("Antarctica", "Antarctica");
        countriess.put("Antigua and Barbuda", "Antigua and Barbuda");
        countriess.put("Argentina", "Argentina");
        countriess.put("Armenia", "Armenia");
        countriess.put("Aruba", "Aruba");
        countriess.put("Australia", "Australia");
        countriess.put("Austria", "Austria");
        countriess.put("Azerbaijan", "Azerbaijan");
        countriess.put("Bahamas", "Bahamas");
        countriess.put("Bahrain", "Bahrain");
        countriess.put("Bangladesh", "Bangladesh");
        countriess.put("Barbados", "Barbados");
        countriess.put("Belarus", "Belarus");
        countriess.put("Belgium", "Belgium");
        countriess.put("Belize", "Belize");
        countriess.put("Benin", "Benin");
        countriess.put("Bermuda", "Bermuda");
        countriess.put("Bhutan", "Bhutan");
        countriess.put("Bolivia", "Bolivia");
        countriess.put("Bosnia and Herzegovina", "Bosnia and Herzegovina");
        countriess.put("Botswana", "Botswana");
        countriess.put("Bouvet Island", "Bouvet Island");
        countriess.put("Brazil", "Brazil");
        countriess.put("British Indian Ocean Territory", "British Indian Ocean Territory");
        countriess.put("British Virgin Islands", "British Virgin Islands");
        countriess.put("Brunei", "Brunei");
        countriess.put("Bulgaria", "Bulgaria");
        countriess.put("Burkina Faso", "Burkina Faso");
        countriess.put("Burundi", "Burundi");
        countriess.put("Cambodia", "Cambodia");
        countriess.put("Cameroon", "Cameroon");
        countriess.put("Canada", "Canada");
        countriess.put("Cape Verde", "Cape Verde");
        countriess.put("Cayman Islands", "Cayman Islands");
        countriess.put("Central African Republic", "Central African Republic");
        countriess.put("Chad", "Chad");
        countriess.put("Chile", "Chile");
        countriess.put("China", "China");
        countriess.put("Christmas Island", "Christmas Island");
        countriess.put("Cocos [Keeling] Islands", "Cocos [Keeling] Islands");
        countriess.put("Colombia", "Colombia");
        countriess.put("Comoros", "Comoros");
        countriess.put("Congo [DRC]", "Congo [DRC]");
        countriess.put("Congo [Republic]", "Congo [Republic]");
        countriess.put("Cook Islands", "Cook Islands");
        countriess.put("Costa Rica", "Costa Rica");
        countriess.put("Côte d'Ivoire", "Côte d'Ivoire");
        countriess.put("Croatia", "Croatia");
        countriess.put("Cuba", "Cuba");
        countriess.put("Cyprus", "Cyprus");
        countriess.put("Czech Republic", "Czech Republic");
        countriess.put("Denmark", "Denmark");
        countriess.put("Djibouti", "Djibouti");
        countriess.put("Dominica", "Dominica");
        countriess.put("Dominican Republic", "Dominican Republic");
        countriess.put("Ecuador", "Ecuador");
        countriess.put("Egypt", "Egypt");
        countriess.put("El Salvador", "El Salvador");
        countriess.put("Equatorial Guinea", "Equatorial Guinea");
        countriess.put("Eritrea", "Eritrea");
        countriess.put("Estonia", "Estonia");
        countriess.put("Ethiopia", "Ethiopia");
        countriess.put("Falkland Islands [Islas Malvinas]", "Falkland Islands [Islas Malvinas]");
        countriess.put("Faroe Islands", "Faroe Islands");
        countriess.put("Fiji", "Fiji");
        countriess.put("Finland", "Finland");
        countriess.put("France", "France");
        countriess.put("French Guiana", "French Guiana");
        countriess.put("French Polynesia", "French Polynesia");
        countriess.put("French Southern Territories", "French Southern Territories");
        countriess.put("Gabon", "Gabon");
        countriess.put("Gambia", "Gambia");
        countriess.put("Gaza Strip", "Gaza Strip");
        countriess.put("Georgia", "Georgia");
        countriess.put("Germany", "Germany");
        countriess.put("Ghana", "Ghana");
        countriess.put("Gibraltar", "Gibraltar");
        countriess.put("Greece", "Greece");
        countriess.put("Greenland", "Greenland");
        countriess.put("Grenada", "Grenada");
        countriess.put("Guadeloupe", "Guadeloupe");
        countriess.put("Guam", "Guam");
        countriess.put("Guatemala", "Guatemala");
        countriess.put("Guernsey", "Guernsey");
        countriess.put("Guinea", "Guinea");
        countriess.put("Guinea-Bissau", "Guinea-Bissau");
        countriess.put("Guyana", "Guyana");
        countriess.put("Haiti", "Haiti");
        countriess.put("Heard Island and McDonald Islands", "Heard Island and McDonald Islands");
        countriess.put("Honduras", "Honduras");
        countriess.put("Hong Kong", "Hong Kong");
        countriess.put("Hungary", "Hungary");
        countriess.put("Iceland", "Iceland");
        countriess.put("India", "India");
        countriess.put("Indonesia", "Indonesia");
        countriess.put("Iran", "Iran");
        countriess.put("Iraq", "Iraq");
        countriess.put("Ireland", "Ireland");
        countriess.put("Isle of Man", "Isle of Man");
        countriess.put("Israel", "Israel");
        countriess.put("Italy", "Italy");
        countriess.put("Jamaica", "Jamaica");
        countriess.put("Japan", "Japan");
        countriess.put("Jersey", "Jersey");
        countriess.put("Jordan", "Jordan");
        countriess.put("Kazakhstan", "Kazakhstan");
        countriess.put("Kenya", "Kenya");
        countriess.put("Kiribati", "Kiribati");
        countriess.put("Kosovo", "Kosovo");
        countriess.put("Kuwait", "Kuwait");
        countriess.put("Kyrgyzstan", "Kyrgyzstan");
        countriess.put("Laos", "Laos");
        countriess.put("Latvia", "Latvia");
        countriess.put("Lebanon", "Lebanon");
        countriess.put("Lesotho", "Lesotho");
        countriess.put("Liberia", "Liberia");
        countriess.put("Libya", "Libya");
        countriess.put("Liechtenstein", "Liechtenstein");
        countriess.put("Lithuania", "Lithuania");
        countriess.put("Luxembourg", "Luxembourg");
        countriess.put("Macau", "Macau");
        countriess.put("Macedonia [FYROM]", "Macedonia [FYROM]");
        countriess.put("Madagascar", "Madagascar");
        countriess.put("Malawi", "Malawi");
        countriess.put("Malaysia", "Malaysia");
        countriess.put("Maldives", "Maldives");
        countriess.put("Mali", "Mali");
        countriess.put("Malta", "Malta");
        countriess.put("Marshall Islands", "Marshall Islands");
        countriess.put("Martinique", "Martinique");
        countriess.put("Mauritania", "Mauritania");
        countriess.put("Mauritius", "Mauritius");
        countriess.put("Mayotte", "Mayotte");
        countriess.put("Mexico", "Mexico");
        countriess.put("Micronesia", "Micronesia");
        countriess.put("Moldova", "Moldova");
        countriess.put("Monaco", "Monaco");
        countriess.put("Mongolia", "Mongolia");
        countriess.put("Montenegro", "Montenegro");
        countriess.put("Montserrat", "Montserrat");
        countriess.put("Morocco", "Morocco");
        countriess.put("Mozambique", "Mozambique");
        countriess.put("Myanmar [Burma]", "Myanmar [Burma]");
        countriess.put("Namibia", "Namibia");
        countriess.put("Nauru", "Nauru");
        countriess.put("Nepal", "Nepal");
        countriess.put("Netherlands", "Netherlands");
        countriess.put("Netherlands Antilles", "Netherlands Antilles");
        countriess.put("New Caledonia", "New Caledonia");
        countriess.put("New Zealand", "New Zealand");
        countriess.put("Nicaragua", "Nicaragua");
        countriess.put("Niger", "Niger");
        countriess.put("Nigeria", "Nigeria");
        countriess.put("Niue", "Niue");
        countriess.put("Norfolk Island", "Norfolk Island");
        countriess.put("North Korea", "North Korea");
        countriess.put("Northern Mariana Islands", "Northern Mariana Islands");
        countriess.put("Norway", "Norway");
        countriess.put("Oman", "Oman");
        countriess.put("Pakistan", "Pakistan");
        countriess.put("Palau", "Palau");
        countriess.put("Palestinian Territories", "Palestinian Territories");
        countriess.put("Panama", "Panama");
        countriess.put("Papua New Guinea", "Papua New Guinea");
        countriess.put("Paraguay", "Paraguay");
        countriess.put("Peru", "Peru");
        countriess.put("Philippines", "Philippines");
        countriess.put("Pitcairn Islands", "Pitcairn Islands");
        countriess.put("Poland", "Poland");
        countriess.put("Portugal", "Portugal");
        countriess.put("Puerto Rico", "Puerto Rico");
        countriess.put("Qatar", "Qatar");
        countriess.put("Réunion", "Réunion");
        countriess.put("Romania", "Romania");
        countriess.put("Russia", "Russia");
        countriess.put("Rwanda", "Rwanda");
        countriess.put("Saint Helena", "Saint Helena");
        countriess.put("Saint Kitts and Nevis", "Saint Kitts and Nevis");
        countriess.put("Saint Lucia", "Saint Lucia");
        countriess.put("Saint Pierre and Miquelon", "Saint Pierre and Miquelon");
        countriess.put("Saint Vincent and the Grenadines", "Saint Vincent and the Grenadines");
        countriess.put("Samoa", "Samoa");
        countriess.put("San Marino", "San Marino");
        countriess.put("São Tomé and Príncipe", "São Tomé and Príncipe");
        countriess.put("Saudi Arabia", "Saudi Arabia");
        countriess.put("Senegal", "Senegal");
        countriess.put("Serbia", "Serbia");
        countriess.put("Seychelles", "Seychelles");
        countriess.put("Sierra Leone", "Sierra Leone");
        countriess.put("Singapore", "Singapore");
        countriess.put("Slovakia", "Slovakia");
        countriess.put("Slovenia", "Slovenia");
        countriess.put("Solomon Islands", "Solomon Islands");
        countriess.put("Somalia", "Somalia");
        countriess.put("South Africa", "South Africa");
        countriess.put("South Georgia and the South Sandwich Islands", "South Georgia and the South Sandwich Islands");
        countriess.put("South Korea", "South Korea");
        countriess.put("Spain", "Spain");
        countriess.put("Sri Lanka", "Sri Lanka");
        countriess.put("Sudan", "Sudan");
        countriess.put("Suriname", "Suriname");
        countriess.put("Svalbard and Jan Mayen", "Svalbard and Jan Mayen");
        countriess.put("Swaziland", "Swaziland");
        countriess.put("Sweden", "Sweden");
        countriess.put("Switzerland", "Switzerland");
        countriess.put("Syria", "Syria");
        countriess.put("Taiwan", "Taiwan");
        countriess.put("Tajikistan", "Tajikistan");
        countriess.put("Tanzania", "Tanzania");
        countriess.put("Thailand", "Thailand");
        countriess.put("Timor-Leste", "Timor-Leste");
        countriess.put("Togo", "Togo");
        countriess.put("Tokelau", "Tokelau");
        countriess.put("Tonga", "Tonga");
        countriess.put("Trinidad and Tobago", "Trinidad and Tobago");
        countriess.put("Tunisia", "Tunisia");
        countriess.put("Turkey", "Turkey");
        countriess.put("Turkmenistan", "Turkmenistan");
        countriess.put("Turks and Caicos Islands", "Turks and Caicos Islands");
        countriess.put("Tuvalu", "Tuvalu");
        countriess.put("U.S. Minor Outlying Islands", "U.S. Minor Outlying Islands");
        countriess.put("U.S. Virgin Islands", "U.S. Virgin Islands");
        countriess.put("Uganda", "Uganda");
        countriess.put("Ukraine", "Ukraine");
        countriess.put("United Arab Emirates", "United Arab Emirates");
        countriess.put("United Kingdom", "United Kingdom");
        countriess.put("United States", "United States");
        countriess.put("Uruguay", "Uruguay");
        countriess.put("Uzbekistan", "Uzbekistan");
        countriess.put("Vanuatu", "Vanuatu");
        countriess.put("Vatican City", "Vatican City");
        countriess.put("Venezuela", "Venezuela");
        countriess.put("Vietnam", "Vietnam");
        countriess.put("Wallis and Futuna", "Wallis and Futuna");
        countriess.put("Western Sahara", "Western Sahara");
        countriess.put("Yemen", "Yemen");
        countriess.put("Zambia", "Zambia");
        countriess.put("Zimbabwe", "Zimbabwe");
        
        
        countries.addAll(countriess.values());
        Collections.sort(countries);
        
    }

    public Map<String, String> getCountriess() {
        return countriess;
    }

    public void setCountriess(Map<String, String> countriess) {
        this.countriess = countriess;
    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    
    

}
