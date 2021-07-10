package com.example.awtSample;

import java.util.*;

public class Theater {
    private final String theaterName;
    //private List<Seat> seats=new ArrayList<Seat>();
    //private List<Seat> seats=new LinkedList<>();
    private List<Seat> seats=new ArrayList<Seat>();//even more generic

    public String getTheaterName() {
        return theaterName;
    }

    public Theater(String theaterName, int numRows, int seatsPerRow) {
        this.theaterName = theaterName;
        int lastRow = 'A' + (numRows -1);
        for (char row = 'A'; row <= lastRow; row++) {
            for(int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }
    public boolean reserveSeat(String seatNumber){
        Seat requestSeat=new Seat(seatNumber);
        int foundSeat=Collections.binarySearch(seats,requestSeat,null);// binary search to find a seat, it needs comparable interface being implemented by Seat class
        if (foundSeat>=0){
            return seats.get(foundSeat).reserve();
        }
        else{
            System.out.println("There is no seat "+seatNumber);
            return false;
        }
        //Seat requestSeat=null;
        //for (Seat seat:seats){
        //    System.out.print(".");
        //    if (seat.getSeatNumber().equals(seatNumber)){
        //        requestSeat=seat;
        //        break;
        //    }
        //}
//        if (requestSeat==null){
//            System.out.println("There is no "+seatNumber);
//            return false;
//        }
//        return requestSeat.reserve();
    }
    public void getSeats(){
        for (Seat seat:seats){
            System.out.println(seat.getSeatNumber());
        }
    }
    private class Seat implements Comparable<Seat>{// if it implements Comparable interface then we can use binary search tree
        private final String seatNumber;
        private boolean reserved=false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }
        public boolean reserve(){
            if (!this.reserved){
                this.reserved=true;
                System.out.println("seat "+seatNumber+" is reserved");
                return true;
            }
            else
                return false;
        }
        public boolean cancel(){
            if (this.reserved){
                this.reserved=false;
                System.out.println("Reservation of the seat "+ seatNumber+ " is cancelled");
                return true;
            }
            else
                return false;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        @Override
        public int compareTo(Seat seat) {
            return this.seatNumber.compareToIgnoreCase(seat.getSeatNumber());
        }
    }

}
