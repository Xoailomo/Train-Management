/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Passenger;
import java.util.Scanner;

public class PassengerList {

    public PassengerNode head, tail;

    public PassengerList() {
        head = tail = null;
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public boolean duplicatePcode(String pcode) {
        PassengerNode n = head;
        while (n != null) {
            if (n.info.pcode.equals(pcode)) {
                return true;
            }
            n = n.next;
        }
        return false;
    }

    // Hiển thị toàn bộ thông tin pass3enger
    public void displayAllTrains() {
        PassengerNode p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
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

    // Kiểm tra pcode có tồn tại hay không
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

    // Kiểm tra phone có tồn tại hay không
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

    //2.2 Input & add to the end
    public void addToTheEnd(PassengerNode x) {
        // If the list is empty, set the new node as the head
        if (head == null) {
            head = x;
        } else {
            // Traverse the list to find the last node
            PassengerNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            // Set the next of the last node to the new node
            current.next = x;
        }
    }

    //2.3 Display data
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

    //2.5 Search by pcode
    public void searchByPcode(String pcode) {

        PassengerNode p = head;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                System.out.println("Found: " + p.info);
                return;
            }
            p = p.next;
        }
        System.out.println("Not found with pcode: " + pcode);
    }

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

    //2.6 Delete by pcode    
    public void deleteByPcode(String pcode) {

        if (isEmpty()) {
            System.out.println("EMPTY!");
            return;
        }
        
        // Nếu hành khách cần xoá ở đầu danh sách
        if (head.info.pcode.equals(pcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Delete passenger with pcode: " + pcode + " successfully.");
            return;
        }

        // Tìm nút trước nút cần xoá
        PassengerNode prev = null;
        PassengerNode p = head;
        while (p != null && !p.info.pcode.equals(pcode)) {
            prev = p;
            p = p.next;
        }

        // Xoá hành khách nếu tìm thấy
        if (p != null) { // Có nghĩa là tìm thấy hành khách cần xoá
            prev.next = p.next;
            if (p == tail) {
                tail = prev; // Cập nhật tail nếu hành khách ở cuối danh sách bị xoá
            }
            System.out.println("Delete passenger with pcode: " + pcode + " successfully.");
        } else {
            // Nếu không tìm thấy hành khách với mã pcode
            System.out.println("Not found passenger with pcode: " + pcode + ".");
        }
    }

    //2.7 Search by name
    public void searchByName(String name) {
        Scanner sc = new Scanner(System.in);

        System.out.println(" ----- Search by Name -----");
        System.out.print("Enter name to search: ");
        name = sc.nextLine().trim().toLowerCase();
        //Chuyển viết thường để dễ so sánh

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
    
    //2.8 Search trains by pcode 
    public void searchTrainByPcode(String pcode){
        
    }
    
}
