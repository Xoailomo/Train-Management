package main;

import java.util.Scanner;

import Entity.Booking;
import Entity.Passenger;
import Entity.Train;
import File.fileIO;

import linkedList.BookingNode;
import linkedList.PassengerNode;
import linkedList.TrainNode;

import linkedList.BookingList;
import linkedList.PassengerList;
import linkedList.TrainList;

import static File.fileIO.readFromTxt;
import static File.fileIO.writeToTxt;
import static sun.nio.ch.IOUtil.load;
import view.viewMenu;



/**
 *
 * @author phank
 */
public class Main {

    private static boolean alive;
    private static Scanner sc;
    private static fileIO fo;
    private static viewMenu view;

    private static TrainList llt;
    private static PassengerList llp;
    private static BookingList llb;

    public static void main(String[] args) {
        new Main().init();
    }

    public void init() {
        alive = true;
        sc = new Scanner(System.in);
        fo = new fileIO();
        view = new viewMenu();

        // Initialize linked lists
        llt = new TrainList();
        llp = new PassengerList();
        llb = new BookingList();

        while (alive) {
            view.mainMenu();
            int choice = getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 4);
            switch (choice) {
                case 1:
                    menuTrain();
                    break;
                case 2:
                    menuPassenger();
                    break;
                case 3:
                    menuBooking();
                    break;
                case 4:
                    alive = false;
                    break;
                default:
                    System.out.println("Unexpected value: " + choice);
            }
        }
    }

    public void menuTrain() {
        alive = true;
        String fn = "";
        while (alive) {
            view.menuTrainList();
            int choice = getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 13);
            switch (choice) {
                case 1: // load
                    System.out.print("Enter file name: ");
                    fn = sc.nextLine();
                    loadTrainData(fn);
                    break;
                case 2: // add to head
                    System.out.println(">>Add train to head  ");
                    llt.addTrainToHead(getNTrain());
                    break;
                case 3: // display data
                    System.out.println("Display data: ");
                    view.displayTrain(llt);

                    break;
                case 4: // save train list to file
                    System.out.print("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(0, fn);
                    break;
                case 5: // search by tcode
                    System.out.print("Search by tcode: ");
                    String code = sc.nextLine();
                    llt.searchByTcode(code);

                    break;
                case 6: // delete by tcode
                    System.out.print("Delete by tcode: ");
                    code = sc.nextLine();
                    llt.deleteByTcode(code);
                    break;
                case 7: // sort by tcode
                    System.out.print(">>Sort by tcode ");
                    llt.sortByTcode();
                    break;
                case 8: // add to the end
                    System.out.println("Add train to the end ");
                    llt.addTrainToEnd(getNTrain(),true);
                    break;
                case 9: // add before position k
                    System.out.println(">>Add before position");
                    int k = getIntCond(0, Integer.MAX_VALUE);
                    llt.addTrainBefore(k, getNTrain());
                    break;
                case 10: // delete position k
                    System.out.println("Delete position: ");
                    k = getIntCond(0, llt.getSize() - 1);
                    llt.deletePosition(k);
                    break;
                case 11: // search by name
                    System.out.println(">>Search by train name ");
                    String name = getString("Enter train name",
                            "err", "invalid",
                            "[A-Za-z\\s]+");
                    llt.searchByName(name);
                    break;
                case 12: // search booked by tcode
                    System.out.print("Search booked by tcode; ");
                    code = sc.nextLine();
                    llt.searchBookedByTcode(code);
                    break;
                case 13: //exit
                    alive = false;
                    break;
            }
        }
    }

    public void menuPassenger() {
        alive = true;
        while (alive) {
            view.menuPassengerList();
            int choice = getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 9);
            switch (choice) {
                case 1: // load 
                    System.out.print("Enter file name: ");
                    String fn = sc.nextLine();
                    loadPassengerData(fn);
                    break;
                case 2: // add to the end *****
                    System.out.println(">>Add passenger to the end");
                    llp.addToTheEnd(getNPassenger());
                    break;
                case 3: // display
                    System.out.println("Display all data: ");
                    view.displayPassenger(llp);
                    break;
                case 4: // save to file
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(1, fn);
                    break;
                case 5: // search by pcode
                    System.out.println("Search by pcode: ");
                    String pcode = sc.nextLine();
                    llp.searchByPcode(pcode);
                    break;
                case 6: // delete by pcode 
                    System.out.println("Delete by pcode: ");
                    pcode = sc.nextLine();
                    llp.deleteByPcode(pcode);
                    break;
                case 7: // search by name
                    System.out.println("Search by name: ");
                    String name = sc.nextLine();
                    llp.searchByName(name);
                    break;
                case 8: // search trains by pcode
                    System.out.println("Search trains by pcode: ");
                    pcode = sc.nextLine();
                    llp.searchByPcode(pcode);
                    break;
                case 9:
                    alive = false;
                    break;
            }
        }
    }

    public void menuBooking() {
        alive = true;
        while (alive) {
            view.menuBookingList();
            int choice = getInt("Your choice:",
                    "Error: Invalid choice.",
                    "Please enter a number.", 1, 7);
            switch (choice) {
                case 1:// load
                    System.out.println("Enter file name: ");
                    String fn = sc.nextLine();
                    loadBookingData(fn);
                    break;
                case 2: // booked trained

                    break;
                case 3: // display data
                    System.out.println("display all data: ");
                    view.displayBooking(llb);
                    break;
                case 4:  // save to file
                    System.out.println("Enter file name: ");
                    fn = sc.nextLine();
                    saveData(2, fn);
                    break;
                case 5: // sort by tocode and pcode
                    break;
                case 6: // pay booking by tcode abd pcode
                    break;
                case 7:
                    alive = false;
                    break;

            }
        }
    }

    private static TrainNode getNTrain() {
        TrainNode ntrain = new TrainNode();
        Train train = new Train();
        // get tcode
        view.loadTrainData(0);
        do {
            train.tcode = sc.nextLine();
            if (!llt.duplicateTcode(train.tcode)) {
                break;
            }
            System.out.println("duplicate tcode " + train.tcode);
        } while (true);

        // get name
        view.loadTrainData(1);
        train.name = sc.nextLine();
        // get depart place
        view.loadTrainData(2);
        train.dstation = sc.nextLine();
        // get arriving station
        view.loadTrainData(3);
        train.astation = sc.nextLine();
        // get depart time
        view.loadTrainData(4);
        train.dtime = getDoubleCond(0, 24);
        // get seated
        view.loadTrainData(5);
        train.seat = getIntCond(1, Integer.MAX_VALUE);
        //get booked
        view.loadTrainData(6);
        train.booked = getIntCond(0, train.seat);
        // get arriving time
        view.loadTrainData(7);
        train.atime = getDoubleCond(train.dtime, 24);

        ntrain.info = train;
        return ntrain;
    }

    private static PassengerNode getNPassenger() {
        PassengerNode npa = new PassengerNode();
        Passenger pa = new Passenger();
        // get pcode
        view.loadPassengerData(0);
        do {
            pa.pcode = sc.nextLine();
            if (llp.isPcodeUnique(pa.pcode)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.pcode);
        } while (true);

        // get name
        view.loadPassengerData(1);
        pa.name = sc.nextLine();
        // get phone
        view.loadPassengerData(2);
        do {
            pa.phone = getString("",
                    "10 so thoi", "pls integer",
                    "\\d+");
            if (llp.isPhoneUnique(pa.phone)) {
                break;
            }
            System.out.println("duplicate tcode " + pa.phone);
        } while (true);

        npa.info = pa;
        return npa;
    }

    private static int getIntCond(int min, int max) {
        int n = getInt("", "err", "invalid", Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (n < min) {
            System.out.println("inp must be >= " + min);
            return getIntCond(min, max);
        }
        if (n > max) {
            System.out.println("inp must be <=" + max);
            return getIntCond(min, max);
        }
        return n;
    }

    private static double getDoubleCond(double min, double max) {
        double n = getDouble("", "err",
                "invalid", Double.MIN_VALUE, Double.MAX_VALUE);
        if (n < min) {
            System.out.println("inp must be >= " + min);
            return getDoubleCond(min, max);
        }
        if (n > max) {
            System.out.println("inp must be <= " + max);
            return getDoubleCond(min, max);
        }
        return n;
    }

    public static int getInt(String message, String error,
            String invalid, int min, int max) {
        do {
            System.out.print(message);
            try {
                int num = Integer.parseInt(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(error);
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        } while (true);

    }

    public static double getDouble(String message, String error,
            String invalid, double min, double max) {
        do {
            System.out.print(message);
            try {
                double num = Double.parseDouble(sc.nextLine());
                if (num >= min && num <= max) {
                    return num;
                }
                System.out.println(error);
            } catch (NumberFormatException e) {
                System.out.println(invalid);
            }
        } while (true);

    }

    public static String getString(String messageInfo,
            String messageError, String invalid,
            final String REGEX) {
        do {
            System.out.print(messageInfo);
            try {
                String str = sc.nextLine();
                if (str.matches(REGEX)) {
                    return str;
                }
                System.err.println(messageError);
            } catch (Exception e) {
                System.err.println(invalid);
            }
        } while (true);
    }

//    public static void saveData(int x, String fn) {
//        switch (x) {
//            case 0:
//                fo.write(llt, fn);
//
//                break;
//            case 1:
//                fo.write(llp, fn);
//
//                break;
//            case 2:
//                fo.write(llb, fn);
//
//                break;
//        }
//    }
//    public static void loadData(int x, String fn) {
//        switch (x) {
//            case 0:
//                llt = fo.read(fn);
//                if (llt == null) {
//                    llt = new TrainList();
//                }
//                break;
//            case 1:
//                llp = fo.read(fn);
//                if (llp == null) {
//                    llp = new PassengerList();
//                }
//                break;
//            case 2:
//                llb = fo.read(fn);
//                if (llb == null) {
//                    llb = new BookingList();
//                    break;
//                }
//        }
//    }
    public static void saveData(int x, String filename) {
        StringBuilder st = new StringBuilder();
        switch (x) {
            case 0:
                for (TrainNode node = llt.head; node != null; node = node.next) {
                    st.append(node.info.tcode).append("| ").append(node.info.name).append("| ")
                            .append(node.info.dstation).append("| ").append(node.info.astation).append("| ")
                            .append(node.info.dtime).append("| ").append(node.info.seat).append("| ")
                            .append(node.info.booked).append("| ").append(node.info.atime).append("\n");
                }
                writeToTxt(st.toString(), filename, true);
                break;
            case 1:
                for (PassengerNode node = llp.head; node != null; node = node.next) {
                    st.append(node.info.pcode).append("| ")
                            .append(node.info.name).append("| ").append(node.info.phone).append("\n");
                }
                writeToTxt(st.toString(), filename, true);
                break;
            case 2:
                for (BookingNode node = llb.head; node != null; node = node.next) {
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

//    public static TrainList loadData(String filename) {
//        TrainList trainList = new TrainList();  // Sử dụng biến cục bộ trainList
//        String data = readFromTxt(filename);    // Đọc dữ liệu từ file
//
//        String[] lines = data.split("\n");      // Tách các dòng
//        for (String line : lines) {
//            String[] parts = line.split(", ");  // Tách theo dấu phẩy và khoảng trắng
//            if (parts.length == 2) {            // Kiểm tra xem dữ liệu có đúng không
//                String tcode = parts[0];        // Mã tàu
//                String trainName = parts[1];    // Tên tàu
//
//                Train train = new Train(); // Tạo đối tượng Train
//                trainList.addTrainToEnd(new TrainNode(train));  // Thêm tàu vào danh sách trainList
//            }
//        }
//        return trainList;  // Trả về trainList đã được thêm dữ liệu
//    }
//    public static Object loadData(int x, String filename) {
//        String data = readFromTxt(filename);
//        String[] lines = data.split("\n");
//        switch (x) {
//            case 0:
//                return loadTrainData(lines);
//            case 1:
//                return loadPassengerData(lines);
//            case 2:
//                return loadBookingData(lines);
//            default:
//                return null;
//        }
//    }
//    public void loadTrainData(String file) {
//        String data = readFromTxt(file);
//        String[] lines = data.split("\n");
//        TrainList trainList = new TrainList();
//        for (String line : lines) {
//            // Giả sử mỗi dòng chứa thông tin train dưới dạng một chuỗi phân cách bằng dấu phẩy
//            String[] trainInfo = line.split("\\| "); // Thay đổi dấu phân cách nếu cần
//            if (trainInfo.length >= 8) { // Kiểm tra số lượng thông tin
//                // Tạo đối tượng Train từ thông tin đọc được
//                // Giả sử Train có constructor tương ứng
//                TrainNode train = new TrainNode(trainInfo);
////                          Train train = new Train(trainInfo[0],
////                        trainInfo[1], trainInfo[2], trainInfo[3], Double.parseDouble(trainInfo[4]),
////                        Integer.parseInt(trainInfo[5]), Integer.parseInt(trainInfo[6]),
////                        Double.parseDouble(trainInfo[7]));
//                trainList.addTrainToEnd(train); // Giả sử bạn có phương thức addTrain trong TrainList
//            }
//        }
//    }
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
                llt.addTrainToEnd(trainNode,false); // Thêm TrainNode vào danh sách liên kết
            }
        }
         System.out.println("All TrainNodes added to the list successfully.");
    }

    private void loadPassengerData(String file) {
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
                llp.addToTheEnd(paNode);
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

//                // Chuyển đổi từ String sang Date
//                Date odate = null;
//                try {
//                    odate = dateFormat.parse(bookingInfo[2]);
//                } catch (ParseException e) {
//                    System.out.println("Invalid date format for: " + bookingInfo[2]);
//                    continue;
//                }

//                boolean paid = Boolean.parseBoolean(bookingInfo[2]);
                int seat = Integer.parseInt(bookingInfo[2]);
                // Tạo đối tượng Booking từ thông tin đã nạp
                Booking booking = new Booking(tcode, pcode, seat);
                BookingNode bn = new BookingNode(booking);
                // Thêm đối tượng Booking vào danh sách đặt chỗ
                llb.addBookingToEnd(bn); // Giả sử có một danh sách liên kết cho Booking
            }
        }
    }

}
