

package boundary;


import controller.FileUploadEJB;
import entities.user.FileUpload;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



import javax.inject.Named;
import javax.servlet.http.Part;

@Named
@ManagedBean(name="fileUploadMB")
@SessionScoped
public class FileUploadMB {
    
    private Part uploadedFile;
    private FileUpload file=new FileUpload();
     @EJB
    private FileUploadEJB uploadEJB;

    public Part getUploadedFile() {
        return uploadedFile;
    }

    public void setUploadedFile(Part uploadedFile) {
        this.uploadedFile = uploadedFile;
    }
    
     
    //call EJB to persist to the database
    public String fileEntity() throws IOException{
        this.fileName();
        this.getFileContent();
        System.out.println(file.getFileName());
         String s = new String(file.getContent());
       System.out.println("File content: " + s);
        //pass the file entity to the EJB
       return uploadEJB.fileToDB(file);
        
    
    }
    //this.getFile().setFileName(getFileName(uploadedFile));
    public void fileName(){
          if(null!=uploadedFile){
        String fileName=getFileName(uploadedFile);
        System.out.println(fileName);
        file.setFileName(fileName);
          }
    
    }
    //extract content and store in the content filed of entity calss to persist
    public void getFileContent() throws IOException{
        
    InputStream inputStream;
    if(null!=uploadedFile){
    inputStream=uploadedFile.getInputStream();//it gets the path
    byte[] bytes=new byte[2097152];//size is maximum file length
    //read in to the byte array created above from the inputStream, uploadedFile
    inputStream.read(bytes);
    //assign to the content field of entity class
    file.setContent(bytes);
    
     //create string from byte array
      String s = new String(bytes);
      System.out.println("File content: " + s);
    }
    
    }
   
   // Extract file name from content-disposition header of file part
    public String getFileName(Part part) {
        final String partHeader = part.getHeader("content-disposition");
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim()
                        .replace("\"", "");
            }
        }
        return "";
    } 
   public FileUpload getFile() {
        return file;
    }

    public void setFile(FileUpload file) {
        this.file = file;
    }
    
    public String getFileText() {
        String text = "";

        if (null != uploadedFile) {
            try {
                InputStream is = uploadedFile.getInputStream();
                text = new Scanner( is ).useDelimiter("\\A").next();
            } catch (IOException ex) {
                
            }
        }
        return text;
    }

    String getFileEntity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
