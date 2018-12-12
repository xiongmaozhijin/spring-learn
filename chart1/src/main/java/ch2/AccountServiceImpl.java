package ch2;

public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void transferMoney(long sourceAccountId, long targetAccountId, double amount) {
        Account sourceAt = accountDao.find(sourceAccountId);
        Account targetAt = accountDao.find(targetAccountId);
        sourceAt.setBalance(sourceAt.getBalance() - amount);
        targetAt.setBalance(targetAt.getBalance() + amount);
        accountDao.update(sourceAt);
        accountDao.update(targetAt);
    }

    public void depositMoney(long accountId, double amount) {
        Account account = accountDao.find(accountId);
        account.setBalance(account.getBalance() + amount);
        accountDao.update(account);
    }

    public Account getAccount(long accountId) {
        return accountDao.find(accountId);
    }
}
