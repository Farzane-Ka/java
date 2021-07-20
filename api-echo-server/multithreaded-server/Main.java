package com.example.awtSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try(Socket socket=new Socket("localhost",5000)){// the port number if we do not have the server
            //and the server is given as API, we should find the port number from the API documentation
            // use BufferReader when reading text from an input stream file, socket,...
            //use PrintWriter to write on console, output file, or output-stream of a socket
            socket.setSoTimeout(5000);// setting a 5 seconds timeout
            BufferedReader echos=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter stringEchos= new PrintWriter(socket.getOutputStream(),true);

            Scanner scanner=new Scanner(System.in);
            String echoString;
            String response;
            do {
                System.out.println("Enter a string to be echoed");
                echoString=scanner.nextLine();
                stringEchos.println(echoString);// send the string from the user to the server
                if (!echoString.equals("exit")){
                    response=echos.readLine();//reading from the server
                    System.out.println(response);
                }
            }while (!echoString.equals("exit"));

        }
        catch (SocketTimeoutException e){
            System.out.println("The socket timed out");
        }
        catch (IOException e){
            System.out.println("Client error "+e.getMessage());
        }
    }
}
