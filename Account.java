public interface IAccount {
    void Deposit(double amount);
    double Withdraw(double amount);
    double GetCurrentBalance();
    int GetAccountNumber();
}


public class StandardAccount extends IAccount {
    int accountNumber;
    double creditLimit;
    double accountBalance;

    public StandardAccount(int accountNumber, double creditLimit) {
        this.accountBalance = 0;

        this.accountNumber = accountNumber;
        if (creditLimit > 0) {
            this.creditLimit = 0
        }
        else {
            this.creditLimit = creditLimit;
        }
    }

    public void Deposit(double amount) {
        this.accountBalance += amount;
    }

    public double GetCurrentBalance() {
        return this.accountBalance;
    }

    public int GetAccountNumber() {
        return this.accountNumber;
    }

    public double Withdraw(double amount) {
        double newBalance = this.accountBalance - amount;
        if (newBalance < this.creditLimit) {
            double balanceInAccount = this.accountBalance - this.creditLimit;
            this.accountBalance = this.creditLimit;
            return balanceInAccount;
        }
        else {
            this.accountBalance = newBalance;
            return amount;
        }
    } 
}

public class BasicAccount extends IAccount {
    int accountNumber;
    double withdrawalLimit;
    double accountBalance;

    public BasicAccount(int accountNumber, double withdrawalLimit) {
        this.accountBalance = 0;

        this.accountNumber = accountNumber;
        this.withdrawalLimit = withdrawalLimit;
    }

    public void Deposit(double amount) {
        this.accountBalance += amount;
    }

    public double GetCurrentBalance() {
        return this.accountBalance;
    }

    public int GetAccountNumber() {
        return this.accountNumber;
    }

    public double Withdraw(double amount) {
        if (this.accountBalance - amount < 0) {
            this.amountToWithdraw = this.accountBalance - amount;
            this.accountBalance = 0;
            return amountToWithdraw;
        }
        else if (amount > this.withdrawalLimit) {
            this.accountBalance -= this.withdrawalLimit;
            return this.withdrawalLimit;
        }
        else {
            this.accountBalance -= amount;
            return amount;
        }
    } 
}

public class PremiumAccount extends IAccount {
    int accountNumber;
    double accountBalance;

    public PremiumAccount(int accountNumber) {
        this.accountBalance = 0;
        this.accountNumber = accountNumber;
    }

    public void Deposit(double amount) {
        this.accountBalance += amount;
    }

    public double GetCurrentBalance() {
        return this.accountBalance;
    }

    public int GetAccountNumber() {
        return this.accountNumber;
    }

    public double Withdraw(double amount) {
        this.accountBalance -= amount;
        return amount;
    } 
}
