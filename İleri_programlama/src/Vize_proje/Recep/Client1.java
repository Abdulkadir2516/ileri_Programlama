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
public class Client1 extends Thread {
    private String serverAddress;
    private int serverPort;

    public Client1(String serverAddress, int serverPort) {
        this.serverAddress = serverAddress;
        this.serverPort = serverPort;
    }

    @Override
    public void run() {
        try (Socket serverSocket = new Socket(serverAddress, serverPort)) {
            System.out.println("Client 1 hazır!");

            // Kullanıcıdan mesaj al
            Scanner scanner = new Scanner(System.in);
            System.out.println("Client 1'den göndermek istediğiniz mesajı giriniz: ");
            String message = scanner.nextLine();

            DataOutputStream dataOutputStream = new DataOutputStream(serverSocket.getOutputStream());
            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();

        } catch (IOException ex) {
            System.err.println(ex);
            System.out.println("Servera bağlanılamıyor. Lütfen serverin açık olduğundan emin olun.");
        }
    }
}
