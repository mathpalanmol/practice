package concurrency;

public class MultiThreadPrintArrayothermethod {

	int[] ary = { 1, 2, 3, 4, 5, 6, 7 };
	volatile int index = 0;

	public static void main(String[] args) {
		// create single object
		MultiThreadPrintArrayothermethod obj = new MultiThreadPrintArrayothermethod();
		// create two threads.
		MyThread1 threadA = new MyThread1("A", obj);
		MyThread1 threadB = new MyThread1("B", obj);
		threadA.start();
		threadB.start();
	}// main thread ends here

	public void print() {
		synchronized (this.ary) { // taking lock on array object
//			System.out.println("index: " + index + "Thread name: " + Thread.currentThread().getName());
			while (index < ary.length) {
				System.out.println("Thread name: " + Thread.currentThread().getName() + " ; Value: " + ary[index]);
				++index;
				ary.notify();
				try {
					ary.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
}

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

class MyThread1 extends Thread {
	MultiThreadPrintArrayothermethod obj = null;

	MyThread1(String name, MultiThreadPrintArrayothermethod obj) {
		super(name);
		this.obj = obj;
	}

	@Override
	public void run() {
		obj.print();

	}
}
