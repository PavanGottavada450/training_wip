
package Day7;

class Bank_mul {
    private double balance;

    public Bank_mul(double balance) {
        this.balance = balance;
    }

    // Synchronized deposit method
    public synchronized void deposit(double amount) {
        balance += amount; // You had "balance = +amount" (incorrect)
        System.out.printf("%s deposited: %.2f, Balance: %.2f\n",
                Thread.currentThread().getName(), amount, balance);
    }

    // Synchronized withdraw method
    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("%s withdrew: %.2f, Balance: %.2f\n",
                    Thread.currentThread().getName(), amount, balance);
        } else {
            System.out.printf("%s: Insufficient funds for withdrawing %.2f, Balance: %.2f\n",
                    Thread.currentThread().getName(), amount, balance);
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Bank_Main {

    public static void main(String[] args) throws InterruptedException {

        Bank_mul b1 = new Bank_mul(1000.0);

        // Deposit Thread
        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                b1.deposit(200.0);
                sleep(100);
            }
        }, "Deposit-Thread");

        // Withdraw Thread
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                b1.withdraw(150.0);
                sleep(120);
            }
        }, "Withdraw-Thread");

        // Start both threads
        t1.start();
        t2.start();

        // Wait for both threads to finish
        t1.join();
        t2.join();

        System.out.printf("Final Balance = %.2f\n", b1.getBalance());
    }

    // Sleep method used to pause thread for given milliseconds
    private static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
