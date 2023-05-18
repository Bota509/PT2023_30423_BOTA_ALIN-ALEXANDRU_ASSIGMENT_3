package model;

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