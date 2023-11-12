/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp2;

/**
 * uzun süren işlemlerde thread kullanmak iyi değil, asenkron veyahut paralel
 * programlama daha iyi
 *
 * @author yesil
 */
public class Starvation2 extends Thread {

    public Starvation2() {
    }

    public Starvation2(int priority) {
        setPriority(priority);
    }

    @Override
    public void run() {
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
        }
        System.out.println("NAME    :" + getName());
    }
}
