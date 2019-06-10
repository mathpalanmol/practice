package pc;


public class PC {
	public static void main(String[] args) throws InterruptedException {
		
		MyRunnable run = new MyRunnable();
		Thread a1 = new Thread(run);
		a1.setName("A");
		Thread a2 = new Thread(run);
		a2.setName("B");
		a1.start();
		a2.start();

	}
}
