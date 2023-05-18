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
    Client client = new Client(3, "a", "d", "alin@fgmail.com", 21);
    ClientDAO daoCLient = new ClientDAO();
        daoCLient.delete(22);

    //ClientDAO.update(4,"Alin","Plevnei","ali@gmail.com",21);




    }
}
