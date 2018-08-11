package MessageBrocker;

import java.util.concurrent.LinkedBlockingQueue;

public class Consumer implements Runnable {
	LinkedBlockingQueue<Message> q ;
	
	
	public Consumer(LinkedBlockingQueue<Message> q) {
		this.q = q;
	}

	@Override
	public void run() {
		while(true) {
			Message message;
			try {
				Thread.sleep(1000); //added just to check the flow
				message = q.take();
				System.out.println("Consume:  " + message.id );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
