/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_2.Fibonacci;

import java.util.Random;

/**
 *
 * @author recep random bir sayi üret ve bu sayi kadar fibonacci terimi bul
 * sonra bunları interrupt'lar ile öldür. "java threadleri kullanarak önce 5
 * adet random sayi üret ve gelen sayılari seçerek bu sayı kadar fibonacci
 * terimi bul ve bunları interrupt kullanarak sonlandır" Kurucu metot ile random
 * sayiyi gönder
 */

/*
Fibonacci dizisinin 10. terimi şu şekildedir:
0, 1, 1, 2, 3, 5, 8, 13, 21, 34
Yani 10. terim, 34'tür.
 */

public class NewClass {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int randomNum = getRandomNumber();
            System.out.println("Random number: " + randomNum);
            FibonacciCalculator calculator = new FibonacciCalculator(randomNum);
            Thread thread = new Thread(calculator);
            thread.start();
        }
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(10) + 1; // 1 ila 10 arasında rastgele bir sayı üret
    }

    static class FibonacciCalculator implements Runnable {

        private final int n;

        public FibonacciCalculator(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            long fib1 = 0;
            long fib2 = 1;
            long fibN = 0;

            for (int i = 0; i < n; i++) {
                if (Thread.interrupted()) {
                    System.out.println("Calculation interrupted for n = " + n);
                    return;
                }

                if (i <= 1) {
                    fibN = i;
                } else {
                    fibN = fib1 + fib2;
                    fib1 = fib2;
                    fib2 = fibN;
                }
            }

            System.out.println("Fibonacci(" + n + ") = " + fibN);
        }
    }
}
