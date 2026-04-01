/**
 * ==========================================================
 * MAIN CLASS - UseCase6BookingRequestQueueApp
 * ==========================================================
 *
 * Use Case 6: Booking Request (FIFO)
 *
 * Description:
 * Demonstrates a queue-driven booking request pipeline.
 * Requests are enqueued, then processed in FIFO order.
 *
 * @version 2.5
 */

public class UseCase6BookingRequestQueueApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 6: Booking Request Queue (FIFO)  ");
        System.out.println("****************************************");

        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        bookingQueue.addRequest(new Reservation("Alice", "Single", 2));
        bookingQueue.addRequest(new Reservation("Bob", "Double", 3));
        bookingQueue.addRequest(new Reservation("Charlie", "Suite", 4));

        bookingQueue.displayQueueStatus();

        while (bookingQueue.hasRequests()) {
            bookingQueue.processNextRequest();
        }

        bookingQueue.displayQueueStatus();
        System.out.println("Use Case 6 completed: all queued booking requests processed.");
    }
}
