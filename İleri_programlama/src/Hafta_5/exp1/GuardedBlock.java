/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_5.exp1;

/**
 * wait, notify, notifyall çalışması için synchronized kullanılması daha iyi
 *
 * @author recep
 */
public class GuardedBlock {

    private boolean condition;

    public GuardedBlock(boolean condition) {
        this.condition = condition;
    }

    public void wastedApproach() {
        while (condition) {
            System.out.println("loop");
        }
        System.out.println("The end of the method");
    }

    public synchronized void unwastedApproach() {
        while (condition) {
            System.out.println("loop");
            try {
                wait();
            } catch (InterruptedException ex) {
            }
        }
        System.out.println("The end of the method");
    }

    public synchronized void setCondition(boolean condition) {
        this.condition = condition;
        notifyAll();
    }
}
