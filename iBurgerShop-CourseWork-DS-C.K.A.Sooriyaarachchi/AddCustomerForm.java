import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


class AddCustomerForm extends JFrame {
    private JLabel titleLabel;
    private JButton addButton;
    private JButton exitButton;
    private JButton homeButton;

    private JLabel idLabel;
    private JLabel nameLabel;

    private JTextField idText;
    private JTextField nameText;

    public AddCustomerForm() {
        setSize(500, 450);
        setTitle("Add Customer Form ");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        Container container = getContentPane();

        titleLabel = new JLabel("Add Customer Form");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBounds(100, 50, 500, 30);

        idLabel = new JLabel("ID");
        idLabel.setBounds(100, 150, 100, 30);
        idLabel.setFont(new Font("", 1, 20));
        idText = new JTextField(10);
        idText.setBounds(180, 150, 200, 30);
        idText.setFont(new Font("", 1, 20));

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(100, 200, 100, 30);
        nameLabel.setFont(new Font("", 1, 20));
        nameText = new JTextField();
        nameText.setBounds(180, 200, 200, 30);
        nameText.setFont(new Font("", 1, 20));

        addButton = new JButton("Add Customer");
        addButton.setFont(new Font("", 1, 15));
        addButton.setBounds(200, 300, 150, 30);
        addButton.setBackground(new Color(255, 255, 255));

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {

                String customerID="";
                String customerName="";
                if(idText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Please fill the all fields", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }else if(nameText.getText().isEmpty()){
                    JOptionPane.showMessageDialog(rootPane, "Please fill the all fields", "Warning", JOptionPane.WARNING_MESSAGE);
                    return;
                }else {
                    customerID = idText.getText();
                    customerName = nameText.getText();
                }
                char ch = customerID.charAt(0);
                int count = customerID.length();

                if (ch != '0') {
                    JOptionPane.showMessageDialog(rootPane, "Customer ID is not correct format", "Warning", JOptionPane.WARNING_MESSAGE);
                    idText.setText(null);
                    nameText.setText(null);
                    return;
                }

                if (count != 10) {
                    JOptionPane.showMessageDialog(rootPane, "Customer ID is not correct format", "Warning", JOptionPane.WARNING_MESSAGE);
                    idText.setText(null);
                    nameText.setText(null);
                    return;
                }

                for (int i = 0; i < Main.custList.size(); i++) {
                    if (Main.custList.contains(customerID)){
                        JOptionPane.showMessageDialog(rootPane, "This Customer already exists. Enter the correct Customer ID again", "Warning", JOptionPane.WARNING_MESSAGE);
                        idText.setText(null);
                        nameText.setText(null);
                        return;
                    }
                }


                Main.custList.add(new Customer(customerID, customerName));


                JOptionPane.showMessageDialog(rootPane, "Customer has been added successfully", "Info", JOptionPane.INFORMATION_MESSAGE);
                idText.setText(null);
                nameText.setText(null);
            }
        });

        exitButton = new JButton("Exit");
        exitButton.setFont(new Font("", 1, 15));
        exitButton.setBounds(360, 300, 100, 30);
        exitButton.setForeground(new Color(255, 255, 255));
        exitButton.setBackground(new Color(223, 46, 56));
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                System.exit(0);
            }
        });


        homeButton = new JButton("Back to HomePage");
        homeButton.setFont(new Font("", 1, 15));
        homeButton.setBounds(200, 345, 260, 30);
        homeButton.setForeground(new Color(255, 255, 255));
        homeButton.setBackground(new Color(32, 82, 149));

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new MainWindow().setVisible(true);
            }
        });

        container.setBackground(new Color(233, 232, 232));
        container.add(titleLabel);
        container.add(idLabel);
        container.add(idText);
        container.add(nameLabel);
        container.add(nameText);
        container.add(addButton);
        container.add(exitButton);
        container.add(homeButton);


    }
}

