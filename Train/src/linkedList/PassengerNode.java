/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;
import Entity.Passenger;
/**
 *
 * @author phank
 */
public class PassengerNode {

    Passenger info;
    PassengerNode next;

    public PassengerNode() {
    }

    public PassengerNode(Passenger info){
        this.info = info;
        next = null;
    }
    public PassengerNode(Passenger info, PassengerNode next) {
        this.info = info;
        this.next = next;
    }
    
}
