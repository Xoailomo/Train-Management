/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Train;
import java.io.Serializable;

/**
 *
 * @author phank
 */
public class TrainNode implements Serializable {

    public TrainNode next;
    public Train info;

    public TrainNode() {
    }

    public TrainNode(Train info) {
        this.info = info;
        next = null;
    }

    public TrainNode(Train info, TrainNode next) {
        this.next = next;
        this.info = info;
    }

}
