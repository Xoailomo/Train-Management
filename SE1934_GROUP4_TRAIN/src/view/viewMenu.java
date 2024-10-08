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
    public static void mainMenu() {
        String content[] = {"Train", "Passenger", "Booking"};
        System.out.println("******** main menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0. exit");

    }

    // hiển thị menu của train
    public static void menuTrainList() {
        String content[] = {"Load from file", "Add to the end",
            "Display data", "Save list to file", "search by tcode",
            "Delete by tcode", "Sort by tcode", "Add to the head",
            "Add before position k", "Delete position k",
            "Search by name", "Search booked by tcode"};
        System.out.println("******** train menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0.exit");
    }

    // hiển thị menu của passenger list
    public static void menuPassengerList() {
        System.out.println("******** passenger menu ********");
        String content[] = {"Load from file", "Add to the end",
            "Display data", "Save to file", "Search by pcode",
            "Delete by pcode", "Search by name", "Search trains by pcode"};
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0. extit");
    }

    // hiển thị menu của booking list
    public static void menuBookingList() {
        String content[] = {"Load from file", "Booked Train",
            "Display data", "save to file", "Sort by tcode+pcode",
            "pay booking by tocde+pcode"};
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0. exit");
    }

    // load train List
    public static void loadTrainData(int i) {
        String content[] = {"tcode", "name", "dstation", "astation",
            "dtime", "seat", "booked", "atime"};
        System.out.println("Enter " + content[i] + ": ");
    }

    // lpad passenger List
    public static void loadPassengerData(int i) {
        String content[] = {"pcode", "name", "phone"};
        System.out.println("Enter " + content[i] + ": ");
    }

    // loa booking list
    public static void loadBookingData(int i) {
        String content[] = {"pcode", "tcode", "odate", "paid", "seat"};
        System.out.print("Enter " + content[i] + ": ");
    }

    // Display table header
    public static void tableHeader(int[] style, String[] header) {
        System.out.print("|");
        for (int i = 0; i < style.length; i++) {
            System.out.print(tableCell(style[i], header[i]));
            System.out.print("|");
        }
        System.out.println();
    }

// Display table cells, center-aligned
    public static String tableCell(int style, String content) {
        int padding = style - content.length();
        int paddingLeft = padding / 2;
        int paddingRight = padding - paddingLeft;

        StringBuilder cellContent = new StringBuilder();
        for (int i = 0; i < paddingLeft; i++) {
            cellContent.append(" ");
        }
        cellContent.append(content);
        for (int i = 0; i < paddingRight; i++) {
            cellContent.append(" ");
        }

        return cellContent.toString();
    }

// Display table border
    public static void tableBorder(int[] style) {
        for (int i = 0; i < style.length; i++) {
            System.out.print("+");
            for (int j = 0; j < style[i]; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }

// Display train list
    public static void displayAllTrain(TrainList tl) {
        String[] header = {"tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "arrive_place", "available_seat"};
        int[] style = {10, 20, 10, 10, 15, 15, 15, 15};

        // Print header and border
        tableBorder(style);
        tableHeader(style, header);
        tableBorder(style);

        TrainNode n = tl.head;
        while (n != null) {
            Train t = n.info;
//            Train newT = new Train();
            tableHeader(style, new String[]{
                t.tcode + "", t.name, t.seat + "", t.booked + "", t.dtime + "",
                t.dstation, t.astation, (t.seat - t.booked) + ""
            });
            tableBorder(style);
            n = n.next;
        }
    }

    public static void displayTrain(Train t) {
        String[] header = {"tcode", "train_name", "seat", "booked",
            "depart_time", "depart_place", "arrive_place", "available_seat"};
        int[] style = {10, 20, 10, 10, 15, 15, 15, 15};

        // Print header and border
        tableBorder(style);
        tableHeader(style, header);
        tableBorder(style);

        tableHeader(style, new String[]{
            t.tcode + "", t.name, t.seat + "", t.booked + "", t.dtime + "",
            t.dstation, t.astation, (t.seat - t.booked) + ""
        });
        tableBorder(style);

    }

    // hiển thị passwnger list
    public static void displayPassenger(PassengerList pl) {
        String header[] = {"pcode", "passenger_name", "phone"};
        int[] style = {10, 20, 15};
        // in ra header
        tableBorder(style);
        tableHeader(style, header);
        tableBorder(style);

        PassengerNode n = pl.head;
        while (n != null) {
            Passenger p = n.info;
            tableHeader(style, new String[]{
                p.getPcode() + "", p.getName() + "", p.getPhone() + ""});
            tableBorder(style);
            n = n.next;
        }
    }

    // hiển thị booked list
    public static void displayBooking(BookingList bl) {
        String header[] = {"pcode", "tcode", "odate", "paid", "seatToBeBook"};
        int[] style = {10, 10, 15, 10, 10};
        // in ra header
        tableBorder(style);
        tableHeader(style, header);
        tableBorder(style);

        BookingNode n = bl.head;
        while (n != null) {
            Booking p = n.info;
            tableHeader(style, new String[]{
                p.getPcode() + "", p.getTcode()
                + "", p.getOdate() + "", p.isPaid()
                + "", p.getSeat() + ""});
            tableBorder(style);
            n = n.next;
        }
    }
}
