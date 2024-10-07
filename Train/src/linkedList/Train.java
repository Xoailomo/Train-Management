/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package main;

/**
 *
 * @author The following has evaluated to null or missing:
==> Mai  [in template "Templates/Classes/Class.java" at line 24, column 14]

----
Tip: If the failing expression is known to legally refer to something that's sometimes null or missing, either specify a default value like myOptionalVar!myDefault, or use <#if myOptionalVar??>when-present<#else>when-missing</#if>. (These only cover the last step of the expression; to cover the whole expression, use parenthesis: (myOptionalVar.foo)!myDefault, (myOptionalVar.foo)??
----

----
FTL stack trace ("~" means nesting-related):
	- Failed at: ${Mai}  [in template "Templates/Classes/Class.java" at line 24, column 12]
----
 */
public class Train {
    String tcode;
    String name;
    String dstation;
    double dtime;
    Integer seat;
    Integer booked;
    double atime;

    public Train() {
    }

    public Train(String tcode, String name, String dstation, double dtime, Integer seat, Integer booked, double atime) {
        this.tcode = tcode;
        this.name = name;
        this.dstation = dstation;
        this.dtime = dtime;
        this.seat = seat;
        this.booked = booked;
        this.atime = atime;
    }

    @Override
    public String toString() {
        return "Tcode: " + tcode + ", Name: " + name + ", DStation: " + dstation +
               ", DTime: " + dtime + ", Seat: " + seat + ", Booked: " + booked + 
               ", ATime: " + atime;
    }
    
    

}
