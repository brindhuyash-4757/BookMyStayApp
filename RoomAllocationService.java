/**
 * ==========================================================
 * CLASS - RoomAllocationService
 * ==========================================================
 *
 * Use Case 7: Reservation Confirmation & Room Allocation
 *
 * Description:
 * This class confirms reservations by assigning an available
 * room of the requested type and updating the room availability.
 *
 * @version 2.6
 */
public class RoomAllocationService {

    private final RoomInventory inventory;

    public RoomAllocationService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public Room allocateRoomForReservation(Reservation reservation) {
        if (reservation == null || reservation.getRoomType() == null) {
            return null;
        }

        String requestedType = reservation.getRoomType().trim();

        for (Room room : inventory.getAvailableRooms()) {
            if (room.type.equalsIgnoreCase(requestedType)) {
                room.setAvailable(false); // mark as booked
                return room;
            }
        }

        return null;
    }

    public boolean confirmReservation(Reservation reservation) {
        Room allocatedRoom = allocateRoomForReservation(reservation);
        if (allocatedRoom != null) {
            System.out.println("Confirmed reservation for guest: " + reservation.getGuestName()
                    + " => room " + allocatedRoom.type
                    + " (ID: " + allocatedRoom.id + ")");
            return true;
        }

        System.out.println("Unable to confirm reservation for guest: " + reservation.getGuestName()
                + ". No available room of type " + reservation.getRoomType() + " found.");
        return false;
    }
}
