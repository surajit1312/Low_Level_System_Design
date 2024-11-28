package P1_Solid_Principles.Single_Responsibility_Principle.Bad_Code.account;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class AccountOperations {
    private static Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

    public void addAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void updateAccount(Account account) {
        accountMap.put(account.getAccountNumber(), account);
    }

    public void deleteAccount(Account account) {
        accountMap.remove(account.getAccountNumber());
    }

    public Account getAccount(int accountNumber) {
        return accountMap.get(accountNumber);
    }

    /**
     * The below methods should not be part of AccountOperations class
     * It is violating Single Responsibility Principle (SRP)
     * 
     * We can create a different class to handle Transaction say
     * 'TransactionOperations.java'
     * 
     * Refer the package named 'Good_Code' for refactoring
     **/
    public void getAccountDetails(int accountNumber) {
        Account account = accountMap.get(accountNumber);
        System.out.println();
        System.out.println("------------- Account Details ---------------");
        System.out.println("Account Number  : " + account.getAccountNumber());
        System.out.println("Account Holder  : " + account.getFirstName() + " " + account.getLastName());
        System.out.println("Account Balance : ₹" + account.getBalance() + ".00");
        System.out.println("---------------------------------------------");
        System.out.println();
    }

    public void depositBalance(int accountNumber, BigDecimal amount) {
        System.out.println();
        System.out.println("---- Deposited Balance : ₹" + amount + " -----");
        Account account = accountMap.get(accountNumber);
        BigDecimal updatedBalance = account.getBalance().add(amount);
        account.setBalance(updatedBalance);
        System.out.println("---- Updated Balance ----");
        getAccountDetails(account.getAccountNumber());
        System.out.println();
    }

    public void withdrawBalance(int accountNumber, BigDecimal amount) {
        Account account = accountMap.get(accountNumber);
        BigDecimal currentBalance = account.getBalance();
        if (currentBalance.compareTo(amount) == -1) {
            System.out.println("---- Transaction Error: Not enough balance! -----");
            return;
        }
        System.out.println();
        System.out.println("---- Withdrawn Balance : ₹" + amount + " -----");
        BigDecimal updatedBalance = account.getBalance().subtract(amount);
        account.setBalance(updatedBalance);
        System.out.println("---- Updated Balance ----");
        getAccountDetails(account.getAccountNumber());
        System.out.println();
    }
}
