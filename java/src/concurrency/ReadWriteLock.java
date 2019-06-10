package concurrency;
//http://tutorials.jenkov.com/java-concurrency/read-write-locks.html
public class ReadWriteLock{
//	Thread 1 gets read access.
//
//	Thread 2 requests write access but is blocked because there is one reader.
//
//	Thread 1 re-requests read access (re-enters the lock), but is blocked because there is a write request

	
//	The ReadWriteLock has two lock methods and two unlock methods. One lock and unlock method for read access and one lock and unlock for write access.
//
//	The rules for read access are implemented in the lockRead() method. All threads get read access unless there is a thread with write access, or one or more threads have requested write access.
//
//	The rules for write access are implemented in the lockWrite() method. A thread that wants write access starts out by requesting write access (writeRequests++). Then it will check if it can actually get write access. A thread can get write access if there are no threads with read access to the resource, and no threads with write access to the resource. How many threads have requested write access doesn't matter.
//
//	It is worth noting that both unlockRead() and unlockWrite() calls notifyAll() rather than notify(). To explain why that is, imagine the following situation:
//
//	Inside the ReadWriteLock there are threads waiting for read access, and threads waiting for write access. If a thread awakened by notify() was a read access thread, it would be put back to waiting because there are threads waiting for write access. However, none of the threads awaiting write access are awakened, so nothing more happens. No threads gain neither read nor write access. By calling noftifyAll() all waiting threads are awakened and check if they can get the desired access.
//
//	Calling notifyAll() also has another advantage. If multiple threads are waiting for read access and none for write access, and unlockWrite() is called, all threads waiting for read access are granted read access at once - not one by one.
		
	
	
	  private int readers       = 0;
	  private int writers       = 0;
	  private int writeRequests = 0;

	  public synchronized void lockRead() throws InterruptedException{
	    while(writers > 0 || writeRequests > 0){
	      wait();
	    }
	    readers++;
	  }

	  public synchronized void unlockRead(){
	    readers--;
	    notifyAll();
	  }

	  public synchronized void lockWrite() throws InterruptedException{
	    writeRequests++;

	    while(readers > 0 || writers > 0){
	      wait();
	    }
	    writeRequests--;
	    writers++;
	  }

	  public synchronized void unlockWrite() throws InterruptedException{
	    writers--;
	    notifyAll();
	  }
	}












