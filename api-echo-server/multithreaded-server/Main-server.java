package com.example.awtSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

    public static void main(String[] args) {
	// write your code here
        //ServerSocket is used on the server side to create a server socket
        // and accept() waits for the client, if the client connects with the same port on the server side then returns a socket and establishes the connection
        // close() closes the connection on the server side

        //Socket class is used for the communication between client/server for reading and writing messages
        try(ServerSocket serverSocket=new ServerSocket(5000)){
            while (true){
               new Echoer(serverSocket.accept()).start();
                System.out.println("Client is connected");
            }

        }catch (IOException e){
            System.out.println("Server exception "+e.getMessage());
        }
    }
}
