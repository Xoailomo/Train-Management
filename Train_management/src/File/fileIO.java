/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Entity.Passenger;
import Entity.Train;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import linkedList.BookingList;
import linkedList.BookingNode;
import linkedList.PassengerList;
import linkedList.PassengerNode;
import linkedList.TrainList;
import linkedList.TrainNode;

public class fileIO {

    private static TrainList tl = new TrainList();
    private static PassengerList pl = new PassengerList();
    private static BookingList bl = new BookingList();

    // write from file
    public void writeToTxt(String data, String file, boolean append) {
        try (FileWriter fw = new FileWriter(file, append); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
            System.out.println("Write to txt success");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + file);
        }
    }

    // save to file
    public void saveData(int x, String filename) {
        StringBuilder st = new StringBuilder();
        switch (x) {
            case 0:
                for (TrainNode node = tl.head; node != null; node = node.next) {
                    st.append(node.info.tcode).append("| ").append(node.info.name).append("| ")
                            .append(node.info.dstation).append("| ").append(node.info.astation).append("| ")
                            .append(node.info.dtime).append("| ").append(node.info.seat).append("| ")
                            .append(node.info.booked).append("| ").append(node.info.atime).append("\n");
                }
                writeToTxt(st.toString(), filename, true);
                break;
            case 1:
                for (PassengerNode node = pl.head; node != null; node = node.next) {
                    st.append(node.info.pcode).append("| ")
                            .append(node.info.name).append("| ").append(node.info.phone).append("\n");
                }
                writeToTxt(st.toString(), filename, true);
                break;
            case 2:
                for (BookingNode node = bl.head; node != null; node = node.next) {
                    st.append(node.info.getPcode()).append("| ")
                            .append(node.info.getTcode()).append("| ")
                            .append(node.info.getOdate()).append("| ")
                            .append(node.info.isPaid()).append("| ")
                            .append(node.info.getSeat()).append("| ").append("\n");
                }
                writeToTxt(st.toString(), filename, true);
                break;
        }

    }

    // read from file
    public String readFromTxt(String file) {
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

    // load file for train menu
    public void loadTrainData(String file) {
        String data = readFromTxt(file);
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] trainInfo = line.split("\\|\\s*");
            if (trainInfo.length >= 8) {
                for (int i = 0; i < trainInfo.length; i++) {
                    trainInfo[i] = trainInfo[i].trim();
                }
                Train train = new Train(
                        trainInfo[0],
                        trainInfo[1],
                        trainInfo[2],
                        trainInfo[3],
                        Double.parseDouble(trainInfo[4]),
                        Integer.parseInt(trainInfo[5]),
                        Integer.parseInt(trainInfo[6]),
                        Double.parseDouble(trainInfo[7])
                );
                TrainNode trainNode = new TrainNode(train);
                tl.addTrainToEnd(trainNode, false);
            }
        }
        System.out.println("All TrainNodes added to the list successfully.");
    }

    // load file for passenger
    public void loadPassengerData(String file) {
        String data = readFromTxt(file);
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] parts = line.split("\\|\\s*");
            if (parts.length == 3) {
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim();
                }
                Passenger pa = new Passenger(parts[0], parts[1], parts[2]);
                PassengerNode paNode = new PassengerNode(pa);
                pl.addToTheEnd(paNode);
            }
        }
    }

//    // load file for booking
//    public void loadBookingData(String file) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        String data = readFromTxt(file);
//        String[] lines = data.split("\n");
//        for (String line : lines) {
//            System.out.println("Processing line: " + line);
//            String[] bookingInfo = line.split("\\|\\s*");
//
//            if (bookingInfo.length >= 5) {
//                for (int i = 0; i < bookingInfo.length; i++) {
//                    bookingInfo[i] = bookingInfo[i].trim();
//                }
//                String bcode = bookingInfo[0];
//                String tcode = bookingInfo[0];
//                String pcode = bookingInfo[1];
//                // Parse the odate string to Date
//                Date odate = null;
//                try {
//                    odate = dateFormat.parse(bookingInfo[2]);
//                } catch (ParseException e) {
//                    System.out.println("Error parsing date for booking: " + bcode + ". Skipping this entry.");
//                    continue;
//                }
//                int paid = Integer.parseInt(bookingInfo[4]);
//                int seat = Integer.parseInt(bookingInfo[5]);
//                bl.addBookingToEnd(booking);
//            }
//        }
//    }
}
