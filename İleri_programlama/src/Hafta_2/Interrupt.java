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
public class Interrupt extends Thread {
    private final Random rnd;
    private long startTime;
    
    public Interrupt(){
        setDaemon(true);
        rnd = new Random();
    }
    
    @Override
    @SuppressWarnings("empty-statement")
    public void run(){
        startTime = System.nanoTime();
        long limit = rnd.nextLong();
        System.out.println(this.getName() + ": " + limit + " times");
        
        for(long i=0; i <= limit; i++);
                
        System.out.println(this.getName() + " is completed");
    }
    
    public double elapsedTime(){
        return(System.nanoTime() - startTime) / 10000.0;
    }
}
