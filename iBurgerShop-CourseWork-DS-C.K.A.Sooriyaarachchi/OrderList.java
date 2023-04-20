public class OrderList {
    private Order[] orderArray;
    private int nextIndex;

    public OrderList() {
        orderArray = new Order[100];
        nextIndex = 0;
    }

    public void add(Order order) {
        orderArray[nextIndex++] = order;

    }


    public int size() {
        return nextIndex;
    }


    public Order[] getOrderArray() {
        return orderArray;
    }

    public void setOrderArray(Order[] orderArray) {
        this.orderArray = orderArray;
    }


    public int getOrderID(int index) {
        return orderArray[index].getOrderIDNum();
    }

    //=======================================================
    public int viewOrderID(int index) {
        return orderArray[index].getOrderIDNum();
    }

    public String viewCustomerID(int index) {
        return orderArray[index].getCustomerID();
    }

    public String viewCustomerName(int index) {
        return orderArray[index].getCustomerName();
    }

    public int viewBurgerQuantity(int index) {
        return orderArray[index].getBurgerQuantity();
    }

    public double viewTotal(int index) {
        return orderArray[index].getTotal();
    }

    public String viewOrderStatus(int index) {
        return orderArray[index].getOrderStatus();
    }


    //==================================
    public void printOrders() {
        System.out.print("[");
        for (int i = 0; i < nextIndex; i++) {
            Order o1 = orderArray[i];
            System.out.print(o1.toString() + ", ");
        }
        System.out.println(nextIndex <= 0 ? "empty]" : "\b\b]");
    }


    public int orderView(int orderID) {
        for (int i = 0; i < size(); i++) {
            if (orderArray[i].equalsID(orderID)) {
                return i;
            }
        }
        return -1;
    }


    public boolean searchOrderID(int ordeID) {
        for (int i = 0; i < size(); i++) {
            if (orderArray[i].equals(ordeID)) {
                return true;
            }
        }
        return false;
    }


    public boolean viewOrderDelivered(int order) {
        if (orderArray[order].equalsStatusDelivered(Main.DELIVERED)) {
            return true;
        }
        return false;
    }

    public boolean viewOrderCancel(int order) {
        if (orderArray[order].equalsStatusCancel(Main.CANCEL)) {
            return true;
        }
        return false;
    }

    public void setQuantityUpdate(int order, int quantity) {
        orderArray[order].setBurgerQuantity(quantity);
    }

    public void setTotalUpdate(int order, double total) {
        orderArray[order].setTotal(total);
    }

    public void setStatusUpdate(int order, String status) {
        orderArray[order].setOrderStatus(status);
    }

}
