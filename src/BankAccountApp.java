import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) {
        List<Account> accounts = new LinkedList<>();

        /*
         Read a CSV File than create new accounts based on that data
         In String file write path in your PC to CSV file that is given in resources like:
         String file = "C:\Users\Java Project\NewBankAccounts.csv";
         */
        String file = "C:\\Users\\Java Project\\NewBankAccounts.csv";

        List<String[]> newAccountHolders = utilities.CSV.read(file);
        for (String[] accountHolder : newAccountHolders) {
            System.out.println("NEW ACCOUNT:");
            String name = accountHolder[0];
            String sSN = accountHolder[1];
            String accountType = accountHolder[2];
            double initDeposit = Double.parseDouble(accountHolder[3]);

            if (accountType.equals("Savings")) {
                accounts.add(new Savings(name, sSN, initDeposit));
            } else if (accountType.equals("Checking")) {
                accounts.add(new Checking(name, sSN, initDeposit));
            } else {
                System.out.println("ERROR READING ACCOUNT TYPE");
            }
        }
        for (Account acc : accounts) {
            System.out.println("**********");
            acc.showInfo();
        }
    }
}
