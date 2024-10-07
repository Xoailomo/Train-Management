/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;


import Entity.Passenger;
import java.util.Scanner;

public class PassengerList {

    PassengerNode head, tail;

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
    public void addToTheEnd(Passenger x) {
        if (isEmpty()) {
            PassengerNode p = new PassengerNode(x);
            head = tail = p;
        } else {
            PassengerNode p = new PassengerNode(x, null);
            tail.next = p;
            tail = p;
        }
    }

    // Thêm thông tin + kiểm tra điều kiện của pcode và phone
    public void input(PassengerList List) {
        Scanner sc = new Scanner(System.in);
        String pcode;
        String phone;

        while (true) {
            System.out.print("Enter pcode: ");
            pcode = sc.nextLine().trim();

            // Kiểm tra Pcode là duy nhất
            if (isPcodeUnique(pcode)) {
                break;
            } else {
                System.err.println("Pcode đã tồn tại. Hãy thử lại.");
            }
        }

        System.out.print("Enter name: ");
        String name = sc.nextLine().trim();

        while (true) {
            System.out.print("Enter phone: ");
            phone = sc.nextLine().trim();

            // Kiểm tra xem phone chỉ chứa chữ số
            if (!phone.matches("\\d+")) {
                System.err.println("Phone chỉ chứa các chữ số.");
                continue;  // Yêu cầu nhập lại
            }

            // Kiểm tra tính duy nhất của số điện thoại
            if (!isPhoneUnique(phone)) {
                System.err.println("Phone đã tồn tại. Hãy thử lại.");
                continue;  // Yêu cầu nhập lại
            }

            // Nếu cả hai điều kiện đều đúng, thoát khỏi vòng lặp
            break;
        }

        Passenger newP = new Passenger(pcode, name, phone);
        addToTheEnd(newP);
        System.out.println("Thêm thành công!");
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
    public PassengerNode searchByPcode(String pcode) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info.getPcode().equals(pcode)) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    public void searchWithInput() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println(" ----- Tim kiem bang Pcode ----- ");
            System.out.print("Enter pcode: ");
            String pcode = sc.nextLine().trim();

            PassengerNode p = searchByPcode(pcode);
            if (p != null) {
                System.out.println("Passenger found: " + p.info);
                System.out.println("");
                break;
            } else {
                System.out.println("Passenger not found");
            }
            System.out.println("");
        }
    }
    
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
    public void deleteByPcode(){
        Scanner sc = new Scanner(System.in);
        
        while (true) {
            System.out.println(" ----- Xoa thong tin bang Pcode ----- ");
            System.out.print("Enter pcode: ");
            String pcode = sc.nextLine().trim();

            PassengerNode p = searchByPcode(pcode); //Tìm Pcode cần xóa
            if (p != null) {
                remove(p); //Xóa Passenger
                System.out.println("Passenger found: " + p.info);
                System.out.println("Xóa hoàn tất!");
                System.out.println("");
                break;
            } else {
                System.out.println("Passenger not found");
            }
            System.out.println("");
        }
    }
    
    // Tìm kiếm theo tên
    public void searchByName(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println(" ----- Search by Name -----");
        System.out.print("Enter name to search: ");
        String nameToSearch = sc.nextLine().trim().toLowerCase(); 
        //Chuyển viết thường để dễ so sánh
        
        PassengerNode p = head;
        boolean valid = false;
        
        while (p != null) {            
            if(p.info.getName().toLowerCase().equals(nameToSearch)) {
                System.out.println("Found Passenger: " + p.info);
                valid = true;
            }
            p = p.next;
        }
        
        if (!valid) {
            System.out.println("Can't find someone with the name: " + nameToSearch);
        }
    }
    
    
}
