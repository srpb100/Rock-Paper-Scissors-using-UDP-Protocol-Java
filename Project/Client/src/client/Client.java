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

import java.io.*;
import java.net.*;


public class Client 
{    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) 
    {
        // TODO code application logic here
        
        String SERVER_NAME = args[0];               // Server/Host Name from arguments
        int portNumber = Integer.parseInt(args[1]); // port number to connect
        // creating new object for Game class with servername and portnumber as parameters'
        Game g = new Game(SERVER_NAME, portNumber);
        g.setVisible(true);
    }
}