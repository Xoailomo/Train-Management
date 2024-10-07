/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;

public class fileIO {

//    // read and write file 
//    public <T> void write(T data, String file) {
//        FileOutputStream fos = null;
//        try {
//            fos = new FileOutputStream(new File(file));
//            ObjectOutputStream oos = new ObjectOutputStream(fos);
//            oos.writeObject(data);
//
//            oos.close();
//            fos.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("file not found " + file);
//        } catch (IOException e) {
//            System.out.println("unable to writie " + file);
//        }
//        System.out.println("write success");
//    }
//
//    public <T> T read(String file) {
//        FileInputStream fis = null;
//        try {
//            fis = new FileInputStream(new File(file));
//            ObjectInputStream ois = new ObjectInputStream(fis);
//            T b= (T) ois.readObject();
//            ois.close();
//            fis.close();
//            return b;
//        } catch (FileNotFoundException e) {
//            System.out.println("file not found " + file);
//        } catch (IOException e) {
//            System.out.println("Unable to read " + file);
//        } catch (ClassNotFoundException e) {
//            System.out.println("class not found ");
//        }
//        return null;
//    }
    public static void writeToTxt(String data, String file,boolean append) {
        try (FileWriter fw = new FileWriter(file,append);
             PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
            System.out.println("Write to txt success");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + file);
        }
    }
    // Đọc dữ liệu từ file .txt
    public static String readFromTxt(String file) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            System.out.println("read successfully!");
        } catch (IOException e) {
            System.out.println("Unable to read file: " + file);
        }
        return result.toString();
    }
  
    
}
