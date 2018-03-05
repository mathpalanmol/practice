package banking;

public abstract class Account {

	volatile double balance;

	public Account(double balance) {
		super();
		this.balance = balance;
	}

	final void deposit(double amount) {
		synchronized (this) {
			balance += amount;
		}
		System.out.println("Amount: " + amount + " deposited successfully");
	}

	final void withdrawl(int amount) {
		synchronized (this) {

			if (balance > amount)
				balance -= balance - amount;

		}
		System.out.println("Amount: " + amount + " withdrawn successfully");
	}

	public abstract float getCreditInterest();

	public void creditInterestAmount() {
		float cInt = getCreditInterest();
		balance = balance + (balance * cInt) / 100;
	}

	@Override
	public String toString() {
		return "Account [balance=" + balance + ", getCreditInterest()=" + getCreditInterest() + "]";
	}

}
