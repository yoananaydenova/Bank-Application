public class Checking extends Account {
    // List properties specific to a Checking Account
    private int debitCardNumber;
    private int debitCardPIN;

    // Constructor to initialize Checking Account properties
    public Checking(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    // List any methods specific to a Checking Account
    @Override
    public void setRate() {
       super.rate = getBaseRate() * 0.15;
    }

    private void setDebitCard() {
        this.debitCardNumber = (int) (Math.random() * Math.pow(10, 12));
        this.debitCardPIN = (int) (Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(" Your Checking Account Features" +
                "\n Debit Card Number: " + this.debitCardNumber +
                "\n Debit Card PIN: " + this.debitCardPIN);
    }
}
