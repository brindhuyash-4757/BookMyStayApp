/**
 * ==========================================================
 * ABSTRACT CLASS - Room
 * ==========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This abstract class represents a generic hotel room.
 * It models attributes that are intrinsic to a room type and
 * remain constant regardless of availability.
 *
 * @version 2.1
 */
public class Room {

    /** Number of beds available in the room. */
    protected int numberOfBeds;

    /** Total size of the room in square feet. */
    protected int squareFeet;

    /** Price charged per night for this room type. */
    protected double pricePerNight;

    /** A room type identifier (e.g., Single, Double, Deluxe). */
    protected String type;

    /** Room id for inventory demo. */
    protected int id;

    /**
     * Constructor used by child classes to initialize common room attributes.
     *
     * @param id room identifier
     * @param type room type name
     * @param numberOfBeds number of beds in the room
     * @param squareFeet total room size
     * @param pricePerNight cost per night
     */
    public Room(int id, String type, int numberOfBeds, int squareFeet, double pricePerNight) {
        this.id = id;
        this.type = type;
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    /** Displays room details. */
    public void displayRoomDetails() {
        System.out.println("Room ID: " + id
                + ", Type: " + type
                + ", Beds: " + numberOfBeds
                + ", Size: " + squareFeet + " sqft"
                + ", Rate: $" + pricePerNight + " per night");
    }
}
