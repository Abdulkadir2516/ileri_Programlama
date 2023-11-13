/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_5.exp2;

/**
 *
 * @author yesil
 */
public class Program {

    public static void main(String[] args) {
        String packages[] = {"Evrak-1", "Evrak-2", "Evrak-3", "Evrak-4"};
        Courier courier = new Courier();

        new Thread(new Sender(courier, packages)).start();
        new Thread(new Recipient(courier)).start();

    }
}
