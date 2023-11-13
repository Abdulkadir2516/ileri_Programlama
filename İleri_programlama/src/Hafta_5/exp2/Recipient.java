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
public class Recipient implements Runnable {

    private final Courier courier;

    public Recipient(Courier courier) {
        this.courier = courier;
    }
    
    @Override
    public void run(){
        Random random = new Random();
        String str = courier.take();
        for(; !str.equals("DONE"); str= courier.take()){
            System.out.format("MESSAGE RECEIVED: %s%n", str);
            try{
                Thread.sleep(random.nextInt(3000));
            } catch(InterruptedException e) {}
        }
        System.out.format("MESSAGE RECEIVED: %s%n", str);
    }
}
