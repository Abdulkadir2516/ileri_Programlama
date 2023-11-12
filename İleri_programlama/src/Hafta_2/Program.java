/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_2;
import java.util.BitSet;

/**
 *
 * @author recep
 */
public class Program {
    public static void main(String[] args){
        interruptByException();
        //interruptByThrowException();
        //interrupt();
    }
    
    private static void interruptByException(){
        InterruptByException[] arr = new InterruptByException[10];
        
        for(int i=0; i < arr.length; i++){
            arr[i] = new InterruptByException();
            arr[i].start();
        }
        
        System.out.println(" ---------------------");
        
        double elapsedTime;
        BitSet allAlive = new BitSet(arr.length);
        allAlive.set(0, arr.length, true);
        while(allAlive.cardinality() > 0){
            for(int i=0; i < arr.length; i++){
                if(arr[i]. isAlive()){
                    elapsedTime = arr[i].elapsedTime();
                    if(elapsedTime > 5000){
                        System.out.println("Elapsed time: " + elapsedTime + " ms for" + arr[i].getName());
                    }
                }
                else{
                    allAlive.set(i, false);
                }
            }
        }
    }
    
    private static void interruptByThrowException(){
        InterruptByThrowException[] arr = new InterruptByThrowException[10];
        
        for(int i=0; i < arr.length; i++){
            arr[i] = new InterruptByThrowException();
            arr[i].start();
        }
        
        System.out.println(" ---------------------");
        
        double elapsedTime;
        BitSet allAlive = new BitSet(arr.length);
        allAlive.set(0, arr.length, true);
        while(allAlive.cardinality() > 0){
            for(int i=0; i < arr.length; i++){
                if(arr[i].isAlive()){
                    elapsedTime = arr[i].elapsedTime();
                    if(elapsedTime > 5000){
                        System.out.println("Elapsed time: " + elapsedTime + " ms for" + arr[i].getName());
                        try{
                            arr[i].interrupt();
                        }
                        catch(RuntimeException ex){
                            System.err.println(ex);
                        }
                    }
                }
                else{
                    allAlive.set(i, false);
                }
            }
        }
    }
    
    private static void interrupt(){
        Interrupt[] arr = new Interrupt[10];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = new Interrupt();
            arr[i].start();
        }
        
        double elapsedTime;
        BitSet allAlive = new BitSet(arr.length);
        allAlive.set(0, arr.length, true);
        while(allAlive.cardinality() > 0){
            for(int i=0; i < arr.length; i++){
                if(arr[i].isInterrupted()){
                    elapsedTime = arr[i].elapsedTime();
                    if(elapsedTime > 3000){
                        arr[i].interrupt();
                        allAlive.set(i, false);
                    }
                    }
                }
            }
        System.out.println("End of the method!");
    }
}
