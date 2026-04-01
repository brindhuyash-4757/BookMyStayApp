/**
 * ==========================================================
 * MAIN CLASS - UseCase11BookingCancellationApp
 * ==========================================================
 *
 * Use Case 11: Booking Cancellation & Inventory Refill
 *
 * Description:
 * Demonstrates cancelling bookings and returning rooms to inventory.
 *
 * @version 2.10
 */

public class UseCase11BookingCancellationApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 11: Booking Cancellation & Inventory Refill  ");
        System.out.println("****************************************");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0, true));
        inventory.addRoom(new Room(3, "Suite", 3, 530, 350.0, true));

        RoomAllocationService allocationService = new RoomAllocationService(inventory);
        CancelReservationService cancellationService = new CancelReservationService();

        Reservation alice = new Reservation("Alice", "Single", 2);
        Reservation bob = new Reservation("Bob", "Double", 3);

        allocationService.confirmReservation(alice);
        allocationService.confirmReservation(bob);

        System.out.println("\nInventory before cancellation:");
        inventory.displayInventory();

        cancellationService.cancelReservation(alice, inventory);

        System.out.println("\nInventory after cancellation:");
        inventory.displayInventory();

        System.out.println("Use Case 11 completed: cancellation processed.");
    }
}
