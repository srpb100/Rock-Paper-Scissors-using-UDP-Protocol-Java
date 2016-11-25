/**
 *
 *    CS 420 --> Computer Networks 
 *         Final Project
 * 
 * Name         :       Santosh Reddy Pullaiahgari Bala
 * Wiu Id       :       915-63-0014
 * Description  :       This is the client program which connects to the server
 *                      This client can be opened in another machine and both the clients can play the game
 * Parameters   :       serverName<space>portNumber  (eg: uxb4.wiu.edu 6963)
 * 
 */

package client;

import java.net.*;

public class StartGame extends javax.swing.JFrame {

    
    String SERVER_NAME;
    int portNumber;
    
    DatagramPacket sendPkt;
    DatagramSocket clientSocket;
    InetAddress dstIP;
    DatagramPacket recvPacket;
    String playerName;
    String move;
    int score = 0;
    String opponent = " ";
    int clickCount =0;
    int arrayCount = -1;
    String[] client1Moves = new String[5];
    String[] client2Moves = new String[5];
    
    public StartGame(String name, String sname, int port) 
    {
        initComponents();
        playerName = name;
        SERVER_NAME = sname;
        portNumber = port; 
        try
        {
            //Create IP address object from IP address of destination
            // sending client's name to the server
            byte[] sendBytes = playerName.getBytes();
            clientSocket = new DatagramSocket();
            dstIP = InetAddress.getByName(SERVER_NAME);                
            sendPkt = new DatagramPacket(sendBytes, playerName.length(), dstIP, portNumber);
            
                //Send packet to server
            System.out.println("connected to server");
            
            clientSocket.send(sendPkt);
            
            byte[] recvData = new byte[1024];
			
            //DatagramPacket object must be created for receiving data from server
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
			
            //Receive reply from server
            clientSocket.receive(recvPacket);
			
            String recvString = new String(recvPacket.getData(), 0, recvPacket.getLength());
            //System.out.println("Received string is " + recvString);
            
            opponent = recvString;
            System.out.println("opponent is: "+opponent);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }                
    }   
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Monotype Corsiva", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 0, 0));
        jLabel2.setText("Heyy let's play Rock Papers and Scissors");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 600, 70));

        jLabel3.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Select Your Choice:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 190, 40));

        jButton1.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 0, 255));
        jButton1.setText("Rock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 90, 50));

        jButton2.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(0, 0, 255));
        jButton2.setText("Paper");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 190, 110, 50));

        jButton3.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jButton3.setForeground(new java.awt.Color(0, 0, 255));
        jButton3.setText("Scissors");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 190, 110, 50));

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 2, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 0, 0));
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 590, 40));

        jButton4.setFont(new java.awt.Font("Monotype Corsiva", 3, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(0, 0, 255));
        jButton4.setText("click here to check the winner");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, -1, -1));

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 255));
        jLabel5.setText("you can play for 5 times. Select each move at once");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 430, 40));

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 0));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 330, 50));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/client/start game background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:        
        clickCount++;
        arrayCount++;
        
        move = jButton1.getText();
        
        try
        {
            //Create IP address object from IP address of destination 
            byte[] sendBytes = move.getBytes();
            
            sendPkt = new DatagramPacket(sendBytes, move.length(), dstIP, portNumber);
            
            //Send packet to server
            
            clientSocket.send(sendPkt);
            
            byte[] recvData = new byte[1024];
			
            //DatagramPacket object must be created for receiving data from server
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
			
            //Receive reply from server
            clientSocket.receive(recvPacket);
			
            String recvMove = new String(recvPacket.getData(), 0, recvPacket.getLength());
            //System.out.println("you choose "+move+" "+opponent+" choose " + recvMove);
            jLabel4.setText("you choose "+move+" "+opponent+" choose " + recvMove);
            
            client1Moves[arrayCount] = move;
            client2Moves[arrayCount] = recvMove;            
            
            // shows a label with game over if 5 moves are done
            if(clickCount == 5)
            {
                jLabel6.setText("Game Over!!!");
            }            
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:   
        clickCount++;
        arrayCount++;
        move = jButton2.getText();
        //String y = "abcdegfhij";
        try
        {
            //Create IP address object from IP address of destination 
            byte[] sendBytes = move.getBytes();
            
            sendPkt = new DatagramPacket(sendBytes, move.length(), dstIP, portNumber);
            
            //Send packet to server
            
            clientSocket.send(sendPkt);
            
            byte[] recvData = new byte[1024];
			
            //DatagramPacket object must be created for receiving data from server
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
			
            //Receive reply from server
            clientSocket.receive(recvPacket);
			
            String recvMove = new String(recvPacket.getData(), 0, recvPacket.getLength());
            jLabel4.setText("you choose "+move+" "+opponent+" choose " + recvMove);
            
            client1Moves[arrayCount] = move;
            client2Moves[arrayCount] = recvMove;
            
            // shows a label with game over if 5 moves are done
            if(clickCount == 5)
            {
                jLabel6.setText("Game Over!!!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:      
        clickCount++;
        arrayCount++;
        
        move = jButton3.getText();
        try
        {
            //Create IP address object from IP address of destination 
            byte[] sendBytes = move.getBytes();
            
            sendPkt = new DatagramPacket(sendBytes, move.length(), dstIP, portNumber);
            
            //Send packet to server
            
            clientSocket.send(sendPkt);
            
            byte[] recvData = new byte[1024];
			
            //DatagramPacket object must be created for receiving data from server
            DatagramPacket recvPacket = new DatagramPacket(recvData, recvData.length);
			
            //Receive reply from server
            clientSocket.receive(recvPacket);
			
            String recvMove = new String(recvPacket.getData(), 0, recvPacket.getLength());
            jLabel4.setText("you choose "+move+" "+opponent+" choose " + recvMove);
            
            client1Moves[arrayCount] = move;
            client2Moves[arrayCount] = recvMove;
            
            
            // shows a label with game over if 5 moves are done
            if(clickCount == 5)
            {
                jLabel6.setText("Game Over!!!");
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        try{
             if(clickCount == 5)
            {
                jLabel6.setText("Game Over!!!");
                
                byte[] receiveData = new byte[4096];
                DatagramPacket recvPacket = new DatagramPacket(receiveData, receiveData.length);
                clientSocket.receive(recvPacket);
			
            String receiveString = new String(recvPacket.getData(), 0, recvPacket.getLength());
            //System.out.println("Message string is " + receiveString);   
            
            WinnerPage wp = new WinnerPage(receiveString);
            wp.setVisible(true);
            
            }
            System.out.println("Your Moves \t"+opponent+" moves");
            
            for(int i =0; i<5;i++)
            {
                System.out.printf("%-16s %s\n", client1Moves[i], client2Moves[i]);
            }
            
            clientSocket.close();       //closing the connection
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        System.out.println("connection closed");
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StartGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new StartGame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}