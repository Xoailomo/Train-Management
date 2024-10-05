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
    Booking data; // Lưu trữ thông tin đặt vé
    BookingNode next; // Con trỏ tới node tiếp theo

    public BookingNode(Booking data) {
        this.data = data;
        this.next = null;
    }
}
