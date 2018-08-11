package dummy;

public class Producer implements Runnable {
	Test test;

	public Producer(Test test) {
		this.test = test;
	}
	
	@Override
	public void run() {
		try {
			test.populater();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
