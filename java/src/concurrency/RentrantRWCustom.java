package concurrency;

import java.util.concurrent.locks.ReentrantReadWriteLock;


//Read Lock   	If no threads have locked the ReadWriteLock for writing, 
//and no thread have requested a write lock (but not yet obtained it). 
//Thus, multiple threads can lock the lock for reading.
//Write Lock   	If no threads are reading or writing. 
//Thus, only one thread at a time can lock the lock for writing.

public class RentrantRWCustom {
	
	ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
	
	public void read() {
		lock.readLock().lock();
		// do read operations
		// any no of threads enters in to this section if no thread is writing or waiting for writing.
		lock.readLock().unlock();
	}
	
	private void write() {
        lock.writeLock().lock();
        //do write operation
        //only one thread can enter at a time.
        lock.writeLock().unlock();
	}

	public static void main(String[] args) {
		

	}

}
