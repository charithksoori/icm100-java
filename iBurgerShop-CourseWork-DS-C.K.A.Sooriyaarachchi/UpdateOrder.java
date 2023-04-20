import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

class UpdateOrder extends JFrame {
    private JLabel titleLabel;
    private JButton updateButton;
    private JButton cancelButton;
    private JButton homeButton;


    private JLabel orderLabel;
    private JComboBox orderBox;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel totalLabel;
    private JLabel orderStatusLabel;
    private JTextField statusLabel;
    private JLabel b;


    private JLabel idText;
    private JLabel nameText;
    private JTextField quantityText;
    private JTextField totalText;
    private JComboBox orderStatusBox;

    public UpdateOrder() {
        setSize(800, 600);
        setTitle("Order  ");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Container container = getContentPane();

        titleLabel = new JLabel("Update Order");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBounds(320, 20, 500, 30);


        orderLabel = new JLabel("Order ID");
        orderLabel.setBounds(80, 100, 100, 30);
        orderLabel.setFont(new Font("", 1, 20));
        b = new JLabel("B");
        b.setBounds(240, 100, 100, 30);
        b.setFont(new Font("", 1, 20));


        orderBox = new JComboBox();
        orderBox.setBounds(260, 100, 200, 30);
        orderBox.setFont(new Font("", 1, 20));


        for (int i = 0; i < Main.orderList.size(); i++) {
            orderBox.addItem(Main.orderList.getOrderID(i));
        }


        idLabel = new JLabel("Customer ID");
        idLabel.setBounds(80, 150, 160, 30);
        idLabel.setFont(new Font("", 1, 20));
        idText = new JLabel();
        idText.setBounds(260, 150, 200, 30);
        idText.setFont(new Font("", 1, 20));

        nameLabel = new JLabel("Customer Name");
        nameLabel.setBounds(80, 200, 160, 30);
        nameLabel.setFont(new Font("", 1, 20));
        nameText = new JLabel();
        nameText.setBounds(260, 200, 200, 30);
        nameText.setFont(new Font("", 1, 20));


        quantityLabel = new JLabel("Burger Quantity");
        quantityLabel.setBounds(80, 250, 160, 30);
        quantityLabel.setFont(new Font("", 1, 20));
        quantityText = new JTextField();
        quantityText.setBounds(260, 250, 200, 30);
        quantityText.setFont(new Font("", 1, 20));


        totalLabel = new JLabel("Bill Value");
        totalLabel.setBounds(80, 300, 100, 30);
        totalLabel.setFont(new Font("", 1, 20));
        totalText = new JTextField();
        totalText.setBounds(260, 300, 200, 30);
        totalText.setFont(new Font("", 1, 20));


        orderStatusLabel = new JLabel("Order Status");
        orderStatusLabel.setBounds(80, 350, 160, 30);
        orderStatusLabel.setFont(new Font("", 1, 20));
        orderStatusBox = new JComboBox();
        orderStatusBox.setBounds(500, 350, 200, 30);
        orderStatusBox.setFont(new Font("", 1, 20));


        statusLabel = new JTextField();
        statusLabel.setBounds(260, 350, 200, 30);
        statusLabel.setFont(new Font("", 1, 20));


        orderStatusBox.addItem(Main.PREPARING);
        orderStatusBox.addItem(Main.DELIVERED);
        orderStatusBox.addItem(Main.CANCEL);


        updateButton = new JButton("Update Order");
        updateButton.setFont(new Font("", 1, 15));
        updateButton.setBounds(260, 450, 150, 30);
        updateButton.setBackground(new Color(255, 255, 255));

        cancelButton = new JButton("Cancel");
        cancelButton.setFont(new Font("", 1, 15));
        cancelButton.setBounds(420, 450, 100, 30);
        cancelButton.setForeground(new Color(255, 255, 255));
        cancelButton.setBackground(new Color(223, 46, 56));

        //------------------------------------------------------------------------------
        orderBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int indexID = Main.orderList.orderView(Integer.parseInt(String.valueOf(orderBox.getSelectedItem())));
                idText.setText(Main.orderList.viewCustomerID(indexID));
                nameText.setText(Main.orderList.viewCustomerName(indexID));
                quantityText.setText(String.valueOf(Main.orderList.viewBurgerQuantity(indexID)));
                totalText.setText(String.valueOf(Main.orderList.viewTotal(indexID)));
                statusLabel.setText(Main.orderList.viewOrderStatus(indexID));
            }
        });

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int indexID = Main.orderList.orderView(Integer.parseInt(String.valueOf(orderBox.getSelectedItem())));

                int burgerQuantity = Integer.parseInt(quantityText.getText());
                double total = 0.0;
                if (burgerQuantity > 0) {
                    total = burgerQuantity * Main.BURGERPRICE;
                    totalText.setText(String.valueOf(total));
                }

                if (Main.orderList.viewOrderDelivered(indexID) | Main.orderList.viewOrderCancel(indexID)) {
                    JOptionPane.showMessageDialog(rootPane, "Cannot update this order", "Warning", JOptionPane.WARNING_MESSAGE);
                } else {
                    Main.orderList.setTotalUpdate(indexID, Double.parseDouble(totalText.getText()));
                    Main.orderList.setStatusUpdate(indexID, String.valueOf(orderStatusBox.getSelectedItem()));
                    Main.orderList.setQuantityUpdate(indexID, Integer.parseInt(quantityText.getText()));
                    statusLabel.setText(Main.orderList.viewOrderStatus(indexID));

                    JOptionPane.showMessageDialog(rootPane, "Order updated successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });


        homeButton = new

                JButton("Back to HomePage");
        homeButton.setFont(new

                Font("", 1, 15));
        homeButton.setBounds(260, 495, 260, 30);
        homeButton.setForeground(new

                Color(255, 255, 255));
        homeButton.setBackground(new

                Color(32, 82, 149));

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new MainWindow().setVisible(true);
            }
        });

        container.setBackground(new Color(233, 232, 232));
        container.add(titleLabel);
        container.add(orderLabel);
        container.add(b);
        container.add(orderBox);
        container.add(idLabel);
        container.add(idText);
        container.add(nameLabel);
        container.add(nameText);
        container.add(quantityText);
        container.add(quantityLabel);
        container.add(totalLabel);
        container.add(totalText);
        container.add(orderStatusLabel);
        container.add(orderStatusBox);

        container.add(statusLabel);
        container.add(updateButton);
        container.add(cancelButton);
        container.add(homeButton);


    }
}

