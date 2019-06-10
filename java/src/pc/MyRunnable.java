package pc;

public class MyRunnable implements Runnable {
	int count = 0;

	@Override
	public void run() {
		if (Thread.currentThread().getName() == "A") {
			try {
				producer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (Thread.currentThread().getName() == "B") {
			try {
				consumer();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	synchronized public void producer() throws InterruptedException {
		while (true) {
			++count;
			// I want to print till 10 so below condition below if is not required.
			if(count >10) {
				notify(); // consumer is waiting so in order to allow him to execute we have to notify..Otherwise program will not terminate. 
				          // when consumer is notified it will also have same conditon and loop will break.
				break;
			}
			Thread.sleep(1000);
			System.out.println("Produce: " + +count);

			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	synchronized public void consumer() throws InterruptedException {
		while (true) {
			if(count >10) {
				break;
			}
			Thread.sleep(1000);
			System.out.println("Consume: " + count);

			try {
				notify();
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
