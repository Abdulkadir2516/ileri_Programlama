package Vize_proje.Me.Server;

import Vize_proje.Recep.ClientHandler;
import java.awt.event.ItemListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.lang.String;
import static java.lang.Thread.MIN_PRIORITY;

/**
 *
 * @author yesil
 */
public class Server extends javax.swing.JFrame {

    private final Socket clientSocket = null;
    private boolean isActive = true; // Başlangıçta aktif durumda

    private final List<DataOutputStream> clientOutputStreams = new ArrayList<>();
    private DataOutputStream client2OutputStream;
    private int port;

    public void setClient2OutputStream(DataOutputStream outputStream) {
        this.client2OutputStream = outputStream;
    }

    public Server() {
        initComponents();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        client_ip = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        port_number = new javax.swing.JTextField();
        Server_Start = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        port_numbers = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Server");
        jLabel1.setToolTipText("");

        jLabel2.setText("Port Seçin");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Gönderen", "Alıcı", "İçerik"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setText("Port Giriniz:");

        port_number.setText("2516");
        port_number.setToolTipText("Port Numarası Giriniz:");

        Server_Start.setText("Serveri Başlat");
        Server_Start.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Server_StartActionPerformed(evt);
            }
        });

        jLabel4.setText("Ağdaki Cihazlar: ");

        port_numbers.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                port_numbersİtemStateChanged(evt);
            }
        });

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(port_numbers, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(port_number, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Server_Start))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(client_ip, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)
                                .addGap(29, 29, 29))))
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(port_number, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Server_Start, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(client_ip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(port_numbers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jButton1)))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened


    }//GEN-LAST:event_formWindowOpened

    private static void tara(String hedefIP, int port) {
        System.out.println("Bağlı IP Adresleri Tarama Başlıyor...");

        for (int i = 1; i <= 255; i++) {
            String hedef = hedefIP + "." + i;
            try {
                Socket socket = new Socket();
                socket.connect(new java.net.InetSocketAddress(hedef, port), 1000); // 1000 ms (1 saniye) süreyle bağlanmaya çalış

                System.out.println("IP Adresi: " + hedef + " - Port " + port + " açık");

            } catch (Exception e) {
                // Bağlantı hatası oluştuğunda devam et
            }
        }

        System.out.println("Bağlı IP Adresleri Tarama Tamamlandı.");
    }

    private static boolean comboBoxContainsItem(javax.swing.JComboBox<String> comboBox, String item) {
        for (int i = 0; i < comboBox.getItemCount(); i++) {
            if (comboBox.getItemAt(i).equals(item)) {
                return true;
            }
        }
        return false;
    }
    private void Server_StartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Server_StartActionPerformed
        // TODO add your handling code here:

        this.port = Integer.valueOf(port_number.getText().toString());

        if (comboBoxContainsItem(port_numbers, String.valueOf(port))) {
            JOptionPane.showMessageDialog(this, "Port Numarası zaten var");

        } else {
            port_numbers.addItem(String.valueOf(port));

            //Server_Class server = new Server_Class(port);
            // Server'i baslat
            //server.start();
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {

                    server_start();
                }
            });

            thread2.start();
        }


    }//GEN-LAST:event_Server_StartActionPerformed

    private void bilgileri_yazdır(Socket clientSocket) {
        
        System.out.println("Bağlanan IP: " + clientSocket.getInetAddress());
        System.out.println("Client's host name is " + clientSocket.getInetAddress().getHostName());
        client_ip.addItem(clientSocket.getInetAddress().toString());
        System.out.println(clientSocket.getLocalPort());
        
    }

    private void client_handler(Socket clientSocket) {
        try {
            DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());

            while (isActive) {
                try {
                    String message = dataInputStream.readUTF();
                    System.out.println("Server'a gelen mesaj: " + message);

                    // Gelen mesajı diğer istemcilere iletmek için sunucuya bildirimde bulun
                    // this.broadcastMessage(message, dataOutputStream);
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
            Server nesne = new Server();
            JOptionPane.showMessageDialog(nesne, e, "Yürütme Hatasi ClientHandler", MIN_PRIORITY);
            e.printStackTrace(System.out);
        }
    }

    private void server_start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server hazır!");

            while (true) {
                Socket clientSocket = serverSocket.accept();

                DataOutputStream clientOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                clientOutputStreams.add(clientOutputStream);

                if (client2OutputStream == null) {
                    setClient2OutputStream(clientOutputStream);
                }

                if (clientSocket.isConnected()) {
                    bilgileri_yazdır(clientSocket);

                }

                Thread thread3 = new Thread(new Runnable() {
                    @Override
                    public void run() {

                        client_handler(clientSocket);

                    }
                });

                thread3.start();

            }
        } catch (IOException e) {
            System.out.println("Port Hatası!");
            e.printStackTrace(System.out);
        }
    }


    private void port_numbersİtemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_port_numbersİtemStateChanged


    }//GEN-LAST:event_port_numbersİtemStateChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {

                String hedefIP = "192.168.1"; // Taranacak IP adresi
                int port = Integer.valueOf(port_numbers.getSelectedItem().toString());            // Bitiş portu
                System.out.println(port);
                tara(hedefIP, port);
            }
        });

        thread1.start();


    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Server().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Server_Start;
    public javax.swing.JComboBox<String> client_ip;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField port_number;
    private javax.swing.JComboBox<String> port_numbers;
    // End of variables declaration//GEN-END:variables
}
