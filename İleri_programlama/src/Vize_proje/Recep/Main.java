/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vize_proje.Recep;

/**
 *
 * @author recep
 */
// Main.java
// Main.java
public class Main {
    public static void main(String[] args) {
        //Server server = new Server();
        // Server'i baslat
        //server.start();

        // Client 1, mesaj gönderen
        Client1 client1 = new Client1("192.168.1.100", 2518);
        
        // Client 2, mesaj alan
        //Client2 client2 = new Client2("localhost", 12345);

        client1.start();
        //client2.start();
        
         try {
            //server.join();
            client1.join();
            //client2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}