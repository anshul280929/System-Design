class FareRequest {
    private final double distance;
    private final int passengers;
    private final int days;

    public FareRequest(double distance, int passengers, int days) {
        this.distance = distance;
        this.passengers = passengers;
        this.days = days;
    }

    public double getDistance() { return distance; }
    public int getPassengers() { return passengers; }
    public int getDays() { return days; }
}

interface PricingStrategy {
    double calculateFare(FareRequest request);
}

class MiniPricing implements PricingStrategy {
    public double calculateFare(FareRequest request) {
        return request.getDistance() * 10;
    }
}

class PrimePricing implements PricingStrategy {
    public double calculateFare(FareRequest request) {
        return request.getDistance() * 15;
    }
}

class SharedPricing implements PricingStrategy {
    public double calculateFare(FareRequest request) {
        if (request.getPassengers() <= 0) {
            throw new IllegalArgumentException("Passengers must be > 0");
        }
        return (request.getDistance() * 12) / request.getPassengers();
    }
}

class Ride {
    private final PricingStrategy pricingStrategy;

    public Ride(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double calculateFare(FareRequest request) {
        return pricingStrategy.calculateFare(request);
    }
}

public class Main {
    public static void main(String[] args) {

        FareRequest request = new FareRequest(10, 2, 0);

        Ride miniRide = new Ride(new MiniPricing());
        Ride primeRide = new Ride(new PrimePricing());
        Ride sharedRide = new Ride(new SharedPricing());

        System.out.println(miniRide.calculateFare(request));
        System.out.println(primeRide.calculateFare(request));
        System.out.println(sharedRide.calculateFare(request));
    }
}