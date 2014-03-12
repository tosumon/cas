/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 *
 * @author atinkut
 */
public class HashAndSalting {
    public static String get_SHA_1_SecurePassword(String passwordToHash, String salt)throws  NoSuchAlgorithmException
    {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            md.update(salt.getBytes());
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< bytes.length ;i++)
            {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } 
        catch (NoSuchAlgorithmException e) 
        {
            e.printStackTrace();
        }
        return generatedPassword;
         //Add salt
    
    }
    public static String getSalt() throws NoSuchAlgorithmException
    {
        //SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
       // byte[] salt = new byte[16];
        //sr.nextBytes(salt);
        String salt="gdisu#@7iao";
        return salt;
    }
    }
    
    

