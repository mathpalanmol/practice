package concurrency;

public class MultiThreadPrintArray {
	int[] ary = { 1, 2, 3, 4, 5, 6, 7 };
	volatile int index = 0;

	public static void main(String[] args) {
		// create single object
		MultiThreadPrintArray obj = new MultiThreadPrintArray();
		// create two threads.
		MyThread threadA = new MyThread("A", obj);
		MyThread threadB = new MyThread("B", obj);
		threadA.start();
		threadB.start();
		
	}// main thread ends here

	public void print() {
		synchronized (ary) { // taking lock on array object
			while (index < ary.length) {
				System.out.println("Thread name: " + Thread.currentThread().getName() + " ; Value: " + ary[index++]);
				try {
					ary.notify();
					ary.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}

}




class MyThread extends Thread {
	MultiThreadPrintArray obj = null;

	MyThread(String name, MultiThreadPrintArray obj) {
		super(name);
		this.obj = obj;
	}

	@Override
	public void run() {
			obj.print();
			}
	
	
	// This will also work but there is a chance of spurious call.
	/*public void print() {
		synchronized (this.ary) { // taking lock on array object
			if (index < ary.length) {
				System.out.println("Thread name: " + Thread.currentThread().getName() + " ; Value: " + ary[index++]);
				ary.wait();
				try {
					ary.wait(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}
	}
	}*/
}
