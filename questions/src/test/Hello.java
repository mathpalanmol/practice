package test;

public class Hello {

	int size = 2;

	public static void main(String[] args) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + "start");
		Thread t = Thread.currentThread();
		System.out.println("hello");
		t.sleep(3000);
		System.out.println("hi");
		
		CThread t1 = new CThread("A");
		t1.run();
	//	t1.join();
		
		System.out.println(Thread.currentThread().getName() + " end");
		
	}

	@Override
	public String toString() {
		return "Hello [size=" + size + "]";
	}
	
	
}
