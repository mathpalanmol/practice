package threadLocal;

class NewRunnable2 implements Runnable {
	MyDateFormater formatter;

	public NewRunnable2(MyDateFormater f) {
		this.formatter = f;
	}

	@Override
	public void run() {
		System.out.println("Beginning Date -  " + formatter.getFormattedBeginningDate());
	}
}
