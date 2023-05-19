package controller;

import dao.ClientDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import model.Bill;
import model.Client;
import model.Orders;
import model.Product;
import presentation.ClientView;
import presentation.GameStoreView;
import presentation.ProductOrderView;
import presentation.ProductView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

/**
 * <p>The controller manages teh GUI windows, receives the inputs from the GUI and connects the GUI with the operations that
 * aer in a strong relation with the database.</p>
 */
public class Controller {
    ClientView clientView;
    ProductView productView;
    ProductOrderView productOrderView;
    GameStoreView gameStoreView;

    //clients
    private int idClient;
    private String nameClient;
    private String adressClient;
    private String emailClient;
    private int ageClient;

    //products
    private int idProduct;
    private String nameProduct;
    private int priceProduct;
    private String categoryProduct;
    private int stockProduct;

    ClientDAO clientDAO;
    ProductDAO productDAO;
    OrdersDAO ordersDAO;
    Bill bill;
    /**
     * <p>It's responsible with the button response from the GUI and initialization of variables</p>
     */
    public Controller(ClientView clientView, ProductView productView, ProductOrderView productOrderView, GameStoreView gameStoreView) {
        this.clientView = clientView;
        this.productOrderView = productOrderView;
        this.productView = productView;
        this.gameStoreView = gameStoreView;
        clientDAO = new ClientDAO();
        productDAO = new ProductDAO();
        ordersDAO = new OrdersDAO();
        bill = new Bill();

        //Main View Controll
        this.gameStoreView.openClientViewActionListener(
                (event) -> {
                    this.clientView.display();
                }
        );
        this.gameStoreView.openProductViewActionListener(
                (event) -> {
                    this.productView.display();
                }
        );
        this.gameStoreView.openProductOrderViewActionListener(
                (event) -> {
                    this.productOrderView.display();
                    //populate the JComboBox
                    populateComboBoxes();
                    populateTables();
                }
        );
        //Client View Controll when one of button pressed
        insertClient();
        removeClient();
        showClients();
        updateClient();

        //Product View Controll when one of button pressed
        insertProduct();
        removeProduct();
        showProducts();
        updateProduct();

        //Orders View Controll
        this.productOrderView.makeOrderActionListener(
                (event) -> {
                    try {
                        purchase();
                    }
                    catch (Exception e)
                    {}
                }
        );
    }
    /**
     * Populates the client and the product JTables in the Orders View.
     */
    public void populateTables() {
        List<Client> clients = clientDAO.findAll();
        List<Product> products = productDAO.findAll();
        populate(productOrderView.getClientTable(), clients);
        populate(productOrderView.getProductTable(), products);
    }
    /**
     * When a purchase is done, this method is called, it verifies if the quantity input is available in the stock, if it's available
     * the purchase is made, it decrements the stock of the product , it refreshes the tables, and creates the bill
     */
    public void purchase() throws IOException {
        String selectedProductItem = (String) productOrderView.getProductListComboBox().getSelectedItem();
        String selectedClientItem = (String) productOrderView.getClientListComboBox().getSelectedItem();
        int quantity = productOrderView.getQuantityTextField();
        //in momentu in care fac order -> insert id client si id product in tabelul orders
        Client client = clientDAO.findByName(selectedClientItem);
        Product product = productDAO.findByName(selectedProductItem);
        if (quantity > product.getStock()) {
            JOptionPane.showMessageDialog(null, "Out of stock only " + product.getStock() + " products available", "Error", JOptionPane.ERROR_MESSAGE);
        } else if (product.getStock() - quantity >= 0) {
            product.setStock(product.getStock() - quantity);
            productDAO.update(product, product.getId());
            Orders order = new Orders(1, client.getId(), product.getId(), quantity);
            ordersDAO.insert(order);
            List<Orders> orders = ordersDAO.findAll();
            populate(productOrderView.getTable(), orders);
            populateTables();
            JOptionPane.showMessageDialog(null, "Order Done", "Thank you!", JOptionPane.INFORMATION_MESSAGE);
            bill.createBill(order,client,product);
        }
    }
    /**
     * It populates the JComboBoxes from the ordersView in order to select the client that purchases a specific product
     * */
    public void populateComboBoxes() {
        List<Client> clients = clientDAO.findAll();
        List<Product> products = productDAO.findAll();
        DefaultComboBoxModel<String> comboBoxModelClient = new DefaultComboBoxModel<>();
        for (Client client : clients) {
            comboBoxModelClient.addElement(client.getName());
        }
        productOrderView.getClientListComboBox().setModel(comboBoxModelClient);

        DefaultComboBoxModel<String> comboBoxModelProduct = new DefaultComboBoxModel<>();
        for (Product product : products) {
            comboBoxModelProduct.addElement(product.getName());
        }
        productOrderView.getProductListComboBox().setModel(comboBoxModelProduct);
    }

