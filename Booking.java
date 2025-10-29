package BusReservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the passenger name : ");
        passengerName = scanner.next();
        System.out.println("Enter the Bus Number : ");
        busNo = scanner.nextInt();
        System.out.println("Enter the date (dd-mm-yyyy) : ");
        String dateInput = scanner.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try {
            date=dateFormat.parse(dateInput);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity =0;
        for(Bus bus:buses){
            if(bus.getBusNo()==busNo){
                capacity=bus.getCapacity();
            }
        }
        int booked = 0;
        for(Booking b:bookings){
            if(b.busNo==busNo && b.date.equals(date)){
                booked++;
            }
        }

        return booked<capacity?true:false;
    }
    public void displayBookingInfo(){
        System.out.println("Name of the passenger : "+passengerName+"\n"+" Bus No : "+busNo+"\n"+" Date of Travel : "+date);
    }


}