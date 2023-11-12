package Hafta_3.exp3;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author abdul
 */
public class Program {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Headwaiter headwaiter = new Headwaiter();
        Customer customer = new Customer(headwaiter);
        
        customer.start();
        headwaiter.start();


    }
}
