/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp2;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author abdul
 */
public class Program {
     
    public static void main(String[] args)
    {
        //immutableObject();
        mutableObject();
        
    }

    public static void mutableObject() {
        MutableCryptographicHash mch;
        
        try {
            mch = new MutableCryptographicHash("Bilgisayar Mühendisliği");

        } catch (NoSuchAlgorithmException e) {
            return;
        }
        
        new Thread(() -> {
            System.out.println("1- " + mch.toString());
            System.out.println("1- " + mch.isTrue("ba4d3296aef7001e6d79e429202358e5"));

        }).start();
            
        new Thread(() -> {
            mch.setInput("Balıkesir Üniversitesi");
            System.out.println("2- " + mch.toString());
            System.out.println("2- " + mch.isTrue("ba4d3296aef7001e6d79e429202358e5"));

        }).start();

       
    }

    public static void ImmutableObject() {
        ImmutableCryptographicHash ich;
        
        try {
            ich = new ImmutableCryptographicHash("Bilgisayar Mühendisliği");

        } catch (NoSuchAlgorithmException e) {
            return;
        }
        
        new Thread(() -> {
            System.out.println("1- " + ich.toString());
            System.out.println("1- " + ich.isTrue("Balıkesir Üniversitesi","ba4d3296aef7001e6d79e429202358e5"));

        }).start();
            
        new Thread(() -> {
            System.out.println("2- " + ich.toString());
            System.out.println("2- " + ich.isTrue("Balıkesir Üniversitesi","ba4d3296aef7001e6d79e429202358e5"));

        }).start();

       
    }

}
