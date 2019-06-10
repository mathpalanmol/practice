package concurrency;


public class MultiThreadPrintArray implements Runnable {
	int[] ary = { 1, 2, 3, 4, 5, 6, 7 };
	volatile int index = 0;

	public static void main(String[] args) {
		// create single object
		MultiThreadPrintArray obj = new MultiThreadPrintArray();
		// create two threads.
		Thread threadA = new Thread(obj);
		threadA.setName("A");
		Thread threadB = new Thread(obj);
		threadB.setName("B");
		
		
		threadA.start();
		threadB.start();

	}// main thread ends here

	public void print() {
		synchronized (ary) { // taking lock on array object
			while (index < ary.length) {
				System.out.println("Thread name: " + Thread.currentThread().getName() + " ; Value: " + ary[index++]);
				try {
					ary.notify(); // notify wakes all the threads waiting on this object.
					ary.wait();   // but threads has to wait until notify end braces executes.
					              // So in this case wait will be always be called.
					// notify will wake the existing threads but they have to wait until notify holds the lock. check below statement.
					              // Wait immediately looses the lock, whereas Notify will leave the lock only when the ending bracket is encountered.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

	@Override
	public void run() {
		print();

	}

}

// class MyThread extends Thread {
// MultiThreadPrintArray obj = null;
//
// MyThread(String name, MultiThreadPrintArray obj) {
// super(name);
// this.obj = obj;
// }
//
// @Override
// public void run() {
// obj.print();
// }
// }

// This will also work but there is a chance of spurious call.
/*
 * public void print() { synchronized (this.ary) { // taking lock on array
 * object if (index < ary.length) { System.out.println("Thread name: " +
 * Thread.currentThread().getName() + " ; Value: " + ary[index++]); ary.wait();
 * try { ary.wait(2000); } catch (InterruptedException e) { e.printStackTrace();
 * }
 * 
 * } } } }
 */
