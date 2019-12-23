package consumer;

import model.Message;

public interface ConsumerIfc {
	public void process(Message message);
}
