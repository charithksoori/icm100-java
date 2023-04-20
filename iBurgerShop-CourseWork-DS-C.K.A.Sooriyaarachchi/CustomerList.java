public class CustomerList {
    private Customer[] customerArray;
    private int nextIndex;


    CustomerList() {
        customerArray = new Customer[100];
        nextIndex = 0;
    }


    public void add(Customer customer) {
        customerArray[nextIndex++] = customer;
    }


    public Customer[] getCustomerArray() {
        return customerArray;
    }

    public void setCustomerArray(Customer[] customerArray) {
        this.customerArray = customerArray;
    }


    public int size() {
        return nextIndex;
    }


    public boolean contains(String customerID) {
        for (int i = 0; i < nextIndex; i++) {
            if (customerArray[i].equals(customerID)) {
                return true;
            }
        }
        return false;
    }


    public String searchCustomer(String customerID) {
        for (int i = 0; i < size(); i++) {
            if (customerArray[i].equals(customerID)) {
                return customerArray[i].getCustomerName();
            }
        }
        return "Not found";
    }


    public String getIndex(int index) {
        return customerArray[index].getCustomerName();
    }

    //----------------------------------------------------------------
    public void printCustomers() {
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++) {
            Customer c1 = customerArray[i];
            System.out.print(c1.toString() + ", ");
        }
        System.out.println(nextIndex <= 0 ? "empty]" : "\b\b]");
    }

    public String viewCustomersID(int index) {
        return customerArray[index].getCustomerID();
    }

    public String viewCustomersName(int index) {
        return customerArray[index].getCustomerName();
    }



}