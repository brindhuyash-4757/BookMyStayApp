/**
 * ==========================================================
 * CLASS - AddOnService
 * ==========================================================
 *
 * Use Case 8: Add-on Service Selection
 *
 * Description:
 * This class represents an optional service
 * that can be attached to a confirmed reservation.
 *
 * @version 2.7
 */
public class AddOnService {

    private final String serviceName;
    private final double cost;

    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
    }

    public String getServiceName() {
        return serviceName;
    }

    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return serviceName + " ($" + cost + ")";
    }
}
