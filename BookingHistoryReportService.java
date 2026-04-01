/**
 * ==========================================================
 * CLASS - BookingHistoryReportService
 * ==========================================================
 *
 * Use Case 9: Booking History & Reporting
 *
 * Description:
 * This class generates a summary report from held booking history.
 *
 * @version 2.8
 */

public class BookingHistoryReportService {

    public void generateReport(BookingHistory history) {
        System.out.println("\nBooking History Report");
        System.out.println("======================");
        if (history.getTotalBookings() == 0) {
            System.out.println("No bookings in history.");
            return;
        }

        for (Reservation reservation : history.getAllBookings()) {
            System.out.println("Booked: Guest: " + reservation.getGuestName()
                    + ", Room: " + reservation.getRoomType()
                    + ", Nights: " + reservation.getNights());
        }

        System.out.println("\nTotal bookings: " + history.getTotalBookings());
    }
}
