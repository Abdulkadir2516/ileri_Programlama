/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vize_proje.Recep;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;

/**
 *
 * @author recep
 */
// ClientHandler.java
public class ClientHandler extends Thread {

    private final Socket clientSocket;
    private final Server server;
    private boolean isActive = true; // Başlangıçta aktif durumda

    public ClientHandler(Socket clientSocket, Server server) {
        this.clientSocket = clientSocket;
        this.server = server;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            while (isActive) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println("Server'a gelen mesaj: " + message);

                    // Gelen mesajı diğer istemcilere iletmek için sunucuya bildirimde bulun
                    server.broadcastMessage(message, dataOutputStream);
                } catch (EOFException eof) {
                    System.out.println("Client1 bağlantısı sonlandı.");
                    isActive = false; // İstemci bağlantısı kapandığında aktif durumu false yap
                }
            }

            // Bekleme süresi
            Thread.sleep(2000); // 2 saniye bekleyecek

            // İstemciden gelen yeni veri yoksa sonlan
            if (!isActive) {
                System.out.println("ClientHandler sonlandı.");
                clientSocket.close();
                System.exit(0); // Programı sonlandır
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("ClientHandler hata en sondaki");
            e.printStackTrace(System.out);
        }
    }
}
