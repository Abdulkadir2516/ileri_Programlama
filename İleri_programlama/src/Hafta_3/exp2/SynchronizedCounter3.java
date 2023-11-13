/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp2;

import java.util.concurrent.atomic.AtomicLong;

/**

 */
public class SynchronizedCounter3 {
    private final AtomicLong c;
    
    public SynchronizedCounter3(){
        c = new AtomicLong(0);
    }
    
    public long increment(){
        return c.incrementAndGet();
    }
    
    public long decrement(){
        return c.getAndDecrement();
    }
    
    public long value(){
        return c.get();
    }
}
