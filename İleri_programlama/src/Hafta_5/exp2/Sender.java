/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_5.exp2;

import java.util.Random;

/**
 *
 * @author recep
 */
public class Sender implements Runnable {

    private final Courier courier;
    private final String[] packages;

    public Sender(Courier courier, String[] packages) {
        this.courier = courier;
        this.packages = packages;
    }

    @Override
    public void run() {
        Random random = new Random();

        for (String p : packages) {
            courier.pickUp(p);
            try {
                Thread.sleep(random.nextInt(3000));
            } catch (InterruptedException e) {
            }

        }
        courier.pickUp("DONE");
    }
}
