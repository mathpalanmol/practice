package executor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import consumer.Subscriber;
import model.FSMachine;
import model.Message;
import model.State;

public class FSMExecutor implements SubscriberInt {
	private State currentState;
	private Map<State, List<Subscriber>> stateSubMapping = new HashMap<State, List<Subscriber>>();
	private BlockingQueue<Message> q = new ArrayBlockingQueue<Message>(1024);
	private FSMachine fsMachine;

	public FSMExecutor(FSMachine fsMachine) {
		super();
		this.fsMachine = fsMachine;
	}

	@Override
	public void registerSubscriber(Subscriber subscriber, State state) {
		if (stateSubMapping.containsKey(state)) {
			List<Subscriber> list = stateSubMapping.get(state);
			list.add(subscriber);
			list.forEach(System.out::println);
		} else {
			List<Subscriber> subscribers = new ArrayList<Subscriber>();
			subscribers.add(subscriber);
			stateSubMapping.put(state, subscribers);
			subscribers.forEach(System.out::println);
		}
	}

	public void process() {
		while (true) {
			Message msg = q.poll();
			System.out.println("Processing msg: " + msg);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			State currentState = fsMachine.getInitialState();
			while (currentState != null) {
				List<Subscriber> subscribers = stateSubMapping.get(currentState);
				new Thread() {
					public void run() {
						notifySubscriber(subscribers, msg);

					}
				}.start();
				currentState = currentState.next;
			}

		}
	}

	@Override
	public void notifySubscriber(List<Subscriber> subscribers, Message message) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		subscribers.forEach(System.out::println);
		for (Subscriber subscriber : subscribers)
			subscriber.process(message);
	}

	@Override
	public void deregisterSubscriber(Subscriber subscriber, State state) {
		List<Subscriber> list = stateSubMapping.get(state);
		if (list != null && list.contains(subscriber))
			list.remove(subscriber);
	}

	public void publish(Message msg) {
		q.add(msg);
		System.out.println("msg is added in q: " + msg);
	}

	public State getCurrentState() {
		return currentState;
	}

	public void setCurrentState(State currentState) {
		this.currentState = currentState;
	}

	@Override
	public String toString() {
		return "FSMExecutor [currentState=" + currentState + "]";
	}

}
