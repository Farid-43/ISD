// Abstraction
abstract class Payment {
    public abstract void makePayment(double amount);
}

// Concrete Payment Methods
class CreditCardPayment extends Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Credit Card.");
    }

    // Merge conflict methods
    public String getTransactionId() {
        return "TXN12345";
    }

    public String getPaymentDate() {
        return "2025-09-21";
    }
}

class PayPalPayment extends Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

class MobileBankingPayment extends Payment {
    @Override
    public void makePayment(double amount) {
        System.out.println("Paid " + amount + " using Mobile Banking.");
    }
}

// Factory Class
class PaymentFactory {
    public static Payment getPayment(String type) {
        switch (type.toUpperCase()) {
            case "CREDIT":
                return new CreditCardPayment();
            case "PAYPAL":
                return new PayPalPayment();
            case "MOBILE":
                return new MobileBankingPayment();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}

// Bridge Pattern: Platform
interface Platform {
    void pay(Payment payment, double amount);
}

class WebApp implements Platform {
    @Override
    public void pay(Payment payment, double amount) {
        System.out.print("WebApp: ");
        payment.makePayment(amount);
    }
}

class MobileApp implements Platform {
    @Override
    public void pay(Payment payment, double amount) {
        System.out.print("MobileApp: ");
        payment.makePayment(amount);
    }
}

// Main (Demo)
public class B2 {
    public static void main(String[] args) {
        // Create platforms
        Platform web = new WebApp();
        Platform mobile = new MobileApp();

        // Create payments using Factory
        Payment credit = PaymentFactory.getPayment("CREDIT");
        Payment paypal = PaymentFactory.getPayment("PAYPAL");
        Payment mobileBank = PaymentFactory.getPayment("MOBILE");

        // Demonstrate payments
        web.pay(credit, 500.0);
        mobile.pay(paypal, 200.0);
        web.pay(mobileBank, 1000.0);
    }
}
