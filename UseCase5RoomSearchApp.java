/**
 * ==========================================================
 * MAIN CLASS - UseCase5RoomSearchApp
 * ==========================================================
 *
 * Use Case 5: Room Search and Exact Availability Report
 *
 * Description:
 * This class shows a focused search of inventory availability
 * using search API criteria, reinforcing a responsive web-like query.
 *
 * @version 2.4
 */
public class UseCase5RoomSearchApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 5: Detailed Room Search Results  ");
        System.out.println("****************************************");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0, true));
        inventory.addRoom(new Room(3, "Deluxe", 2, 350, 200.0, false));
        inventory.addRoom(new Room(4, "Suite", 3, 530, 350.0, true));

        System.out.println("\nSearch query: no type filter; minimum 2 beds.");
        var candidates = inventory.searchRooms("", 2);

        if (candidates.isEmpty()) {
            System.out.println("No matching rooms found.");
        } else {
            for (Room room : candidates) {
                System.out.print("[Match] ");
                room.displayRoomDetails();
                String availMsg = room.isAvailable() ? "Available now" : "Not currently available";
                System.out.println("  -> " + availMsg);
            }
        }

        System.out.println("Use Case 5 completed: search + tide availability status.");
    }
}
