public interface IBank {
    void OpenAccount(IAccount account);
    void CloseAccount(int accountNumber);
    List<IAccount> GetAllAccounts();
    List<IAccount> GetAllAccountsInDebt();
    List<IAccount> GetAllAccountsWithBalance(double balanceAbove);
}

public class Bank extends IBank {
    List<IAccount> accounts;

    public Bank() {
        this.accounts = new ArrayList<IAccount>();
    }

    public void OpenAccount(IAccount account) {
        this.accounts.add(account.GetAccountNumber(), account);
    }

    public void CloseAccount(int accountNumber) {
        try {
            IAccount account = this.accounts.get(accountNumber);
        }
        catch (Exception e) {
            return;
        }
        if (account.GetCurrentBalance() >= 0) {
            this.accounts.remove(accountNumber);
        }
        else {
            System.out.println("Account not closed due to debt.");
        }
    }

    public List<IAccount> GetAllAccounts() {
        return this.accounts;
    }

    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> accountsInDebt = new ArrayList<IAccount>();

        for (IAccount account: this.accounts) {
            if (account.GetCurrentBalance() < 0) {
                accountsInDebt.add(account.GetAccountNumber(), account);
            }
        }

        return accountsInDebt;
    }

    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> accountsWithBalance = new ArrayList<IAccount>();

        for (IAccount account: this.accounts) {
            if (account.GetCurrentBalance() > balanceAbove) {
                accountsWithBalance.add(account.GetAccountNumber(), account);
            }
        }

        return accountsWithBalance;
    }
}
