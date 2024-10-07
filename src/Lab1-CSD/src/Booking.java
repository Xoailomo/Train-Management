package Lab1-CSD.src;

class Booking {
    private String tcode;
    private String pcode;
    private Date odate;
    private boolean paid;
    private int seat;

    public Booking(String tcode, String pcode, int seat) {
        this.tcode = tcode;
        this.pcode = pcode;
        this.seat = seat;
        this.odate = new Date(); // Ngày đặt vé là ngày hiện tại
        this.paid = false; // Mặc định là chưa thanh toán
    }

    // Getter và setter cho các thuộc tính
    public String getTcode() { return tcode; }
    public String getPcode() { return pcode; }
    public boolean isPaid() { return paid; }
    public void setPaid(boolean paid) { this.paid = paid; }

    @Override
    public String toString() {
        return "Booking{" +
                "tcode='" + tcode + '\'' +
                ", pcode='" + pcode + '\'' +
                ", odate=" + odate +
                ", paid=" + paid +
                ", seat=" + seat +
                '}';
    }
}
