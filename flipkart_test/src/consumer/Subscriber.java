package consumer;

import executor.FSMExecutor;
import model.Message;
import model.State;

public class Subscriber implements ConsumerIfc, Runnable {
	private FSMExecutor fsmExecutor;
	private long id;

	public Subscriber(long id, FSMExecutor fsmExecutor) {
		super();
		this.fsmExecutor = fsmExecutor;
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void subscribe() {
		State state = new State("Inprogress");
		fsmExecutor.registerSubscriber(this, state);
	}

	@Override
	public void process(Message message) {
		System.out.println("Message Executed: Subscriber Id: " + id);
	}

	@Override
	public void run() {
		subscribe();
	}

}
