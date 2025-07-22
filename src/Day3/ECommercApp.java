package Day3;

interface PaymentMode{
	void pay(double amount);
}

class UpiPayment implements PaymentMode {
	public void pay(double amount) {
		System.out.println("Paid $" + amount + "via UPI");
	}
}

class CreditCardPayment implements PaymentMode{
	public void pay(double amount) {
		System.out.println("Paid $ " + amount + "via CreditCard");
	}
}

class CashOnDelivery implements PaymentMode{
	public void pay(double amount) {
		System.out.println("Paid $ " + amount + "via CashOnDelivery");
	}
}

public class ECommercApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PaymentMode payment;
		
		payment = new UpiPayment();
		payment.pay(1500.00);
		
		payment = new CreditCardPayment();
		payment.pay(3200.00);
		
		payment = new CashOnDelivery();
		payment.pay(2000.00);
	}

}
