/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author phank
 */
public class Booking implements Serializable {

    private String tcode;
    private String pcode;
    private Date odate;
    private Date paid;
    private int seat;
    public Train t;

    public Booking(String tcode, String pcode, int seat) {
        this.tcode = tcode;
        this.pcode = pcode;
        this.seat = seat;
        this.odate = new Date();
        this.paid = new Date();
    }

    public String getTcode() {
        return tcode;
    }

    public String getPcode() {
        return pcode;
    }

    public Date getOdate() {
        return odate;
    }

    public int getSeat() {
        return t.getSeat() - t.getBooked();
    }

    public Date isPaid() {
        return paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    @Override
    public String toString() {
        return String.format("Booking - Train: %s |", tcode,
                " Passenger: %s |", pcode,
                " Date: %s |", odate,
                " Paid: %d |", paid,
                " Seats: %d", seat);
    }
}
