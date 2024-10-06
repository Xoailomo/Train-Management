/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import Entity.Booking;
import Entity.Passenger;
import Entity.Train;
import linkedList.BookingList;
import linkedList.BookingNode;
import linkedList.PassengerList;
import linkedList.PassengerNode;
import linkedList.TrainList;
import linkedList.TrainNode;

/**
 *
 * @author phank
 */
public class viewMenu {

    // hiển thị menu chính
    public void mainMenu() {
        String content[] = {"Train", "Passenger", "Booking"};
        System.out.println("******** main menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0.exit");

    }

    // hiển thị menu của train
    public void menuTrainList() {
        String content[] = {"Load from file", "Add to the end",
            "Display data", "Save list to file", "search by tcode",
            "Delete by tcode", "Sort by tcode", "Add to the begining",
            "Add before position k", "Delete position k",
            "Search by name", "Search booked by tcode"};
        System.out.println("******** train menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0.exit");
    }

    // hiển thị menu của passenger list
    public void menuPassengerList() {
        String content[] = {"Load from file", "Add to the end",
            "Display data", "Save to file", "Search by pcode",
            "Delete by pcode", "Search by name", "Search trains by pcode"};
        System.out.println("******** passenger menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0. extit");
    }

    // hiển thị menu của booking list
    public void menuBookingList() {
        String content[] = {"Load from file", "Booked Train",
            "Display data", "save to file", "Sort by tcode+pcode",
            "pay booking by tocde+pcode"};
        for(int i=0;i<content.length;i++){
            System.out.println("Enter "+content[i]+": ");
        }
        
    }

    // load train List
    public void loadTrainData() {
        String content[] = {"tcode", "name", "dstation", "astation",
            "dtime", "seat", "booked", "atime"};
        for (int i = 0; i < content.length; i++) {
            System.out.println("Enter " + content[i] + ": ");
        }
    }

    // lpad passenger List
    public void loadPassengerData() {
        String content[] = {"pcode", "name", "phone"};
        for (int i = 0; i < content.length; i++) {
            System.out.println("Enter " + content[i] + ": ");
        }
    }

    // loa booking list
    public void loadBookingData() {
        String content[] = {"pcode", "tcode", "odate", "paid", "seat"};
        for (int i = 0; i < content.length; i++) {
            System.out.println("Enter " + content[i] + ": ");
        }
    }

    // hiển thị đầu của bảng
    public void tableHearder(int[] style, String[] header) {
        for (int i = 0; i < style.length; i++) {
            System.out.print("|");
            for (int j = 0; j < style[i]; j++) {
                System.out.println(tableCell(style[i], header[i]));
            }
            System.out.println("|");
        }
    }

    // hiển thị các ô của bảng
    public String tableCell(int style, String content) {
        String s = content; // ? de lam gi
        int offset = style - content.length();
        for (int i = 0; i < style; i++) {
            content += " ";
        }
        return content;
    }

    // hiển thị đường viền của bảng
    public void tableBorder(int[] style) {
        for (int i = 0; i < style.length; i++) {
            System.out.print("+");
            for (int j = 0; j < style[i]; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

    // hiển thị train list
    public void displayTrain(TrainList tl) {
        String header[] = {"tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "available_seat"};
        int[] style = {10, 20, 10, 20, 15, 15, 15};
        // in ra header
        tableBorder(style);
        tableHearder(style, header);
        tableBorder(style);

        TrainNode n = tl.head;
        while (n != null) {
            Train t = n.info;
            tableHearder(style, new String[]{
                t.tcode + "", t.name + "", t.seat + "", t.booked + "", t.dtime + "",
                t.dstation + "", t.seat - t.booked + ""
            });
            tableBorder(style);
            n = n.next;
        }
    }

    // hiển thị passwnger list
    public void displayPassenger(PassengerList pl) {
        String header[] = {"pcode", "passenger_name", "phone"};
        int[] style = {10, 20, 10};
        // in ra header
        tableBorder(style);
        tableHearder(style, header);
        tableBorder(style);

        PassengerNode n = pl.head;
        while (n != null) {
            Passenger p = n.info;
            tableHearder(style, new String[]{
                p.getPcode() + "", p.getName() + "", p.getPhone() + ""});
            tableBorder(style);
            n = n.next;
        }
    }

    // hiển thị booked list
    public void displayBooking(BookingList bl) {
        String header[] = {"pcode", "tcode", "odate", "paid", "seat"};
        int[] style = {10, 10, 15, 10, 10};
        // in ra header
        tableBorder(style);
        tableHearder(style, header);
        tableBorder(style);

        BookingNode n = bl.head;
        while (n != null) {
            Booking p = n.info;
            tableHearder(style, new String[]{
                p.getPcode() + "", p.getTcode() + "", p.getOdate() + "", p.isPaid() + "", p.getSeat() + ""});
            tableBorder(style);
            n = n.next;
        }
    }
}
