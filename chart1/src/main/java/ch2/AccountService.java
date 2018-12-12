package ch2;

public interface AccountService {
    void transferMoney(long sourceAccountId, long targetAccountId,
                       double amount);

    void depositMoney(long accountId, double amount);

    Account getAccount(long accountId);

}
