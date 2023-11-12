/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp4;

/**
 *
 * @author abdul
 */
public class Program {
    
    public static void main(String[] args)
    {
        Predictor[] predictors = new Predictor[10];
        Producer producer = new Producer(predictors.length);
        producer.start();
        
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        
        for (int i = 0; i < predictors.length; i++) {
            predictors[i] = new Predictor(producer, predictors.length);
            predictors[i].start();
            
        }
    }
    
}
