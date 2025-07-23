package Day4;

abstract class Payments{
	double amount;
	
	Payments(double amount){
		this.amount = amount;
	}
	
	abstract void makePayment();
	
	void showSuccessMesssage() {
		System.out.println("Payment Successfull" + amount);
	}
}

class CreditCardPayment extends Payments{
	
	CreditCardPayment(double amount){
		super(amount);
	}
	
	void makePayment() {
		System.out.println("Credit card payment is Done...");
	}
	
}

class UpiPayment extends Payments{
	
	UpiPayment(double amount){
		super(amount);
	}
	
	void makePayment() {
		System.out.println("Upi payment is Done...");
	}
}

public class PaymentAbstract {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Payments p = new CreditCardPayment(4500);
		p.makePayment();
		
		System.out.println("Credit Card Payment Process is Completed");
		
		Payments p1 = new UpiPayment(3000);
		p1.makePayment();
		
		System.out.println("Upi Payment Process is Completed");
	}

}
