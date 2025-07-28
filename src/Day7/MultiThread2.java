package Day7;

class Mul3 implements Runnable{
	public void run() {
		for(int i=1;i<=10;i++) {
			System.out.println("Pavan");	
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class Mul4 implements Runnable{
	public void run() {
		for(int i=0;i<=10;i++) {
			System.out.println("---------");
			try {
				Thread.sleep(10);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class MultiThread2 {

	public static void main(String[] args) {
		Runnable m3 = new Mul3();
		Runnable m4 = new Mul4();
		
		
		Thread t1 = new Thread(m3);
		Thread t2 = new Thread(m4);
		
		t1.start();
		t2.start();

	}


}
