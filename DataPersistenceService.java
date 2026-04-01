/**
 * ==========================================================
 * CLASS - DataPersistenceService
 * ==========================================================
 *
 * Use Case 13: Data Persistence & System Recovery
 *
 * Description:
 * This class is responsible for persisting room inventory to disk
 * and recovering state from disk after restart.
 *
 * @version 3.1
 */

import java.io.*;

public class DataPersistenceService {

    public void saveInventory(RoomInventory inventory, String filename) {
        if (inventory == null || filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Inventory and filename must be provided");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Room room : inventory.getAllRooms()) {
                writer.write(room.getId() + "," + room.getType() + "," + room.getNumberOfBeds() + "," + room.getSquareFeet() + "," + room.getPricePerNight() + "," + room.isAvailable());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to save inventory", e);
        }
    }

    public RoomInventory loadInventory(String filename) {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename must be provided");
        }

        RoomInventory inventory = new RoomInventory();

        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 6) {
                    continue;
                }
                int id = Integer.parseInt(parts[0]);
                String type = parts[1];
                int beds = Integer.parseInt(parts[2]);
                int sq = Integer.parseInt(parts[3]);
                double price = Double.parseDouble(parts[4]);
                boolean available = Boolean.parseBoolean(parts[5]);
                inventory.addRoom(new Room(id, type, beds, sq, price, available));
            }
        } catch (FileNotFoundException e) {
            // return empty inventory if file missing, caller can handle
            return inventory;
        } catch (IOException e) {
            throw new RuntimeException("Unable to load inventory", e);
        }

        return inventory;
    }
}
