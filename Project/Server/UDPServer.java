/**
 *
 *    CS 420 --> Computer Networks 
 *         Final Project
 * 
 * Name         :       Santosh Reddy Pullaiahgari Bala
 * Wiu Id       :       915-63-0014
 * Description  :       This is the server program which waits for the client to connect
 *                      This server can be connect 2 clients each of them sitting on a different machine
 * Parameters   :       portNumber  (eg: 6963)
 * 
 */
 
import java.io.*;
import java.net.*;

public class UDPServer {

    public static void main(String[] args) {
		// TODO Auto-generated method stub
        
        String recvString1 = " ";
        String recvString2 = " ";
        DatagramPacket sendPacket2 = null;
        DatagramPacket sendPacket1 = null;
        DatagramPacket winMsgPacket1 = null;
        DatagramPacket winMsgPacket2 = null;

        int DEST_PORT = Integer.parseInt(args[0]);

        try {
            //Create local port and bind to DEST_PORT
            DatagramSocket serverSocket = new DatagramSocket(DEST_PORT);

            //Server always listens for incoming connections
            int clientport2 = 0;
            int clientport1 = 0;
            InetAddress clientIP1 = null;
            InetAddress clientIP2 = null;
            int count = 0;
            String r = "rock";
            String p = "paper";
            String s = "scissors";
            String ClientName1 = " ";
            String ClientName2 = " ";
            int moves = 0;
            String message = " "; 
            int client1WinCount = 0;
            int client2WinCount = 0;
            int rockMoveC1 = 0;
            int paperMoveC1 = 0;
            int scissorsMoveC1 = 0;
            int rockMoveC2 = 0;
            int paperMoveC2 = 0;
            int scissorsMoveC2 = 0;
            
                
                while (moves <= 5) {
                    count++;
                    byte[] receiveData = new byte[1024];

                    //Create UDP packet object to receive packet from client
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    if(count==1)
                    System.out.println("Waiting for Client");
                    else if(count ==2)
                    System.out.println("Waiting for another Client");
                    // Blocking receive
                    serverSocket.receive(receivePacket);

				//Client packet contains source IP address and port number.
                    //Get these values to reply back to client
                    InetAddress clientIP = receivePacket.getAddress();
                    int clientPort = receivePacket.getPort();
                    if (count == 1) {
			
                        clientIP1 = clientIP;
                        clientport1 = clientPort;
                        recvString1 = new String(receivePacket.getData(), 0, receivePacket.getLength());

                        if (recvString1.equalsIgnoreCase(r) || recvString1.equalsIgnoreCase(p) || recvString1.equalsIgnoreCase(s)) {
                            System.out.println(ClientName1 + "'s Move is " + recvString1);
                        } else {
                            ClientName1 = recvString1;
                            System.out.println("welcome " + recvString1);
                        }
                    }
                    if (count == 2) {
			            clientIP2 = clientIP;
                        clientport2 = clientPort;
                        recvString2 = new String(receivePacket.getData(), 0, receivePacket.getLength());
                        if (recvString2.equalsIgnoreCase(r) || recvString2.equalsIgnoreCase(p) || recvString2.equalsIgnoreCase(s)) {
                            System.out.println(ClientName2 + "'s Move is " + recvString2);
                        } else {
                            ClientName2 = recvString2;
                            System.out.println("welcome " + recvString2);
                        }

                        sendPacket2 = new DatagramPacket(recvString2.getBytes(), recvString2.length(), clientIP1, clientport1);
                        sendPacket1 = new DatagramPacket(recvString1.getBytes(), recvString1.length(), clientIP2, clientport2);
                        serverSocket.send(sendPacket1);
                        serverSocket.send(sendPacket2);
                        // functionality of the game
                        if (recvString2.equalsIgnoreCase(r) || recvString2.equalsIgnoreCase(r) || recvString2.equalsIgnoreCase(p) || recvString2.equalsIgnoreCase(p) || recvString2.equalsIgnoreCase(s) || recvString2.equalsIgnoreCase(s)) {
                                if(recvString1.equalsIgnoreCase(r))
                                {
                                    rockMoveC1++;
                                    if(recvString2.equalsIgnoreCase(r))
                                    {
                                        rockMoveC2++;
                                        client1WinCount++;
                                        client2WinCount++;
                                        System.out.println("Tied!");
                                    }
                                    else if(recvString2.equalsIgnoreCase(p))
                                    {
                                        paperMoveC2++;
                                        client2WinCount++;
                                        System.out.println(ClientName2+" wins");
                                    }
                                    else if(recvString2.equalsIgnoreCase(s))
                                    {
                                        scissorsMoveC2++;
                                        client1WinCount++;
                                        System.out.println(ClientName1+" wins");
                                    }                                    
                                }                               
                                
                                else if(recvString1.equalsIgnoreCase(p))
                                {
                                    paperMoveC1++;
                                    if(recvString2.equalsIgnoreCase(p))
                                    {
                                        paperMoveC2++;
                                        client1WinCount++;
                                        client2WinCount++;
                                        System.out.println("Tied!");
                                    }
                                    else if(recvString2.equalsIgnoreCase(r))
                                    {
                                        rockMoveC2++;
                                        client1WinCount++;
                                        System.out.println(ClientName1+" wins");
                                    }
                                    else if(recvString2.equalsIgnoreCase(s))
                                    {
                                        scissorsMoveC2++;
                                        client2WinCount++;
                                        System.out.println(ClientName2+" wins");
                                    }                                    
                                }
                                
                                else if(recvString1.equalsIgnoreCase(s))
                                {
                                    scissorsMoveC1++;
                                    if(recvString2.equalsIgnoreCase(s))
                                    {
                                        scissorsMoveC2++;
                                        client1WinCount++;
                                        client2WinCount++;
                                        System.out.println("Tied!");
                                    }
                                    else if(recvString2.equalsIgnoreCase(r))
                                    {
                                        rockMoveC2++;
                                        client2WinCount++;
                                        System.out.println(ClientName2+" wins");
                                    }
                                    else if(recvString2.equalsIgnoreCase(p))
                                    {
                                        paperMoveC2++;
                                        client1WinCount++;
                                        System.out.println(ClientName1+" wins");
                                    }                                    
                                } 
                        }
                        count = 0;
                         moves++;
                    }
                }
                
                System.out.println("Finished processing");
                // calculating the winner
                if(client1WinCount == client2WinCount)
                    {
                        message = "Congrats Game Tied!!!";
                    }
                    else if(client1WinCount > client2WinCount)
                    {
                        message = ClientName1+" Won!!! ";
                    }
                    else
                        message = ClientName2+" Won!!!";
                    
                    System.out.println(message);
                    // sending the winner message to both the clients
                    byte[] sendBytes = message.getBytes();
                    winMsgPacket1 = new DatagramPacket(sendBytes, message.length(),clientIP1, clientport1);
                    winMsgPacket2 = new DatagramPacket(sendBytes, message.length(),clientIP2, clientport2);
                    serverSocket.send(winMsgPacket1);
                    serverSocket.send(winMsgPacket2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
