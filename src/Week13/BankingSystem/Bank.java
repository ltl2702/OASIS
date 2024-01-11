import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<Customer> customerList = new ArrayList<Customer>();

    /**
     * read Customer List.
     */
    public void readCustomerList(InputStream inputStream) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            Customer curCustomer = null;

            while ((line = reader.readLine()) != null) {
                if (Character.isAlphabetic(line.charAt(0))) {
                    String[] tokens = line.split("\\s+(?=\\d)");
                    if (curCustomer != null) {
                        customerList.add(curCustomer);
                    }
                    long idNumber = Long.parseLong(tokens.length > 1 ? tokens[1] : "0");
                    String fullName = tokens.length > 0 ? tokens[0] : "";
                    curCustomer = new Customer(idNumber, fullName);
                } else if (Character.isDigit(line.charAt(0)) && curCustomer != null) {
                    String[] tokens = line.split("\\s+");
                    if (tokens.length >= 3) {
                        long accountNumber = Long.parseLong(tokens[0]);
                        String accountType = tokens[1];
                        double balance = Double.parseDouble(tokens[2]);
                        if (accountType.equals(Account.CHECKING)) {
                            curCustomer.addAccount(new CheckingAccount(accountNumber, balance));
                        } else if (accountType.equals(Account.SAVINGS)) {
                            curCustomer.addAccount(new SavingsAccount(accountNumber, balance));
                        }
                    }
                }
            }

            if (curCustomer != null) {
                customerList.add(curCustomer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * get Customers Info By Id Order.
     */
    public String getCustomersInfoByIdOrder() {
        List<Customer> sortedCustomers = new ArrayList<>(this.customerList);
        sortedCustomers.sort(Comparator.comparingLong(Customer::getIdNumber));

        StringBuilder result = new StringBuilder();
        for (Customer customer : sortedCustomers) {
            result.append(customer.getCustomerInfo()).append(".").append(System.lineSeparator());
        }

        return result.toString();
    }

    /**
     * get Customers Info By Name Order.
     */
    public String getCustomersInfoByNameOrder() {
        List<Customer> sortedCustomers = new ArrayList<>(this.customerList);
        sortedCustomers.sort(Comparator.comparing(Customer::getFullName));

        StringBuilder result = new StringBuilder();
        for (Customer customer : sortedCustomers) {
            result.append(customer.getCustomerInfo()).append(".").append(System.lineSeparator());
        }

        return result.toString();
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
