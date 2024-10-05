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
       public void displayTrain(TrainList tl){
        String header[]={"tcode", "train_name", "seat", "booked",
            "depart_time","depart_place", "available_seat"};
        int[] style ={10,20,10,20,15,15,15};
        // in ra header
        tableBorder(style);
        tableHearder(style, header);
        tableBorder(style);
        
        TrainNode n = tl.head;
        while(n!=null){
            Train t = n.info;
            tableHearder(style, new String[]{
                t.tcode+"",t.name+"",t.seat+"",t.booked+"",t.dtime+"",
                t.dstation+"",t.seat-t.booked+""
            });
            tableBorder(style);
            n=n.next;
        }
    }
    public void tableHearder(int[] style, String[] header) {
        for(int i=0;i<style.length;i++){
            System.out.print("|");
                for(int j=0;j<style[i];j++){
                    System.out.println(tableCell(style[i],header[i]));
                }
                System.out.println("|");
        }
    }
    public String tableCell(int style, String content){
        String s = content; // ? de lam gi
        int  offset = style - content.length();
        for(int i=0;i<style;i++){
            content +=" ";
        }
        return content;
    }

    public void tableBorder(int[] style) {
        for (int i = 0; i < style.length; i++) {
            System.out.print("+");
            for (int j = 0; j < style[i]; j++) {
                System.out.print("-");
            }
        }
        System.out.println("+");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

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
