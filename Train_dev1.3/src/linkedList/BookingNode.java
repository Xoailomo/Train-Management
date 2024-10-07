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
public class BookingNode {
    public Booking info;
    public BookingNode next;

    public BookingNode() {
    }

    public BookingNode(Booking info){
        this.info = info;
        next = null;
    }
    public BookingNode(Booking info, BookingNode next) {
        this.info = info;
        this.next = next;
    }
}