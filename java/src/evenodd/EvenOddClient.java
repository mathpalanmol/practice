package evenodd;

public class EvenOddClient {
	public static void main(String[] args) {
		Counter runRef = new Counter();
		Thread even = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						runRef.printEven();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}

			}
		});

		Thread odd = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						runRef.printOdd();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		even.setName("Even");
		odd.setName("Odd");
		
		even.start();
		odd.start();
	}

}
