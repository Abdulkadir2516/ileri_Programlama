/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp1;

/**
 *
 * @author abdul
 */
public class ImmutableStudent {

    private final String name;
    private final String surname;

    public ImmutableStudent(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public ImmutableStudent getInstance(String name, String surname) {
        return new ImmutableStudent(name, surname);
    }

    @Override
    public String toString() {
        return name + " " + surname;
    }
    
}
