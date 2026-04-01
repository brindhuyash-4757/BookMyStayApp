/**
 * ==========================================================
 * CLASS - BookingRequestQueue
 * ==========================================================
 *
 * Use Case 6: Booking Request (FIFO)
 *
 * Description:
 * Maintains a FIFO queue for reservation requests.
 * responds to user commands in a queue-based process.
 *
 * @version 2.5
 */

import java.util.LinkedList;
import java.util.Queue;

public class BookingRequestQueue {

    private final Queue<Reservation> queue = new LinkedList<>();

    public void addRequest(Reservation reservation) {
        if (reservation != null) {
            queue.offer(reservation);
            System.out.println("Request queued: " + reservation);
        }
    }

    public Reservation processNextRequest() {
        Reservation next = queue.poll();
        if (next != null) {
            System.out.println("Processing booking for guest: " + next.getGuestName()
                    + ", room type: " + next.getRoomType()
                    + ", nights: " + next.getNights());
        }
        return next;
    }

    public int queueSize() {
        return queue.size();
    }

    public boolean hasRequests() {
        return !queue.isEmpty();
    }

    public void displayQueueStatus() {
        System.out.println("Current requests in queue: " + queue.size());
        for (Reservation reservation : queue) {
            System.out.println(" - " + reservation);
        }
    }
}
