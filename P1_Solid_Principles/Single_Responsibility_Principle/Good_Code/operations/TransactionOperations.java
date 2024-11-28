package P1_Solid_Principles.Single_Responsibility_Principle.Good_Code.operations;

import java.math.BigDecimal;

import P1_Solid_Principles.Single_Responsibility_Principle.Good_Code.account.Account;

public class TransactionOperations {
    private AccountOperations accountOperations;

    public TransactionOperations() {
        accountOperations = new AccountOperations();
    }

    public void getAccountDetails(int accountNumber) {
        Account account = accountOperations.getAccount(accountNumber);
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
        Account account = accountOperations.getAccount(accountNumber);
        BigDecimal updatedBalance = account.getBalance().add(amount);
        account.setBalance(updatedBalance);
        System.out.println("---- Updated Balance ----");
        getAccountDetails(account.getAccountNumber());
        System.out.println();
    }

    public void withdrawBalance(int accountNumber, BigDecimal amount) {
        Account account = accountOperations.getAccount(accountNumber);
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
