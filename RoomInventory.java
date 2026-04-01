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

    public int getAvailableRoomCount() {
        int count = 0;
        for (Room room : rooms) {
            if (room.isAvailable()) {
                count++;
            }
        }
        return count;
    }

    public List<Room> getAvailableRooms() {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return Collections.unmodifiableList(availableRooms);
    }

    public List<Room> searchRooms(String type, int minimumBeds) {
        List<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            boolean typeMatch = type == null || type.isBlank() || room.type.equalsIgnoreCase(type);
            boolean bedsMatch = room.numberOfBeds >= minimumBeds;
            if (typeMatch && bedsMatch) {
                result.add(room);
            }
        }
        return Collections.unmodifiableList(result);
    }

    public void displayInventory() {
        System.out.println("\nRoom Inventory status");
        System.out.println("Total rooms: " + getTotalRooms());
        System.out.println("Available rooms: " + getAvailableRoomCount());
        for (Room room : rooms) {
            room.displayRoomDetails();
        }
    }
}
