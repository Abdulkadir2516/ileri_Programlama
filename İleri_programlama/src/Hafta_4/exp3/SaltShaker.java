/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_4.exp3;

/**
 *
 * @author yesil
 */
public class SaltShaker {

    private final String name;
    private Livelock owner;

    public SaltShaker(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Livelock getOwner() {
        return owner;
    }

    public synchronized void setOwner(Livelock owner) {
        this.owner = owner;
        this.owner.setSaltShaker(this);
    }
}
