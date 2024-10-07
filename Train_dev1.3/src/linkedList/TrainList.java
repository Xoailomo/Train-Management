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

    public TrainNode head;
    public TrainNode tail;

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

    public void traverse() {
        TrainNode p = head;
        while (p != null) {
            System.out.println(p.info);
            p = p.next;

        }
        System.out.println();

    }

    public void displayTrainList() {
        if (isEmpty()) {
            System.out.println("The train list is empty.");
            return;
        }

        TrainNode current = head;
        while (current != null) {
            System.out.println(current.info); // In thông tin của Train từ current.info
            current = current.next;
        }
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

    public void addTrainToEnd(TrainNode newNode, boolean print) {
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

//    // Thêm một TrainNode vào cuối danh sách
//    public void addTrainToEnd(TrainNode newNode) {
//        if (newNode == null) {
//            System.out.println("TrainNode object cannot be null.");
//            return;
//        }
//        System.out.println("Adding train: " + newNode.info); // In ra thông tin trước khi thêm
//        if (isEmpty()) {
//            head = tail = newNode;
//        } else {
//            tail.next = newNode;
//            tail = newNode;
//        }
//        System.out.println("TrainNode added to the end of the list successfully.");
//    }
//    // Hiển thị toàn bộ thông tin tàu
//    public void displayAllTrains() {
//        TrainNode p = head;
//        while (p != null) {
//            System.out.println(p.info.toString());
//            p = p.next;
//        }
//    }
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
    public void searchByTcode(String tcode) {
        TrainNode p = head;
        while (p != null) {
            if (p.info.tcode.equals(tcode)) {
                System.out.println("Tàu tìm thấy: " + p.info);
                return;
            }
            p = p.next;
        }
        System.out.println("Không tìm thấy tàu với mã " + tcode);
    }

//    // Xoá tàu theo mã tcode
//    public void deleteByTcode(String tcode) {
//        if (isEmpty()) {
//            return;
//        }
//
//        // Nếu tàu cần xoá ở đầu danh sách
//        if (head.info.tcode.equals(tcode)) {
//            head = head.next;
//            if (head == null) {
//                tail = null;
//            }
//            return;
//        }
//
//        // Tìm nút trước nút cần xoá
//        TrainNode prev = null;
//        TrainNode p = head;
//        while (p != null) {
//            prev = p;
//            p = p.next;
//        }
//
//        // Xoá tàu nếu tìm thấy
//        if (p != null) {
//            prev.next = p.next;
//            if (p == tail) {
//                tail = prev; // Cập nhật tail nếu tàu ở cuối danh sách bị xoá
//            }
//        }
//    }
    public void deleteByTcode(String tcode) {
        if (isEmpty()) {
            System.out.println("Danh sách rỗng. Không có tàu để xoá.");
            return;
        }

        // Nếu tàu cần xoá ở đầu danh sách
        if (head.info.tcode.equals(tcode)) {
            head = head.next;
            if (head == null) {
                tail = null;
            }
            System.out.println("Xoá tàu có mã " + tcode + " thành công.");
            return;
        }

        // Tìm nút trước nút cần xoá
        TrainNode prev = null;
        TrainNode p = head;
        while (p != null && !p.info.tcode.equals(tcode)) {
            prev = p;
            p = p.next;
        }

        // Xoá tàu nếu tìm thấy
        if (p != null) { // Có nghĩa là tìm thấy tàu cần xoá
            prev.next = p.next;
            if (p == tail) {
                tail = prev; // Cập nhật tail nếu tàu ở cuối danh sách bị xoá
            }
            System.out.println("Xoá tàu có mã " + tcode + " thành công.");
        } else {
            // Nếu không tìm thấy tàu với mã tcode
            System.out.println("Không tìm thấy tàu có mã " + tcode + ".");
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
    public void addTrainToHead(TrainNode newNode) {
        if (newNode == null) {
            // Handle null input if needed, to avoid adding null to the list
            return;
        }

        // Check if the list is empty
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            // Add the new node at the head of the list
            newNode.next = head;
            head = newNode;
        }
    }

    // Phương thức để chèn node mới trước node đã cho
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

    public void addTrainBefore(int position, TrainNode newNode) {
        // Trường hợp đặc biệt: danh sách rỗng
        if (isEmpty()) {
            head = newNode;
            tail = newNode; // Cập nhật tail vì đây là node duy nhất
            System.out.println("Train added to an empty list at the beginning.");
            return;
        }

        // Trường hợp đặc biệt: nếu chèn trước vị trí 1 (chèn đầu danh sách)
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            System.out.println("Train added at the beginning.");
            return;
        }

        // Kiểm tra xem vị trí có hợp lệ hay không
        TrainNode nodeAtK = getByIndex(position);
        if (nodeAtK == null) {
            System.out.println("Invalid position. Please enter a valid position.");
            return;
        }

        // Lấy node tại vị trí k-1
        TrainNode nodeAtKMinus1 = getByIndex(position - 1);
        if (nodeAtKMinus1 != null) {
            // Chèn node mới trước vị trí k
            insertBefore(nodeAtK, newNode);
            System.out.println("Train added before position " + position);
        } else {
            System.out.println("Invalid position.");
        }
    }

    public void remove(TrainNode p) {
        // Trường hợp danh sách chỉ có 1 phần tử
        if (head == tail) {
            head = tail = null;
        } // Trường hợp node cần xóa là node đầu tiên
        else if (p == head) {
            removeFirst();
        } // Trường hợp node cần xóa là node cuối cùng
        else if (p == tail) {
            removeLast();
        } // Trường hợp node ở giữa
        else {
            TrainNode pre = getPrev(p); // Lấy node đứng trước node cần xóa
            if (pre != null) {
                pre.next = p.next; // Bỏ qua node cần xóa
                p.next = null; // Xóa tham chiếu của node cần xóa
            }
        }
    }

    public void deletePosition(int position) {
        // Kiểm tra nếu vị trí hợp lệ
        TrainNode nodeAtPosition = getByIndex(position);
        if (nodeAtPosition == null) {
            System.out.println("Invalid position. No node found at position " + position);
            return;
        }

        // Gọi phương thức remove để xóa node tại vị trí
        remove(nodeAtPosition);
        System.out.println("Delete successfully!");
    }

    public Train searchByName(String name) {
        TrainNode current = head;
        while (current != null) {
            if (current.info.getName().equalsIgnoreCase(name)) {
                System.out.println(current.info.toString());
                return current.info; // Trả về tàu đã tìm thấy
            }
            current = current.next;
        }
        System.out.println("Not found");
        return null; // Trả về null nếu không tìm thấy
    }

    public void searchBookedByTcode(String tcode) {
        TrainNode current = head;
        boolean found = false;

        while (current != null) {
            // dùng getTcode để so sánh và kiểm tra nếu đã đặt
            if (current.info.getTcode().equalsIgnoreCase(tcode)) {
                if (current.info.booked > 0) {
                    System.out.println("Tàu có mã " + tcode + " đã được đặt: " + current.info);
                } else {
                    System.out.println("Tàu có mã " + tcode + " chưa được đặt.");
                }
                found = true;
                break; // Dừng vòng lặp khi tìm thấy tàu
            }
            current = current.next;
        }

        if (!found) {
            System.out.println("Không tìm thấy tàu có mã " + tcode + ".");
        }
    }

}
