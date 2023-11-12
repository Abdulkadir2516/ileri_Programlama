/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp2;

import java.math.BigInteger;
/**
 *
 * @author yesil
 */
public class Starvation1 extends Thread {
    private final BigInteger num1;
    private final BigInteger num2;
    
    public Starvation1(BigInteger num1, BigInteger num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    
    private synchronized void getResult4Mult(){
        System.out.println("NAME    :" + getName());
        System.out.println("Num1    :" + num1);
        System.out.println("Num2    :" + num2);
        System.out.println("Result    :" + num1.multiply(num2));
        System.out.println();
    }
    
    @Override
    public void run(){
        getResult4Mult();
    }
}
