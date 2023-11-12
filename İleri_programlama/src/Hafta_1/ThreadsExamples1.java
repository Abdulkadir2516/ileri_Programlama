/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Hafta_1;
import java.util.Random;

/**
 *
 * @author recep
 */
public class ThreadsExamples1{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //callSimpleThread();
        //callRunnable();
        callThreadSleep();
    }
private static void callSimpleThread() {
        int number = 10;
        Thread thread;
        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                long result = RecursiveFactorial.factorial(number);
                System.out.println("Number: " + number + "\tResult: " + result);
            }
        });
        thread.start();
        System.out.println("Metot sonu");
    }

public static void callRunnable(){
    Random rnd = new Random();
    ImplementedRunnable[] irs = new ImplementedRunnable[10];
    
    for(int i=0; i< irs.length; i++)
        irs[i] = new ImplementedRunnable(i, rnd.nextInt(20));
    
    for(int i=0; i < 10; i++){
        (new Thread(irs[i])).start();
    }
}

private static void callThreadSleep(){
    SuspendedThread[] sts = new SuspendedThread[10];
    
    for(int i= 0; i < sts.length; i++)
        sts[i] = new SuspendedThread(i);
    
    for(int i=0; i<10; i++)
        (new Thread(sts[i])).start();
}

}


