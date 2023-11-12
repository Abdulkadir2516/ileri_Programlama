/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_1;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author yesil
 */
public class SuspendedThread implements Runnable {
    private int id;
    
    public SuspendedThread(int id){
        this.id = id;
    }
    
    @Override
    public void run(){
        try{
            Thread.sleep(id*10);
            
            System.out.println("ID: " + id);
        }
        catch(InterruptedException ex){
            Logger.getLogger(SuspendedThread.class.getName()).log(Level.SEVERE, null,ex);
        }
    }
}
