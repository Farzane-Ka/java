package com.example.awtSample;

public class Main {

    public static void main(String[] args) {
        // write your code here
    Theater theater=new Theater("Kino",7,11);
   // theater.getSeats();//print the seat numbers
    if(theater.reserveSeat("H11")){
        System.out.println("Please pay");
    }
    else {
        System.out.println("Sorry, seat is taken");
    }
        if(theater.reserveSeat("H11")){// we should get an error
            System.out.println("Please pay");
        }
        else {
            System.out.println("Sorry, seat is taken");
        }
    }
}
