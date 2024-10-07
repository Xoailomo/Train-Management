/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;
import Entity.Booking;
/**
 *
 * @author phank
 */
class BookingNode {
    String bcode;
    String pcode;
    Date odate;
    Date paid;
    int seat;
    BookingNode next;

    public BookingNode(String bcode, String pcode, Date odate, Date paid, int seat) {
        this.bcode = bcode;
        this.pcode = pcode;
        this.odate = odate;
        this.paid = paid;
        this.seat = seat;
        this.next = null;
    }

    public String toString() {
        return bcode + " " + pcode + " " + odate + " " + paid + " " + seat;
    }
}
public class BookingNode {
    Booking booking;  // Chứa đối tượng booking
    BookingNode next; // Tham chiếu đến node tiếp theo

    public BookingNode(Booking booking) {
        this.booking = booking;
        this.next = null;
    }
}
