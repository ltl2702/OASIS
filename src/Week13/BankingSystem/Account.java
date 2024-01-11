import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<>();

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    /**
     * Do Withdrawing.
     */
    public void doWithdrawing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else if (balance < amount) {
            throw new InsufficientFundsException(amount);
        } else if (this instanceof SavingsAccount && amount > 1000.0) {
            throw new InsufficientFundsException(amount);
        } else if (this instanceof SavingsAccount && this.getBalance() - amount < 5000.0) {
            throw new InsufficientFundsException(amount);
        } else {
            balance -= amount;
        }
    }

    /**
     * Do Depositing.
     */
    public void doDepositing(double amount) throws BankException {
        if (amount < 0) {
            throw new InvalidFundingAmountException(amount);
        } else {
            balance += amount;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    /**
     * get Transaction History.
     */
    public String getTransactionHistory() {
        StringBuilder history = new StringBuilder("Lịch sử giao dịch của tài khoản "
                + getAccountNumber() + ":\n");

        for (Transaction transaction : transactionList) {
            history.append(transaction.getTransactionSummary()).append("\n");
        }

        return history.toString();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Account that = (Account) o;
        return Objects.equals(this.getAccountNumber(), that.getAccountNumber());
    }

}
