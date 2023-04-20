public class Order {
    private int orderIDNum;
    private String customerID;
    private String customerName;
    private int burgerQuantity;
    private double total;
    private String orderStatus;

    public Order(int orderIDNum, String customerID, String customerName, int burgerQuantity, double total, String orderStatus) {
        this.orderIDNum = orderIDNum;
        this.customerID = customerID;
        this.customerName = customerName;
        this.burgerQuantity = burgerQuantity;
        this.total = total;
        this.orderStatus = orderStatus;
    }

    public Order() {
    }

    public boolean equalsID(int order) {
        return order==(this.orderIDNum);
    }


    public String toString() {
        return orderIDNum + "-" + customerID + "-" + customerName + "-" + burgerQuantity + "-" + total + "-" + orderStatus;
    }

    public boolean equalsOrder(int orderNumber) {
        if (this.getOrderIDNum() == orderNumber) {
            return true;
        }
        return false;
    }

    public boolean equalsCustomer(String customerIDSearch) {
        return customerIDSearch.equalsIgnoreCase(this.customerID);
    }

    public boolean equalsStatusCancel(String CANCEL) {
        return CANCEL.equalsIgnoreCase(this.orderStatus);
    }

    public boolean equalsStatusDelivered(String DELIVERED) {
        return DELIVERED.equalsIgnoreCase(this.orderStatus);
    }

    public boolean equalsStatusPreparing(String PREPARING) {
        return PREPARING.equalsIgnoreCase(this.orderStatus);
    }

    public boolean equalsUpdate(int orderNum) {
        if (this.getOrderIDNum() == orderNum) {
            return true;
        }
        return false;
    }

    //-----------------------------------------------------------------

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerIDNum) {
        this.customerID = customerIDNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerPlaceName) {
        this.customerName = customerPlaceName;
    }

    public int getBurgerQuantity() {
        return burgerQuantity;
    }

    public void setBurgerQuantity(int burgerQuantity) {
        this.burgerQuantity = burgerQuantity;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getOrderIDNum() {
        return orderIDNum;
    }

    public void setOrderIDNum(int orderIDNum) {
        this.orderIDNum = orderIDNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}