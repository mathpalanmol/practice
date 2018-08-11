package atm;

public class Client {
	public static void main(String[] args) {
		AtmMachine atmMachine = new AtmMachine();
		System.out.println("ATM Machine Current state" + atmMachine.getClass().getName());
		System.out.println();
		atmMachine.enterPinAndWithdrawMoney();
		atmMachine.ejectDebitCard();
		atmMachine.insertDebitCard();
		System.out.println("\n ---------------");
		System.out.println("ATM Machine Current State" + atmMachine.getClass().getName());
		System.out.println();
		atmMachine.enterPinAndWithdrawMoney();
		atmMachine.insertDebitCard();
		atmMachine.ejectDebitCard();

	}
}
