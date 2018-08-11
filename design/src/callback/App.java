package callback;

public class App implements Callback {

	public static void main(String[] args) {
		System.out.println("Download button is clicked, Thread name: " + Thread.currentThread().getName());
        new App().initiateDownload();
	}
	
	private void initiateDownload() {
		Thread t1 = new Thread(new Download(this), "t1");
		Thread t2 = new Thread(new Download(this), "t2");
		Thread t3 = new Thread(new Download(this), "t3");
		t1.start();
		t2.start();
		t3.start();
	}

	
	//if required we can 
	@Override
	public void onFinish() {
		System.out.println("Download is Finished, " + "Thread Name: " + Thread.currentThread().getName());
		
	}

}
