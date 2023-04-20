import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


class ViewAllCustomers extends JFrame {

    private JLabel titleLabel;
    private JButton homeButton;

    public ViewAllCustomers() {
        setSize(800, 600);
        setTitle("View All Customers");
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        Object[][] rowData = {};
        Object[] columnNames = {"Customer ID", "Name ID"};
        Double tot = 0.0;
        DefaultTableModel listTableModel;
        listTableModel = new DefaultTableModel(rowData, columnNames);


        for (int i = 0; i < Main.custList.size(); i++) {
            String rowString1 = Main.custList.viewCustomersID(i);
            String rowString2 = Main.custList.viewCustomersName(i);
            listTableModel.addRow(new Object[]{rowString1, rowString2});
        }


        JTable listTable;
        listTable = new JTable(listTableModel);
        listTable.setCellEditor(null);
        listTable.setBounds(50, 200, 500, 300);

        add(new JScrollPane(listTable));

        //----------------------------------------------------------------------

        JPanel toppanel = new JPanel();
        JPanel centerpanel = new JPanel();


        titleLabel = new JLabel("View All Customers");
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

