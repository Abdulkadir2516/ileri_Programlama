package Hafta_2.Fibonacci;

import java.util.Random;

public class NewClass1 {

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
