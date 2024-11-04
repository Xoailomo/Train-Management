/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.io.Serializable;



/**
 *
 * @author phank
 */
public class Passenger implements Serializable {

    public String pcode;
    public String name;
    public String phone;


    public Passenger() {
    }

    
     public Passenger(String pcode, String name, String phone) {
        this.pcode = pcode;
        this.name = name;
        this.phone = phone;
    }

    public String getPcode() {
        return pcode;
    }

    public void setPcode(String pcode) {
        this.pcode = pcode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (phone.matches("\\d+")) {
            this.phone = phone;
        } else {
            throw new IllegalArgumentException("Phone must contains only digit");
        }
    }

    @Override
    public String toString() {
        return String.format("Passenger code: %s | Name: %s | Phone: %s", pcode, name, phone);
        
    }

}
