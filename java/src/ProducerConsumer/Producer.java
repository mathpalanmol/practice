package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{

    protected BlockingQueue queue = null;

    public Producer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
        	for(int i=1; i<=50; i++) {
        		System.out.println("Produce: " + i);
            queue.put(i);
  //          Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
