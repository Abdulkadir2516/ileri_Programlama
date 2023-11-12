/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp3;

/**
 * bu sorunlu kodu düzeltin, çalışabilecek bir hale getirin.
 * @author yesil
 */
public class Program {

    public static void main(String[] args) {
        Livelock person1 = new Livelock("Ahmet");
        Livelock person2 = new Livelock("Mehmet");
        
        SaltShaker saltShaker = new SaltShaker("Tuzluk");
        saltShaker.setOwner(person1);
        
        person2.setSaltShaker(saltShaker);
        
        new Thread(() -> {
            person1.passSaltShakerTo(person2);
        }).start();
        
        new Thread(() -> {
            person2.passSaltShakerTo(person1);
        }).start();
    }
}
