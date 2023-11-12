/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp3;

import java.security.SecureRandom;

/**
 *
 * @author abdul
 */
public class Customer extends Thread{

    private final Menu food;
    private final SecureRandom sRandom;
    private final Headwaiter waiter;

    public Customer(Headwaiter waiter) {
        food = new Menu(4);
        sRandom = new SecureRandom();
        this.waiter = waiter;
    }

    private void addOrder() throws InterruptedException {
        Menu menu = Menu.getAllFood();
        Thread.sleep(500);
        Food f = menu.get(sRandom.nextInt(menu.size()));
        food.add(f);
        System.out.println("\t" + f.getName() + " (" + f.getTime() + " ms )");
    }

    public void sleepp(long millis) {
        try {
            Thread.sleep(500);

        } catch (InterruptedException ex) {

        }

    }
    @Override
    public void run() {
        while (true) {
            System.out.println(this.getName() + "'s orders are as follows: ");
            try {
                food.clear();
                for (int i = 0; i < 4; i++) {
                    addOrder();
                }
                waiter.setOrder(new Order(this, food));

            } catch (InterruptedException e) {
            }

            synchronized (waiter) {
                waiter.notify();
            }

            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException ex) {
                }

            }
        }

    }

}
