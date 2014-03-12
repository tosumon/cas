/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;
import java.util.HashMap;
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

    private Map<String, String> countries = new HashMap<String, String>();

    public CountryList() {
        countries.put("Afghanistan", "Afghanistan");
        countries.put("Albania", "Albania");
        countries.put("Algeria", "Algeria");
        countries.put("American Samoa", "American Samoa");
        countries.put("Andorra", "Andorra");
        countries.put("Angola", "Angola");
        countries.put("Anguilla", "Anguilla");
        countries.put("Antarctica", "Antarctica");
        countries.put("Antigua and Barbuda", "Antigua and Barbuda");
        countries.put("Argentina", "Argentina");
        countries.put("Armenia", "Armenia");
        countries.put("Aruba", "Aruba");
        countries.put("Australia", "Australia");
        countries.put("Austria", "Austria");
        countries.put("Azerbaijan", "Azerbaijan");
        countries.put("Bahamas", "Bahamas");
        countries.put("Bahrain", "Bahrain");
        countries.put("Bangladesh", "Bangladesh");
        countries.put("Barbados", "Barbados");
        countries.put("Belarus", "Belarus");
        countries.put("Belgium", "Belgium");
        countries.put("Belize", "Belize");
        countries.put("Benin", "Benin");
        countries.put("Bermuda", "Bermuda");
        countries.put("Bhutan", "Bhutan");
        countries.put("Bolivia", "Bolivia");
        countries.put("Bosnia and Herzegovina", "Bosnia and Herzegovina");
        countries.put("Botswana", "Botswana");
        countries.put("Bouvet Island", "Bouvet Island");
        countries.put("Brazil", "Brazil");
        countries.put("British Indian Ocean Territory", "British Indian Ocean Territory");
        countries.put("British Virgin Islands", "British Virgin Islands");
        countries.put("Brunei", "Brunei");
        countries.put("Bulgaria", "Bulgaria");
        countries.put("Burkina Faso", "Burkina Faso");
        countries.put("Burundi", "Burundi");
        countries.put("Cambodia", "Cambodia");
        countries.put("Cameroon", "Cameroon");
        countries.put("Canada", "Canada");
        countries.put("Cape Verde", "Cape Verde");
        countries.put("Cayman Islands", "Cayman Islands");
        countries.put("Central African Republic", "Central African Republic");
        countries.put("Chad", "Chad");
        countries.put("Chile", "Chile");
        countries.put("China", "China");
        countries.put("Christmas Island", "Christmas Island");
        countries.put("Cocos [Keeling] Islands", "Cocos [Keeling] Islands");
        countries.put("Colombia", "Colombia");
        countries.put("Comoros", "Comoros");
        countries.put("Congo [DRC]", "Congo [DRC]");
        countries.put("Congo [Republic]", "Congo [Republic]");
        countries.put("Cook Islands", "Cook Islands");
        countries.put("Costa Rica", "Costa Rica");
        countries.put("Côte d'Ivoire", "Côte d'Ivoire");
        countries.put("Croatia", "Croatia");
        countries.put("Cuba", "Cuba");
        countries.put("Cyprus", "Cyprus");
        countries.put("Czech Republic", "Czech Republic");
        countries.put("Denmark", "Denmark");
        countries.put("Djibouti", "Djibouti");
        countries.put("Dominica", "Dominica");
        countries.put("Dominican Republic", "Dominican Republic");
        countries.put("Ecuador", "Ecuador");
        countries.put("Egypt", "Egypt");
        countries.put("El Salvador", "El Salvador");
        countries.put("Equatorial Guinea", "Equatorial Guinea");
        countries.put("Eritrea", "Eritrea");
        countries.put("Estonia", "Estonia");
        countries.put("Ethiopia", "Ethiopia");
        countries.put("Falkland Islands [Islas Malvinas]", "Falkland Islands [Islas Malvinas]");
        countries.put("Faroe Islands", "Faroe Islands");
        countries.put("Fiji", "Fiji");
        countries.put("Finland", "Finland");
        countries.put("France", "France");
        countries.put("French Guiana", "French Guiana");
        countries.put("French Polynesia", "French Polynesia");
        countries.put("French Southern Territories", "French Southern Territories");
        countries.put("Gabon", "Gabon");
        countries.put("Gambia", "Gambia");
        countries.put("Gaza Strip", "Gaza Strip");
        countries.put("Georgia", "Georgia");
        countries.put("Germany", "Germany");
        countries.put("Ghana", "Ghana");
        countries.put("Gibraltar", "Gibraltar");
        countries.put("Greece", "Greece");
        countries.put("Greenland", "Greenland");
        countries.put("Grenada", "Grenada");
        countries.put("Guadeloupe", "Guadeloupe");
        countries.put("Guam", "Guam");
        countries.put("Guatemala", "Guatemala");
        countries.put("Guernsey", "Guernsey");
        countries.put("Guinea", "Guinea");
        countries.put("Guinea-Bissau", "Guinea-Bissau");
        countries.put("Guyana", "Guyana");
        countries.put("Haiti", "Haiti");
        countries.put("Heard Island and McDonald Islands", "Heard Island and McDonald Islands");
        countries.put("Honduras", "Honduras");
        countries.put("Hong Kong", "Hong Kong");
        countries.put("Hungary", "Hungary");
        countries.put("Iceland", "Iceland");
        countries.put("India", "India");
        countries.put("Indonesia", "Indonesia");
        countries.put("Iran", "Iran");
        countries.put("Iraq", "Iraq");
        countries.put("Ireland", "Ireland");
        countries.put("Isle of Man", "Isle of Man");
        countries.put("Israel", "Israel");
        countries.put("Italy", "Italy");
        countries.put("Jamaica", "Jamaica");
        countries.put("Japan", "Japan");
        countries.put("Jersey", "Jersey");
        countries.put("Jordan", "Jordan");
        countries.put("Kazakhstan", "Kazakhstan");
        countries.put("Kenya", "Kenya");
        countries.put("Kiribati", "Kiribati");
        countries.put("Kosovo", "Kosovo");
        countries.put("Kuwait", "Kuwait");
        countries.put("Kyrgyzstan", "Kyrgyzstan");
        countries.put("Laos", "Laos");
        countries.put("Latvia", "Latvia");
        countries.put("Lebanon", "Lebanon");
        countries.put("Lesotho", "Lesotho");
        countries.put("Liberia", "Liberia");
        countries.put("Libya", "Libya");
        countries.put("Liechtenstein", "Liechtenstein");
        countries.put("Lithuania", "Lithuania");
        countries.put("Luxembourg", "Luxembourg");
        countries.put("Macau", "Macau");
        countries.put("Macedonia [FYROM]", "Macedonia [FYROM]");
        countries.put("Madagascar", "Madagascar");
        countries.put("Malawi", "Malawi");
        countries.put("Malaysia", "Malaysia");
        countries.put("Maldives", "Maldives");
        countries.put("Mali", "Mali");
        countries.put("Malta", "Malta");
        countries.put("Marshall Islands", "Marshall Islands");
        countries.put("Martinique", "Martinique");
        countries.put("Mauritania", "Mauritania");
        countries.put("Mauritius", "Mauritius");
        countries.put("Mayotte", "Mayotte");
        countries.put("Mexico", "Mexico");
        countries.put("Micronesia", "Micronesia");
        countries.put("Moldova", "Moldova");
        countries.put("Monaco", "Monaco");
        countries.put("Mongolia", "Mongolia");
        countries.put("Montenegro", "Montenegro");
        countries.put("Montserrat", "Montserrat");
        countries.put("Morocco", "Morocco");
        countries.put("Mozambique", "Mozambique");
        countries.put("Myanmar [Burma]", "Myanmar [Burma]");
        countries.put("Namibia", "Namibia");
        countries.put("Nauru", "Nauru");
        countries.put("Nepal", "Nepal");
        countries.put("Netherlands", "Netherlands");
        countries.put("Netherlands Antilles", "Netherlands Antilles");
        countries.put("New Caledonia", "New Caledonia");
        countries.put("New Zealand", "New Zealand");
        countries.put("Nicaragua", "Nicaragua");
        countries.put("Niger", "Niger");
        countries.put("Nigeria", "Nigeria");
        countries.put("Niue", "Niue");
        countries.put("Norfolk Island", "Norfolk Island");
        countries.put("North Korea", "North Korea");
        countries.put("Northern Mariana Islands", "Northern Mariana Islands");
        countries.put("Norway", "Norway");
        countries.put("Oman", "Oman");
        countries.put("Pakistan", "Pakistan");
        countries.put("Palau", "Palau");
        countries.put("Palestinian Territories", "Palestinian Territories");
        countries.put("Panama", "Panama");
        countries.put("Papua New Guinea", "Papua New Guinea");
        countries.put("Paraguay", "Paraguay");
        countries.put("Peru", "Peru");
        countries.put("Philippines", "Philippines");
        countries.put("Pitcairn Islands", "Pitcairn Islands");
        countries.put("Poland", "Poland");
        countries.put("Portugal", "Portugal");
        countries.put("Puerto Rico", "Puerto Rico");
        countries.put("Qatar", "Qatar");
        countries.put("Réunion", "Réunion");
        countries.put("Romania", "Romania");
        countries.put("Russia", "Russia");
        countries.put("Rwanda", "Rwanda");
        countries.put("Saint Helena", "Saint Helena");
        countries.put("Saint Kitts and Nevis", "Saint Kitts and Nevis");
        countries.put("Saint Lucia", "Saint Lucia");
        countries.put("Saint Pierre and Miquelon", "Saint Pierre and Miquelon");
        countries.put("Saint Vincent and the Grenadines", "Saint Vincent and the Grenadines");
        countries.put("Samoa", "Samoa");
        countries.put("San Marino", "San Marino");
        countries.put("São Tomé and Príncipe", "São Tomé and Príncipe");
        countries.put("Saudi Arabia", "Saudi Arabia");
        countries.put("Senegal", "Senegal");
        countries.put("Serbia", "Serbia");
        countries.put("Seychelles", "Seychelles");
        countries.put("Sierra Leone", "Sierra Leone");
        countries.put("Singapore", "Singapore");
        countries.put("Slovakia", "Slovakia");
        countries.put("Slovenia", "Slovenia");
        countries.put("Solomon Islands", "Solomon Islands");
        countries.put("Somalia", "Somalia");
        countries.put("South Africa", "South Africa");
        countries.put("South Georgia and the South Sandwich Islands", "South Georgia and the South Sandwich Islands");
        countries.put("South Korea", "South Korea");
        countries.put("Spain", "Spain");
        countries.put("Sri Lanka", "Sri Lanka");
        countries.put("Sudan", "Sudan");
        countries.put("Suriname", "Suriname");
        countries.put("Svalbard and Jan Mayen", "Svalbard and Jan Mayen");
        countries.put("Swaziland", "Swaziland");
        countries.put("Sweden", "Sweden");
        countries.put("Switzerland", "Switzerland");
        countries.put("Syria", "Syria");
        countries.put("Taiwan", "Taiwan");
        countries.put("Tajikistan", "Tajikistan");
        countries.put("Tanzania", "Tanzania");
        countries.put("Thailand", "Thailand");
        countries.put("Timor-Leste", "Timor-Leste");
        countries.put("Togo", "Togo");
        countries.put("Tokelau", "Tokelau");
        countries.put("Tonga", "Tonga");
        countries.put("Trinidad and Tobago", "Trinidad and Tobago");
        countries.put("Tunisia", "Tunisia");
        countries.put("Turkey", "Turkey");
        countries.put("Turkmenistan", "Turkmenistan");
        countries.put("Turks and Caicos Islands", "Turks and Caicos Islands");
        countries.put("Tuvalu", "Tuvalu");
        countries.put("U.S. Minor Outlying Islands", "U.S. Minor Outlying Islands");
        countries.put("U.S. Virgin Islands", "U.S. Virgin Islands");
        countries.put("Uganda", "Uganda");
        countries.put("Ukraine", "Ukraine");
        countries.put("United Arab Emirates", "United Arab Emirates");
        countries.put("United Kingdom", "United Kingdom");
        countries.put("United States", "United States");
        countries.put("Uruguay", "Uruguay");
        countries.put("Uzbekistan", "Uzbekistan");
        countries.put("Vanuatu", "Vanuatu");
        countries.put("Vatican City", "Vatican City");
        countries.put("Venezuela", "Venezuela");
        countries.put("Vietnam", "Vietnam");
        countries.put("Wallis and Futuna", "Wallis and Futuna");
        countries.put("Western Sahara", "Western Sahara");
        countries.put("Yemen", "Yemen");
        countries.put("Zambia", "Zambia");
        countries.put("Zimbabwe", "Zimbabwe");
        
        
    }

    public Map<String, String> getCountries() {
        return countries;
    }

    public void setCountries(Map<String, String> countries) {
        this.countries = countries;
    }

    

}
