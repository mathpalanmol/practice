package atm;

public class AtmMachine implements AtmMachineState {
	private AtmMachineState atmMachineState;

	public AtmMachine() {
		atmMachineState = new NoDebitCardState();
	}

	public AtmMachineState getAtmMachineState() {
		return atmMachineState;
	}

	public void setAtmMachineState(AtmMachineState atmMachineState) {
		this.atmMachineState = atmMachineState;
	}

	@Override
	public void insertDebitCard() {
		atmMachineState.insertDebitCard();
		setAtmMachineState(new HasDebitCardState());//change the state to has debit card.
	}

	@Override
	public void ejectDebitCard() {
		atmMachineState.ejectDebitCard();
		if (atmMachineState instanceof HasDebitCardState) {
			AtmMachineState noDebitCardState = new NoDebitCardState();
			setAtmMachineState(noDebitCardState);
			System.out.println("ATM Machine internal state has been moved to" + atmMachineState.getClass().getName());
		}
	}

	@Override
	public void enterPinAndWithdrawMoney() {
		atmMachineState.enterPinAndWithdrawMoney();
	}
}
