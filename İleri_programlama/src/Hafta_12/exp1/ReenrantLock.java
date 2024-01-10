/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_12.exp1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author abdul
 */
public class ReenrantLock {
    ReentrantLock lock = new ReentrantLock();
   // ...

   public void m() {
       assert !lock.isHeldByCurrentThread();
       lock.lock();
       try {
           // ... method body
       } finally {
           lock.unlock();
       }
   }
}
