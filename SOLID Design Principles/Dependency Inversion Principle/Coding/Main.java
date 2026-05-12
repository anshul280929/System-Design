
interface PaymentProcessor{
    void processPayment(double amount);
}
interface Refundable{
    void refund(double amount);
}

class CreditCardPayment implements PaymentProcessor,Refundable{
    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing Credit Card Payment: " + amount
        );
    }

    @Override
    public void refund(double amount) {
        System.out.println(
            "Refunding Credit Card Payment"+amount
        );
    }
    
}

class UPIPayment implements PaymentProcessor {

    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing UPI Payment: " + amount
        );
    }
}

class PayPalPayment implements PaymentProcessor, Refundable {

    @Override
    public void processPayment(double amount) {
        System.out.println(
            "Processing PayPal Payment: " + amount
        );
    }

    @Override
    public void refund(double amount) {
        System.out.println(
            "Refunding PayPal Payment: " + amount
        );
    }
}

class PaymentService{
    private final PaymentProcessor paymentProcessor;

    public PaymentService(PaymentProcessor paymentProcessor){
        this.paymentProcessor=paymentProcessor;
    }
    public void pay(double amount){
        paymentProcessor.processPayment(amount);
    }
}

public class Main {

    public static void main(String[] args) {

        PaymentProcessor creditCard =
                new CreditCardPayment();

        PaymentProcessor upi =
                new UPIPayment();

        PaymentProcessor paypal =
                new PayPalPayment();

        PaymentService creditCardService =
                new PaymentService(creditCard);

        PaymentService upiService =
                new PaymentService(upi);

        PaymentService paypalService =
                new PaymentService(paypal);

        creditCardService.pay(5000);

        upiService.pay(1200);

        paypalService.pay(8000);
    }
}