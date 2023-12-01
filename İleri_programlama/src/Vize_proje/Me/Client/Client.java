package Vize_proje.Me.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import static java.lang.Thread.MIN_PRIORITY;
import java.net.InetAddress;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 * @author abdul
 */
public class Client extends javax.swing.JFrame {

    private Socket serverSocket;
    private boolean isActive = true; // Başlangıçta aktif durumda

    public Client() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        ip_adress = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        port = new javax.swing.JTextField();
        connect = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        content = new javax.swing.JTextArea();
        send = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        ip_adress1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        gelen_mesajlar = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("İp Adress");

        ip_adress.setText("192.168.1.100");
        ip_adress.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ip_adressActionPerformed(evt);
            }
        });

        jLabel2.setText("Port");

        port.setText("2516");
        port.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                portActionPerformed(evt);
            }
        });

        connect.setText("Baglan");
        connect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectActionPerformed(evt);
            }
        });

        jLabel3.setText("İp Adress");

        content.setColumns(20);
        content.setRows(5);
        jScrollPane1.setViewportView(content);

        send.setText("Gönder");
        send.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Client");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        ip_adress1.setText("192.168.1.101");
        ip_adress1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ip_adress1ActionPerformed(evt);
            }
        });

        jLabel5.setText("Gelen Mesajlar");

        gelen_mesajlar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tarih-Saat", "Gönderen Kişi", "Mesaj"
            }
        ));
        jScrollPane2.setViewportView(gelen_mesajlar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ip_adress1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(285, 285, 285))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(288, 288, 288))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(send))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ip_adress, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(31, 31, 31)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 260, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ip_adress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(port, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ip_adress1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(send, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addGap(41, 41, 41))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ip_adressActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_adressActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ip_adressActionPerformed

    private void portActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_portActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_portActionPerformed

    private void connectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectActionPerformed

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                String serverAddress = ip_adress.getText().toString();
                int server_port = Integer.valueOf(port.getText().toString());

                try {

                    baglan(serverAddress, server_port);
                    //tara("192.168.1", server_port);

                    getMessage();

                } catch (IOException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        thread1.start();


    }//GEN-LAST:event_connectActionPerformed

    private void sendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendActionPerformed
        
        System.out.println(serverSocket.getInetAddress().getHostName().toString());
        //serverSocket.getInetAddress().getHostName();
        send(serverSocket.getInetAddress().getHostAddress() + " " + content.getText().toString() + " " + ip_adress1.getText());

    }//GEN-LAST:event_sendActionPerformed

    private void ip_adress1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ip_adress1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ip_adress1ActionPerformed

    public void baglan(String serverAddress, int serverPort) throws IOException {

        try {

            this.serverSocket = new Socket(serverAddress, serverPort);

            JOptionPane.showMessageDialog(this, "Client Hazır");

        } catch (IOException ex) {
            System.err.println(ex);
            System.out.println("Servera bağlanılamıyor. Lütfen serverin açık olduğundan emin olun.");
        }
    }

    private static void tara(String hedefIP, int port) {
        System.out.println("Bağlı IP Adresleri Tarama Başlıyor...");

        for (int i = 1; i <= 255; i++) {
            String hedef = hedefIP + "." + i;
            try {
                Socket socket = new Socket();
                socket.connect(new java.net.InetSocketAddress(hedef, port), 100); // 1000 ms (1 saniye) süreyle bağlanmaya çalış

                System.out.println("IP Adresi: " + hedef + " - Port " + port + " açık");

            } catch (Exception e) {
                // Bağlantı hatası oluştuğunda devam et
            }
        }

        System.out.println("Bağlı IP Adresleri Tarama Tamamlandı.");
    }

    public void getMessage() {
        try {
            DataInputStream dataInputStream = new DataInputStream(serverSocket.getInputStream());
            

            while (isActive) {
                try {
                    String message = dataInputStream.readUTF();

                    // IP adreslerini çıkarmak için düzenli ifade
                    String ipRegex = "\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b";

                    String pureText = message.replaceAll(ipRegex, "").trim();

                    // Pattern ve Matcher oluştur
                    Pattern pattern = Pattern.compile(ipRegex);
                    Matcher matcher = pattern.matcher(message);

                    LocalDateTime currentDateTime = LocalDateTime.now();

                    String ipAddress = serverSocket.getInetAddress().getHostAddress();

                    // Gönderen ve alıcı IP adreslerini bul
                    String senderIP = null;
                    String receiverIP = null;

                    // Eşleşen IP adreslerini yazdır
                    int count = 0;
                    while (matcher.find()) {
                        if (count == 0) {
                            senderIP = matcher.group();
                        } else if (count == 1) {
                            receiverIP = matcher.group();
                        }
                        count++;
                    }
                   
                    
                    if (ipAddress.equals(receiverIP) ){
                        // Yeni bir satır ekleyin
                        Object[] newRow = {currentDateTime.toString(), senderIP, pureText};
                        // Veriyi ekleyin
                        ((javax.swing.table.DefaultTableModel) gelen_mesajlar.getModel()).addRow(newRow);

                    }

                } catch (EOFException eof) {
                    System.out.println("Client bağlantısı sonlandı.");
                    isActive = false; // İstemci bağlantısı kapandığında aktif durumu false yap
                }
            }

            // Bekleme süresi
            Thread.sleep(2000); // 2 saniye bekleyecek

            // İstemciden gelen yeni veri yoksa sonlan
            if (!isActive) {
                System.out.println("ClientHandler sonlandı.");
                //serverSocket.close();
                System.exit(0); // Programı sonlandır
            }
        } catch (IOException | InterruptedException e) {
            Client nesne = new Client();
            //JOptionPane.showMessageDialog(nesne, e, "Yürütme Hatasi ClientHandler", MIN_PRIORITY);
            e.printStackTrace(System.out);
        }
    }

    public void send(String message) {
        try {

            DataOutputStream dataOutputStream = new DataOutputStream(this.serverSocket.getOutputStream());
            dataOutputStream.writeUTF(message);

            dataOutputStream.flush();

        } catch (IOException ex) {
            System.err.println(ex);
            System.out.println("Servera bağlanılamıyor. Lütfen serverin açık olduğundan emin olun.");
        }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Client().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connect;
    private javax.swing.JTextArea content;
    private javax.swing.JTable gelen_mesajlar;
    private javax.swing.JTextField ip_adress;
    private javax.swing.JTextField ip_adress1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField port;
    private javax.swing.JButton send;
    // End of variables declaration//GEN-END:variables
}
