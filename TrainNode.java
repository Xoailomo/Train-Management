/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

import java.util.*;
public class TrainNode {
    Train info; 
    TrainNode next; 
    
    public TrainNode() {}

    
    public TrainNode(Train info) {
        this.info = info;
        this.next = null;
    }

   
    public TrainNode(Train info, TrainNode next) {
        this.info = info;
        this.next = next;
    }
}
