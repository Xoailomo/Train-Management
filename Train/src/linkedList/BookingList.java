/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linkedList;

import Entity.Booking;
import Entity.Train;

/**
 *
 * @author phank
 */
import java.io.*;
import java.util.Date;

class Booking {
    String bcode; // Mã booking
    String tcode; // Mã tàu
    String pcode; // Mã hành khách
    Date odate; // Ngày đặt vé
    Date paid; // Trạng thái thanh toán (0 - chưa thanh toán, 1 - đã thanh toán)
    int seat; // Số ghế đã đặt

    public Booking(String bcode, String tcode, String pcode, Date odate, Date paid, int seat) {
        this.bcode = bcode;
        this.tcode = tcode;
        this.pcode = pcode;
        this.odate = odate;
        this.paid = paid;
        this.seat = seat;
    }
}

class BookingList {
    private BookingNode head; // Đầu danh sách liên kết

    public BookingList() {
        this.head = null; // Khởi tạo danh sách rỗng
    }

    // 3.1. Load data from file
    public void loadBookingFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String bcode = parts[0];
                String tcode = parts[1];
                String pcode = parts[2];
                String odate = parts[3];
                int paid = Integer.parseInt(parts[4]);
                int seat = Integer.parseInt(parts[5]);
                addBookingToEnd(bcode, tcode, pcode, odate, paid, seat);
            }
            System.out.println("Dữ liệu booking đã được tải từ file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi tải dữ liệu từ file: " + e.getMessage());
        }
    }

    // 3.2. Book bus
    public void bookBus(String tcode, String pcode, int seatToBook) {
        // Phương thức tìm tàu và hành khách có thể được gọi từ lớp TrainList và PassengerList tương ứng
        Train foundTrain = TrainList.searchTrainByTcode(tcode);
        Passenger foundPassenger = PassengerList.searchPassengerByPcode(pcode);

        if (foundTrain == null) {
            System.out.println("Không tìm thấy mã tàu " + tcode);
            return;
        }

        if (foundPassenger == null) {
            System.out.println("Không tìm thấy mã hành khách " + pcode);
            return;
        }

        if (seatToBook <= 0 || seatToBook > (foundTrain.seat - foundTrain.booked)) {
            System.out.println("Số ghế đặt không hợp lệ");
            return;
        }

        // Cập nhật thông tin tàu
        foundTrain.booked += seatToBook;
        foundTrain.seat -= seatToBook;

        // Thêm booking mới
        String bcode = generateBcode(); // Giả sử có hàm sinh mã booking
        String odate = getCurrentDate(); // Lấy ngày hiện tại
        int paid = 0; // Mặc định là chưa thanh toán
        addBookingToEnd(bcode, tcode, pcode, odate, paid, seatToBook);

        System.out.println("Đặt vé thành công cho hành khách " + pcode + " trên tàu " + tcode);
    }
    // Phương thức sinh mã booking
    private String generateBcode() {
        long currentTime = System.currentTimeMillis();
        return "B" + currentTime;
    }

    // Phương thức lấy ngày hiện tại
    private String getCurrentDate() {
        return LocalDate.now().toString();
    }
    // 3.3. Display data
    public void displayBookingList() {
        BookingNode current = head;
        while (current != null) {
            System.out.println(current.booking);
            current = current.next;
        }
    }

    // 3.4. Save booking list to file
    public void saveBookingListToFile(String filename) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            BookingNode current = head;
            while (current != null) {
                Booking booking = current.booking;
                bw.write(booking.bcode + "," + booking.tcode + "," + booking.pcode + "," + booking.odate + "," + booking.paid + "," + booking.seat);
                bw.newLine();
                current = current.next;
            }
            System.out.println("Danh sách booking đã được lưu vào file " + filename);
        } catch (IOException e) {
            System.out.println("Lỗi khi lưu danh sách booking: " + e.getMessage());
        }
    }

    // 3.5. Sort by tcode + pcode
    public void sortBookingsByTcodeAndPcode() {
        if (head == null || head.next == null) {
            return; // Không cần sắp xếp nếu danh sách rỗng hoặc chỉ có 1 phần tử
        }

        boolean sorted;
        do {
            sorted = true;
            BookingNode current = head;
            while (current.next != null) {
                if (current.booking.tcode.compareTo(current.next.booking.tcode) > 0 ||
                        (current.booking.tcode.equals(current.next.booking.tcode) &&
                                current.booking.pcode.compareTo(current.next.booking.pcode) > 0)) {

                    // Hoán đổi booking
                    Booking temp = current.booking;
                    current.booking = current.next.booking;
                    current.next.booking = temp;
                    sorted = false;
                }
                current = current.next;
            }
        } while (!sorted);
    }

    // 3.6. Pay booking by tcode + pcode
    public void payBooking(String tcode, String pcode) {
        if (tcode == null || pcode == null) {
            System.out.println("tcode hoặc pcode không được null");
            return;
        }

        BookingNode current = head; // Biến head là node đầu tiên trong danh sách liên kết

        // Duyệt qua danh sách liên kết
        while (current != null) {
            // Kiểm tra nếu current.booking không phải là null
            if (current.booking != null) {
                // So sánh chuỗi tcode và pcode của booking hiện tại
                if (tcode.equals(current.booking.tcode) && pcode.equals(current.booking.pcode)) {
                    // Kiểm tra xem booking đã được thanh toán hay chưa
                    if (current.booking.paid == 0) {
                        current.booking.paid = 1;
                        System.out.println("Booking cho tàu " + tcode + " và hành khách " + pcode + " đã được thanh toán.");
                    } else {
                        System.out.println("Booking đã được thanh toán trước đó.");
                    }
                    return; // Thoát khỏi vòng lặp sau khi tìm thấy
                }
            }
            current = current.next; // Di chuyển đến node tiếp theo
        }

        // Nếu không tìm thấy booking
        System.out.println("Không tìm thấy booking với tcode: " + tcode + " và pcode: " + pcode);
    }

    // Phương thức thêm booking vào cuối danh sách
    private void addBookingToEnd(String bcode, String tcode, String pcode, String odate, int paid, int seat) {
        Booking newBooking = new Booking(bcode, tcode, pcode, odate, paid, seat);
        BookingNode newNode = new BookingNode(newBooking);
        if (head == null) {
            head = newNode; // Nếu danh sách rỗng, gán head bằng node mới
        } else {
            BookingNode current = head;
            while (current.next != null) {
                current = current.next; // Tìm đến node cuối
            }
            current.next = newNode; // Gán node mới vào cuối danh sách
        }
    }

    // Các phương thức hỗ trợ khác như generateBcode() và getCurrentDate() cũng nên được định nghĩa trong lớp này
}
