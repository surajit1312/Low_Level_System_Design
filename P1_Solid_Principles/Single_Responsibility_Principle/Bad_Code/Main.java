package P1_Solid_Principles.Single_Responsibility_Principle.Bad_Code;

import java.math.BigDecimal;

import P1_Solid_Principles.Single_Responsibility_Principle.Bad_Code.account.Account;
import P1_Solid_Principles.Single_Responsibility_Principle.Bad_Code.account.AccountOperations;

public class Main {
    public static void main(String[] args) {
        Account account = new Account();
        account.setAccountNumber(50506050);
        account.setFirstName("Surajit");
        account.setLastName("Rana");
        account.setBalance(BigDecimal.valueOf(10000));

        AccountOperations accountOperations = new AccountOperations();
        accountOperations.addAccount(account);
        accountOperations.getAccountDetails(account.getAccountNumber());
        accountOperations.depositBalance(account.getAccountNumber(), BigDecimal.valueOf(20000));
        accountOperations.withdrawBalance(account.getAccountNumber(), BigDecimal.valueOf(50000));
        accountOperations.withdrawBalance(account.getAccountNumber(), BigDecimal.valueOf(10000));
    }
}
