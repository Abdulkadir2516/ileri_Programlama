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
public class ImmutableCryptographicHash {

    private final MessageDigest md;

    public ImmutableCryptographicHash(String input) throws NoSuchAlgorithmException {
        md = MessageDigest.getInstance("md5");
    }

    public String digest(String input) {
        byte[] digest = md.digest(input.getBytes());

        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            sb.append(String.format("%02X", b));
        }
        return sb.toString();

    }

    public boolean isTrue(String input, String md5) {
        return digest(input).equals(md5.toUpperCase());

    }

}
