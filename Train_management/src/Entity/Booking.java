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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Booking {
    private String tcode;       // Mã tàu
    private String pcode;       // Mã hành khách
    private Date odate;         // Ngày đặt vé
    private Date paidDate;      // Ngày thanh toán (null nếu chưa thanh toán)
    private int seat;           // Số ghế đặt

    // Constructor khởi tạo booking với ngày đặt hiện tại và chưa thanh toán
    public Booking(String tcode, String pcode, int seat) {
        this.tcode = tcode;
        this.pcode = pcode;
        this.seat = seat;
        this.odate = new Date(); // Lấy thời gian hiện tại làm ngày đặt
        this.paidDate = null;    // Chưa thanh toán, gán giá trị null cho paidDate
    }

    // Getter cho tcode
    public String getTcode() {
        return this.tcode;
    }

    // Getter cho pcode
    public String getPcode() {
        return this.pcode;
    }

    // Kiểm tra xem đã thanh toán hay chưa (nếu paidDate khác null tức là đã thanh toán)
    public boolean isPaid() {
        return this.paidDate != null;
    }

    // Getter cho ngày thanh toán
    public Date getPaidDate() {
        return this.paidDate;
    }

    // Setter cho ngày thanh toán (đặt ngày thanh toán là ngày hiện tại)
    public void setPaidDate() {
        this.paidDate = new Date();
    }

    // Getter cho số ghế
    public int getSeat() {
        return this.seat;
    }

    // Getter cho ngày đặt vé
    public Date getOdate() {
        return this.odate;
    }

    // Phương thức toString hiển thị thông tin booking một cách rõ ràng
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); // Định dạng ngày theo chuẩn
        String paidStatus = (this.paidDate == null) ? "Not Paid" : "Paid on " + sdf.format(this.paidDate);
        return String.format("Booking - Train: %s | Passenger: %s | Date: %s | Paid: %s | Seats: %d",
                this.tcode, this.pcode, sdf.format(this.odate), paidStatus, this.seat);
    }
}
