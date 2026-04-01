/**
 * ==========================================================
 * CLASS - Reservation
 * ==========================================================
 *
 * Use Case 6: Booking Request (FIFO)
 *
 * Description:
 * A reservation entity captures request details and
 * is used for a queue processing model in the booking system.
 *
 * @version 2.5
 */
public class Reservation {

    private final String guestName;
    private final String roomType;
    private final int nights;

    public Reservation(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getRoomType() {
        return roomType;
    }

    public int getNights() {
        return nights;
    }

    @Override
    public String toString() {
        return "Reservation{guest='" + guestName + "', roomType='" + roomType + "', nights=" + nights + "}";
    }
}
