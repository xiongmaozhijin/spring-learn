package ch2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountDaoInMemoryImpl implements AccountDao {
    private Map<Long, Account> accountsMap = new HashMap<Long, Account>();

    {
        Account account1 = new Account();
        account1.setId(1L);
        account1.setOwnerName("John");
        account1.setBalance(10.0);

        Account account2 = new Account();
        account2.setId(2L);
        account2.setOwnerName("Mary");
        account2.setBalance(20.0);

        accountsMap.put(account1.getId(), account1);
        accountsMap.put(account2.getId(), account2);

    }

    public void insert(Account account) {

    }

    public void update(Account account) {
        accountsMap.put(account.getId(), account);
    }

    public void update(List<Account> accounts) {

    }

    public void delete(long accountId) {

    }

    public Account find(long accountId) {
        return accountsMap.get(accountId);
    }

    public List<Account> find(List<Long> accountIds) {
        return null;
    }
}
