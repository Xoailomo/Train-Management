/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;


import java.io.*;

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
            writer.write(p.info.tcode + "," + p.info.name + "," + p.info.dstation + "," +
                         p.info.dtime + "," + p.info.seat + "," + p.info.booked + "," + p.info.atime);
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
        if (isEmpty()) return;

        // Nếu tàu cần xoá ở đầu danh sách
        if (head.info.tcode.equals(tcode)) {
            head = head.next;
            if (head == null) tail = null;
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
        if (isEmpty()) return;
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
}

