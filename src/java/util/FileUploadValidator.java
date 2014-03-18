/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author atinkut
 */
@FacesValidator("FileUploadValidator")
public class FileUploadValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        Part file= (Part)value;
        
        //validate file name length
       String fileName = getFileName(file);
        if(fileName.length() == 0 ) {
            FacesMessage message = new FacesMessage("Error: File name is invalid !!");
            throw new ValidatorException(message);
        } else if (fileName.length() > 50) {
            FacesMessage message = new FacesMessage("Error: File name is too long !!");
            throw new ValidatorException(message);
        }
       
        //validate file type, only text files are allowed
        if (!"application/pdf".equals(file.getContentType())) {
            FacesMessage message = new FacesMessage("Error: File type is invalid !!");
            throw new ValidatorException(message);
          }
        
        //validate size of file, only 2Mb are allowed
         if (file.getSize() > 2*1024*1024) {
            FacesMessage message = new FacesMessage("Error: File size is too big !!");
            throw new ValidatorException(message);
        }
    
    }
     // Extract file name from content-disposition header of file part
    public static String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "";
    }
    
}
