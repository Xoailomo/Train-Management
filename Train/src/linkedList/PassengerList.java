/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;


import Entity.Passenger;
import java.util.Scanner;

class PassengerList {
    PassengerNode head;

    public PassengerList() {
        this.head = null;
    }

    // Thêm hành khách vào cuối danh sách
    public void addPassengerToEnd(String pcode, String name, String phone) {
        PassengerNode newPassenger = new PassengerNode(pcode, name, phone);
        if (head == null) {
            head = newPassenger;
        } else {
            PassengerNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newPassenger;
        }
    }

    // Hiển thị tất cả hành khách
    public void displayPassengers() {
        PassengerNode temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    // Tìm kiếm hành khách theo pcode
    public PassengerNode searchByPcode(String pcode) {
        PassengerNode temp = head;
        while (temp != null) {
            if (temp.pcode.equals(pcode)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}

