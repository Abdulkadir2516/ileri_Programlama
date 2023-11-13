/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp2;

/**
 *
 * @author recep
 */
public class SynchronizedCounter2 {

    private long c;
    private final Object lock = new Object();

    public SynchronizedCounter2() {
        c = 0;
    }

    public void increment() {
        synchronized (lock) {
            c++;
        }
    }

    public void decrement() {
        synchronized (lock) {
            c--;
        }
    }

    public long value() {
        synchronized (lock) {
            return c;
        }
    }

    public long getCount() {
        synchronized (this) {
            return c;
        }
    }
}
