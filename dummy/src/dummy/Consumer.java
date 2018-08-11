package dummy;

public class Consumer extends Thread {
	Test test;

	public Consumer(Test test) {
		this.test = test;
	}

	@Override
	public void run() {
		try {
			test.print();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
