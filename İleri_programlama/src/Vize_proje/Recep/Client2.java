//package Vize_proje.Recep;
//
///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//import java.io.DataInputStream;
//import java.io.IOException;
//import java.net.Socket;
///**
// *
// * @author recep
// */
//public class Client2 extends Thread {
//    private String serverAddress;
//    private int serverPort;
//
//    public Client2(String serverAddress, int serverPort) {
//        this.serverAddress = serverAddress;
//        this.serverPort = serverPort;
//    }
//
//    @Override
//    public void run() {
//        try (Socket serverSocket = new Socket(serverAddress, serverPort)) {
//            System.out.println("Client 2 hazır!");
//
//            DataInputStream dataInputStream = new DataInputStream(serverSocket.getInputStream());
//            while (true) {
//                String message = dataInputStream.readUTF();
//                System.out.println("Client 2'ye gelen mesaj: " + message);
//            }
//        } catch (IOException ex) {
//            System.err.println(ex);
//            System.out.println("Servera bağlanılamıyor. Lütfen serverin açık olduğundan emin olun.");
//        }
//    }
//}
