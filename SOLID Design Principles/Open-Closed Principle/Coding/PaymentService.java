interface PaymentMethod {
    PaymentResult pay(PaymentRequest request);
}
class PaymentRequest {
    private final double amount;
    private final String currency;

    public PaymentRequest(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() { return amount; }
    public String getCurrency() { return currency; }
}

class PaymentResult {
    private final boolean success;
    private final String message;

    public PaymentResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
}
class UpiPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(PaymentRequest request) {
        System.out.println("Processing UPI payment: " + request.getAmount());
        return new PaymentResult(true, "UPI Success");
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(PaymentRequest request) {
        System.out.println("Processing Credit Card payment: " + request.getAmount());
        return new PaymentResult(true, "Card Success");
    }
}

class PaymentProcessor {

    public PaymentResult process(PaymentMethod paymentMethod, PaymentRequest request) {
        PaymentResult result = paymentMethod.pay(request);

        if (result.isSuccess()) {
            System.out.println("[LOG] Payment successful: " + result.getMessage());
        } else {
            System.out.println("[LOG] Payment failed: " + result.getMessage());
        }

        return result;
    }
}
class CryptoPayment implements PaymentMethod {
    @Override
    public PaymentResult pay(PaymentRequest request) {
        return new PaymentResult(true, "Crypto Success");
    }
}