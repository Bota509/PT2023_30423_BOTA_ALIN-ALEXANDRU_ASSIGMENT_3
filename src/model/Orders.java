package model;

/**
 * Is the class that contains all information about a specific order
 * @author Bota Alin
 */
public class Orders {

private int id;
private int clientID;
private int productID;
private int quantity;

    public Orders()
    {

    }
    public Orders(int id, int clientID, int productID, int quantity) {
        this.id = id;
        this.clientID = clientID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }


    public int getClientID() {
        return clientID;
    }

    public void setClientID(int clientID) {
        this.clientID = clientID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public void setId(int id) {
        this.id = id;
    }

}
