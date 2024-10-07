package main;

import File.fileIO;
import Validate.validate;
import java.util.Scanner;
import linkedList.BookingList;
import linkedList.PassengerList;
import linkedList.TrainList;
import static sun.nio.ch.IOUtil.load;
import view.viewMenu;
import Validate.validate;
import Controller.MenuManager;
import Entity.Passenger;
import Entity.Train;
import linkedList.PassengerNode;
import linkedList.TrainNode;

/**
 *
 * @author phank
 */
public class Main {

    private static boolean alive;
    private static Scanner sc;
    private static fileIO fo;
    private static viewMenu view;

    private static TrainList llt;
    private static PassengerList llp;
    private static BookingList llb;

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        alive = true;
        sc = new Scanner(System.in);
        fo = new fileIO();
        view = new viewMenu();

        // Initialize linked lists
        llt = new TrainList();
        llp = new PassengerList();
        llb = new BookingList();

        while (alive) {
            view.mainMenu();
            int choice = getInt("Your choice:", "Error: Invalid choice.", "Please enter a number.", 1, 4);
            switch (choice) {
                case 1:
                    menuTrain();
                    break;
                case 2:
                    menuPassenger();
                    break;
                case 3:
                    menuBooking();
                    break;
                case 4:
                    alive = false;
                    break;
                default:
                    System.out.println("Unexpected value: " + choice);
            }
        }
    }

    public void menuTrain() {
        alive = true;
        String fn = "";
        while (alive) {
            view.menuTrainList();
            int choice = getInt("Your choice:", "Error: Invalid choice.", "Please enter a number.", 1, 4);
            switch (choice) {
                case 1: // load
                    System.out.print("Enter file name: ");
                    fn = sc.nextLine();
                    loadData(0, fn);
                    break;
                case 2: // add to head
                    System.out.println(">>Add train to head  ");
                    llt.addTrainToHead(getNTrain());
                    break;
                case 3: // display data
                    System.out.println("Display data: ");
                    view.displayTrain(llt);
                    break;
                case 4: // save train list to file
                    System.out.print("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(0, fn);
                    break;
                case 5: // search by tcode
                    System.out.print("Search by tcode: ");
                    String code = sc.nextLine();
                    llt.searchByTcode(code);
                    break;
                case 6: // delete by tcode
                    System.out.print("Delete by tcode: ");
                    code = sc.nextLine();
                    llt.deleteByTcode(code);
                    break;
                case 7: // sort by tcode
                    System.out.print("Sort by tcode: ");
                    code = sc.nextLine();
                    llt.sortByTcode();
                    break;
                case 8: // add to the end
                    System.out.print("Add train to the endof list: ");
                    llt.addTrainToEnd(getNTrain());
                    break;
                case 9: // add before position k
                    int k = sc.nextInt();
                    System.out.printf("Add before position %d", k);
                    llt.addTrainBefore(k);
                    break;
                case 10: // delete position k
                    k = sc.nextInt();
                    System.out.print("Delete position k: ");
                    llt.deletePosition(k);
                    break;
                case 11: // search by name
                    System.out.print("Search by train name: ");
                    String name = sc.nextLine();
                    llt.searchByName(name);
                    break;
                case 12: // search booked by tcode
                    System.out.print("Search booked by tcode; ");
                    code = sc.nextLine();
                    llt.searchBookedByTcode(code);
                    break;
                case 0: //exit
                    alive = false;
                    break;
            }
        }
    }

    public void menuPassenger() {
        alive = true;
        while (true) {
            view.menuPassengerList();
             int choice = getInt("Your choice:", 
                     "Error: Invalid choice.", 
                     "Please enter a number.", 1, 9);
            switch (choice) {
                case 1: // load 
                    System.out.print("Enter file name: ");
                    String fn = sc.nextLine();
                    loadData(1, fn);
                    break;
                case 2: // add to the end *****
                    System.out.println(">>Add passenger to the end");
                    
                    llp.addToTheEnd(getNPassenger());
                    break;
                case 3: // display
                    System.out.println("Display all data: ");
                    view.displayPassenger(llp);
                    break;
                case 4: // save to file
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(0, fn);
                    break;
                case 5: // search by pcode
                    System.out.println("Search by pcode: ");
                    String pcode = sc.nextLine();
                    llp.searchByPcode(pcode);
                    break;
                case 6: // delete by pcode 
                    System.out.println("Delete by pcode: ");
                    pcode = sc.nextLine();
                    llp.deleteByPcode(pcode);
                    break;
                case 7: // search by name
                    System.out.println("Search by name: ");
                    String name = sc.nextLine();
                    llp.searchByName(name);
                    break;
                case 8: // search trains by pcode
                    System.out.println("Search trains by pcode: ");
                    pcode = sc.nextLine();
                    llp.searchByPcode(pcode);
                    break;
                case 9:
                    alive = false;
                    break;
            }
        }
    }

    public void menuBooking() {
        alive = true;
        while (alive) {
            view.menuBookingList();
            int choice = getInt("Your choice:", 
                    "Error: Invalid choice.", 
                    "Please enter a number.", 1, 4);
            switch (choice) {
                case 1:// load
                    System.out.println("Enter file name: ");
                    String fn = sc.nextLine();
                    loadData(0, fn);
                    break;
                case 2: // booked trained
                    System.out.println("");
                case 3: // display data
                    System.out.println("display all data: ");
                    view.displayBooking(llb);
                    break;
                case 4:  // save to file
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(0, fn);
                    break;
                case 5: // sort by tocode and pcode
                case 6: // pay booking by tcode abd pcode
                case 7:
                    alive = false;
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
            if (!llt.duplicateTcode(train.tcode)) {
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
        train.dtime = getDoubleCond(0, 24);
        // get seated
        view.loadTrainData(5);
        train.seat = getIntCond(1, Integer.MAX_VALUE);
        //get booked
        view.loadTrainData(6);
        train.booked = getIntCond(0, train.seat);
        // get arriving time
        view.loadTrainData(7);
        train.atime = getDoubleCond(train.dtime, 24);

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
            if (!llp.duplicatePcode(pa.pcode)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.pcode);
        } while (true);

        // get name
        view.loadPassengerData(1);
        pa.name = sc.nextLine();
        // get phone
        view.loadPassengerData(2);
        pa.phone = sc.nextLine();

        npa.info = pa;
        return npa;
    }

    public static void loadData(int x, String fn) {
        switch (x) {
            case 0:
                llt = fo.read(fn);
                if (llt == null) {
                    llt = new TrainList();
                }
                break;
            case 1:
                llp = fo.read(fn);
                if (llp == null) {
                    llp = new PassengerList();
                }
                break;
            case 2:
                llb = fo.read(fn);
                if (llb == null) {
                    llb = new BookingList();
                    break;
                }
        }
    }

    private static int getIntCond(int min, int max) {
        int n = getInt("","","",Integer.MIN_VALUE,Integer.MAX_VALUE);
        if (n < min) {
            System.out.println("inp must be > " + min);
            return getIntCond(min, max);
        }
        if (n > max) {
            System.out.println("inp must be <" + max);
            return getIntCond(min, max);
        }
        return n;
    }

    private static double getDoubleCond(double min, double max) {
        double n = getDouble();
        if (n < min) {
            System.out.println("inp must be > " + min);
            return getDoubleCond(min, max);
        }
        if (n > max) {
            System.out.println("inp must be < " + max);
            return getDoubleCond(min, max);
        }
        return n;
    }

    public static int getInt(String message, String error,
            String invalid, int min, int max) {
        do {
            System.out.println(message);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(error);
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        } while (true);

    }

    public static double getDouble() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            return getDouble();
        }
    }

    public static void saveData(int x, String fn) {
        switch (x) {
            case 0:
                fo.write(llt, fn);

                break;
            case 1:
                fo.write(llp, fn);

                break;
            case 2:
                fo.write(llb, fn);

                break;
        }
    }

}
