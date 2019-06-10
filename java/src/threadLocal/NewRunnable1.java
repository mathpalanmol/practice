package threadLocal;

class NewRunnable1 implements Runnable {
	MyDateFormater formatter;

	public NewRunnable1(MyDateFormater f) {
		this.formatter = f;
	}

	@Override
	public void run() {
		System.out.println("Current Date - " + formatter.getFormattedCurrentDate());
	}
}
