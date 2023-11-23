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
public class ImmutableCrytography {

    private String message;
    private String key;
    private Cipher cipher;

    public ImmutableCrytography() {
        message = key = null;
    }

    public ImmutableCrytography(String message, String key) throws NoSuchAlgorithmException, NoSuchPaddingException {
        this.message = message;
        this.key = key;
        cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
    }

    public String encrypt(String message, String key) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, NoSuchPaddingException {
        cipher.init(Cipher.ENCRYPT_MODE, getKey(key));
        byte[] cipherBytes = cipher.doFinal(message.getBytes());
        return Base64.getEncoder().encodeToString(cipherBytes);
    }

    public String decrypt(String cipherText, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        ImmutableCrytography im = new ImmutableCrytography(cipherText, key);
        return im.decrypt();
    }

    public String decrypt() throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        cipher.init(Cipher.DECRYPT_MODE, getKey(key));
        byte[] plainBytes = cipher.doFinal(Base64.getDecoder().decode(message));
        return new String(plainBytes);
    }

    public static Key getKey(String key) {
        double len = 24;
        int newSize = (int) (Math.ceil(key.getBytes().length / len) * len);
        byte[] keyBytes = Arrays.copyOf(key.getBytes(), newSize);
        return new SecretKeySpec(keyBytes, "AES");
    }
}