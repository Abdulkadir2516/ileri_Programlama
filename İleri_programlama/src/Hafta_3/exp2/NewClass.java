/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp2;

import java.util.BitSet;

/**
 * * Synchronized join() method
 *
 * @author recep sanal bilgisayarlarda thread kullanımı AtomicLong AtomicInteger
 * AtomicBoolean wait() - notify() - notifyAll()
 * @author recep
 */

/*
Senkronizasyon, aynı anda birden fazla iş parçacığının paylaşılan kaynaklara 
erişimini düzenlemek ve senkronize etmek için kullanılan bir mekanizmadır.
synchronized anahtar kelimesi veya blokları, kritik bölgelerin kilitlemesi ve 
yalnızca bir iş parçacığının bu bölgeye erişmesine izin verir. 
Diğer iş parçacıkları bu bölgeye girmeye çalışırken bekler.
 */
public class NewClass {

    public static void main(String[] args) {
        Thread[] thread = new Thread[5];
        SynchronizedCounter1 c = new SynchronizedCounter1();
        //SynchronizedCounter2 c = new SynchronizedCounter2(); 
        //SynchronizedCounter3 c = new SynchronizedCounter3(); 
        //Counter c = new Counter();

        for (int i = 0; i < thread.length; i++) {
            thread[i] = new Thread(() -> {
                for (int k = 0; k < 100000; k++) {
                    c.increment();
                }
            });
            thread[i].start();
        }

        BitSet allAlive = new BitSet(thread.length);
        allAlive.set(0, thread.length, true);
        while (allAlive.cardinality() > 0) {
            for (int i = 0; i < thread.length; i++) {
                if (!thread[i].isAlive()) {
                    allAlive.set(i, false);
                }
            }
        }

        System.out.println("Value: " + c.value());

    }
}
