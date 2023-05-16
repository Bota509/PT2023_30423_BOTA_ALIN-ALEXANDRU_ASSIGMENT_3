package controller;

import presentation.ClientView;
import presentation.GameStoreView;
import presentation.ProductOrderView;
import presentation.ProductView;


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
    private String descriptionProduct;

    public Controller(ClientView clientView, ProductView productView,ProductOrderView productOrderView,GameStoreView gameStoreView)
    {
        this.clientView = clientView;
        this.productOrderView = productOrderView;
        this.productView = productView;
        this.gameStoreView = gameStoreView;

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
        this.clientView.addNewClientActionListener(
                (event) -> {
                    readForClients();
                    //add client action
                }
        );
        this.clientView.deleteClientActionListener(
                (event) -> {
                    readForClients();
                    //delete client action
                }
        );
        this.clientView.showClientActionListener(
                (event) -> {
                    readForClients();
                    //show clients action
                }
        );
        this.clientView.editClientActionListener(
                (event) -> {
                    readForClients();
                    //edit clients action
                }
        );

        //Product View Controll when one of button pressed
        this.productView.addProductActionListener(
                (event) -> {
                    readForProducts();
                    //add products action
                }
        );
        this.productView.deleteProductActionListener(
                (event) -> {
                    readForProducts();
                    //delete products action
                }
        );
        this.productView.showProductsActionListener(
                (event) -> {
                    readForProducts();
                    //show products action
                }
        );
        this.productView.editProductActionListener(
                (event) -> {
                    readForProducts();
                    //edit products action
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


}
