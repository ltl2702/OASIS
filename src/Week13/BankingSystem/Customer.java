import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName;
    private List<Account> accountList = new ArrayList<>();

    public Customer() {}

    public Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public String getCustomerInfo() {
        return "Số CMND: " + idNumber + ". Họ tên: " + fullName;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    /**
     * remove Account.
     */
    public void removeAccount(Account account) {
        Iterator<Account> iterator = accountList.iterator();
        while (iterator.hasNext()) {
            Account acc = iterator.next();
            if (acc.getAccountNumber() == account.getAccountNumber()) {
                iterator.remove();
                return;
            }
        }
    }


    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
}
