/**
 * ==========================================================
 * MAIN CLASS - UseCase8AddOnServiceSelectionApp
 * ==========================================================
 *
 * Use Case 8: Add-on Service Selection
 *
 * Description:
 * Demonstrates adding optional services to reservations
 * and calculating add-on totals.
 *
 * @version 2.7
 */
public class UseCase8AddOnServiceSelectionApp {

    public static void main(String[] args) {
        System.out.println("****************************************");
        System.out.println("  Use Case 8: Add-on Service Selection  ");
        System.out.println("****************************************");

        AddOnServiceManager serviceManager = new AddOnServiceManager();

        Reservation res1 = new Reservation("Alice", "Single", 2);
        Reservation res2 = new Reservation("Bob", "Double", 3);

        AddOnService breakfast = new AddOnService("Breakfast", 15.0);
        AddOnService spa = new AddOnService("Spa", 45.0);
        AddOnService airportTransfer = new AddOnService("Airport Transfer", 30.0);

        serviceManager.addService(res1, breakfast);
        serviceManager.addService(res1, airportTransfer);
        serviceManager.addService(res2, breakfast);
        serviceManager.addService(res2, spa);

        System.out.println();
        displayReservationCosts(serviceManager, res1);
        displayReservationCosts(serviceManager, res2);

        System.out.println("\nTotal add-on cost for all reservations: $" + serviceManager.calculateTotalServiceCost());

        System.out.println("Use Case 8 completed: add-on services assigned.");
    }

    private static void displayReservationCosts(AddOnServiceManager manager, Reservation reservation) {
        System.out.println("Reservation for " + reservation.getGuestName() + ":");
        manager.getServicesForReservation(reservation).forEach(service -> System.out.println(" - " + service));
        System.out.println("Add-on subtotal: $" + manager.calculateServiceCost(reservation));
    }
}
