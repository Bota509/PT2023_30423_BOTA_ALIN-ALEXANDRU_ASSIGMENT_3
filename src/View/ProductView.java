package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProductView extends JFrame {


    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField priceTextField;
    private JTextField categoryTextField;
    private JTextField descriptionTextField;
    private JTable table;
    private JButton addNewProductButton;
    private JButton editProductButton;
    private JButton deleteProductButton;
    private JButton showProductsButton;
    private JScrollPane productsTable;

    
    public  ProductView()
    {
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(100, 100, 1368, 761);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelClient = new JLabel("Products");
        labelClient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        labelClient.setBounds(533, 33, 133, 38);
        contentPane.add(labelClient);

        addNewProductButton = new JButton("Add New Product");
        addNewProductButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        addNewProductButton.setBounds(158, 85, 314, 50);
        contentPane.add(addNewProductButton);

        editProductButton = new JButton("Edit Product");
        editProductButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        editProductButton.setBounds(158, 171, 314, 50);
        contentPane.add(editProductButton);

        deleteProductButton = new JButton("Delete Product");
        deleteProductButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        deleteProductButton.setBounds(158, 247, 314, 50);
        contentPane.add(deleteProductButton);

        idTextField = new JTextField();
        idTextField.setBounds(288, 405, 184, 43);
        contentPane.add(idTextField);
        idTextField.setColumns(10);

        showProductsButton = new JButton("Show Products");
        showProductsButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        showProductsButton.setBounds(158, 333, 314, 50);
        contentPane.add(showProductsButton);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(288, 470, 184, 43);
        contentPane.add(nameTextField);

        priceTextField = new JTextField();
        priceTextField.setColumns(10);
        priceTextField.setBounds(288, 538, 184, 43);
        contentPane.add(priceTextField);

        categoryTextField = new JTextField();
        categoryTextField.setColumns(10);
        categoryTextField.setBounds(288, 602, 184, 43);
        contentPane.add(categoryTextField);

        descriptionTextField = new JTextField();
        descriptionTextField.setColumns(10);
        descriptionTextField.setBounds(288, 671, 184, 43);
        contentPane.add(descriptionTextField);

        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        idLabel.setBounds(158, 405, 120, 43);
        contentPane.add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nameLabel.setBounds(158, 470, 120, 43);
        contentPane.add(nameLabel);

        JLabel priceLabel = new JLabel("Price");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        priceLabel.setBounds(158, 538, 120, 43);
        contentPane.add(priceLabel);

        JLabel categoryLabel = new JLabel("Category");
        categoryLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        categoryLabel.setBounds(158, 602, 120, 43);
        contentPane.add(categoryLabel);

        JLabel descriptionLabel = new JLabel("Description");
        descriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        descriptionLabel.setBounds(158, 671, 120, 43);
        contentPane.add(descriptionLabel);

        productsTable = new JScrollPane();
        productsTable.setBounds(665, 81, 643, 633);
        contentPane.add(productsTable);

        table = new JTable();
        productsTable.setViewportView(table);

        this.setVisible(false);
    }



    public int getIdTextField() {
        return Integer.parseInt(idTextField.getText());
    }

    public void setIdTextField(String idTextField) {
        this.idTextField.setText(idTextField);
    }

    public String getNameTextField() {
        return nameTextField.getText();
    }

    public void setNameTextField(String nameTextField) {
        this.nameTextField.setText(nameTextField);
    }

    public int getPriceTextField() {
        return Integer.parseInt(priceTextField.getText());
    }

    public void setPriceTextField(String  priceTextField) {
        this.priceTextField.setText(priceTextField);
    }

    public String getCategoryTextField() {
        return categoryTextField.getText();
    }

    public void setCategoryTextField(String categoryTextField) {
        this.categoryTextField.setText(categoryTextField);
    }

    public String getDescriptionTextField() {
        return descriptionTextField.getText();
    }

    public void setDescriptionTextField(String descriptionTextField) {
        this.descriptionTextField.setText(descriptionTextField);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
    public void display()
    {
        this.setVisible(true);
    }
    public void addProductActionListener(ActionListener actionListener)
    {
        this.addNewProductButton.addActionListener(actionListener);
    }
    public void editProductActionListener(ActionListener actionListener)
    {
        this.editProductButton.addActionListener(actionListener);
    }
    public void deleteProductActionListener(ActionListener actionListener)
    {
        this.deleteProductButton.addActionListener(actionListener);
    }
    public void showProductsActionListener(ActionListener actionListener)
    {
        this.showProductsButton.addActionListener(actionListener);
    }
}
