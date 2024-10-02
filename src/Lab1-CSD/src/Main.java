
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ASUS
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Test chạy PassengerList
        PassengerList a = new PassengerList();
        
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong Passenger: ");
        int n = Integer.parseInt(sc.nextLine());
        
        for (int i = 0; i < n; i++) {
            a.input(a);
        }
        
        a.traverse();
        
        //a.searchWithInput();
        a.deleteByPcode();
        
        //a.searchByName();
    }
    
}
