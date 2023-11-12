/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp4;
import java.util.BitSet;
import java.util.Random;
/**
 *
 * @author abdul
 */
public class Producer extends Thread{
    private final Random rnd;
    private volatile int val;
    
    private final int numOfPredictors;
    public final Object notifier;
    public final BitSet isDone;
    
    public Producer(int numOfPredictors)
    {
        rnd = new Random();
        notifier = new Object();
        this.numOfPredictors = numOfPredictors;
        isDone = new BitSet(numOfPredictors);
        isDone.set(0, numOfPredictors, false);
        
    }
    
    public int value()
    {
        return val;
        
    }
            
    @Override
    public void run()
    {
        while(true)
        {
            synchronized (isDone) {
                isDone.set(0,numOfPredictors,false);
            }
            
            val = rnd.nextInt(numOfPredictors*2);
            System.out.println("number:" + val);
            
            synchronized (notifier) {
                notifier.notifyAll();
                
            }
            
            synchronized (this) {

                try {
                    wait();
                } catch (InterruptedException ex) {
                }
            }
            
            
            
            
        }
    }
            
}
