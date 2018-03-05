package thread;

//The virtual machine terminates if the last non-daemon thread has finished. It doesn't have to be the main thread
// Main ends every other daemon thread ends if they exist.
//Non Daemon Thread still runs even if Main ends.
public class ThreadA implements Runnable {
	String str = "A";

	public static void main(String[] args) throws InterruptedException {
		System.out.println("Main Thread Start");
		ThreadA obj = new ThreadA();

		Thread ta = new Thread(obj, "A");
		Thread tb = new Thread(obj, "B");
		Thread tc = new Thread(obj, "C");
		ta.start();
		tb.start();
		tc.start();

		Thread td = new Thread() {
			public void run() {
				synchronized (obj) {
					while (true) {
						obj.notifyAll();
						try {
							obj.wait(3000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

				}
			}
		};
		td.setDaemon(true);
		td.start();

	}

	volatile String tName = "A";

	@Override
	public void run() {

		synchronized (this) {
			for (int i = 0; i < 3; i++) {
				if (Thread.currentThread().getName().equals(tName)) {
					System.out.println(Thread.currentThread().getName());
					tName = (tName == "A") ? "B" : (tName == "B") ? "C" : "A";
					try {
						this.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
				else{
					--i;
					try {
						this.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
//					System.out.println("else" + Thread.currentThread().getName());
//					System.out.println(tName);
//					try {
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					this.notify();}
			}
		}
	}

//	 @Override
//	 public void run() {
//	
//	 synchronized (this) {
//	 for (int i = 0; i < 3; i++) {
//	 this.notify();
//	 if (str.equals(Thread.currentThread().getName())) {
//	 System.out.println(Thread.currentThread().getName());
//	 this.notify();
//	 if (str.equals("A")) {
//	 str = "B";
//	 }else if (str.equals("B")) {
//	 str = "C";
//	 }else if (str.equals("C")) {
//	 str = "A";
//	 }
//	 try {
//	 this.notify();
//	 this.wait();
//	 } catch (InterruptedException e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 } else {
//	 --i;
//	 try {
//	 this.notify();
//	 this.wait();
//	 this.notify();
//	
//	 } catch (InterruptedException e) {
//	 // TODO Auto-generated catch block
//	 e.printStackTrace();
//	 }
//	 }
//	 }
//	 this.notify();
//	 }
//	
//	 }

}
