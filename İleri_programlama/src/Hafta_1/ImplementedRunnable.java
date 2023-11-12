/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_1;

/**
 *
 * @author yesil
 */
public class ImplementedRunnable implements Runnable{
    private int id;
    private int number;
    
    public ImplementedRunnable(int id, int number){
        if(number < 0){
            throw new ArithmeticException("Sıfırdan büyük bir değer giriniz");
        }
        this.id = id;
        this.number = number;
    }
    @Override
    public void run(){
        long result = RecursiveFactorial.factorial(number);
        System.out.println("ID: " + id + "\tNumber: " + number + "\tResult:" + result);
    }
}
