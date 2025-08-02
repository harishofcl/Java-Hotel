import java.io.*;
import java.util.*;

public class Database {
    private static final String FILE = "bookings.txt";

    public static void saveBooking(Booking booking) {
        try (FileWriter fw = new FileWriter(FILE, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(booking.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void viewBookings() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String line;
            System.out.println("\n--- Booking History ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("------------------------");
        } catch (IOException e) {
            System.out.println("No bookings found.");
        }
    }
}
