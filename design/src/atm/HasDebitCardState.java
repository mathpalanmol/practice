package atm;

public class HasDebitCardState implements AtmMachineState{
    @Override
    public void insertDebitCard() {
        System.out.println("Debit Card is already in the ATM, so you can't insert another");
    }

    @Override
    public void ejectDebitCard() {
        System.out.println("Debit card is ejected");
    }

    @Override
    public void enterPinAndWithdrawMoney() {
        System.out.println("Pin Card entered correctly, and money has been withdrawn");
    }
}
