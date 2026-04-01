/**
 * ==========================================================
 * CLASS - AddOnServiceManager
 * ==========================================================
 *
 * Use Case 8: Add-on Service Selection
 *
 * Description:
 * Manages the add-on services tied to reservations.
 *
 * @version 2.7
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddOnServiceManager {

    private final Map<Reservation, List<AddOnService>> reservationServices = new HashMap<>();

    public void addService(Reservation reservation, AddOnService service) {
        if (reservation == null || service == null) {
            return;
        }

        reservationServices
                .computeIfAbsent(reservation, r -> new ArrayList<>())
                .add(service);

        System.out.println("Added service " + service + " to reservation for " + reservation.getGuestName());
    }

    public List<AddOnService> getServicesForReservation(Reservation reservation) {
        return reservationServices.getOrDefault(reservation, new ArrayList<>());
    }

    public double calculateServiceCost(Reservation reservation) {
        return getServicesForReservation(reservation).stream().mapToDouble(AddOnService::getCost).sum();
    }

    public double calculateTotalServiceCost() {
        return reservationServices.values().stream()
                .flatMap(List::stream)
                .mapToDouble(AddOnService::getCost)
                .sum();
    }
}
