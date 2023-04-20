import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class ViewOrder extends JFrame {
    private JLabel mainHeading;
    private JButton viewAllOrdersButton;
    private JButton viewAllCustomersButton;
    private JButton orderViewButton;
    private JButton cancelButton;
    private ViewAllOrders viewAllOrdersForm;
    private ViewAllCustomers viewAllCustomersForm;
    private OrderView orderViewForm;


    public ViewOrder() {
        setSize(600, 500);
        setTitle("iBurgerShop Management System");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);


        JPanel headingPanel = new JPanel();

        mainHeading = new JLabel("View Orders");
        mainHeading.setFont(new Font("MV Boli", 1, 45));


        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(203, 228, 222));
        JPanel centerPanel = new JPanel(new GridLayout(4, 1, 20, 20));
        centerPanel.setBounds(100, 45, 400, 300);
        centerPanel.setBackground(new Color(203, 228, 222));

        viewAllOrdersForm = new ViewAllOrders();

        viewAllOrdersButton = new JButton();
        viewAllOrdersButton.setText("View All Orders");
        viewAllOrdersButton.setFocusable(false);
        viewAllOrdersButton.setFont(new Font("", 1, 25));
        viewAllOrdersButton.setBackground(new Color(44, 51, 51));
        viewAllOrdersButton.setForeground(new Color(255, 255, 255));
        viewAllOrdersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                viewAllOrdersForm.setVisible(true);
            }
        });


        viewAllCustomersForm = new ViewAllCustomers();

        viewAllCustomersButton = new JButton();
        viewAllCustomersButton.setText("View All Customers");
        viewAllCustomersButton.setFocusable(false);
        viewAllCustomersButton.setFont(new Font("", 1, 25));
        viewAllCustomersButton.setBackground(new Color(44, 51, 51));
        viewAllCustomersButton.setForeground(new Color(255, 255, 255));
        viewAllCustomersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                viewAllCustomersForm.setVisible(true);
            }
        });

        orderViewForm = new OrderView();
        orderViewButton = new JButton();
        orderViewButton.setText("View Orders");
        orderViewButton.setFocusable(false);
        orderViewButton.setFont(new Font("", 1, 25));
        orderViewButton.setBackground(new Color(44, 51, 51));
        orderViewButton.setForeground(new Color(255, 255, 255));
        orderViewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                orderViewForm.setVisible(true);
            }
        });





        centerPanel.add(viewAllOrdersButton);
        centerPanel.add(viewAllCustomersButton);
        centerPanel.add(orderViewButton);


        headingPanel.add(mainHeading);
        mainPanel.add(centerPanel);

        add("North", headingPanel);
        add("Center", mainPanel);


    }
}
