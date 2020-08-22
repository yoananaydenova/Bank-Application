public abstract class Account implements IBaseRate {
    // List common properties for savings and checking accounts
    private String name;
    private String sSN;
    private double balance;

    private static int index = 10000;
    protected String accountNumber;
    protected double rate;

    // Constructor to set base properties and initialize the account
    public Account(String name, String sSN, double initDeposit) {
        this.name = name;
        this.sSN = sSN;
        this.balance = initDeposit;

        // Set Account number
        index++;
        this.accountNumber = setAccountNumber();

        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoOfSSN = this.sSN.substring(this.sSN.length() - 2);
        int uniqueID = index;
        int randomNumber = (int) (Math.random() * Math.pow(10, 3));
        return lastTwoOfSSN + uniqueID + randomNumber;
    }

    public void compound(){
        double accruedInterest = this.balance * (this.rate / 100);
        this.balance += accruedInterest;
        System.out.println("Accrued Interest: $" + accruedInterest);
        printBalance();
    }

    // List common methods - transactions
    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Depositing $" + amount);
        printBalance();
    }

    public void withdraw(double amount) {
        this.balance -= amount;
        System.out.println("Withdrawing $" + amount);
        printBalance();
    }

    public void transfer(String toWhere, double amount) {
        this.balance -= amount;
        System.out.println("Transferring $" + amount + " to " + toWhere);
        printBalance();
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + this.balance);
    }

    public void showInfo() {
        System.out.println(
                "NAME: " + this.name +
                        "\nACCOUNT NUMBER: " + this.accountNumber +
                        "\nBALANCE: " + this.balance +
                        "\nRATE: " + this.rate + "%"
        );
    }
}
