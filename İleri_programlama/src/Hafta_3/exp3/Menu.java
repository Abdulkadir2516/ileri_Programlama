/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hafta_3.exp3;

import java.util.ArrayList;

/**
 *
 * @author abdul
 */
public class Menu extends ArrayList<Food> {

    private static Menu menu;

    public Menu(int capacity) {
        super(capacity);
    }

    private Menu() {
        add(new Food("Bol Malzemos", 3000));
        add(new Food("Pizza Margherita", 2500));
        add(new Food("Çılbır", 6000));
        add(new Food("Köfte", 3500));
        add(new Food("Karnabahar Kızartması", 3500));
        add(new Food("Ispanaklı Börek", 2500));
        add(new Food("Kuzu Tandır", 5000));
        add(new Food("Mantar Sote", 2000));
        add(new Food("Dana Fajita", 4500));
        add(new Food("Fırın Makarna", 4000));
        add(new Food("Somon Izgara", 3500));
        add(new Food("Lahmacun", 2800));
        add(new Food("Köri Tavuk", 4000));
        add(new Food("Kumpir", 6000));
        add(new Food("Biftek", 4500));
        add(new Food("Mango Salatası", 1500));
        add(new Food("Çılbır", 3000));
        add(new Food("Kızarmış Tavuk", 3800));
        add(new Food("Tavuk Şiş", 3200));
        add(new Food("Peynirli Rulo", 2500));
        add(new Food("Kumpir", 6000));
        add(new Food("Tiramisu", 3500));
        add(new Food("Cheesecake", 4000));

    }

    public static Menu getAllFood() {
        if (menu != null) {
            return menu;
        } else {
            return menu = new Menu();
        }
    }

}
