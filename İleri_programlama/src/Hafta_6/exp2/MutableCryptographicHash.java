/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author abdul
 */
public class MutableCryptographicHash {

    private String input;
    private final MessageDigest md;

    public MutableCryptographicHash(String input) throws NoSuchAlgorithmException {
        this.input = input;
        md = MessageDigest.getInstance("md5");
    }

    public String getInput() {
        return input;

    }

    public void setInput(String input) {
        this.input = input;
    }

    public String digest() {
        byte[] digest = md.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();

    }

    public boolean isTrue(String md5) {
        return digest().equals(md5.toUpperCase());
    }

}
