package main;

import connection.ConnectionFactory;
import controller.Controller;
import dao.ClientDAO;
import model.Client;
import presentation.ClientView;
import presentation.GameStoreView;
import presentation.ProductOrderView;
import presentation.ProductView;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        GameStoreView gameStoreView = new GameStoreView();
        ProductOrderView productOrderView = new ProductOrderView();
        Controller controller = new Controller(clientView,productView,productOrderView,gameStoreView);


    //ClientDAO.update(4,"Alin","Plevnei","ali@gmail.com",21);




    }
}
