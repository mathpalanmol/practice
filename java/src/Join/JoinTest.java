package Join;


/*
 * Here main started t1.
 * t1.join; means t1 will complete first and then join main thread.
 * */
public class JoinTest {

	public static void main(String[] args) {
		System.out.println("Start");
		CThread t1 = new CThread("A");
		t1.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("End");
	}
}