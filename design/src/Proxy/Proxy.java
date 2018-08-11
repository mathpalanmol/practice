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
				internetRef = new InternetImpl(); // here we need to create the object, don't pass it. 
			    // external entity shouldn't have access to subject object.
			internetRef.getInternetAccess();
		}
	}

}
