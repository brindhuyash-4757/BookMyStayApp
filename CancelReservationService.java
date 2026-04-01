/**
 * ==========================================================
 * CLASS - CancelReservationService
 * ==========================================================
 *
 * Use Case 11: Booking Cancellation & Inventory Refill
 *
 * Description:
 * This class is responsible for handling booking cancellations.
 * It validates cancellation requests and updates inventory accordingly.
 *
 * @version 2.10
 */

public class CancelReservationService {

    public boolean cancelReservation(Reservation reservation, RoomInventory inventory) {
        if (reservation == null) {
            System.out.println("Cancellation failed: reservation is null.");
            return false;
        }

        if (inventory == null) {
            System.out.println("Cancellation failed: inventory is null.");
            return false;
        }

        for (Room room : inventory.getAllRooms()) {
            if (room.getType().equalsIgnoreCase(reservation.getRoomType()) && !room.isAvailable()) {
                room.setAvailable(true);
                System.out.println("Cancellation successful: " + reservation.getGuestName() + " room type " + reservation.getRoomType());
                return true;
            }
        }

        System.out.println("Cancellation failed: no matching booked room found for " + reservation.getGuestName());
        return false;
    }
}
