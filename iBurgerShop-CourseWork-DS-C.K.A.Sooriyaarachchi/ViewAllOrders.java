import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class ViewAllOrders extends JFrame {

    private JLabel titleLabel;
    private JButton homeButton;

    public ViewAllOrders() {
        setSize(800, 600);
        setTitle("View All Orders");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Object[][] rowData = {};
        Object[] columnNames = {"Order ID", "Customer ID", "Quantity", "Order Status"};

        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);
        for (int i = 0; i < Main.orderList.size(); i++) {
            String rowString1 = "B"+Main.orderList.viewOrderID(i);
            String rowString2 = Main.orderList.viewCustomerID(i);
            String rowString3 = String.valueOf(Main.orderList.viewBurgerQuantity(i));
            String rowString4 = Main.orderList.viewOrderStatus(i);
            listTableModel.addRow(new Object[]{rowString1, rowString2, rowString3, rowString4});
        }

        JTable listTable;
        listTable = new JTable(listTableModel);
        listTable.setCellEditor(null);
        listTable.setBounds(50, 200, 500, 300);

        add(new JScrollPane(listTable));

        //----------------------------------------------------------------------

        JPanel toppanel = new JPanel();
        JPanel centerpanel = new JPanel();


        titleLabel = new JLabel("View All Orders");
        titleLabel.setFont(new Font("", 1, 30));
        titleLabel.setBounds(150, 20, 500, 30);


        homeButton = new JButton("Back to HomePage");
        homeButton.setFont(new Font("", 1, 15));
        homeButton.setBounds(460, 500, 260, 30);
        homeButton.setForeground(new Color(255, 255, 255));
        homeButton.setBackground(new Color(32, 82, 149));

        homeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
                new MainWindow().setVisible(true);
            }
        });

        toppanel.add(titleLabel);
        centerpanel.add(homeButton);

        add("South", centerpanel);
        add("North", toppanel);

    }
}

