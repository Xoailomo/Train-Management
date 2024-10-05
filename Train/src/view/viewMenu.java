/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author phank
 */
public class viewMenu {

    // hiển thị menu chính
    public void mainMenu() {
        String content[] = {"Train", "Passenger", "Booking"};
        System.out.println("******** main menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0.exit");

    }
    // hiển thị menu của train
    public void menuTrainList() {
        String content[] = {"add last","add first", "search","delete",
                            "save", "sort"};
        System.out.println("******** train menu ********");
        for(int i= 0;i<content.length;i++){
            System.out.println((i+1)+". "+content[i]);
        }
        System.out.println("0.exit");
    }
    // truyền dữ liệu cho train List
    public void loadTrainData(){
        String content[]={"tcode", "name","dstation", "astation",
                          "dtime"," seat","booked", "atime"};
        System.out.println("**** load train data **** ");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);
        }
        System.out.println("0. extit");
        
    }
    public void tableHearder(){
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

    // display menu of passenger list
    public void menuPassengerList() {
        String content[] = {"add last", "add first", "search","delete",
                            "save"};
        System.out.println("******** passenger menu ********");
        for (int i = 0; i < content.length; i++) {
            System.out.println((i + 1) + ". " + content[i]);

        }
        System.out.println("0. extit");
    }
    
    
    // display menu of booling list
}
