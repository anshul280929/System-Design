class Order {
    private final String id;
    private final double amount;

    public Order(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() { return id; }
    public double getAmount() { return amount; }
}

interface OrderRepository {
    void save(Order order);
}

interface NotificationService {
    void notify(String message);
}

interface PaymentService {
    boolean processPayment(Order order);
}

class MySQLOrderRepository implements OrderRepository {
    public void save(Order order) {
        System.out.println("Order saved to MySQL: " + order.getId());
    }
}

class EmailNotificationService implements NotificationService {
    public void notify(String message) {
        System.out.println("Email sent: " + message);
    }
}

class StripePaymentService implements PaymentService {
    public boolean processPayment(Order order) {
        System.out.println("Payment processed for: " + order.getAmount());
        return true;
    }
}

class OrderService {

    private final OrderRepository repository;
    private final NotificationService notificationService;
    private final PaymentService paymentService;

    public OrderService(OrderRepository repository,
                        NotificationService notificationService,
                        PaymentService paymentService) {
        this.repository = repository;
        this.notificationService = notificationService;
        this.paymentService = paymentService;
    }

    public void placeOrder(Order order) {

        boolean paymentSuccess = paymentService.processPayment(order);

        if (!paymentSuccess) {
            throw new RuntimeException("Payment failed");
        }

        repository.save(order);
        notificationService.notify("Order placed successfully: " + order.getId());
    }
}

public class Main {
    public static void main(String[] args) {

        OrderRepository repository = new MySQLOrderRepository();
        NotificationService notificationService = new EmailNotificationService();
        PaymentService paymentService = new StripePaymentService();

        OrderService orderService = new OrderService(
                repository,
                notificationService,
                paymentService
        );

        Order order = new Order("ORD123", 500.0);

        orderService.placeOrder(order);
    }
}