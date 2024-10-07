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
    private boolean paid;
    private int seat;
    public Train t ;


    public Booking(String tcode, String pcode, int seat) {
        this.tcode = tcode;
        this.pcode = pcode;
        this.seat = seat;
        this.odate = new Date(); // Ngày đặt vé là ngày hiện tại
        this.paid = false; // Mặc định là chưa thanh toán
    }

    // Getter và setter cho các thuộc tính
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
        return t.getSeat()-t.getBooked();
    }

    
    
    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
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
