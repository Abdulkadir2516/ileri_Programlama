/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_1;

/**
 *
 * @author yesil
 */
class RecursiveFactorial {
    public static long factorial(int number) {
        if (number > 1) {
            return recursiveN(1, number);
        }
        return 1;
    }

    private static long recursiveN(long n, int len) {
        if (len > 1) {
            int i = len / 2;
            return recursiveN(n, i) * recursiveN(n + i, len - i);
        }
        return n;
    }
}
