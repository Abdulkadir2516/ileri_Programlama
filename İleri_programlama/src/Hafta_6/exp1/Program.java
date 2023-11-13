/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_6.exp1;

/**
 *
 * @author abdul
 */
public class Program {
    
    public static void main(String[] args)
    {
        //immutableObject();
        mutableObject();
        
    }

    public static void mutableObject() {
        MutableStudent ms = new MutableStudent("Abdulkadir", "YEŞİLKAYA");

        new Thread(() -> {
            String name = ms.getName();
            String surname = ms.getSurname();
            System.out.println("1- " + name + " " + surname);
        }).start();

        new Thread(() -> {

            ms.setName("Recep");
            ms.setSurname("URKUN");
            System.out.println("2- " + ms);
        }).start();
    }

    private static void immutableObject() {
        ImmutableStudent is = new ImmutableStudent("Abdulkadir", "YEŞİLKAYA");

        new Thread(() -> {
            System.out.println("1- " + is);
        }).start();
        
        new Thread(() -> {
            System.out.println("2- " + is.getInstance("Recep", "URKUN"));
        }).start(); 

    }

}
