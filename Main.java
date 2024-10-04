/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package main;

import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Test chạy TrainList
        TrainList trainList = new TrainList();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng tàu: ");
        int n = Integer.parseInt(sc.nextLine());
        
        // Nhập thông tin tàu và thêm vào danh sách
        for (int i = 0; i < n; i++) {
            Train train = inputTrain(sc);
            trainList.addTrainToEnd(train); // Thêm tàu vào cuối danh sách
        }
        
        // Hiển thị danh sách tàu
        trainList.traverse();
        
        // Thử xóa tàu theo tcode
        System.out.print("Nhập mã tàu cần xóa: ");
        String tcodeToDelete = sc.nextLine();
        trainList.deleteByTcode(tcodeToDelete);
        
        // Hiển thị lại danh sách tàu sau khi xóa
        trainList.traverse();
    }
    
    // Hàm nhập thông tin của một tàu
    private static Train inputTrain(Scanner sc) {
        System.out.print("Nhập mã tàu: ");
        String tcode = sc.nextLine();
        System.out.print("Nhập tên tàu: ");
        String name = sc.nextLine();
        System.out.print("Nhập ga đến: ");
        String dstation = sc.nextLine();
        System.out.print("Nhập thời gian khởi hành: ");
        double dtime = sc.nextDouble();
        System.out.print("Nhập số ghế: ");
        int seat = sc.nextInt();
        System.out.print("Nhập số ghế đã đặt: ");
        int booked = sc.nextInt();
        System.out.print("Nhập thời gian đến: ");
        double atime = sc.nextDouble();
        sc.nextLine(); // Nhận ký tự xuống dòng sau khi nhập số

        return new Train(tcode, name, dstation, dtime, seat, booked, atime);
    }
}
