/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class fileIO {

    // read and write file .txt
    public <T> void write(T data, String file) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(data);
        } catch (FileNotFoundException e) {
            System.out.println("File not found "+file);
        } catch (IOException e) {
            System.out.println("unable to write "+file);
        } 
        System.out.println("Write successfully!");
    }
    public <T> T read(String file){
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(new File(file));
            ObjectInputStream ois = new ObjectInputStream(fis);
            ois.close();
            fis.close();
            return (T) ois.readObject();
        }catch(FileNotFoundException e){
            System.out.println("File not found "+file);
        }catch(IOException e){
            System.out.println("Unable to read "+file);
        }catch(ClassNotFoundException e){
            System.out.println("Class not found");
        }
        return null;
    }
}
