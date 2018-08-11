package test;

public class ThreadJoin {

	int size = 2;

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "start");
		Thread t = Thread.currentThread();
		System.out.println("hello");
		t.sleep(3000);
		System.out.println("hi");
		
		CThread t1 = new CThread("A");
		t1.start();
		t1.join();// let current thread wait(here it is main thread) and t1 to execute first.
		
		System.out.println(Thread.currentThread().getName() + " end");
		
	}

	@Override
	public String toString() {
		return "Hello [size=" + size + "]";
	}
	
	
}
