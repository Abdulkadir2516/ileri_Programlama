/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Hafta_3.exp3;
/**
 *
 * @author recep
 */
public class Headwaiter extends Thread {

    private Order order;

    public Headwaiter() {
        order = new Order(null, null);
        order.makeReceived(false);
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void waitt() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException ex) {

            }
        }
    }
    
    @Override
    public void run(){
        Customer customer;
        while(true){
            if(!order.isReceived())
                waitt();
            
            customer = order.getCustomer();
            System.out.println("Orders received from " + customer.getName() + " are as follows: ");
            for(Food f : order.getFoods())
                System.out.println("\t " + f.getName() + " (" + f.getTime() + ") ms");
            
            synchronized(customer){
                customer.notify();
                order.makeReceived(false);
            }
            
            waitt();
        }
    }
}
