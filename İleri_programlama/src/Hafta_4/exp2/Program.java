/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp2;

import java.math.BigInteger;
import java.util.Random;

/**
 * bir thread ile baloncuk oluştur, her thread bir baloncuk oluşturup ekranın
 * üstüne çıksın ve ekranın sonuna geldiğinde son bulsun
 *
 * @author yesil
 */
public class Program {

    public static void main(String[] args) {
        //starvation1();
        starvation2();
    }

    private static void starvation1() {
        Starvation1[] starvations = new Starvation1[10];
        Random rnd = new Random();

        for (int i = 0; i < starvations.length; i++) {
            starvations[i] = new Starvation1(BigInteger.probablePrime(80, rnd), BigInteger.probablePrime(80, rnd)); //2 üzeri 80
            starvations[i].start();
        }
    }

    private static void starvation2() {
        Starvation2[] starvations = new Starvation2[10];

        for (int i = 0; i < starvations.length; i++) {
            starvations[i] = new Starvation2(i + 1);
        }

        for (Starvation2 starvation : starvations) {
            starvation.start();
        }

    }

}
