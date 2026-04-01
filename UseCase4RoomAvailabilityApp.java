/**
 * ==========================================================
 * MAIN CLASS - UseCase4RoomAvailabilityApp
 * ==========================================================
 *
 * Use Case 4: Room Search & Availability Check
 *
 * Description:
 * This class demonstrates how guests can query
 * the hotel inventory for room availability
 * across room types and optional filters.
 *
 * The logic separates model and query access
 * through RoomInventory, the central source.
 *
 * @version 2.3
 */
public class UseCase4RoomAvailabilityApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 4: Room Search & Availability Check  ");
        System.out.println("****************************************");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0, false));
        inventory.addRoom(new Room(3, "Deluxe", 2, 350, 200.0, true));
        inventory.addRoom(new Room(4, "Suite", 3, 530, 350.0, true));

        inventory.displayInventory();

        System.out.println("\nSearching available rooms of type 'Deluxe' or higher bed count >= 2:");
        for (Room room : inventory.searchRooms("Deluxe", 2)) {
            if (room.isAvailable()) {
                room.displayRoomDetails();
            }
        }

        System.out.println("\nTotal available rooms: " + inventory.getAvailableRoomCount());
        System.out.println("Use Case 4 completed: search + availability check.");
    }
}
