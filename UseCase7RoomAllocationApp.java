/**
 * ==========================================================
 * MAIN CLASS - UseCase7RoomAllocationApp
 * ==========================================================
 *
 * Use Case 7: Reservation Confirmation & Room Allocation
 *
 * Description:
 * Demonstrates reservation confirmation based on current
 * room inventory and updates room availability simultaneously.
 *
 * @version 2.6
 */
public class UseCase7RoomAllocationApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 7: Reservation Confirmation & Room Allocation  ");
        System.out.println("****************************************");

        RoomInventory roomInventory = new RoomInventory();
        roomInventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        roomInventory.addRoom(new Room(2, "Double", 2, 275, 120.0, true));
        roomInventory.addRoom(new Room(3, "Suite", 3, 530, 350.0, true));

        RoomAllocationService allocationService = new RoomAllocationService(roomInventory);

        Reservation r1 = new Reservation("Alice", "Single", 2);
        Reservation r2 = new Reservation("Bob", "Suite", 1);
        Reservation r3 = new Reservation("Charlie", "Double", 3);
        Reservation r4 = new Reservation("Denise", "Single", 1); // should fail if single is gone

        System.out.println("\nInitial inventory:");
        roomInventory.displayInventory();

        System.out.println("\nProcessing booking requests:");
        allocationService.confirmReservation(r1);
        allocationService.confirmReservation(r2);
        allocationService.confirmReservation(r3);
        allocationService.confirmReservation(r4);

        System.out.println("\nInventory after allocation:");
        roomInventory.displayInventory();

        System.out.println("Use Case 7 completed: confirmations and allocations executed.");
    }
}
