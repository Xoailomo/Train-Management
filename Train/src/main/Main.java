/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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

/**
 *
 * @author phank
 */
public class Main {

    private final String booking_fn = "booking.dat";
    private final String passenger_fn = "passenger.dat";
    private final String train_fn = "train.dat";

    private Scanner sc;
    private fileIO fo;
    private TrainList llt;
    private PassengerList llp;
    private BookingList llb;
    private viewMenu view;

    private boolean alive;

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        alive = true;
        sc = new Scanner(System.in);
        fo = new fileIO();
        view = new viewMenu();

        // khởi tạo các linkedList
        llt = new TrainList();
        llp = new PassengerList();
        llb = new BookingList();
    }

    private void menuTrain(validate va) {
        boolean alive = true;
        while (alive) {
            view.mainMenu();
            switch (getInteger()) {
                case 1: // load
                    System.out.print("Enter file name: ");
                    String fn = sc.nextLine();
                    loadData(0, fn);
                    break;
                case 2: // add to end
                    System.out.print("**add train to end of list ");
                    llt.addTrainToEnd(get);

                case 3: // display data
                case 4: // save train list to file
                case 5: // search by tcode
                case 6: // delete by tcode
                case 7: // sort by tcode
                case 8: // add to beginning
                case 9: // add before position k
                case 10: // delete position k
                case 11: // search by name
                case 12: // search booked by tcode
                case 0: //exit

            }
        }
    }

    private void menuPassenger() {

    }

    private void menuBooking() {

    }

    public int getInteger() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            return getInteger();
        }
    }

    public String getString() {
        do {
            String str = sc.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }

    public double getDouble() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (Exception e) {
            return getDouble();
        }
    }

    public void loadData(int x, String fn) {
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

    public void saveData(int x) {
        switch (x) {
            case 0:
                fo.write(llt, train_fn);
                if (llt == null) {
                    llt = new TrainList();
                }
                break;
            case 1:
                fo.write(llp, passenger_fn);
                if (llp == null) {
                    llp = new PassengerList();
                }
                break;
            case 2:
                fo.write(llb, booking_fn);
                if (llb == null) {
                    llb = new BookingList();
                    break;
                }
        }
    }
}
