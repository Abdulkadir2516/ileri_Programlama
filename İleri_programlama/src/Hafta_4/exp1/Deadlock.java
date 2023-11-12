/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp1;

/**
 *
 * @author yesil 
 * Deadlock obj1 = new Deadlock("Ahmet"); 
 * Deadlock obj2 = new Deadlock("Mehmet"); 
 * obj1.sayHello(obj2);
 * obj2.sayHello(obj1);
 */
public class Deadlock {

    private final String name;

    public Deadlock(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public synchronized void sayHello(Deadlock bower) {
        System.out.format("%s dedi ki: %s " + " bugün bana merhaba dedi. %n ", this.name, bower.getName());
        /*bower.sayHello(this);*/ // hangisi doğru hatırlamıyorum
        bower.sayHelloBack(this);
    }

    public synchronized void sayHelloBack(Deadlock bower) {
        System.out.format("%s dedi ki: %s " + " de bana merhaba dedi. %n ", this.name, bower.getName());
         /*bower.sayHello(this);*/ // hangisi doğru hatırlamıyorum
        bower.sayHelloBack(this);
    }
}
