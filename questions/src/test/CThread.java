package test;

public class CThread extends Thread {
	public CThread(String name) {
		super(name);
	}
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName() + " start");
		for (int i = 0; i < 50; i++) {
			System.out.println(i);
		}
		Test t = new Test();
		t.m1();
		System.out.println(Thread.currentThread().getName() + " end");
	}
}
