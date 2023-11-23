/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp2;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * md5 bak
 *
 * @author recep
 */
public class Program {

    public static void main(String[] args) {
        mutableObject();
        //immutableObject();
    }
    //ikisinin de true dönmesi gerekiyor
    private static void mutableObject() {
        MutableCryptographicHash mch;
        try {
            mch = new MutableCryptographicHash("Bilgisayar Mühendisliği");
            //mch = new MutableCryptographicHash("a");
        } catch (NoSuchAlgorithmException ex) {
            return;
        }

        new Thread(() -> {
            try {
                System.out.println("1- " + mch.isTrue("ba4d3296aef7001e6d79e429202358e5"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

        new Thread(() -> {
            mch.setInput("Balıkesir Üniversitesi");
            try {
                System.out.println("2- " + mch.isTrue("51bc9c1d3fb93a560ddb37e15d84220a"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }
    
    //true dönmesi gerekiyor ikisininde 
    private static void immutableObject() {
        ImmutableCryptographicHash ich;
        try {
            ich = new ImmutableCryptographicHash();
        } catch (NoSuchAlgorithmException ex) {
            return;
        }

        new Thread(() -> {
            try {
                System.out.println("1- " + ich.isTrue("Bilgisayar Mühendisliği", "ba4d3296aef7001e6d79e429202358e5"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("2- " + ich.isTrue("Balıkesir Üniversitesi","51bc9c1d3fb93a560ddb37e15d84220a"));
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
            }
        }).start();
    }

}
