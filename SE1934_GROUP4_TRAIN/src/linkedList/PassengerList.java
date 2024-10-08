/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Booking;
import Entity.Passenger;
import Entity.Train;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import static linkedList.TrainList.head;
import static linkedList.TrainList.isEmpty;
import static linkedList.TrainList.tail;

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

    // add train to tail
    public void addToTail(Passenger x) {
        PassengerNode q = new PassengerNode(x);
        if (isEmpty()) {
            head = tail = q;
        } else {
            tail.next = q;
            tail = q;
        }
    }

    // 2.1 load from filr passengers.txt
    public void loadFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\|\\s*");
                if (parts.length < 3) {
                    System.out.println("Invalid line: " + line);
                    continue;
                }

                String pcode = parts[0].trim();
                String name = parts[1].trim();
                String phone = parts[2].trim();
                if (pcode.isEmpty() || name.isEmpty() || phone.isEmpty()) {
                    System.out.println("Invalid line (empty values): " + line);
                    continue;
                }
                Passenger pa = new Passenger(pcode, name, phone);
                addToTail(pa);
            }
            System.out.println("Load successfully " + filename);
        } catch (IOException e) {
            System.out.println("Load error: " + e.getMessage());
        }
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

    // 2.4 save to file
    public void saveToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            PassengerNode current = head;
            while (current != null) {
                Passenger pa = current.info;
                bw.write(pa.getPcode() + "| " + pa.getName() + "| "
                        + pa.getPhone());
                bw.newLine();
                current = current.next;
            }
            System.out.println("Save to success to file " + filename);
        } catch (IOException e) {
            System.out.println("Save file error" + e.getMessage());
        }
    }

    //2.5. Search by pcode
    public static Passenger searchByPcode(String pcode) {
        PassengerNode p = head;
        while (p != null) {
            if (p.info.pcode.equals(pcode)) {
                System.out.println("Found passenger");
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
        Scanner sc = new Scanner(System.in);

        System.out.println(" ----- Search by Name -----");
        System.out.print("Enter name to search: ");
        name = sc.nextLine().trim().toLowerCase();
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

//    // 2.8 Search trains by pcode
    

}
