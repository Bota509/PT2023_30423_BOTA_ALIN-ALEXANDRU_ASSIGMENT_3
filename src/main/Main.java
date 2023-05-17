package main;

import connection.ConnectionFactory;
import dao.ClientDAO;
import model.Client;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {


       /* ClientView clientView = new ClientView();
        ProductView productView = new ProductView();
        GameStoreView gameStoreView = new GameStoreView();
        ProductOrderView productOrderView = new ProductOrderView();
        Controller controller = new Controller(clientView,productView,productOrderView,gameStoreView);*/

        Client client = ClientDAO.findById(2);
        System.out.println(client.toString());


    }
}
