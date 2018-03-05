package banking;

public class Nre extends Account {

	public Nre(double balance) {
		super(balance);
	}

	@Override
	public float getCreditInterest() {
		return 6;
	}

}
