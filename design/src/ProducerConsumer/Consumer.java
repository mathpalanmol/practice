package ProducerConsumer;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    protected BlockingQueue queue = null;

    public Consumer(BlockingQueue queue) {
        this.queue = queue;
    }

    public void run() {
        try {
        	while(true) {
            System.out.println("consume: " + queue.take());
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
