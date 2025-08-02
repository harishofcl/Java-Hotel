import java.util.*;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Booking> bookings = new ArrayList<>();

    public Hotel() {
        // Adding rooms
        for (int i = 1; i <= 3; i++) rooms.add(new Room(i, "Standard"));
        for (int i = 4; i <= 6; i++) rooms.add(new Room(i, "Deluxe"));
        for (int i = 7; i <= 9; i++) rooms.add(new Room(i, "Suite"));
    }

    public void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked()) {
                System.out.println(room);
            }
        }
    }

    public void bookRoom(String customerName, String category) {
        for (Room room : rooms) {
            if (room.getCategory().equalsIgnoreCase(category) && !room.isBooked()) {
                if (Payment.processPayment(customerName, 500.0)) {
                    room.bookRoom();
                    Booking booking = new Booking(customerName, room);
                    bookings.add(booking);
                    Database.saveBooking(booking);
                    System.out.println("Booking Successful!");
                }
                return;
            }
        }
        System.out.println("No available rooms in this category.");
    }

    public void cancelBooking(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber && room.isBooked()) {
                room.cancelBooking();
                System.out.println("Booking for Room " + roomNumber + " has been cancelled.");
                return;
            }
        }
        System.out.println("Room is either not found or not booked.");
    }

    public void viewAllBookings() {
        bookings.sort(Comparator.comparing(Booking::getBookingDate));
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }
}
