/**
 * ==========================================================
 * MAIN CLASS - UseCase12ConcurrentBookingSimulationApp
 * ==========================================================
 *
 * Use Case 12: Concurrent Booking Simulation
 *
 * Description:
 * Demonstrates concurrent processors consuming a booking queue
 * and allocating rooms in a thread-safe manner.
 *
 * @version 3.0
 */

public class UseCase12ConcurrentBookingSimulationApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 12: Concurrent Booking Simulation  ");
        System.out.println("****************************************");

        RoomInventory inventory = new RoomInventory();
        inventory.addRoom(new Room(1, "Single", 1, 180, 80.0, true));
        inventory.addRoom(new Room(2, "Double", 2, 275, 120.0, true));
        inventory.addRoom(new Room(3, "Suite", 3, 530, 350.0, true));

        BookingRequestQueue bookingQueue = new BookingRequestQueue();
        bookingQueue.addRequest(new Reservation("Alice", "Single", 2));
        bookingQueue.addRequest(new Reservation("Bob", "Double", 3));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite", 1));
        bookingQueue.addRequest(new Reservation("Denise", "Single", 1));

        RoomAllocationService allocationService = new RoomAllocationService(inventory);

        Thread worker1 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));
        Thread worker2 = new Thread(new ConcurrentBookingProcessor(bookingQueue, inventory, allocationService));

        worker1.start();
        worker2.start();

        try {
            worker1.join();
            worker2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Main thread interrupted");
        }

        System.out.println("\nFinal inventory state:");
        inventory.displayInventory();

        System.out.println("Use Case 12 completed: concurrent booking simulation done.");
    }
}
