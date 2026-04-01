/**
 * ==========================================================
 * MAIN CLASS - UseCase10ErrorHandlingValidationApp
 * ==========================================================
 *
 * Use Case 10: Error Handling & Validation
 *
 * Description:
 * Demonstrates validation and exception handling
 * for booking requests.
 *
 * @version 2.9
 */
public class UseCase10ErrorHandlingValidationApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 10: Error Handling & Validation  ");
        System.out.println("****************************************");

        ReservationValidator validator = new ReservationValidator();
        Reservation[] reservations = new Reservation[] {
            new Reservation("Alice", "Single", 2),
            new Reservation("", "Deluxe", 1),
            new Reservation("Bob", "", 2),
            new Reservation("Charlie", "Suite", 0),
            null
        };

        for (Reservation reservation : reservations) {
            try {
                validator.validate(reservation);
                System.out.println("Reservation is valid for: " + reservation.getGuestName());
            } catch (InvalidBookingException e) {
                System.out.println("Validation failed: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Validation failed: reservation object is null");
            }
        }

        System.out.println("Use Case 10 completed: validation cases handled.");
    }
}
