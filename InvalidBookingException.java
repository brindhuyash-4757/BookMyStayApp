/**
 * ==========================================================
 * CLASS - InvalidBookingException
 * ==========================================================
 *
 * Use Case 10: Error Handling & Validation
 *
 * Description:
 * Thrown when a booking request is not valid.
 *
 * @version 2.9
 */
public class InvalidBookingException extends RuntimeException {
    public InvalidBookingException(String message) {
        super(message);
    }
}