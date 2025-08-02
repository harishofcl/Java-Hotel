import java.time.LocalDate;

public class Booking {
    private String customerName;
    private Room room;
    private LocalDate bookingDate;

    public Booking(String customerName, Room room) {
        this.customerName = customerName;
        this.room = room;
        this.bookingDate = LocalDate.now();
    }

    public String getCustomerName() {
        return customerName;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    @Override
    public String toString() {
        return customerName + " booked Room " + room.getRoomNumber() + " (" + room.getCategory() + ") on " + bookingDate;
    }
}
