package main;

import connection.ConnectionFactory;
import presentation.ClientView;
import presentation.GameStoreView;
import presentation.ProductOrderView;
import presentation.ProductView;
import controller.Controller;

import java.util.Date;

public class Main {
    public static void main(String[] args) {


        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        GameStoreView gameStoreView = new GameStoreView();
        ProductOrderView productOrderView = new ProductOrderView();
        Controller controller = new Controller(clientView,productView,productOrderView,gameStoreView);
    }
}
