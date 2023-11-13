/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vize_proje.Recep;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * https://docs.oracle.com/javase/8/docs/api/java/net/Socket.html
 *
 * @author recep
 */
// Server.java
public class Server extends Thread {

    private final List<DataOutputStream> clientOutputStreams = new ArrayList<>();
    private DataOutputStream client2OutputStream;

    public void setClient2OutputStream(DataOutputStream outputStream) {
        this.client2OutputStream = outputStream;
    }

    @Override
    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server hazır!");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Bağlanan IP: " + clientSocket.getInetAddress());
                System.out.println("Client's host name is " + clientSocket.getInetAddress().getHostName());
                        
                DataOutputStream clientOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(clientOutputStream);

                if (client2OutputStream == null) {
                    setClient2OutputStream(clientOutputStream);
                }

                // Her bağlantı için bir iş parçacığı başlat
                ClientHandler clientHandler = new ClientHandler(clientSocket, this);
                clientHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Port Hatası!");
            e.printStackTrace(System.out);
        }
    }

    public synchronized void broadcastMessage(String message, DataOutputStream senderStream) throws IOException {
        for (DataOutputStream clientOutputStream : clientOutputStreams) {
            if (clientOutputStream != senderStream) { // Gönderen istemciye tekrar gönderme
                clientOutputStream.writeUTF(message);
                clientOutputStream.flush();
            }
        }
    }
}
