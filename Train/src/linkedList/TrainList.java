/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Passenger;
import Entity.Train;

/**
 *
 * @author phank
 */
import java.io.*;
import java.util.Scanner;

public class TrainList {

    TrainNode head;
    TrainNode tail;

    public TrainList() {
        this.head = null;
        this.tail = null;
    }

    public boolean isEmpty() {
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
    public TrainNode get(Train x) {
        TrainNode p = head;
        while (p != null) {
            if (p.info == x) {
                return p;
            } else {
                p = p.next;
            }
        }
        return null;
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
    

    void visit(TrainNode p) {
        System.out.print(p.info + " ");

    }

    void traverse() {
        TrainNode p = head;
        while (p != null) {
            visit(p);
            p = p.next;

        }
        System.out.println(" ");

    }

    // Thêm tàu vào cuối danh sách
    public void addTrainToEnd(Train train) {
        TrainNode newNode = new TrainNode(train);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    // Hiển thị toàn bộ thông tin tàu
    public void displayAllTrains() {
        TrainNode p = head;
        while (p != null) {
            System.out.println(p.info.toString());
            p = p.next;
        }
    }

    // Lưu danh sách tàu vào file
    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        TrainNode p = head;
        while (p != null) {
            writer.write(p.info.tcode + "," + p.info.name + "," + p.info.dstation + ","
                    + p.info.dtime + "," + p.info.seat + "," + p.info.booked + "," + p.info.atime);
            writer.newLine();
            p = p.next;
        }
        writer.close();
    }

    // Tìm kiếm tàu theo mã tcode
    public Train searchByTcode(String tcode) {
        TrainNode p = head;
        while (p != null) {
            if (p.info.tcode.equals(tcode)) {
                return p.info; // Trả về tàu tìm thấy
            }
            p = p.next;
        }
        return null; // Không tìm thấy
    }

    // Xoá tàu theo mã tcode
    public void deleteByTcode(String tcode) {
        if (isEmpty()) {
            return;
        }

        // Nếu tàu cần xoá ở đầu danh sách
        if (head.info.tcode.equals(tcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            return;
        }

        // Tìm nút trước nút cần xoá
        TrainNode prev = null;
        TrainNode p = head;
        while (p != null) {
            prev = p;
            p = p.next;
        }

        // Xoá tàu nếu tìm thấy
        if (p != null) {
            prev.next = p.next;
            if (p == tail) {
                tail = prev; // Cập nhật tail nếu tàu ở cuối danh sách bị xoá
            }
        }
    }

    // Sắp xếp tàu theo mã tcode
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

    // Thêm tàu vào đầu danh sách
    public void addTrainToBeginning(Train train) {
        TrainNode newNode = new TrainNode(train);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    //sua//
    public void addFirst(TrainNode p) {
        if (isEmpty()) {
            TrainNode q = new TrainNode();
            head = tail = q;

        } else {
            TrainNode q = new TrainNode();
            q.next = head;
            head = q;
        }
    }

    //sua//
    public void addTrainBefore(TrainNode p, int x) {
        TrainNode q = head;
        TrainNode tmp = new TrainNode();
        if (p != head) {
            TrainNode prev = getPrev(p);
            prev.next = tmp;
            tmp.next = p;
        } else {
            addFirst(p);
        }

    }
    
    public void remove(TrainNode p) {
        if (head == tail) {
            head = tail = null;
        } else if (p == head) {
            removeFirst();
        } else if (p == tail) {
            removeLast();
        } else {
            TrainNode pre = getPrev(p);
            TrainNode x = get(p.info);
            TrainNode next = getNext(p);

            x.next = null;
            pre.next = next;
        }
    }

    //Delete position k
    public void deletePosition(int x) {
        int i = 0;
        while (i != x) {
            i++;
        }
        remove(getByIndex(x));
    }

    // tìm theo tên tàu
    public void searchByName(){
        Scanner sc = new Scanner(System.in);
        
// ko hiện này ở đây
//        System.out.println(" ----- Search by Name -----");
//        System.out.print("Enter name to search: ");
        
        String nameToSearch = sc.nextLine().trim().toLowerCase(); 
        //Chuyển viết thường để dễ so sánh
        
        TrainNode p = head;
        boolean valid = false;
        
        while (p != null) {            
            if(p.info.getName().toLowerCase().equals(nameToSearch)) {
                System.out.println("Found Train: " + p.info);
                valid = true;
            }
            p = p.next;
        }
        
        if (!valid) {
            System.out.println("Can't find someone with the name: " + nameToSearch);
        }
    }

    // tìm kiếm tàu được đặt bằng tcode
    public Train searchBookedByTcode(String tcode) throws Exception {
        TrainNode current = head;
        while(current != null){
            // dùng getTcode để so sánh
            if(current.info.getTcode().equalsIgnoreCase(tcode)){
                return current.info;
            }
            current = current.next;
        }
        throw new Exception("Not found");
    }
}
