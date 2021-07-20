//the code reads from a url address
package com.example.awtSample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        try {// by having a base uri we can change the server
            URL url= new URL("http://example.org");
            URLConnection urlConnection=url.openConnection();
            urlConnection.setDoOutput(true);// configuration before the connect() method to set it on the output
            urlConnection.connect();

            BufferedReader input=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            //BufferedReader input=new BufferedReader(new InputStreamReader(url.openStream()));
            String line="";
            while (line!=null){
                line=input.readLine();
                System.out.println(line);
            }
            input.close();
           // URI uri=url.toURI();
            //System.out.println ("Scheme = " + uri.getScheme ());
            //System.out.println ("Scheme-specific part = " + uri.getSchemeSpecificPart());
            // System.out.println ("Authority = " + uri.getAuthority());
            // System.out.println ("User Info = " + uri.getUserInfo());
            // System.out.println ("Host = " + uri.getHost());
            // System.out.println ("Port = " + uri.getPort());
            // System.out.println ("Path = " + uri.getPath());
            // System.out.println ("Query = " + uri.getQuery());
            // System.out.println ("Fragment = " + uri.getFragment());
        }
        catch(IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }

    }
}
