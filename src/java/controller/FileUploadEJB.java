/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;


import boundary.FileUploadFacade;
import entities.user.FileUpload;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.Part;

/**
 *
 * @author atinkut
 */
@Stateless
public class FileUploadEJB {
    @EJB
    private FileUploadFacade fileFacade;

   public String fileToDB(FileUpload file){
   fileFacade.create(file);
   return "/uploadFile/file_success";
   }
}
