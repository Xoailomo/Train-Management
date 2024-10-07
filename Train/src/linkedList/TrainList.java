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

class TrainList {
    TrainNode head;

    public TrainList() {
        this.head = null;
    }

    // Thêm tàu vào cuối danh sách
    public void addTrainToEnd(String tcode, String name, String dstation, String astation, double dtime, int seat, int booked, double atime) {
        TrainNode newTrain = new TrainNode(tcode, name, dstation, astation, dtime, seat, booked, atime);
        if (head == null) {
            head = newTrain;
        } else {
            TrainNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTrain;
        }
    }

    // Hiển thị tất cả các tàu
    public void displayTrains() {
        TrainNode temp = head;
        while (temp != null) {
            System.out.println(temp.toString());
            temp = temp.next;
        }
    }

    // Tìm kiếm tàu theo tcode
    public TrainNode searchByTcode(String tcode) {
        TrainNode temp = head;
        while (temp != null) {
            if (temp.tcode.equals(tcode)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Xóa tàu theo tcode
    public void deleteByTcode(String tcode) {
        if (head == null) return;

        if (head.tcode.equals(tcode)) {
            head = head.next;
            return;
        }

        TrainNode temp = head;
        while (temp.next != null && !temp.next.tcode.equals(tcode)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
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
public void addTrainToBeginning(String tcode, String name, String dstation, String astation, double dtime, int seat, int booked, double atime) {
    TrainNode newTrain = new TrainNode(tcode, name, dstation, astation, dtime, seat, booked, atime);
    if (head == null) {
        head = newTrain;
    } else {
        newTrain.next = head;
        head = newTrain;
    }
}
public void saveToFile(String filename) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
        TrainNode temp = head;
        while (temp != null) {
            bw.write(temp.toString());
            bw.newLine();
            temp = temp.next;
        }
        System.out.println("Dữ liệu đã được lưu vào file " + filename);
    } catch (IOException e) {
        System.out.println("Lỗi khi lưu vào file: " + e.getMessage());
    }
}
public void loadFromFile(String filename) {
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(" ");
            // Giả sử các phần tử của mảng parts là tcode, name, dstation, astation, dtime, atime, seat, booked.
            String tcode = parts[0];
            String name = parts[1];
            String dstation = parts[2];
            String astation = parts[3];
            double dtime = Double.parseDouble(parts[4]);
            double atime = Double.parseDouble(parts[5]);
            int seat = Integer.parseInt(parts[6]);
            int booked = Integer.parseInt(parts[7]);
            addTrainToEnd(tcode, name, dstation, astation, dtime, seat, booked, atime);
        }
        System.out.println("Dữ liệu đã được tải từ file " + filename);
    } catch (IOException e) {
        System.out.println("Lỗi khi tải từ file: " + e.getMessage());
    }
}

}
