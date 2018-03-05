package Proxy;

public class InternetImpl implements InternetIfc {

	@Override
	public void getInternetAccess() {
		grantAccess();
	}
	
	private void grantAccess(){
		System.out.println("Access Grant.");
	}

}
