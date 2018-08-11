package MessageBrocker;

public class Producer implements Runnable {
	Exchange exchange;

	public Producer(Exchange exchange) {
		this.exchange = exchange;
	}

	@Override
	public void run() {
		int i = 1;
		boolean flag = true;
		while (i <= 10) {
			Message message = new Message(i);
			if (flag)
				exchange.sendMessage("1", message);
			else
				exchange.sendMessage("2", message);
			flag = !flag;
			i++;
		}
	}
	// should have sendMessage method which inturn will call exchange sendMessage method.

}
