/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp1;

import java.util.Random;

/**
 *
 * @author recep
 */
public class NewClass {
    public static void main(String[] args) {
        Factorial();
    }
    
    private static void Factorial() {
        Random rnd = new Random();
        Factorial[] irs = new Factorial[10];
        
        for(int i=0; i< irs.length; i++){
            irs[i] = new Factorial(rnd.nextInt(30 * (irs.length - i)));
            
            irs[i].start();
            try{
                irs[i].join();
                
            }catch(InterruptedException ex){
                System.err.println(ex);
            }
        }
        System.out.println("End of Method");
    }
}
