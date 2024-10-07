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



  public TrainNode getNext(TrainNode p) {
    if (p.next != null) {
       return p.next;
    }
    return null;
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
    head = getNext(head);
}

public void removeLast() {
    tail = getPrev(tail);
    if (tail != null) {
        tail.next = null;
    }
}

    public boolean duplicateTcode(String tcode) {
        TrainNode newNode = head;
        while (newNode != null) {
            if (newNode.info.tcode.equals(tcode)) {
                return true;
            }
            newNode = newNode.next;
        }
        return false;
    }
    
    

    

    // 1.2 add train to tail
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
    // 1.3: Display data
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

    //1.4: Save bus list to file
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

    // 1.5: Search by tcode
    public void searchByTcode(String tcode) {
        TrainNode newNode = head;
        while (newNode != null) {
            if (newNode.info.tcode.equals(tcode)) {
                System.out.println("Tàu tìm thấy: " + newNode.info);
                return;
            }
            newNode = newNode.next;
        }
        System.out.println("Không tìm thấy tàu với mã " + tcode);
    }

    //1.6 delete by tocde
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
        TrainNode newNode = head;
        while (newNode != null && !newNode.info.tcode.equals(tcode)) {
            prev = newNode;
            newNode = newNode.next;
        }

        // Xoá tàu nếu tìm thấy
        if (newNode != null) { // Có nghĩa là tìm thấy tàu cần xoá
            prev.next = newNode.next;
            if (newNode == tail) {
                tail = prev; // Cập nhật tail nếu tàu ở cuối danh sách bị xoá
            }
            System.out.println("Xoá tàu có mã " + tcode + " thành công.");
        } else {
            // Nếu không tìm thấy tàu với mã tcode
            System.out.println("Không tìm thấy tàu có mã " + tcode + ".");
        }
    }

    //1.7: Sort by tcode
    public void sortByTcode() {
        if (isEmpty()) {
            return;
        }
        TrainNode newNode = head;
        while (newNode != null) {
            TrainNode j = newNode.next;
            while (j != null) {
                if (newNode.info.tcode.compareTo(j.info.tcode) > 0) {
                    Train temp = newNode.info;
                    newNode.info = j.info;
                    newNode.info = temp;
                }
                j = j.next;
            }
            newNode =newNode.next;
        }
    }

    //1.8 Input and add to beginning
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
//1.9: Add before position k
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
    //1.10: Delete position k


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
    //1.11:search by name
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
    //1.12: search booked by tocde
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
