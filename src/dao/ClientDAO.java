package dao;


import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;


public class ClientDAO extends AbstractDAO<Client>{
    protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
    private static final String insertStatementString = "INSERT INTO client (name,adress,email,age)"
            + " VALUES (?,?,?,?)";
    private final static String findStatementString = "SELECT * FROM client where id = ?";
    private final static String  findString = "SELECT * FROM client";
    private final static String deleteStatementString = "DELETE FROM client where id =?";
    private final static String updateStatementString = "UPDATE client SET name = ?, adress = ?,email= ?,age =? WHERE id =?";

//    public static Client findById(int clientID) {
//        Client toReturn = null;
//
//        Connection dbConnection = ConnectionFactory.getConnection();
//        PreparedStatement findStatement = null;
//        ResultSet rs = null;
//        try {
//            findStatement = dbConnection.prepareStatement(findStatementString);
//            findStatement.setInt(1, clientID);
//            rs = findStatement.executeQuery();
//            rs.next();
//
//            String name = rs.getString("name");
//            String adress = rs.getString("adress");
//            String email = rs.getString("email");
//            int age = rs.getInt("age");
//            toReturn = new Client(clientID, name, adress, email, age);
//        } catch (SQLException e) {
//            LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
//        } finally {
//            ConnectionFactory.close(rs);
//            ConnectionFactory.close(findStatement);
//            ConnectionFactory.close(dbConnection);
//        }
//        return toReturn;
//    }

   /* public static void delete(int clientId)
    {
        Connection dbConnection = null;
        PreparedStatement findStatement = null;
        ResultSet rs = null;
        try {
                dbConnection = ConnectionFactory.getConnection();
                findStatement = dbConnection.prepareStatement(deleteStatementString);
                findStatement.setInt(1,clientId);
                findStatement.executeUpdate();
        }
        catch (Exception e)
        {
            LOGGER.log(Level.WARNING,"ClientDAO:deleteClient " + e.getMessage());
        }
        finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(findStatement);
            ConnectionFactory.close(dbConnection);
        }
    }*/

//    public  static void insert( String name,String adress, String email, int age)
//    {
//        Connection dbConnection =null;
//        PreparedStatement statement = null;
//        ResultSet rs = null;
//        try {
//            dbConnection = ConnectionFactory.getConnection();
//
//           statement =  dbConnection.prepareStatement(insertStatementString);
//
//            statement.setString(1,name);
//            statement.setString(2,adress);
//            statement.setString(3,email);
//            statement.setInt(4,age);
//            statement.executeUpdate();
//
//        }catch (Exception e)
//        {
//            LOGGER.log(Level.WARNING,"ClientDAO:inserClient" + e.getMessage());
//        }finally {
//            ConnectionFactory.close(rs);
//            ConnectionFactory.close(statement);
//            ConnectionFactory.close(dbConnection);
//        }
//    }
//    public  static void update(int clientId, String name,String adress, String email, int age)
//    {
//        Connection dbConnection = null;
//        PreparedStatement statement = null;
//        ResultSet rs = null;
//        try {
//
//            dbConnection = ConnectionFactory.getConnection();
//            statement =  dbConnection.prepareStatement(updateStatementString);
//            statement.setObject(1,name);
//            statement.setObject(2,adress);
//            statement.setObject(3,email);
//            statement.setObject(4,age);
//            statement.setObject(5,clientId);
//
//            statement.executeUpdate();
//
//        }catch (Exception e)
//        {
//            LOGGER.log(Level.WARNING,"ClientDAO:inserClient" + e.getMessage());
//        }finally {
//            ConnectionFactory.close(rs);
//            ConnectionFactory.close(statement);
//            ConnectionFactory.close(dbConnection);
//        }
//    }


}
