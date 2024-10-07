/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manager;

import Entity.Passenger;
import Entity.Train;
import java.util.Scanner;
import view.viewMenu;
import view.InputData;
import File.fileIO;
import static File.fileIO.writeToTxt;
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
public class MenuManger {

    private static final TrainList llt = new TrainList();
    private static final PassengerList llp = new PassengerList();
    private static final BookingList llb = new BookingList();
    private static final TrainNode tn = new TrainNode();
    private static final PassengerNode pn = new PassengerNode();
    private static final BookingNode bn = new BookingNode();
    private boolean alive = true;
    private static final viewMenu view = new viewMenu();
    private final fileIO fo = new fileIO();
    private final InputData inp = new InputData();
    private static Scanner sc;

    public void menuTrain() {
        sc = new Scanner(System.in);
        alive = true;
        while (alive) {
            view.menuTrainList();
            int choice = inp.getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 13);
            switch (choice) {
                case 1: // load from file trains.txt
                    System.out.print("Enter file name: ");
                    fo.
                    break;
                case 2: // add to the beginning
                    System.out.println(">>Add train to the beginning  ");
                    llt.addTrainToHead(getNTrain());
                    break;
                case 3: // display data
                    System.out.println(">>Display data ");
                    view.displayAllTrain(llt);
                    break;
                case 4: // save train list to file
                    System.out.print("Enter file name: ");
                    String fn = sc.nextLine();
                    fo.saveData(0, fn);
                    break;
                case 5: // search by tcode
                    System.out.print("Search by tcode: ");
                    String code = sc.nextLine();
                    Train t = llt.searchByTcode(code);
                    view.displayTrain(t);
                    break;
                case 6: // delete by tcode
                    System.out.print("Delete by tcode: ");
                    code = sc.nextLine();
                    llt.deleteByTcode(code);
                    break;
                case 7: // sort by tcode
                    System.out.print(">>Sort by tcode ");
                    llt.sortByTcode();
                    break;
                case 8: // add to the end
                    System.out.println("Add train to the end ");
                    llt.addTrainToEnd(getNTrain(), true);
                    break;
                case 9: // add before position k
                    System.out.println(">>Add before position");
                    int k = inp.getIntCond(0, Integer.MAX_VALUE);
                    llt.addTrainBefore(k, getNTrain());
                    break;
                case 10: // delete position k
                    System.out.println("Delete position: ");
                    k = inp.getIntCond(0, llt.getSize() - 1);
                    llt.deletePosition(k);
                    break;
                case 11: // search by name
                    System.out.println(">>Search by train name ");
                    String name = inp.getString("Enter train name",
                            "err", "invalid",
                            "[A-Za-z\\s]+");
                    llt.searchByName(name);
                    break;
                case 12: // search booked by tcode
                    System.out.print("Search booked by tcode; ");
                    code = sc.nextLine();
                    llt.searchBookedByTcode(code);
                    break;
                case 13: //exit
                    alive = false;
                    break;
            }
        }
    }

    public void menuPassenger() {
        alive = true;
        while (alive) {
            view.menuPassengerList();
            int choice = inp.getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 9);
            switch (choice) {
                case 1: // load 
                    System.out.print("Enter file name: ");
                    String fn = sc.nextLine();
                    fo.loadPassengerData(fn);
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
                    fo.saveData(1, fn);
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
            int choice = inp.getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 7);
            switch (choice) {
                case 1:// load
                    System.out.println("Enter file name: ");
                    String fn = sc.nextLine();
                    fo.loadBookingData(fn);
                    break;
                case 2: // booked trained

                    break;
                case 3: // display data
                    System.out.println("display all data: ");
                    view.displayBooking(llb);
                    break;
                case 4:  // save to file
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    fo.saveData(2, fn);
                    break;
                case 5: // sort by tocode and pcode
                    break;
                case 6: // pay booking by tcode abd pcode
                    break;
                case 7:
                    alive = false;
                    break;

            }
        }
    }

    private TrainNode getNTrain() {
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

    private PassengerNode getNPassenger() {
        PassengerNode npa = new PassengerNode();
        Passenger pa = new Passenger();
        // get pcode
        view.loadPassengerData(0);
        do {
            pa.pcode = sc.nextLine();
            if (llp.isPcodeUnique(pa.pcode)) {
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
            if (llp.isPhoneUnique(pa.phone)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.phone);
        } while (true);

        npa.info = pa;
        return npa;
    }
    
    

}
