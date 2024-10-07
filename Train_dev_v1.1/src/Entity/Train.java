/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;



/**
 *
 * @author phank
 */
public class Train implements Serializable {

    public String tcode;
    public String name;
    public String dstation;
    public String astation;
    public double dtime;
    public int seat;
    public int booked;
    public double atime;

    public Train() {
    }


    public Train(String tcode, String name, String dstation, String astation, double dtime, int seat, int booked, double atime) {
        this.tcode = tcode;
        this.name = name;
        this.dstation = dstation;
        this.astation = astation;
        this.dtime = dtime;
        this.seat = seat;
        this.booked = booked;
        this.atime = atime;
    }

    public String getTcode() {
        return tcode;
    }

    public String getName() {
        return name;
    }

    public int getSeat() {
        return seat;
    }

    public int getBooked() {
        return booked;
    }

    
    @Override
    public String toString() {
        return "Train Code: "+tcode+
                " |Name: "+ name+
                " |Departing station: "+ dstation+
                " |Arriving Station: "+ astation+
                " |Deprating Time: "+ dtime+
                " |Arriving Time: "+ atime+
                " |Total seats: "+ seat+
                " |seat booked: "+booked;

    }
}
