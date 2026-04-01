/**
 * ==========================================================
 * CLASS - RoomInventory
 * ==========================================================
 *
 * Use Case 3: Centralized Room Inventory Management
 *
 * Description:
 * This class acts as the single source of truth
 * for room availability in the hotel.
 *
 * Room pricing and characteristics are enclosed
 * from data objects, not duplicated here.
 *
 * This class supports a simple inventory API and
 * keeps responsibilities clearly separated.
 *
 * @version 2.2
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoomInventory {

    private final List<Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
        }
    }

    public int getTotalRooms() {
        return rooms.size();
    }

    public Room getRoomById(int id) {
        for (Room room : rooms) {
            if (room.id == id) {
                return room;
            }
        }
        return null;
    }

    public List<Room> getAllRooms() {
        return Collections.unmodifiableList(rooms);
    }

    public void displayInventory() {
        System.out.println("\nRoom Inventory status");
        System.out.println("Total rooms: " + getTotalRooms());
        for (Room room : rooms) {
            room.displayRoomDetails();
        }
    }
}
