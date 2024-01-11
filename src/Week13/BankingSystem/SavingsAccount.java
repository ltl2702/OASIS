public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * withdraw.
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            try {
                doWithdrawing(amount);
                this.addTransaction(new Transaction(4,
                        amount, this.balance + amount, this.balance));
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid withdrawal amount: " + amount);
        }
    }

    /**
     * deposit.
     */
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            try {
                doDepositing(amount);
                this.addTransaction(new Transaction(3,
                        amount, this.balance - amount, this.balance));
            } catch (BankException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Invalid deposit amount: " + amount);
        }
    }


}
