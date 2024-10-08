package main;

import Entity.Passenger;
import Entity.Train;
import view.viewMenu;
import view.InputData;
import linkedList.BookingList;
import linkedList.PassengerList;
import linkedList.TrainList;
import java.util.Scanner;
import linkedList.BookingNode;
import linkedList.PassengerNode;
import linkedList.TrainNode;

/**
 *
 * @author phank
 */
public class Main {

    private static viewMenu view = new viewMenu();
    private static InputData inp = new InputData();
    private static Scanner sc = new Scanner(System.in);
    private static TrainList tl = new TrainList();
    private static PassengerList pl = new PassengerList();
    private static BookingList bl = new BookingList();

    public static void main(String[] args) {
        TrainNode tn = new TrainNode();
        PassengerNode pn = new PassengerNode();
        BookingNode bn = new BookingNode();
        runMenu(tn, pn, bn);
    }

    public static void runMenu(TrainNode tn, PassengerNode pn, BookingNode bn) {
        while (true) {
            view.mainMenu();
            int choice = inp.getInt("Your choice:", "Error: Invalid choice.", "Please enter a number.", 0, 3);
            if (choice == 0) {
                System.out.println("thanh you!");
                break;
            }
            switch (choice) {
                // Train***************************************************
                case 1:
                    while (true) {
                        view.menuTrainList();
                        int choiceT = inp.getInt("Your choice:",
                                "Error: Invalid choice.",
                                "Please enter a number.", 0, 12);
                        if (choiceT == 0) {
                            break;
                        }
                        switch (choiceT) {
                            case 1: // load
                                System.out.println("Enter name: ");
                                String fn = sc.nextLine();
                                tl.loadFromFile(fn);
                                break;
                            case 2: // add to head
                                tl.addTrainToHead(getNTrain());
                                break;
                            case 3: // display data
                                view.displayAllTrain(tl);
                                break;
                            case 4: // save train list to file
                                fn = sc.nextLine();
                                tl.saveToFile(fn);
                                break;
                            case 5: // search by tcode
                                System.out.print("Search by tcode: ");
                                String code = sc.nextLine();
                                Train t = tl.searchByTcode(code);
                                view.displayTrain(t);
                                break;
                            case 6: // delete by tcode
                                System.out.print("Delete by tcode: ");
                                code = sc.nextLine();
                                tl.deleteByTcode(code);
                                break;
                            case 7: // sort by tcode
                                System.out.print(">>Sort by tcode ");
                                tl.sortByTcode();
                                break;
                            case 8: // add to the end
                                System.out.println("Add train to the end ");
                                tl.addTrainToEnd(getNTrain(), true);
                                break;
                            case 9: // add before position k
                                System.out.println(">>Add before position");
                                int k = inp.getIntCond(0, Integer.MAX_VALUE);
                                tl.addTrainBefore(k, getNTrain());
                                break;
                            case 10: // delete position k
                                System.out.println("Delete position: ");
                                k = inp.getIntCond(0, tl.getSize() - 1);
                                tl.deletePosition(k);
                                break;
                            case 11: // search by name
                                System.out.println(">>Search by train name ");
                                String name = inp.getString("Enter train name",
                                        "err", "invalid",
                                        "[A-Za-z\\s]+");
                                tl.searchByName(name);
                                break;
                            case 12: // search booked by tcode
                                System.out.print("Search booked by tcode; ");
                                code = sc.nextLine();
                                tl.searchBookedByTcode(code, tl, pl, bl);
                                break;
                        }
                    }
                    break;
                // Passenger************************************************
                case 2:
                    while (true) {
                        view.menuPassengerList();
                        int choiceP = inp.getInt("Your choice:", "Error: Invalid choice.", "Please enter a number.", 0, 8);
                        if (choiceP == 0) {
                            break;
                        }
                        switch (choiceP) {
                            case 1: // load 
                                System.out.print("Enter file name: ");
                                String fn = sc.nextLine();
                                pl.loadFromFile(fn);
                                break;
                            case 2: // add to the end *****
                                System.out.println(">>Add passenger to the end");
                                pl.addToTheEnd(getNPassenger());
                                break;
                            case 3: // display
                                System.out.println("Display all data: ");
                                view.displayPassenger(pl);
                                break;
                            case 4: // save to file
                                System.out.println("Enter file name: ");
                                fn = sc.nextLine();
                                tl.saveToFile(fn);
                                break;
                            case 5: // search by pcode
                                System.out.println("Search by pcode: ");
                                String pcode = sc.nextLine();
                                pl.searchByPcode(pcode);
                                break;
                            case 6: // delete by pcode 
                                System.out.println("Delete by pcode: ");
                                pcode = sc.nextLine();
                                pl.deleteByPcode(pcode);
                                break;
                            case 7: // search by name
                                System.out.println("Search by name: ");
                                String name = sc.nextLine();
                                pl.searchByName(name);
                                break;
                            case 8: // search trains by pcode
                                System.out.print("Search booked by pcode: ");
                                pcode = sc.nextLine();                                
                                pl.searchBookedByPcode(pcode);
                                break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        view.menuBookingList();
                        int choiceB = inp.getInt("Your choice:",
                                "Error: Invalid choice.",
                                "Please enter a number.", 0, 6);
                        if (choiceB == 0) {
                            break;
                        }
                        switch (choiceB) {
                            case 1:// load
                                System.out.println("Enter file name: ");
                                String fn = sc.nextLine();
                                bl.loadFromFile(fn);
                                break;
                            case 2: // booked trained
                                System.out.println("Enter tcode: ");
                                String tcode = sc.nextLine();
                                System.out.println("Enter pcode: ");
                                String pcode = sc.nextLine();
                                int seatToBook = inp.getInt("Enter seat to book: ", "", "pls input integer", 0, Integer.MAX_VALUE);                                
                                bl.bookBus(tcode, pcode, seatToBook, tl, pl);
                                break;
                            case 3: // display data
                                System.out.println("display all data: ");
                                bl.displayBookings();
                                break;
                            case 4:  // save to file
                                System.out.println("Enter file name: ");
                                fn = sc.nextLine();
                                bl.saveToFile(fn);
                                break;
                            case 5: // sort by tocode and pcode
                                bl.sortBookings();
                                break;
                            case 6: // pay booking by tcode abd pcode
                                System.out.println("Enter tcode");
                                tcode = sc.nextLine();
                                System.out.println("Enter pcode");
                                pcode = sc.nextLine();
                                bl.payBooking(tcode, pcode);
                                break;
                        }
                    }
                    break;

            }
        }
    }

    private static TrainNode getNTrain() {
        TrainNode ntrain = new TrainNode();
        Train train = new Train();
        // get tcode
        view.loadTrainData(0);
        do {
            train.tcode = sc.nextLine();
            if (!tl.duplicateTcode(train.tcode)) {
                break;
            }
            System.out.println("duplicate tcode " + train.tcode);
        } while (true);

        // get name
        view.loadTrainData(1);
        train.name = sc.nextLine();
        // get depart place
        view.loadTrainData(2);
        train.dstation = sc.nextLine();
        // get arriving station
        view.loadTrainData(3);
        train.astation = sc.nextLine();
        // get depart time
        view.loadTrainData(4);
        train.dtime = InputData.getDoubleCond(0, 24);
        // get seated
        view.loadTrainData(5);
        train.seat = inp.getIntCond(1, Integer.MAX_VALUE);
        //get booked
        view.loadTrainData(6);
        train.booked = inp.getIntCond(0, train.seat);
        // get arriving time
        view.loadTrainData(7);
        train.atime = inp.getDoubleCond(train.dtime, 24);

        ntrain.info = train;
        return ntrain;
    }

    private static PassengerNode getNPassenger() {
        PassengerNode npa = new PassengerNode();
        Passenger pa = new Passenger();
        // get pcode
        view.loadPassengerData(0);
        do {
            pa.pcode = sc.nextLine();
            if (pl.isPcodeUnique(pa.pcode)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.pcode);
        } while (true);

        // get name
        view.loadPassengerData(1);
        pa.name = sc.nextLine();
        // get phone
        view.loadPassengerData(2);
        do {
            pa.phone = inp.getString("",
                    "10 so thoi", "pls integer",
                    "\\d+");
            if (pl.isPhoneUnique(pa.phone)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.phone);
        } while (true);

        npa.info = pa;
        return npa;
    }

}
