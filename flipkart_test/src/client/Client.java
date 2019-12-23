package client;

import consumer.Subscriber;
import executor.FSMExecutor;
import model.FSMachine;
import model.State;
import producer.Producer;

public class Client {
	public static void main(String[] args) {
		State start = new State("START");
		State inprogress = new State("INPROGRESS");
		State end = new State("END");

		FSMachine fsMachine = new FSMachine("FinateStateMachine");
		fsMachine.addState(start);
		fsMachine.addState(inprogress);
		fsMachine.addState(end);

		FSMExecutor fsmExecutor = new FSMExecutor(fsMachine);

		Producer producer = new Producer(fsmExecutor);

		Thread producerThread = new Thread(producer);

		Subscriber subscriber1 = new Subscriber(1, fsmExecutor);
		Subscriber subscriber2 = new Subscriber(2, fsmExecutor);
		Subscriber subscriber3 = new Subscriber(3, fsmExecutor);

		Thread subscriberThread1 = new Thread(subscriber1);
		Thread subscriberThread2 = new Thread(subscriber2);
		Thread subscriberThread3 = new Thread(subscriber3);

		// starting producer and consumer threads.

		producerThread.start();
		subscriberThread1.start();
		subscriberThread2.start();
		subscriberThread3.start();

		fsmExecutor.process();

	}
}
