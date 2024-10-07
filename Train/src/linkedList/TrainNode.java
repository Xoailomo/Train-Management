/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import java.util.*;
class TrainNode {
    String tcode;
    String name;
    String dstation;
    String astation;
    double dtime;
    int seat;
    int booked;
    double atime;
    TrainNode next;

    public TrainNode(String tcode, String name, String dstation, String astation, double dtime, int seat, int booked, double atime) {
        this.tcode = tcode;
        this.name = name;
        this.dstation = dstation;
        this.astation = astation;
        this.dtime = dtime;
        this.seat = seat;
        this.booked = booked;
        this.atime = atime;
        this.next = null;
    }

    public String toString() {
        return tcode + " " + name + " " + dstation + " " + astation + " " + dtime + " " + atime + " " + seat + " " + booked;
    }
}

