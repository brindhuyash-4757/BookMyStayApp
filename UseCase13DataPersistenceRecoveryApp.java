/**
 * ==========================================================
 * MAIN CLASS - UseCase13DataPersistenceRecoveryApp
 * ==========================================================
 *
 * Use Case 13: Data Persistence & System Recovery
 *
 * Description:
 * Demonstrates saving inventory to disk and reloading it.
 *
 * @version 3.1
 */

public class UseCase13DataPersistenceRecoveryApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 13: Data Persistence & System Recovery  ");
        System.out.println("****************************************");

        String filename = "room_inventory.txt";

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0, true));
        inventory.addRoom(new Room(3, "Suite", 3, 530, 350.0, true));

        System.out.println("\nOriginal inventory:");
        inventory.displayInventory();

        DataPersistenceService persistenceService = new DataPersistenceService();
        persistenceService.saveInventory(inventory, filename);
        System.out.println("\nInventory saved to " + filename);

        RoomInventory recovered = persistenceService.loadInventory(filename);
        System.out.println("\nRecovered inventory:");
        recovered.displayInventory();

        System.out.println("Use Case 13 completed: persistence + recovery executed.");
    }
}
