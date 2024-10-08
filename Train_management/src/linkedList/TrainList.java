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
public class TrainList {

    public static TrainNode head;
    public static TrainNode tail;

    public TrainList() {
        this.head = null;
        this.tail = null;
    }

    public static boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        TrainNode x = head;
        int count = 0;
        while (x != null) {
            count++;
            x = x.next;
        }
        return count;
    }

    public TrainNode getNext(TrainNode p) {
        if (p.next != null) {
            return p.next;
        } else {
            return null;
        }
    }

    public TrainNode getPrev(TrainNode p) {
        TrainNode x = head;
        while (x != null) {
            if (x.next == p) {
                break;
            } else {
                x = x.next;
            }
        }
        return x;
    }

    public TrainNode getByIndex(int index) {
        TrainNode p = head;
        int i = 0;
        while (p != null && i != index) {
            i++;
            p = p.next;

        }
        return p;
    }

    public void removeFirst() {
        head.next = null;
        head = getNext(head);
    }

    public void removeLast() {
        tail = getPrev(tail);
        tail.next = null;
    }

    public void traverse() {
        TrainNode p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;

        }
        System.out.println();

    }

    public boolean duplicateTcode(String tcode) {
        TrainNode n = head;
        while (n != null) {
            if (n.info.tcode.equals(tcode)) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    // add train to tail
    public void addToTail(Train x) {
        TrainNode q = new TrainNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // 1.2 Input & add to the end
    public static void addTrainToEnd(TrainNode newNode, boolean print) {
        if (newNode == null) {
            System.out.println("TrainNode object cannot be null.");
            return;
        }
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        if (print == true) {

            System.out.println("TrainNode added to the end of the list successfully.");
        }
    }

    // 1.5 search by tcode
    public static Train searchByTcode(String tcode) {
        TrainNode p = head;
        while (p != null) {
            if (p.info.tcode.equals(tcode)) {
                System.out.println("Found train: ");
                return p.info;
            }
            p = p.next;
        }
        System.out.println("Tcode train not found " + tcode);
        return null;
    }

    // 1.6 Delete by tcode
    public void deleteByTcode(String tcode) {
        if (isEmpty()) {
            System.out.println("Train list is Empty!");
            return;
        }

        // if train at head
        if (head.info.tcode.equals(tcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Delete train with code " + tcode + " ,success!");
            return;
        }

        // find previous node of delete node
        TrainNode prev = null;
        TrainNode p = head;
        while (p != null && !p.info.tcode.equals(tcode)) {
            prev = p;
            p = p.next;
        }

        // delete train if found
        if (p != null) { // mean found it
            prev.next = p.next;
            if (p == tail) {
                tail = prev; // update tail if train at tail
            }
            System.out.println("Delete train with code " + tcode + " ,sucess!");
        } else {
            System.out.println("Not found train with code " + tcode + ".");
        }
    }

    // 1.7 Sort by tcode
    public void sortByTcode() {
        if (isEmpty()) {
            return;
        }
        TrainNode i = head;
        while (i != null) {
            TrainNode j = i.next;
            while (j != null) {
                if (i.info.tcode.compareTo(j.info.tcode) > 0) {
                    Train temp = i.info;
                    i.info = j.info;
                    j.info = temp;
                }
                j = j.next;
            }
            i = i.next;
        }
    }

    // 1.8 Input & add to beginning
    public void addTrainToHead(TrainNode newNode) {
        if (newNode == null) {
            return;
        }
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // use for 1.9
    public void insertBefore(TrainNode node, TrainNode newNode) {
        if (node == head) {
            // Nếu node là node đầu tiên, chèn trước đầu danh sách
            newNode.next = head;
            head = newNode;
        } else {
            // Duyệt danh sách để tìm node đứng trước node cần chèn
            TrainNode current = head;
            while (current != null && current.next != node) {
                current = current.next;
            }
            if (current != null) {
                current.next = newNode;
                newNode.next = node;
            }
        }
    }

    // 1.9 Add before position k
    public void addTrainBefore(int position, TrainNode newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            System.out.println("Train added to an empty list at the beginning.");
            return;
        }
        //  if insert at position 0: insert at head
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            System.out.println("Train added at the beginning.");
            return;
        }

        // check position valid
        TrainNode nodeAtK = getByIndex(position);
        if (nodeAtK == null) {
            System.out.println("Invalid position. Please enter a valid position.");
            return;
        }

        // get node at k-1
        TrainNode nodeAtKMinus1 = getByIndex(position - 1);
        if (nodeAtKMinus1 != null) {
            // insert before k
            insertBefore(nodeAtK, newNode);
            System.out.println("Train added before position " + position);
        } else {
            System.out.println("Invalid position.");
        }
    }

    // use for 1.10
    public void remove(TrainNode p) {
        if (head == tail) {
            head = tail = null;
        } else if (p == head) {
            removeFirst();
        } else if (p == tail) {
            removeLast();
        } else {
            TrainNode pre = getPrev(p);
            if (pre != null) {
                pre.next = p.next;
                p.next = null;
            }
        }
    }

    // 1.10 delete position k
    public void deletePosition(int position) {
        TrainNode nodeAtPosition = getByIndex(position);
        if (nodeAtPosition == null) {
            System.out.println("Invalid position. No node found at position " + position);
            return;
        }
        remove(nodeAtPosition);
        System.out.println("Delete successfully!");
    }

    // 1.11 search by name
    public Train searchByName(String name) {
        TrainNode current = head;
        while (current != null) {
            if (current.info.getName().equalsIgnoreCase(name)) {
                System.out.println(current.info.toString());
                return current.info;
            }
            current = current.next;
        }
        System.out.println("Not found");
        return null;
    }

    // use for 1.12
    private static void listPassengers(Booking booking) {
        System.out.println("Passenger Code: " + booking.getPcode());
    }

    //1.12 Search booked by tcode
    public Train searchBookedByTcode(String tcode) {
        BookingList bl = new BookingList();
        BookingNode current = bl.head;
        boolean found = false;
        while (current != null) {
            if (current.info.getTcode().equals(tcode)) {
                found = true; // Mark as found
                Train train = TrainList.searchByTcode(tcode);
                if (train != null) {
                    System.out.println("Train Details: " + train); // Display train information
                } else {
                    System.out.println("Train not found for tcode: " + tcode);
                }
                System.out.println("Passengers who booked this train:");
                listPassengers(current.info);
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("No bookings found for train code: " + tcode);
        }
        return null;
    }
}
