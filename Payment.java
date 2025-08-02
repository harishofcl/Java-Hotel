public class Payment {
    public static boolean processPayment(String customerName, double amount) {
        System.out.println("Processing payment for " + customerName + ": ₹" + amount);
        // Simulated success
        return true;
    }
}
