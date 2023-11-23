/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp3;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author recep
 */
public class Program {

    public static void main(String[] args) {
        mutableObject();
    }

    private static void mutableObject() {
        try {
            MutableCrytography mc = new MutableCrytography("Bilgisayar Mühendisliği", "Balıkesir Üniversitesi");

            new Thread(() -> {
                System.out.println("1-Message      : " + mc.getMessage());
                System.out.println("1-Key          : " + mc.getKey()); //balıkesir üni yazmalı fakat Mühendislik Fakültesi yazıyor
                try {
                    String cipherText = mc.encrypt();
                    System.out.println("1-Cipher Text    : " + cipherText);

                    String plainText = mc.decrypt();
                    System.out.println("1-Plain Text     : " + plainText);
                } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    System.out.println("1-Exception during encryption/decryption: " + ex);
                }
            }).start();

            new Thread(() -> {
                mc.setMessage("Yazılım Mühendisliği");
                mc.setKey("Mühendislik Fakültesi");
                System.out.println("2-Message      : " + mc.getMessage());
                System.out.println("2-Key          : " + mc.getKey());
                try {
                    String cipherText = mc.encrypt();
                    System.out.println("2-Cipher Text    : " + cipherText);

                    String plainText = mc.decrypt();
                    System.out.println("2-Plain Text     : " + plainText);
                } catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException ex) {
                    System.out.println("2-Exception during encryption/decryption: " + ex);
                }
            }).start();
        } catch (NoSuchAlgorithmException | NoSuchPaddingException ex) {
            System.out.println(ex);
        }
    }
}