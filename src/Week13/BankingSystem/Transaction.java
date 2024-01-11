public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 1;
    public static final int TYPE_WITHDRAW_CHECKING = 2;
    public static final int TYPE_DEPOSIT_SAVINGS = 3;
    public static final int TYPE_WITHDRAW_SAVINGS = 4;

    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * constructor.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * get Transaction Summary.
     */
    public String getTransactionSummary() {
        return "- Kiểu giao dịch: " + getTransactionTypeString(type)
                + ". Số dư ban đầu: $" + String.format("%.2f", initialBalance)
                + ". Số tiền: $" + String.format("%.2f", amount)
                + ". Số dư cuối: $" + String.format("%.2f", finalBalance) + ".";
    }

    /**
     * get Transaction Type.
     */
    private String getTransactionTypeString(int type) {
        switch (type) {
            case 1:
                return "Nạp tiền vãng lai";
            case 2:
                return "Rút tiền vãng lai";
            case 3:
                return "Nạp tiền tiết kiệm";
            case 4:
                return "Rút tiền tiết kiệm";
            default:
                return "Unknown";
        }
    }
}
