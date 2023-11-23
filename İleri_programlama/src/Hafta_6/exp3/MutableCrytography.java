/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp3;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author recep
 */
public class MutableCrytography {

    private String message;
    private String key;
    private String cipherText;
    private final Cipher cipher;
    private final Key secretKey;

    public MutableCrytography(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.message = message;
        this.key = key;
        secretKey = getKey(key);
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String encrypt() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] cipherBytes = cipher.doFinal(message.getBytes());
        return cipherText = Base64.getEncoder().encodeToString(cipherBytes);
    }

    public String decrypt() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] plainBytes = cipher.doFinal(Base64.getDecoder().decode(cipherText));
        return new String(plainBytes);
    }

    public static Key getKey(String key) {
        double len = 24;
        int newSize = (int) (Math.ceil(key.getBytes().length / len) * len);
        byte[] keyBytes = Arrays.copyOf(key.getBytes(), newSize);
        return new SecretKeySpec(keyBytes, "AES");
    }
}