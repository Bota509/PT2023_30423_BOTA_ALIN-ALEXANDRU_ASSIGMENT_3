package View;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ClientView extends JFrame{

    private JPanel contentPane;
    private JTextField idTextField;
    private JTextField nameTextField;
    private JTextField adressTextField;
    private JTextField emailTextField;
    private JTextField ageTextField;
    private JTable table;

    public ClientView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1368, 761);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(128, 128, 0));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel labelClient = new JLabel("Clients");
        labelClient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        labelClient.setBounds(533, 33, 133, 38);
        contentPane.add(labelClient);

        JButton addNewClientButton = new JButton("Add New Client");
        addNewClientButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        addNewClientButton.setBounds(158, 85, 314, 50);
        contentPane.add(addNewClientButton);

        JButton editClientButton = new JButton("Edit Client");
        editClientButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        editClientButton.setBounds(158, 171, 314, 50);
        contentPane.add(editClientButton);

        JButton deleteClient = new JButton("Delete Client");
        deleteClient.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        deleteClient.setBounds(158, 247, 314, 50);
        contentPane.add(deleteClient);

        idTextField = new JTextField();
        idTextField.setBounds(288, 405, 184, 43);
        contentPane.add(idTextField);
        idTextField.setColumns(10);

        JButton showClientsButton = new JButton("Show Clients");
        showClientsButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 26));
        showClientsButton.setBounds(158, 333, 314, 50);
        contentPane.add(showClientsButton);

        nameTextField = new JTextField();
        nameTextField.setColumns(10);
        nameTextField.setBounds(288, 470, 184, 43);
        contentPane.add(nameTextField);

        adressTextField = new JTextField();
        adressTextField.setColumns(10);
        adressTextField.setBounds(288, 538, 184, 43);
        contentPane.add(adressTextField);

        emailTextField = new JTextField();
        emailTextField.setColumns(10);
        emailTextField.setBounds(288, 602, 184, 43);
        contentPane.add(emailTextField);

        ageTextField = new JTextField();
        ageTextField.setColumns(10);
        ageTextField.setBounds(288, 671, 184, 43);
        contentPane.add(ageTextField);

        JLabel idLabel = new JLabel("Id");
        idLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        idLabel.setBounds(158, 405, 120, 43);
        contentPane.add(idLabel);

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        nameLabel.setBounds(158, 470, 120, 43);
        contentPane.add(nameLabel);

        JLabel adressLabel = new JLabel("Adress");
        adressLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        adressLabel.setBounds(158, 538, 120, 43);
        contentPane.add(adressLabel);

        JLabel emailLabel = new JLabel("Email");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        emailLabel.setBounds(158, 602, 120, 43);
        contentPane.add(emailLabel);

        JLabel ageLabel = new JLabel("Age");
        ageLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        ageLabel.setBounds(158, 671, 120, 43);
        contentPane.add(ageLabel);

        JScrollPane clientsTable = new JScrollPane();
        clientsTable.setBounds(665, 81, 643, 633);
        contentPane.add(clientsTable);

        table = new JTable();
        clientsTable.setViewportView(table);
        this.setVisible(true);
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

    public String getAdressTextField() {
        return adressTextField.getText();
    }

    public void setAdressTextField(String adressTextField) {
        this.adressTextField.setText(adressTextField);
    }

    public String getEmailTextField() {
        return emailTextField.getText();
    }

    public void setEmailTextField(String emailTextField) {
        this.emailTextField.setText(emailTextField);
    }

    public int getAgeTextField() {
        return Integer.parseInt(ageTextField.getText());
    }

    public void setAgeTextField(String ageTextField) {
        this.ageTextField.setText(ageTextField);
    }

    public JTable getTable() {
        return table;
    }

    public void setTable(JTable table) {
        this.table = table;
    }
}
