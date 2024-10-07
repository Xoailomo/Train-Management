package Lab1-CSD.src;

class BookingNode {
    Booking data; // Lưu trữ thông tin đặt vé
    BookingNode next; // Con trỏ tới node tiếp theo

    public BookingNode(Booking data) {
        this.data = data;
        this.next = null;
    }
}

