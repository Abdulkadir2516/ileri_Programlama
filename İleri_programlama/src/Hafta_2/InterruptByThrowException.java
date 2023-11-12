/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_2;
import java.util.Random;

/**
 *
 * @author recep
 */
public class InterruptByThrowException extends Thread {
    private final Random rnd;
    private long startTime;
    
    public InterruptByThrowException(){
        rnd = new Random();
    }
    
    @Override
    public void run(){
        startTime = System.nanoTime();
        long sleepTime = rnd.nextInt(10000) + 1;
        System.out.println(this.getName() + ": " + sleepTime + " ms");
        try{
            Thread.sleep(sleepTime);
        }
        catch(InterruptedException ex){
            throw new RuntimeException();
        }
    }
    
    public double elapsedTime(){
        return (System.nanoTime() - startTime) / 100000.0;
    }
}
