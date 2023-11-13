/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_5.exp1;

/**
 * wasted'da 10 tane loop yazdırıp sonra durması gerekiyor. 
 * unwasted olan da ise tek loop yazıp durması gerekiyor.
 *
 * @author recep
 */
public class Program {

    public static void main(String[] args) {
        GuardedBlock gb = new GuardedBlock(true);

        new Thread(() -> {
            gb.wastedApproach();
            //gb.unwastedApproach();
        }).start();

        new Thread(() -> {
            gb.setCondition(false);
        }).start();
    }
}
