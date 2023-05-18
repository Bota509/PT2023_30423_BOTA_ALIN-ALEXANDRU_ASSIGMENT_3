package model;

import dao.ClientDAO;


/**
 * Is the class that contains all information about a specific client
 * @author Bota Alin
 */
public class Client {
    private int id;
    private String name;
    private String adress;
    private String email;
    private int age;

    /**
     * An empty constructor of type Client
     */
    public Client()
    {

    }

    /**
     * @param id the id of the client
     * @param name the name of client
     * @param adress the adress of client
     * @param email the email of client
     * @param age the age of client
     * Constructor for Client
     */
    public Client(int id, String name, String adress, String email, int age) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.email = email;
        this.age = age;
    }

    /**
     * getter of id
     * @return gets the id
     */
    public int getId() {
        return id;
    }

    /**
     * setter of if
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * getter of name
     * @return gets the name
     */
    public String getName() {
        return name;
    }

    /**
     * setter of name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * getter of address
     * @return gets the address
     */
    public String getAdress() {
        return adress;
    }
    /**
     * setter of address
     */

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Client [id=" + id + ", name=" + name + ", address=" + adress + ", email=" + email + ", age=" + age
                + "]";
    }

}
