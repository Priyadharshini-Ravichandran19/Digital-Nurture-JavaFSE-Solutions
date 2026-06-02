interface Payment {

    void pay(double amount);
}
class UpiPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using UPI");
    }
}
class CreditCardPayment implements Payment {

    public void pay(double amount) {
        System.out.println("Paid ₹" + amount + " using Credit Card");
    }
}
public class Interfacepaytm{
    public static void main(String[] args) {

        Payment p1 = new UpiPayment();

        Payment p2 = new CreditCardPayment();

        p1.pay(1000);

        p2.pay(2500);
    }
}