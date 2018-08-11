package callback;

public class Download implements Runnable {
	Callback callback;

	public Download(Callback callback) {
		this.callback = callback;
	}
	
	public void download()  {
		System.out.println("Download has started");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		callback.onFinish();
	}
	
	@Override
	public void run() {
		download();
	}
}
