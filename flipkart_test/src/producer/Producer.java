package producer;

import executor.FSMExecutor;
import model.Message;

public class Producer implements Runnable {
	private FSMExecutor fsmExecutor;

	public Producer(FSMExecutor fsmExecutor) {
		super();
		this.fsmExecutor = fsmExecutor;
	}

	public void produce() {
		System.out.println();
		for (int i = 0; i < 500; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			Message msg = new Message(i, "msg: " + i);
			System.out.println("Publishing msgs: " + msg);
			fsmExecutor.publish(msg);
		}
	}

	@Override
	public void run() {
		produce();

	}
}
