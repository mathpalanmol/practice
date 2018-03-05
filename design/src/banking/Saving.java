package banking;

public class Saving extends Account {

	public Saving(double balance) {
		super(balance);
	}

	@Override
	public float getCreditInterest() {
		return 3;
	}

}
