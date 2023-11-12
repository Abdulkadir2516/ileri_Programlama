/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Hafta_3.exp3;
/**
 *
 * @author recep
 */
public class Order {
    private boolean received;
    private boolean submitted;
    private final Customer customer;
    private final Menu foods;
    
    public Order(Customer customer, Menu foods){
        this.customer = customer;
        this.foods = foods;
        submitted = false;
        received = true;
    }
    
    public Customer getCustomer(){
        return customer;
    }
    
    public Menu getFoods(){
        return foods;
    }
    
    public boolean isSubmitted2Chef(){
        return submitted;
    }
    
    public void submit2Chef(boolean state){
        submitted = state;
    }
    
    public boolean isReceived(){
        return received;
    }
    
    public void makeReceived(boolean state){
        received = state;
    }
}
