class DeliveryPartner {
    private final String id;
    private final double rating;
    private final double distance;
    private final boolean available;

    public DeliveryPartner(String id, double rating, double distance, boolean available) {
        this.id = id;
        this.rating = rating;
        this.distance = distance;
        this.available = available;
    }

    public String getId() { return id; }
    public double getRating() { return rating; }
    public double getDistance() { return distance; }
    public boolean isAvailable() { return available; }
}

class Order {
    private final String id;
    private final String address;

    public Order(String id, String address) {
        this.id = id;
        this.address = address;
    }

    public String getAddress() { return address; }
}

interface AssignmentStrategy {
    DeliveryPartner assign(List<DeliveryPartner> partners, Order order);
}

class NearestStrategy implements AssignmentStrategy {
    public DeliveryPartner assign(List<DeliveryPartner> partners, Order order) {
        return partners.stream()
                .filter(DeliveryPartner::isAvailable)
                .min(Comparator.comparingDouble(DeliveryPartner::getDistance))
                .orElse(null);
    }
}

class HighestRatedStrategy implements AssignmentStrategy {
    public DeliveryPartner assign(List<DeliveryPartner> partners, Order order) {
        return partners.stream()
                .filter(DeliveryPartner::isAvailable)
                .max(Comparator.comparingDouble(DeliveryPartner::getRating))
                .orElse(null);
    }
}

class DeliveryService {

    private AssignmentStrategy strategy;

    public DeliveryService(AssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(AssignmentStrategy strategy) {
        this.strategy = strategy;
    }

    public void assignOrder(Order order, List<DeliveryPartner> partners) {

        DeliveryPartner partner = strategy.assign(partners, order);

        if (partner == null) {
            System.out.println("No delivery partner available");
        } else {
            System.out.println("Assigned partner " + partner.getId() +
                    " to deliver at " + order.getAddress());
        }
    }
}

List<DeliveryPartner> partners = List.of(
        new DeliveryPartner("P1", 4.5, 2.0, true),
        new DeliveryPartner("P2", 4.8, 5.0, true)
);

Order order = new Order("O1", "Bangalore");

DeliveryService service = new DeliveryService(new NearestStrategy());
service.assignOrder(order, partners);

// Switch strategy dynamically
service.setStrategy(new HighestRatedStrategy());
        service.assignOrder(order, partners);