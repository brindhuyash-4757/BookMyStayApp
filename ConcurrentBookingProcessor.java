/**
 * ==========================================================
 * CLASS - ConcurrentBookingProcessor
 * ==========================================================
 *
 * Use Case 12: Concurrent Booking Simulation
 *
 * Description:
 * This class represents a booking processor that can be executed
 * by multiple threads coordinating on the same inventory and queue.
 *
 * It demonstrates thread-safe behavior as booking requests are processed.
 *
 * @version 3.0
 */

public class ConcurrentBookingProcessor implements Runnable {

    private final BookingRequestQueue bookingQueue;
    private final RoomInventory inventory;
    private final RoomAllocationService allocationService;

    public ConcurrentBookingProcessor(BookingRequestQueue bookingQueue, RoomInventory inventory, RoomAllocationService allocationService) {
        this.bookingQueue = bookingQueue;
        this.inventory = inventory;
        this.allocationService = allocationService;
    }

    @Override
    public void run() {
        while (bookingQueue.hasRequests()) {
            Reservation reservation = bookingQueue.processNextRequest();
            if (reservation == null) {
                continue;
            }
            // Synchronize on inventory for safe shared modification
            synchronized (inventory) {
                allocationService.confirmReservation(reservation);
            }
            try {
                Thread.sleep(100); // simulate processing time
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Thread processing interrupted");
                break;
            }
        }
    }
}
