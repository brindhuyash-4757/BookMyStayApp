/**
 * ==========================================================
 * CLASS - ReservationValidator
 * ==========================================================
 *
 * Use Case 10: Error Handling & Validation
 *
 * Description:
 * Validates incoming reservation input before processing.
 * Throws InvalidBookingException for invalid data.
 *
 * @version 2.9
 */
public class ReservationValidator {

    public void validate(Reservation reservation) {
        if (reservation == null) {
            throw new InvalidBookingException("Reservation cannot be null");
        }

        if (reservation.getGuestName() == null || reservation.getGuestName().isBlank()) {
            throw new InvalidBookingException("Guest name is required");
        }

        if (reservation.getRoomType() == null || reservation.getRoomType().isBlank()) {
            throw new InvalidBookingException("Room type is required");
        }

        if (reservation.getNights() <= 0) {
            throw new InvalidBookingException("Duration must be at least one night");
        }
    }
}
