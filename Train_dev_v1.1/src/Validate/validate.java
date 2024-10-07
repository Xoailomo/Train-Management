/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author phank
 */
public class validate {

    private  final static  Scanner sc = new Scanner(System.in);

    public static int getInteger(String messageinfo, String messageError, String invalid, int min, int max) {
        do {
            System.out.println(messageinfo);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(messageError);
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        } while (true);

    }

    public static String getString(String messageInfo, String messageError,
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            String str = sc.nextLine();
            if (str.matches(REGEX)) {
                return str;
            }
            System.out.println(messageError);
        } while (true);
    }
    public double getDouble(String messageinfo, String messageError, String invalid, double min,  double max){
        do {
            System.out.println(messageinfo);
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(messageError);
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        } while (true);

    }

    public Date getDate(String messageInfo, String messageError, String invalid,
            final String regex, Date min, Date max) {
        SimpleDateFormat dateFormate = new SimpleDateFormat(regex);
        dateFormate.setLenient(false);
        while (true) {
            System.out.println(messageInfo);
            try {
                Date date = dateFormate.parse(sc.nextLine());
                if (date.compareTo(min) >= 0 && date.compareTo(max) <= 0) {
                    return date;
                }
                System.out.println(messageError);
            } catch (ParseException e) {
                System.out.println(invalid);
            }
        }
    }
}
