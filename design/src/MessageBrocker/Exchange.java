package MessageBrocker;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

public class Exchange {
	
	String name;
	Map<String, LinkedBlockingQueue<Message>> map = new HashMap<String, LinkedBlockingQueue<Message>>();
	public Exchange(String name) {
		this.name = name;
	}
	

	final void registerQueue(String routingKey, LinkedBlockingQueue<Message> q) {
		map.put(routingKey, q);
	}
	
	void sendMessage(String routingKey, Message message) {
		LinkedBlockingQueue<Message> q = map.get(routingKey);
		q.offer(message);
		System.out.println("Producer: Message added" + message.id );
	}

	
}

