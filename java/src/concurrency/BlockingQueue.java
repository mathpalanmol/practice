package concurrency;

import java.util.LinkedList;
import java.util.List;

// Although wait( ) normally waits until notify( ) or notifyAll( ) is called, there is a possibility that in very rare cases the waiting thread could be awakened due to a spurious wakeup. 
// In this case, a waiting thread resumes without notify( ) or notifyAll( ) having been called.
// In essence, the thread resumes for no apparent reason.
// Because of this remote possibility, Oracle recommends that calls to wait( ) should take place within a loop that checks the condition on which the thread is waiting.

public class BlockingQueue {

	  private List queue = new LinkedList();
	  private int  limit = 10;

	  public BlockingQueue(int limit){
	    this.limit = limit;
	  }


	  public synchronized void enqueue(Object item)
	  throws InterruptedException  {
	    while(this.queue.size() == this.limit) { // use while loop for wait.
	      wait();
	    }
	    if(this.queue.size() == 0) {
	      notifyAll();
	    }
	    this.queue.add(item);
	  }


	  public synchronized Object dequeue()
	  throws InterruptedException{
	    while(this.queue.size() == 0){
	      wait();
	    }
	    if(this.queue.size() == this.limit){
	      notifyAll();
	    }

	    return this.queue.remove(0);
	  }

	}
