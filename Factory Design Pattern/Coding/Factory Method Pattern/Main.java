//Product interface
interface Notification{
    void notifyUser();    
}

//Create product
class EmailNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("User has been notified by an Email");
    }
}

class SMSNotification implements Notification{
    @Override
    public void notifyUser(){
        System.out.println("User has been notified by a SMS");
    }
}

//Create Factory class
abstract class NotificationFactory{
    abstract Notification createNotification();
}

//Concrete Factories
class EmailNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new EmailNotification();
    }
}

class SMSNotificationFactory extends NotificationFactory{
    Notification createNotification(){
        return new SMSNotification();
    }
}

//Usuage
public class Main{
    public static void main(String[] args) {
        NotificationFactory nv=new EmailNotificationFactory();
        Notification n= nv.createNotification();
        n.notifyUser();
    }
}