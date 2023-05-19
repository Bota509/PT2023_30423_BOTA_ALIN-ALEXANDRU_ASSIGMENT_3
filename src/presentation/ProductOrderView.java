package presentation;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductOrderView extends JFrame {


    private JPanel contentPane;
    private JTextField quantityTextField;
    private JTable table;
    private JScrollPane scrollPane;

    private JTable clientTable;
    private JScrollPane clientScrollPane;

    private JTable productTable;
    private JScrollPane productScrollPane;

    private JTable billTable;
    private JScrollPane billScrollPane;


    private JComboBox clientListComboBox;

    private JComboBox productListComboBox;
    private JButton makeOrderButton;

    public ProductOrderView()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 1283, 732);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelOrderProducts = new JLabel("Order Products");
        labelOrderProducts.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 36));
        labelOrderProducts.setBounds(530, 10, 300, 38);
        contentPane.add(labelOrderProducts);

        quantityTextField = new JTextField();
        quantityTextField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        quantityTextField.setBounds(225, 52, 183, 40);
        contentPane.add(quantityTextField);
        quantityTextField.setColumns(10);

       JLabel quantityButton = new JLabel("Select Quantity");
        quantityButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        quantityButton.setBounds(20, 51, 300, 40);
        contentPane.add(quantityButton);

        JLabel clientsLabel = new JLabel("Clients List");
        clientsLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        clientsLabel.setBounds(220, 120, 141, 52);
        contentPane.add(clientsLabel);

        JLabel productListLabel = new JLabel("Products List");
        productListLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        productListLabel.setBounds(740, 120, 165, 52);
        contentPane.add(productListLabel);


        //product order scroll pane

        JLabel ordersLabel = new JLabel("Orders List");
        ordersLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        ordersLabel.setBounds(160, 240, 165, 52);
        contentPane.add(ordersLabel);

        scrollPane = new JScrollPane();
        scrollPane.setBounds(100, 298, 250, 250);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);


        //client order scroll pane
        JLabel clientLabel = new JLabel("Clients List");
        clientLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        clientLabel.setBounds(440, 240, 165, 52);
        contentPane.add(clientLabel);


        clientScrollPane = new JScrollPane();
        clientScrollPane.setBounds(380, 298, 250, 250);
        contentPane.add(clientScrollPane);

        clientTable = new JTable();
        clientScrollPane.setViewportView(clientTable);

        //product order scroll pane
        JLabel productLabel = new JLabel("Products List");
        productLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        productLabel.setBounds(710, 240, 165, 52);
        contentPane.add(productLabel);


        productScrollPane = new JScrollPane();
        productScrollPane.setBounds(650, 298, 250, 250);
        contentPane.add(productScrollPane);

        productTable = new JTable();
        productScrollPane.setViewportView(productTable);





        JLabel billLabel = new JLabel("Bill List");
        billLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        billLabel.setBounds(1010, 240, 165, 52);
        contentPane.add(billLabel);


        billScrollPane = new JScrollPane();
        billScrollPane.setBounds(950, 298, 250, 250);
        contentPane.add(billScrollPane);

        billTable = new JTable();
        billScrollPane.setViewportView(billTable);







        clientListComboBox = new JComboBox();
        clientListComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        clientListComboBox.setBounds(384, 139, 183, 21);
        contentPane.add(clientListComboBox);

        productListComboBox = new JComboBox();
        productListComboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        productListComboBox.setBounds(951, 139, 177, 21);
        contentPane.add(productListComboBox);

        makeOrderButton = new JButton("Make Order");
        makeOrderButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
        makeOrderButton.setBounds(1021, 585, 190, 65);
        contentPane.add(makeOrderButton);


        this.setVisible(false);
    }

    public void display()
    {
        this.setVisible(true);
    }



    public int getQuantityTextField() {
        return Integer.parseInt(quantityTextField.getText());
    }

    public void setQuantityTextField(String quantityTextField) {
        this.quantityTextField.setText(quantityTextField);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }


    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }

    public JComboBox getClientListComboBox() {
        return clientListComboBox;
    }

    public void setClientListComboBox(JComboBox clientListComboBox) {
        this.clientListComboBox = clientListComboBox;
    }

    public JComboBox getProductListComboBox() {
        return productListComboBox;
    }

    public void setProductListComboBox(JComboBox productListComboBox) {
        this.productListComboBox = productListComboBox;
    }

    public JButton getMakeOrderButton() {
        return makeOrderButton;
    }

    public void setMakeOrderButton(JButton makeOrderButton) {
        this.makeOrderButton = makeOrderButton;
    }
    public void makeOrderActionListener(ActionListener actionListener)
    {
        this.makeOrderButton.addActionListener(actionListener);
    }



    public void setQuantityTextField(JTextField quantityTextField) {
        this.quantityTextField = quantityTextField;
    }

    public JTable getClientTable() {
        return clientTable;
    }

    public void setClientTable(JTable clientTable) {
        this.clientTable = clientTable;
    }

    public JScrollPane getClientScrollPane() {
        return clientScrollPane;
    }

    public void setClientScrollPane(JScrollPane clientScrollPane) {
        this.clientScrollPane = clientScrollPane;
    }

    public JTable getProductTable() {
        return productTable;
    }

    public void setProductTable(JTable productTable) {
        this.productTable = productTable;
    }

    public JScrollPane getProductScrollPane() {
        return productScrollPane;
    }

    public void setProductScrollPane(JScrollPane productScrollPane) {
        this.productScrollPane = productScrollPane;
    }

    public JTable getBillTable() {
        return billTable;
    }

    public void setBillTable(JTable billTable) {
        this.billTable = billTable;
    }

    public JScrollPane getBillScrollPane() {
        return billScrollPane;
    }

    public void setBillScrollPane(JScrollPane billScrollPane) {
        this.billScrollPane = billScrollPane;
    }
}
