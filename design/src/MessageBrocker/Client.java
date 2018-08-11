package MessageBrocker;

import java.util.concurrent.LinkedBlockingQueue;

public class Client {

	public static void main(String[] args) {
		Exchange exchange = new Exchange("exchange");
		
		LinkedBlockingQueue<Message> q1 = new LinkedBlockingQueue<Message>();
		LinkedBlockingQueue<Message> q2 = new LinkedBlockingQueue<Message>();
		LinkedBlockingQueue<Message> q3 = new LinkedBlockingQueue<Message>();
		exchange.registerQueue("1", q1);
		exchange.registerQueue("2", q2);
		exchange.registerQueue("3", q3);
		
		Consumer c1 = new Consumer(q1);
		Consumer c2 = new Consumer(q2);
		Consumer c3 = new Consumer(q3);
		Producer producer = new Producer(exchange);
		new Thread(producer).start();
		new Thread(c1).start();
		new Thread(c2).start();
		new Thread(c3).start();
	}

}
