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

    }
    

}
