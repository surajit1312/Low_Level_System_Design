package P1_Solid_Principles.Single_Responsibility_Principle.Good_Code.operations;

import java.util.HashMap;
import java.util.Map;

import P1_Solid_Principles.Single_Responsibility_Principle.Good_Code.account.Account;

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
}
