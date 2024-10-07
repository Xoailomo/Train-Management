/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Booking;
import Entity.Train;

/**
 *
 * @author phank
 */
public class BookingList {

    public BookingNode head;
    public BookingNode tail;

    public BookingList() {
        this.head = null;
        this.tail = null;
    }
    public boolean isEmpty() {
        return head == null;
    }

    // Thêm booking vào cuối danh sách
    public void addBooking(Booking booking) {
        BookingNode newNode = new BookingNode(booking);
        if (head == null) {
            head = newNode;
        } else {
            BookingNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Hủy booking theo tcode và pcode
    public boolean cancelBooking(String tcode, String pcode) {
        if (head == null) {
            return false;
        }

        // Trường hợp hủy booking ở đầu danh sách
        if (head.info.getTcode().equals(tcode) && head.info.getPcode().equals(pcode)) {
            head = head.next;
            return true;
        }

        // Tìm và hủy booking
        BookingNode current = head;
        BookingNode prev = null;
        while (current != null && !(current.info.getTcode().equals(tcode) && current.info.getPcode().equals(pcode))) {
            prev = current;
            current = current.next;
        }

        if (current != null) {
            prev.next = current.next; // Bỏ qua node cần xóa
            return true;
        }
        return false;
    }

    // Cập nhật trạng thái thanh toán
    public boolean updatePaymentStatus(String tcode, String pcode) {
        BookingNode temp = head;
        while (temp != null) {
            if (temp.info.getTcode().equals(tcode) && temp.info.getPcode().equals(pcode)) {
                temp.info.setPaid(true); // Đánh dấu trạng thái thanh toán
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Hiển thị danh sách booking
    public void display() {
        BookingNode temp = head;
        while (temp != null) {
            System.out.println(temp.info);
            temp = temp.next;
        }
    }

//    public boolean bookSeat(String tcode, String pcode, int seatsToBook, TrainList trainList) {
//        Train train = trainList.searchByTcode(tcode);
//        if (train != null && train.getSeat() >= seatsToBook) {
//            train.setBooked(train.getBooked() + seatsToBook); // Cập nhật số ghế đã đặt
//            train.setSeat(train.getSeat() - seatsToBook); // Giảm số ghế còn lại
//            return true;
//        }
//        return false;
//    }
//
//    public boolean cancelSeat(String tcode, String pcode, int seatsToCancel, TrainList trainList) {
//        Train train = trainList.searchByTcode(tcode);
//        if (train != null) {
//            train.setBooked(train.getBooked() - seatsToCancel); // Hoàn lại số ghế đã đặt
//            train.setSeat(train.getSeat() + seatsToCancel); // Tăng số ghế còn lại
//            return true;
//        }
//        return false;
//    }

    public void addBookingToEnd(BookingNode bn) {
        if (bn == null) {
            System.out.println("TrainNode object cannot be null.");
            return;
        }
        if (isEmpty()) {
            head = tail = bn;
        } else {
            tail.next = bn;
            tail = bn;
        }
        System.out.println("TrainNode added to the end of the list successfully.");
    
    }
}