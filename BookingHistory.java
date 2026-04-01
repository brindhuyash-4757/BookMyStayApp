/**
 * ==========================================================
 * CLASS - BookingHistory
 * ==========================================================
 *
 * Use Case 9: Booking History & Reporting
 *
 * Description:
 * This class maintains a record of completed reservations.
 * It provides accessors for tracking and reporting purposes.
 *
 * @version 2.8
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookingHistory {

    private final List<Reservation> historicalBookings = new ArrayList<>();

    public void addBooking(Reservation reservation) {
        if (reservation != null) {
            historicalBookings.add(reservation);
            System.out.println("Recorded booking: " + reservation);
        }
    }

    public List<Reservation> getAllBookings() {
        return Collections.unmodifiableList(historicalBookings);
    }

    public int getTotalBookings() {
        return historicalBookings.size();
    }

    public double getTotalRevenue(double roomRatePerNight) {
        return historicalBookings.stream().mapToDouble(r -> r.getNights() * roomRatePerNight).sum();
    }
}
