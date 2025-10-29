package BusReservation;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1,false,2));
        buses.add(new Bus(2,true,3));
        buses.add(new Bus(3,true,3));

        for(Bus b:buses){
            b.displayBusInfo();
        }

        int userOpt = 1;
        while (userOpt==1) {
            System.out.println("Enter 1 to book and 2 to exit");
            userOpt=scanner.nextInt();
            if(userOpt==1){
                Booking booking = new Booking();
                if(booking.isAvailable(bookings,buses)){
                    bookings.add(booking);
                }
                else {
                    System.out.println("Capacity full !!!!!");
                }
            }

        }
        for(Booking booking1:bookings){
            booking1.displayBookingInfo();
        }
    }
}