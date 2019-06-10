package threadLocal;

public class Client {
	
//	As we see, the thread local creates one instance of SimpleDateFormat for each of the threads.
//	Now, in a thread pooled environment, 
//	if the thread local is not cleaned by calling its remove method, 
//	it will never allow the SimpleDateFormat to be garbage collected and that will 
//	end up having a lot of unused instances of SimpleDateFormat.
	
	public static void main(String[] args) {

		MyDateFormater formatter3 = new MyDateFormater();
		NewRunnable1 mr1 = new NewRunnable1(formatter3);
		NewRunnable2 mr2 = new NewRunnable2(formatter3);

		for (int i = 0; i < 100; i++) {
			Thread t1 = new Thread(mr1);
			Thread t2 = new Thread(mr2);
			t1.start();
			t2.start();
		}
	}
}