// Step 1: Notification Interface
interface Notification {
    void notifyUser();
}

// Step 2: Concrete Classes
class EmailNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending Email Notification: Your borrowed book is due soon!");
    }
}

class SMSNotification implements Notification {
    public void notifyUser() {
        System.out.println("Sending SMS Notification: Your borrowed book is due soon!");
    }
}

// Step 3: Factory Class
class NotificationFactory {
    public Notification createNotification(String type) {
        if (type == null || type.isEmpty()) {
            return null;
        }
        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        } else if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }
        return null;
    }
}

// Step 4: Main Class to Test
public class Task {
    public static void main(String[] args) {
        NotificationFactory factory = new NotificationFactory();

        Notification email = factory.createNotification("EMAIL");
        email.notifyUser();

        Notification sms = factory.createNotification("SMS");
        sms.notifyUser();
    }
}
