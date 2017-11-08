package thread;

class A extends Thread {
//	volatile A obj = null;
    private static Test obj = new Test();
	boolean prod = false;
	int count  = 0;

	@Override
	public void run() {
		
		if(Thread.currentThread().getName() == "A"){
producer();
}
		if(Thread.currentThread().getName() == "B"){
			consumer();
			}
		
	}

	public void producer() {
		synchronized (obj) {
		while (true) {
			System.out.println("Produce" + " text" + ++count);
			
//			consumer();
			
				try {
					obj.notify();
//					Thread.sleep(5000);
					obj.wait(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void consumer() {
		synchronized (obj) {
		while (true) {
			System.out.println("Consume" + " text");
//			obj.notify();
//			producer();
			
				try {
//					obj.notify();
//					Thread.sleep(5000);
					obj.notifyAll();
					Thread.sleep(2000);
					obj.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}
class Test{
	
}

public class PC {

	public static void main(String[] args) throws InterruptedException {
		A a1 = new A();
		a1.setName("A");
		A a2 = new A();
		a2.setName("B");
		// Thread b = new Thread(obj, "B");
		// Thread c = new Thread(obj, "C");
		a1.start();
//		Thread.sleep(2000);
		a2.start();
		// b.start();

	}

}
