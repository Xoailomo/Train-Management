/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package File;

import Entity.Booking;
import Entity.Passenger;
import Entity.Train;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

    public void writeToTxt(String data, String file, boolean append) {
        try (FileWriter fw = new FileWriter(file, append); PrintWriter pw = new PrintWriter(fw)) {
            pw.println(data);
            System.out.println("Write to txt success");
        } catch (IOException e) {
            System.out.println("Unable to write to file: " + file);
        }
    }

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

    public void loadTrainData(String file) {
        String data = readFromTxt(file);
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] trainInfo = line.split("\\|\\s*");
            if (trainInfo.length >= 8) {
                for (int i = 0; i < trainInfo.length; i++) {
                    trainInfo[i] = trainInfo[i].trim(); // Loại bỏ khoảng trắng thừa
                }
                Train train = new Train(
                        trainInfo[0], // tên tàu
                        trainInfo[1], // số hiệu tàu
                        trainInfo[2], // điểm đi
                        trainInfo[3], // điểm đến
                        Double.parseDouble(trainInfo[4]), // giá vé
                        Integer.parseInt(trainInfo[5]), // số ghế
                        Integer.parseInt(trainInfo[6]), // số ghế đã đặt
                        Double.parseDouble(trainInfo[7]) // thời gian khởi hành
                );
                TrainNode trainNode = new TrainNode(train);
                tl.addTrainToEnd(trainNode, false); // Thêm TrainNode vào danh sách liên kết
            }
        }
        System.out.println("All TrainNodes added to the list successfully.");
    }

    public void loadPassengerData(String file) {
        String data = readFromTxt(file);
        String[] lines = data.split("\n");
        for (String line : lines) {
            String[] parts = line.split("\\|\\s*");
            if (parts.length == 3) {
                for (int i = 0; i < parts.length; i++) {
                    parts[i] = parts[i].trim(); // Loại bỏ khoảng trắng thừa
                }
                Passenger pa = new Passenger(parts[0], parts[1], parts[2]);
                PassengerNode paNode = new PassengerNode(pa);
                pl.addToTheEnd(paNode);
            }
        }
    }

    public void loadBookingData(String file) {
        String data = readFromTxt(file);
        String[] lines = data.split("\n");
        for (String line : lines) {
            System.out.println("Processing line: " + line);
            String[] bookingInfo = line.split("\\|\\s*");

            if (bookingInfo.length >= 5) {
                for (int i = 0; i < bookingInfo.length; i++) {
                    bookingInfo[i] = bookingInfo[i].trim(); // Loại bỏ khoảng trắng
                }

                String tcode = bookingInfo[0];
                String pcode = bookingInfo[1];

                int seat = Integer.parseInt(bookingInfo[2]);
                // Tạo đối tượng Booking từ thông tin đã nạp
                Booking booking = new Booking(tcode, pcode, seat);
                BookingNode bn = new BookingNode(booking);
                // Thêm đối tượng Booking vào danh sách đặt chỗ
                bl.addBookingToEnd(bn); // Giả sử có một danh sách liên kết cho Booking
            }
        }
    }
}
