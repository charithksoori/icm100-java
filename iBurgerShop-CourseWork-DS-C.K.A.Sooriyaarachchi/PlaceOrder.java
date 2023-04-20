import javax.sound.sampled.Line;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlaceOrder extends JFrame {


    //Customer customer = new Customer();

    //Order order = new Order();


    //=================================================================
    private JLabel titlePlace = new JLabel();
    private JButton placeOrderButton;
    private JButton exitButton;
    private JButton homeButton;
    private JLabel orderIDLabel;
    private JLabel idLabel;
    private JLabel nameLabel;
    private JLabel quantityLabel;
    private JLabel totalLabel;
    private JTextField idText;
    private JLabel nameText;
    private JLabel orderIDText;

    private JTextField quantityText;
    private JLabel totalText;

    public PlaceOrder() {
        setSize(600, 600);
        setTitle("Place Order");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Container container = getContentPane();

        titlePlace = new JLabel("Place Order");
        titlePlace.setFont(new Font("", 1, 30));
        titlePlace.setBounds(160, 20, 500, 30);

        orderIDLabel = new JLabel("Order ID - B");
        orderIDLabel.setFont(new Font("", 1, 20));
        orderIDLabel.setBounds(80, 100, 120, 30);
        orderIDText = new JLabel();
        orderIDText.setBounds(195, 100, 200, 30);
        orderIDText.setFont(new Font("", 1, 20));


        idLabel = new JLabel("ID");
        idLabel.setBounds(80, 150, 160, 30);
        idLabel.setFont(new Font("", 1, 20));
        idText = new JTextField(10);
        idText.setBounds(260, 150, 200, 30);
        idText.setFont(new Font("", 1, 20));

        nameLabel = new JLabel("Customer Name");
        nameLabel.setBounds(80, 200, 160, 30);
        nameLabel.setFont(new Font("", 1, 20));
        nameText = new JLabel();
        nameText.setBounds(260, 200, 200, 30);
        nameText.setFont(new Font("", 1, 20));

        JPanel line = new JPanel();
        line.setBounds(20, 250, 540, 1);
        line.setBackground(new Color(60, 64, 72));


        quantityLabel = new JLabel("Burger Quantity");
        quantityLabel.setBounds(80, 280, 160, 30);
        quantityLabel.setFont(new Font("", 1, 20));
        quantityText = new JTextField();
        quantityText.setBounds(260, 280, 200, 30);
        quantityText.setFont(new Font("", 1, 20));

        totalLabel = new JLabel("Bill Value");
        totalLabel.setBounds(80, 330, 100, 30);
        totalLabel.setFont(new Font("", 1, 20));
        totalText = new JLabel();
        totalText.setBounds(260, 330, 200, 30);
        totalText.setFont(new Font("", 1, 20));

        //-------- Order ID ------------------------------------------------------------
        orderIDText.setText(String.valueOf(Main.orderID));

        idText.addActionListener(new ActionListener() {
            String customerIDNum = "";

            public void actionPerformed(ActionEvent evt) {
                customerIDNum = idText.getText();
                char ch = customerIDNum.charAt(0);
                int count = customerIDNum.length();

                if (ch != '0' || count != 10) {
                    JOptionPane.showMessageDialog(rootPane, "Customer ID is not correct format", "Warning", JOptionPane.WARNING_MESSAGE);
                    idText.setText(null);
                    nameText.setText(null);
                    quantityText.setText(null);
                    totalText.setText(null);
                    return;
                }

                for (int i = 0; i < Main.custList.size(); i++) {
                    if (Main.custList.contains(customerIDNum)) {
                        nameText.setText(Main.custList.searchCustomer(customerIDNum));
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Customer is not registered", "Warning", JOptionPane.WARNING_MESSAGE);
                        idText.setText(null);
                        return;
                    }
                }
            }
        });


        //=========================================================================================================
        quantityText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                int burgerQuantity = Integer.parseInt(quantityText.getText());
                double total = 0.0;
                if (burgerQuantity > 0) {
                    total = burgerQuantity * Main.BURGERPRICE;
                    totalText.setText(String.valueOf(total));

                }
            }
        });

        //------------------------------------------------------------------------------

        placeOrderButton = new JButton("Place Order");
        placeOrderButton.setFont(new Font("", 1, 15));
        placeOrderButton.setBounds(260, 450, 150, 30);
        placeOrderButton.setBackground(new Color(255, 255, 255));
        placeOrderButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String customerIDNum = idText.getText();
                String customerPlaceName = nameText.getText();

                Double total = Double.valueOf(totalText.getText());

                Main.orderList.add(new Order(Main.orderID, customerIDNum, customerPlaceName, Integer.parseInt(quantityText.getText()), total, Main.PREPARING));

                JOptionPane.showMessageDialog(rootPane, "Your order is enter to the system successfully", "Info", JOptionPane.INFORMATION_MESSAGE);

                idText.setText(null);
                nameText.setText(null);
                quantityText.setText(null);
                totalText.setText(null);
                orderIDText.setText(null);
                int orderNum = Main.orderID += 1;
                orderIDText.setText(String.valueOf(orderNum));
            }

        });

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("", 1, 15));
        exitButton.setBounds(420, 450, 100, 30);
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setBackground(new Color(223, 46, 56));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });

        homeButton = new JButton("Back to HomePage");
        homeButton.setFont(new Font("", 1, 15));
        homeButton.setBounds(260, 495, 260, 30);
        homeButton.setForeground(new Color(255, 255, 255));
        homeButton.setBackground(new Color(32, 82, 149));

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new MainWindow().setVisible(true);
            }
        });

        container.setBackground(new Color(233, 232, 232));
        container.add(idLabel);
        container.add(idText);
        container.add(titlePlace);
        container.add(orderIDLabel);
        container.add(orderIDText);
        container.add(nameLabel);
        container.add(nameText);
        container.add(quantityText);
        container.add(quantityLabel);
        container.add(totalLabel);
        container.add(totalText);
        container.add(placeOrderButton);
        container.add(exitButton);
        container.add(homeButton);
        container.add(line);
    }
}
