/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author phank
 */
public class passenger {
 private String pcode;
 private String name;
 private String phone;

    public passenger(String pcode, String name, String phone) {
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
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "passenger{" + "pcode=" + pcode + ", name=" + name + ", phone=" + phone + '}';
    }
 
}
