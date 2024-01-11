public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    public void withdraw(double amount) {
        try {
            if (amount > 0) {
                doWithdrawing(amount);
                this.addTransaction(new Transaction(2, amount,
                        this.balance + amount, this.balance));
            } else {
                System.out.println("Invalid withdrawal amount: " + amount);
            }
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    @Override
    public void deposit(double amount) {
        try {
            if (amount > 0) {
                doDepositing(amount);
                this.addTransaction(new Transaction(1, amount,
                        this.balance - amount, this.balance));
            } else {
                System.out.println("Invalid deposit amount: " + amount);
            }
        } catch (BankException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
