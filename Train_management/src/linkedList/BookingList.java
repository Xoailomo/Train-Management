/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Booking;
import Entity.Passenger;
import Entity.Train;

/**
 *
 * @author phank
 */
import java.io.*;
import java.util.*;

public class BookingList {
    public BookingNode head;

    public BookingList() {
        this.head = null;
    }

    // add booking to end 
    public void addBookingToEnd(Booking booking) {
        BookingNode newNode = new BookingNode(booking);
        if (head == null) {
            head = newNode; 
        } else {
            BookingNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    // 3.1. Load data from file
    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                String tcode = parts[0];
                String pcode = parts[1];
                int seat = Integer.parseInt(parts[2]);
                boolean paid = Boolean.parseBoolean(parts[3]);
                Booking booking = new Booking(tcode, pcode, seat);
                booking.setPaidDate();
                addBookingToEnd(booking);
            }
            System.out.println("Load successfully " + filename);
        } catch (IOException e) {
            System.out.println("Load error " + e.getMessage());
        }
    }

    // 3.2. Book bus
    public void bookBus(String tcode, String pcode, int seatToBook, TrainList trainList, PassengerList passengerList) {
        Train train = trainList.searchByTcode(tcode); // Tìm tàu theo tcode
        Passenger passenger = passengerList.searchByPcode(pcode); // Tìm hành khách theo pcode

        if (train == null) {
            System.out.println("Train not found with " + tcode);
            return;
        }
        if (passenger == null) {
            System.out.println("Passenger not found with " + pcode);
            return;
        }

        if (seatToBook > (train.getSeat() - train.getBooked())) {
            System.out.println("Seat to book over available seat!");
            return;
        }

        Booking booking = new Booking(tcode, pcode, seatToBook);
        addBookingToEnd(booking);

        train.setBooked(train.getBooked() + seatToBook); // update seat to book
        train.setSeat(train.getSeat() - seatToBook);

        System.out.println("Book success for passenger with code " + pcode + " in train " + tcode);
    }

    // 3.3. Display data
    public void displayBookings() {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        BookingNode current = head;
        while (current != null) {
            System.out.println(current.info);
            current = current.next;
        }
    }

    // 3.4. Save booking list to file
    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            BookingNode current = head;
            while (current != null) {
                Booking booking = current.info;
                bw.write(booking.getTcode() + " " + booking.getPcode() + " "
                        + booking.getSeat() + " " + booking.isPaid());
                bw.newLine();
                current = current.next;
            }
            System.out.println("Save to success to file " + filename);
        } catch (IOException e) {
            System.out.println("Save file error" + e.getMessage());
        }
    }

    // 3.5. Sort by tcode + pcode
    public void sortBookings() {
        if (head == null) return;
        BookingNode current, index;
        Booking temp;

        for (current = head; current.next != null; current = current.next) {
            for (index = current.next; index != null; index = index.next) {
                if (current.info.getTcode().compareTo(index.info.getTcode()) > 0 ||
                        (current.info.getTcode().equals(index.info.getTcode()) &&
                                current.info.getPcode().compareTo(index.info.getPcode()) > 0)) {

                    temp = current.info;
                    current.info = index.info;
                    index.info = temp;
                }
            }
        }
        System.out.println("Sort by tcode and pcode complete!.");
    }

    // 3.6. Pay booking by tcode + pcode
    public void payBooking(String tcode, String pcode) {
        BookingNode current = head;
        while (current != null) {
            if (current.info.getTcode().equals(tcode) && current.info.getPcode().equals(pcode)) {
                if (!current.info.isPaid()) {
                    current.info.setPaidDate(); // mark as paid
                    System.out.println("Booking for train " + tcode + " and passenger " + pcode + " is paid.");
                } else {
                    System.out.println("Already paid.");
                }
                return;
            }
            current = current.next;
        }
        System.out.println("Not found booking with tcode: " + tcode + " and pcode: " + pcode);
    }
}
