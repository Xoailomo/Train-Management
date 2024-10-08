/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Booking;
import Entity.Passenger;
import java.util.Scanner;

public class PassengerList {

    public static PassengerNode head, tail;

    public PassengerList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public PassengerNode get(Passenger x) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            } else {
                p = p.next;
            }
        }
        return null;
    }

    public PassengerNode getNext(PassengerNode p) {
        if (p.next != null) {
            return p.next;
        } else {
            return null;
        }
    }

    public PassengerNode getPrev(PassengerNode p) {
        PassengerNode x = head;
        while (x != null) {
            if (x.next == p) {
                break;
            } else {
                x = x.next;
            }
        }
        return x;
    }

    public int getSize() {
        PassengerNode x = head;
        int count = 0;
        while (x != null) {
            count++;
            x = x.next;
        }
        return count;
    }

    public void removeFirst() {
        head.next = null;
        head = getNext(head);
    }

    public void removeLast() {
        tail = getPrev(tail);
        tail.next = null;
    }

    // check uinique
    public boolean isPcodeUnique(String pcode) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info.getPcode().equals(pcode)) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    // check phone exist
    public boolean isPhoneUnique(String phone) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info.getPhone().equals(phone)) {
                return false;
            }
            p = p.next;
        }
        return true;
    }

    // 2.2. Input & add to the end
    public void addToTheEnd(PassengerNode x) {
        if (head == null) {
            head = x;
        } else {
            PassengerNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = x;
        }
    }

    public void visit(PassengerNode p) {
        System.out.println(p.info);
    }

    public void traverse() {
        PassengerNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;
        }
        System.out.println();
    }

    //2.5. Search by pcode
    public static Passenger searchByPcode(String pcode) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                System.out.println("Found passenger: " + p.info);
                return p.info;
            }
            p = p.next;
        }
        System.out.println("Not found passenger " + pcode);
        return null;
    }

    //use for 2.6
    public void remove(PassengerNode p) {
        if (getSize() == 1) {
            head = tail = null;
        } else if (p == head) {
            removeFirst();
        } else if (p == tail) {
            removeLast();
        } else {
            PassengerNode pre = getPrev(p);
            PassengerNode x = get(p.info);
            PassengerNode next = getNext(p);

            x.next = null;
            pre.next = next;
        }
    }

    // 2.6. Delete by pcode
    public void deleteByPcode(String pcode) {
        if (isEmpty()) {
            System.out.println("Empty List!");
            return;
        }
        if (head.info.pcode.equals(pcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Delete passenger with code " + pcode + " success");
            return;
        }
        PassengerNode prev = null;
        PassengerNode p = head;
        while (p != null && !p.info.pcode.equals(pcode)) {
            prev = p;
            p = p.next;
        }
        if (p != null) {
            prev.next = p.next;
            if (p == tail) {
                tail = prev;
            }
            System.out.println("Delete passenger with code " + pcode + " success.");
        } else {
            // Nếu không tìm thấy tàu với mã tcode
            System.out.println("not found " + pcode + ".");
        }
    }

    // 2.7. Search by name
    public void searchByName(String name) {
        name = name.trim().toLowerCase();
        PassengerNode p = head;
        boolean valid = false;
        while (p != null) {
            if (p.info.getName().toLowerCase().equals(name)) {
                System.out.println("Found Passenger: " + p.info);
                valid = true;
            }
            p = p.next;
        }
        if (!valid) {
            System.out.println("Can't find someone with the name: " + name);
        }
    }

    private static void listTrain(Booking booking) {
        // Assuming Booking has a method to return passenger details
        System.out.println("Train Code: " + booking.getTcode());
        // Add more details as necessary
    }

    //2.8 Search trains by pcode
    public Passenger searchBookedByPcode(String pcode) {
        BookingList bl = new BookingList();
        BookingNode current = bl.head;
        boolean found = false; // Flag to check if any booking was found

        while (current != null) {
            // Check if the booking's train code matches the input pcode
            if (current.info.getPcode().equals(pcode)) {
                found = true; // Mark as found
                // Get passenger details by pcode
                Passenger passenger = PassengerList.searchByPcode(pcode);
                if (passenger != null) {
                    System.out.println("Passenger Details: " + passenger); // Display passenger information
                } else {
                    System.out.println("Passenger not found for pcode: " + pcode);
                }

                // List train
                System.out.println("Passengers who booked this train:");
                listTrain(current.info); // Call to display train info
            }
            current = current.next; // Move to the next booking
        }

        // If no booking was found
        if (!found) {
            System.out.println("No bookings found for train code: " + pcode);
        }
        return null;
    }

}
