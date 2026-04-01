/**
 * ==========================================================
 * MAIN CLASS - HotelBookingApp
 * ==========================================================
 *
 * Use Case 2: Basic Room Types & Static Availability
 *
 * Description:
 * This class is the application entry point and a simple demo
 * of basic room type representation and availability.
 *
 * @version 2.1
 */
public class HotelBookingApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Welcome to the Hotel Booking System!  ");
        System.out.println("****************************************");
        System.out.println("Application Name: Hotel Booking App");
        System.out.println("Version: v2.1");

        // Configure and show static room inventory for use case 2.
        Room single = new Room(1, "Single", 1, 180, 80.0);
        Room doubleRoom = new Room(2, "Double", 2, 275, 120.0);
        Room deluxe = new Room(3, "Deluxe", 2, 350, 200.0);

        System.out.println("\nRoom catalog (basic types & static availability):");
        single.displayRoomDetails();
        doubleRoom.displayRoomDetails();
        deluxe.displayRoomDetails();

        System.out.println("\nUse Case 2 completed: room types displayed.");
    }
}

