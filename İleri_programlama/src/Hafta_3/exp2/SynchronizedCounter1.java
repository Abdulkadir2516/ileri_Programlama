/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp2;

/**
 * !Synchronized Counter with synchronized method.
 * @author recep
 */
public class SynchronizedCounter1 {

    private long c;

    public SynchronizedCounter1() {
        c = 0;
    }

    public synchronized void increment() {
        c++;
    }

    public synchronized void decrement() {
        c--;
    }

    public synchronized long value() {
        return c;
    }
}
