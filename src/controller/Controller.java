package controller;

import View.ClientView;
import View.GameStoreView;
import View.ProductOrderView;
import View.ProductView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller {


    ClientView clientView;
    ProductView productView;
    ProductOrderView productOrderView;
    GameStoreView gameStoreView;

    public Controller(ClientView clientView, ProductView productView,ProductOrderView productOrderView,GameStoreView gameStoreView)
    {
        this.clientView = clientView;
        this.productOrderView = productOrderView;
        this.productView = productView;
        this.gameStoreView = gameStoreView;

        this.gameStoreView.openClientViewActionListener(
                (event) -> {this.clientView.display();}
        );
        this.gameStoreView.openProductViewActionListener(
                (event) -> {this.productView.display();}
        );
        this.gameStoreView.openProductOrderViewActionListener(
                (event) -> {this.productOrderView.display();}
        );
    }


}
