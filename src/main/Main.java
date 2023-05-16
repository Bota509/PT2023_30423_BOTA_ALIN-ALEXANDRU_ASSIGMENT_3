package main;

import View.ClientView;
import View.GameStoreView;
import View.ProductOrderView;
import View.ProductView;
import controller.Controller;

public class Main {
    public static void main(String[] args) {

        ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        GameStoreView gameStoreView = new GameStoreView();
        ProductOrderView productOrderView = new ProductOrderView();
        Controller controller = new Controller(clientView,productView,productOrderView,gameStoreView);
    }
}
