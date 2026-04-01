/**
 * ==========================================================
 * MAIN CLASS - UseCase3HotelInventoryApp
 * ==========================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * Demonstrates inventory control with a dedicated
 * RoomInventory service.
 *
 * @version 2.2
 */
public class UseCase3HotelInventoryApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Welcome to the Hotel Booking System!  ");
        System.out.println("****************************************");
        System.out.println("Use Case 3: Centralized Room Inventory Management");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0));
        inventory.addRoom(new Room(3, "Deluxe", 2, 350, 200.0));
        inventory.addRoom(new Room(4, "Suite", 3, 530, 350.0));

        inventory.displayInventory();

        System.out.println("\nUse Case 3 completed: centralized inventory reporting done.");
    }
}
