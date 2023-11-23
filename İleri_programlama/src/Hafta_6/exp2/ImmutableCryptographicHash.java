/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
//import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author recep
 */
public class ImmutableCryptographicHash {

    //private final MessageDigest md;
    public ImmutableCryptographicHash() throws NoSuchAlgorithmException {

    }

    public String digest(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02X", b));
        }
        System.out.println("sb: " + sb.toString());
        return sb.toString();
    }

    public boolean isTrue(String input, String md5) throws NoSuchAlgorithmException {
        return digest(input).equals(md5.toUpperCase());
    }

}
