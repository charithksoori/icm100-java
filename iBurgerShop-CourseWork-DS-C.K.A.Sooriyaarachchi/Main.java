public class Main {
    //==================================================================================================================
    public static CustomerList custList = new CustomerList();
    public static OrderList orderList = new OrderList();


    //DataBase Area=====================================================================================================
    public static int orderID = 1001;
    final static double BURGERPRICE = 500;
    //Order status
    public static String CANCEL = "Cancelled";
    public static String PREPARING = "Prepairing";
    public static String DELIVERED = "Delivered";
    //DataBase Area=====================================================================================================

    public static void main(String[] args) {
        new MainWindow().setVisible(true);

    }
}