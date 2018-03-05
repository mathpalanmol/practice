package Proxy;
//Protection proxy
public class Proxy implements InternetIfc {

	int roll;
	InternetImpl internetRef;

	Proxy(int roll) {
		this.roll = roll;
	}

	@Override
	public void getInternetAccess() {
		if (roll > 2) {
			if (internetRef == null)
				internetRef = new InternetImpl();
			internetRef.getInternetAccess();
		}
	}

}
