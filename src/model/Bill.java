package model;

import javax.swing.plaf.PanelUI;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

/**
 * The Bill class si responsible for holding the createBill method which will create the bill after an order is made
 * @author Bota Alin
 */
public class Bill {

    private int id;
    private String clientName;
    private String productName;
    private int orderQuantity;
    private int productPrice;
    private int totalPrice;

    public Bill()
    {

    }
    public Bill(int id, String clientName, String productName, int orderQuantity, int productPrice, int totalPrice) {
        this.id = id;
        this.clientName = clientName;
        this.productName = productName;
        this.orderQuantity = orderQuantity;
        this.productPrice = productPrice;
        this.totalPrice = totalPrice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getOrderQuantity() {
        return orderQuantity;
    }

    public void setOrderQuantity(int orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @param order is an object of type Order to retrieve the information that is necessary for the bill
     * @param client is a client of type Client to retrieve the information that is necessary for the bill
     * @param product is a product of type Product to retrieve the information that is necessary for the bill
     * It creates the bill in a random file
     */
    public void createBill(Orders order,Client client, Product product) throws IOException {
        Random rand = new Random();
        int billId = rand.nextInt();
        String name = "bill" + billId + ".txt";
        File file = new File(name);
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        writer.write(df.format(now) + "\n");
        writer.write("Client's name: "+ client.getName() + "\n");
        writer.write("Product bought: " + product.getName() + "\n");
        writer.write("Quantity bought: " + order.getQuantity() + "\n");
        writer.write("Price per piece: " + product.getPrice() + "\n");
        writer.write("Total price: " + product.getPrice() * order.getQuantity());
        writer.flush();
        writer.close();
    }

}