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

    // Thêm Passenger vào cuối
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

    //Hiển thị thông tin
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

    //Tìm kiếm bằng pcode
    public void searchByPcode(String pcode) {
//        if (isEmpty()){
//            System.out.println("danh deo co");
//        }
//            
//        PassengerNode p = head;
//        while (p != null) {
//            if (p.info.getPcode().equals(pcode)) {
//                return p;
//            }
//            p = p.next;
//        }
//        return null;
        PassengerNode p = head;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                System.out.println("Tàu tìm thấy: " + p.info);
                return;
            }
            p = p.next;
        }
        System.out.println("Không tìm thấy tàu với mã " + pcode);
    }

//public void searchWithInput() {
//        Scanner sc = new Scanner(System.in);
//
//        while (true) {
//            System.out.println(" ----- Tim kiem bang Pcode ----- ");
//            System.out.print("Enter pcode: ");
//            String pcode = sc.nextLine().trim();
//
//            PassengerNode p = searchByPcode(pcode);
//            if (p != null) {
//                System.out.println("Passenger found: " + p.info);
//                System.out.println("");
//                break;
//            } else {
//                System.out.println("Passenger not found");
//            }
//            System.out.println("");
//        }
//    }
    //Delete by Pcode
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

    // Bổ sung BookList để xóa được hết các list đã được đặt của hành khách
    public void deleteByPcode(String pcode) {
//        Scanner sc = new Scanner(System.in);
//        
//        while (true) {
//            System.out.println(" ----- Xoa thong tin bang Pcode ----- ");
//            System.out.print("Enter pcode: ");
//            pcode = sc.nextLine().trim();
//
//            PassengerNode p = searchByPcode(pcode); //Tìm Pcode cần xóa
//            if (p != null) {
//                remove(p); //Xóa Passenger
//                System.out.println("Passenger found: " + p.info);
//                System.out.println("Xóa hoàn tất!");
//                System.out.println("");
//                break;
//            } else {
//                System.out.println("Passenger not found");
//            }
//            System.out.println("");
//        }
//    }
        if (isEmpty()) {
            System.out.println("Danh sách rỗng. Không có tàu để xoá.");
            return;
        }

        // Nếu tàu cần xoá ở đầu danh sách
        if (head.info.pcode.equals(pcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Xoá tàu có mã " + pcode + " thành công.");
            return;
        }

        // Tìm nút trước nút cần xoá
        PassengerNode prev = null;
        PassengerNode p = head;
        while (p != null && !p.info.pcode.equals(pcode)) {
            prev = p;
            p = p.next;
        }

        // Xoá tàu nếu tìm thấy
        if (p != null) { // Có nghĩa là tìm thấy tàu cần xoá
            prev.next = p.next;
            if (p == tail) {
                tail = prev; // Cập nhật tail nếu tàu ở cuối danh sách bị xoá
            }
            System.out.println("Xoá tàu có mã " + pcode + " thành công.");
        } else {
            // Nếu không tìm thấy tàu với mã tcode
            System.out.println("Không tìm thấy tàu có mã " + pcode + ".");
        }
    }

    // Tìm kiếm theo tên
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

}
