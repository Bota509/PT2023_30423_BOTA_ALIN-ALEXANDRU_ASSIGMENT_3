package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;


public class ClientDAO {
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (name,address,email,age)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where id = ?";

    public static Client findById(int clientID) {
        Client toReturn = null;

        Connection dbConnection = ConnectionFactory.getConnection();
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
            findStatement = dbConnection.prepareStatement(findStatementString);
            findStatement.setLong(1, clientID);
            rs = findStatement.executeQuery();
            rs.next();

            String name = rs.getString("name");
            String adress = rs.getString("adress");
            String email = rs.getString("email");
            int age = rs.getInt("age");
            toReturn = new Client(clientID, name, adress, email, age);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
        } finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
        return toReturn;
    }

}
