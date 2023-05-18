package controller;

import dao.ClientDAO;
import dao.OrdersDAO;
import dao.ProductDAO;
import model.Client;
import model.Product;
import presentation.ClientView;
import presentation.GameStoreView;
import presentation.ProductOrderView;
import presentation.ProductView;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.lang.reflect.Field;
import java.util.List;


public class Controller {
    ClientView clientView;
    ProductView productView;
    ProductOrderView productOrderView;
    GameStoreView gameStoreView;

    //clients
    private int idClient = 0;
    private String nameClient ="";
    private String adressClient ="";
    private String emailClient ="";
    private int ageClient = 0;

    //products
    private int idProduct;
    private String nameProduct;
    private int priceProduct;
    private String categoryProduct;
    private String descriptionProduct;

    ClientDAO clientDAO;
    ProductDAO productDAO;
    OrdersDAO ordersDAO;
    public Controller(ClientView clientView, ProductView productView,ProductOrderView productOrderView,GameStoreView gameStoreView)
    {
        this.clientView = clientView;
        this.productOrderView = productOrderView;
        this.productView = productView;
        this.gameStoreView = gameStoreView;
        clientDAO = new ClientDAO();
        productDAO = new ProductDAO();
        ordersDAO = new OrdersDAO();

        //Main View Controll
        this.gameStoreView.openClientViewActionListener(
                (event) -> {this.clientView.display();}
        );
        this.gameStoreView.openProductViewActionListener(
                (event) -> {this.productView.display();}
        );
        this.gameStoreView.openProductOrderViewActionListener(
                (event) -> {this.productOrderView.display();}
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
    }

    private void updateProduct() {
        this.productView.editProductActionListener(
                (event) -> {
                    readForProducts();
                    //edit products action
                    Product product = new Product(idProduct,nameProduct,priceProduct,categoryProduct,descriptionProduct);
                    productDAO.update(product,idProduct);
                }
        );
    }

    private void showProducts() {
        this.productView.showProductsActionListener(
                (event) -> {
                    //show products action
                    List<Product> products = productDAO.findAll();
                    populate(productView.getTable(),products);
                }
        );
    }

    private void removeProduct() {
        this.productView.deleteProductActionListener(
                (event) -> {
                    idProduct = productView.getIdTextField();
                    //delete products action
                    productDAO.delete(idProduct);
                }
        );
    }

    private void insertProduct() {
        this.productView.addProductActionListener(
                (event) -> {
                    readForProducts();
                    //add products action
                    Product product = new Product(idProduct,nameProduct,priceProduct,categoryProduct,descriptionProduct);
                    productDAO.insert(product);
                }
        );
    }

    private void updateClient() {
        this.clientView.editClientActionListener(
                (event) -> {
                    readForClients();
                    //edit clients action
                    Client client = new Client(idClient,nameClient,adressClient,emailClient,ageClient);
                    clientDAO.update(client,idClient);
                }
        );
    }

    private void removeClient() {
        this.clientView.deleteClientActionListener(
                (event) -> {
                    idClient = clientView.getIdTextField();
                    //delete client action
                    clientDAO.delete(idClient);
                }
        );
    }

    private void insertClient() {
        this.clientView.addNewClientActionListener(
                (event) -> {
                    readForClients();
                    //add client action
                    Client client = new Client(idClient,nameClient,adressClient,emailClient,ageClient);
                    clientDAO.insert(client);
                }
        );
    }

    private void showClients() {
        this.clientView.showClientActionListener(
                (event) -> {
                    //show clients action
                    List<Client> clients = clientDAO.findAll();
                    populate(clientView.getTable(),clients);
                }
        );
    }

    public void readForClients()
    {
        idClient = clientView.getIdTextField();
        nameClient = clientView.getNameTextField();
        adressClient = clientView.getAdressTextField();
        emailClient = clientView.getEmailTextField();
        ageClient = clientView.getAgeTextField();
        clientView.refresh();
    }
    public void readForProducts()
    {
        idProduct = productView.getIdTextField();
        nameProduct = productView.getNameTextField();
        categoryProduct = productView.getCategoryTextField();
        priceProduct = productView.getPriceTextField();
        descriptionProduct = productView.getDescriptionTextField();
        productView.refresh();
    }

    public void populate(JTable table, List<?> object)
    {
        //TODO:
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0); // Clear existing data in the table

        // Get the class of the objects in the list
        Class<?> objectClass = object.get(0).getClass();

        // Get the fields of the object class
        Field[] fields = objectClass.getDeclaredFields();

        // Create column names array based on the field names
        String[] columnNames = new String[fields.length];
        for (int i = 0; i < fields.length; i++) {
            columnNames[i] = fields[i].getName();
        }
        model.setColumnIdentifiers(columnNames);

        // Iterate through the list of objects and add each object as a row to the table
        for (Object obj : object) {
            Object[] rowData = new Object[fields.length];

            // Retrieve the values of the fields using reflection
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
