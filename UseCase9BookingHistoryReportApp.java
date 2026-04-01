/**
 * ==========================================================
 * MAIN CLASS - UseCase9BookingHistoryReportApp
 * ==========================================================
 *
 * Use Case 9: Booking History & Reporting
 *
 * Description:
 * Demonstrates history recording from confirmed bookings
 * and generates a report.
 *
 * @version 2.8
 */

public class UseCase9BookingHistoryReportApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 9: Booking History & Reporting  ");
        System.out.println("****************************************");

        BookingHistory history = new BookingHistory();
        history.addBooking(new Reservation("Alice", "Single", 2));
        history.addBooking(new Reservation("Bob", "Double", 3));
        history.addBooking(new Reservation("Charlie", "Suite", 1));

        BookingHistoryReportService reportService = new BookingHistoryReportService();
        reportService.generateReport(history);

        System.out.println("\nUse Case 9 completed: booking history was recorded and reported.");
    }
}
