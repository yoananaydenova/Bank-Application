public class Savings extends Account {
    // List properties specific to a Savings Account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    // Constructor to initialize Savings Account properties
    public Savings(String name, String sSN, double initDeposit) {
        super(name, sSN, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    // List any methods specific to a Savings Account

    @Override
    public void setRate() {
        super.rate = getBaseRate() - 0.25;
    }

    private void setSafetyDepositBox(){
        this.safetyDepositBoxID =(int)( Math.random() * Math.pow(10, 3));
        this.safetyDepositBoxKey = (int)( Math.random() * Math.pow(10, 4));
    }

    public void showInfo() {
        super.showInfo();
        System.out.println(
                " Your Savings Account Features"+
                "\n Safety Deposit Box ID: " + this.safetyDepositBoxID +
                "\n Safety Deposit Box Key: " + this.safetyDepositBoxKey
        );
    }
}
