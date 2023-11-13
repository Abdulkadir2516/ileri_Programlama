/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vize_proje.Recep;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author recep
 */
// Client.java
/*
public class Client extends Thread {
    private final String serverAddress;
    private final int serverPort;

    public Client(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try (Socket serverSocket = new Socket(serverAddress, serverPort)) {
            System.out.println("Client hazır!");

            while (true) {
                // Kullanıcıdan mesaj al
                Scanner scanner = new Scanner(System.in);
                System.out.println("Göndermek istediğiniz mesajı giriniz: ");
                String message = scanner.nextLine();

                DataOutputStream dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();
            }
        } catch (IOException ex) {
            System.err.println(ex);
            System.out.println("Servera bağlanılamıyor. Lütfen serverin açık olduğundan emin olun.");
        }
    }
}*/