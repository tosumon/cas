/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author atinkut
 */
public class SendEmail {
     
  Properties emailProperties;
  Session mailSession;
  MimeMessage emailMessage;
 
 /* public static void main(String args[]) throws AddressException,
      MessagingException {
 
    SendEmail javaEmail = new SendEmail();
 
    javaEmail.setMailServerProperties();
    javaEmail.createEmailMessage();
    javaEmail.sendEmail();
  }*/
 
  public void setMailServerProperties() {
 
    String emailPort = "587";//gmail's smtp port
 
    emailProperties = System.getProperties();
    emailProperties.put("mail.smtp.port", emailPort);
    emailProperties.put("mail.smtp.auth", "true");
    emailProperties.put("mail.smtp.starttls.enable", "true");
 
  }
 
  public void createEmailMessage(String username, String password) throws AddressException,
      MessagingException {
    this.setMailServerProperties();
    
    String[] toEmails = { username };//username is email
    String emailSubject = "Compro Registration System";
    String emailBody = "This is an email sent by <b>MUM Compro Registration System</b>.<p>Dear applicant,</p> <p>Use the following credentials for login</p>  <p><b>username:</b>" +username+"</p> <p><b>password:</b>" +password+"</p";
 
    mailSession = Session.getDefaultInstance(emailProperties, null);
    emailMessage = new MimeMessage(mailSession);
 
    for (int i = 0; i < toEmails.length; i++) {
      emailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmails[i]));
    }
 
    emailMessage.setSubject(emailSubject);
    emailMessage.setContent(emailBody, "text/html");//for a html email
    //emailMessage.setText(emailBody);// for a text email
    this.sendEmail();
 
  }
 
  public void sendEmail() throws AddressException, MessagingException {
 
    String emailHost = "smtp.gmail.com";
    String fromUser = "atinkut.demessie";//just the id alone without @gmail.com
    String fromUserEmailPassword = "";
 
    Transport transport = mailSession.getTransport("smtp");
 
    transport.connect(emailHost, fromUser, fromUserEmailPassword);
    transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
    transport.close();
    System.out.println("Email sent successfully.");
  }
    
}

