package P1_Solid_Principles.P1_Single_Responsibility_Principle.Good_Code;

import java.math.BigDecimal;

import P1_Solid_Principles.P1_Single_Responsibility_Principle.Good_Code.account.Account;
import P1_Solid_Principles.P1_Single_Responsibility_Principle.Good_Code.operations.AccountOperations;
import P1_Solid_Principles.P1_Single_Responsibility_Principle.Good_Code.operations.TransactionOperations;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber(50506050);
        account.setFirstName("Surajit");
        account.setLastName("Rana");
        account.setBalance(BigDecimal.valueOf(10000));

        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);

        TransactionOperations transactionOperations = new TransactionOperations();
        transactionOperations.getAccountDetails(account.getAccountNumber());
        transactionOperations.depositBalance(account.getAccountNumber(), BigDecimal.valueOf(20000));
        transactionOperations.withdrawBalance(account.getAccountNumber(), BigDecimal.valueOf(50000));
        transactionOperations.withdrawBalance(account.getAccountNumber(), BigDecimal.valueOf(10000));
    }
}