    private void updateProduct() {
        this.productView.editProductActionListener(
                (event) -> {
                    readForProducts();
                    Product product = new Product(idProduct, nameProduct, priceProduct, categoryProduct, stockProduct);
                    productDAO.update(product, idProduct);
                }
        );
    }

    private void showProducts() {
        this.productView.showProductsActionListener(
                (event) -> {
                    List<Product> products = productDAO.findAll();
                    populate(productView.getTable(), products);
                }
        );
    }

    private void removeProduct() {
        this.productView.deleteProductActionListener(
                (event) -> {
                    idProduct = productView.getIdTextField();
                    productDAO.delete(idProduct);
                }
        );
    }

    private void insertProduct() {
        this.productView.addProductActionListener(
                (event) -> {
                    readForProducts();
                    Product product = new Product(idProduct, nameProduct, priceProduct, categoryProduct, stockProduct);
                    productDAO.insert(product);
                }
        );
    }

    private void updateClient() {
        this.clientView.editClientActionListener(
                (event) -> {
                    readForClients();
                    Client client = new Client(idClient, nameClient, adressClient, emailClient, ageClient);
                    clientDAO.update(client, idClient);
                }
        );
    }



    private void removeClient() {
        this.clientView.deleteClientActionListener(
                (event) -> {
                    idClient = clientView.getIdTextField();
                    clientDAO.delete(idClient);
                }
        );
    }

    private void insertClient() {
        this.clientView.addNewClientActionListener(
                (event) -> {
                    readForClients();
                    Client client = new Client(idClient, nameClient, adressClient, emailClient, ageClient);
                    clientDAO.insert(client);
                }
        );
    }

    private void showClients() {
        this.clientView.showClientActionListener(
                (event) -> {
                    List<Client> clients = clientDAO.findAll();
                    populate(clientView.getTable(), clients);
                }
        );
    }

    public void readForClients() {
        idClient = clientView.getIdTextField();
        nameClient = clientView.getNameTextField();
        adressClient = clientView.getAdressTextField();
        emailClient = clientView.getEmailTextField();
        ageClient = clientView.getAgeTextField();
        clientView.refresh();
    }

    public void readForProducts() {
        idProduct = productView.getIdTextField();
        nameProduct = productView.getNameTextField();
        categoryProduct = productView.getCategoryTextField();
        priceProduct = productView.getPriceTextField();
        stockProduct = productView.getStockTextField();
        productView.refresh();
    }
    /**
     * @param table ta the table that will be populated
     * @param object the type of data that will be populated in the table ex : client, product, order
     *  By using the reflection method, the method takes a table and populates it with all the data available in a database of the
     *  specific object
     */
    public void populate(JTable table, List<?> object) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table
        Class<?> objectClass = object.get(0).getClass();
        Field[] fields = objectClass.getDeclaredFields();
        String[] columnNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
        }
        model.setColumnIdentifiers(columnNames);

        for (Object obj : object) {
            Object[] rowData = new Object[fields.length];
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                field.setAccessible(true);
                try {
                    rowData[i] = field.get(obj);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
            model.addRow(rowData);
        }

    }
}
