package evenodd;

public class Counter {

	int limit = 20;
	volatile int count = 1;
	volatile boolean even = false;

	synchronized void printEven() throws InterruptedException {
		if (!even) {
			wait();
		}
		if (count <= limit && count % 2 == 0) {
			System.out.println(Thread.currentThread().getName() + " " + count++);
		}
		even = false;
		notify();
	}

	synchronized void printOdd() throws InterruptedException {
		if (even) {
			wait();
		}
		if (count <= limit && count % 2 == 1) {
			System.out.println(Thread.currentThread().getName() + " " +count++);
		}
		even = true;
		notify();
	}

}
