package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;

import javax.swing.*;


/**
 * AbstractDAO represents a generic form of all Data Acces Objects and implements all the operations that are necessary to modify the
 * data from the tables : clients, products, orders. The methos are : find all, insert, delete, update, show, findByName
 * @author Bota Alin
 */
public class AbstractDAO<T> {

    /**
     *The Logger class is a part of the Java Logging API, which provides a flexible framework for logging messages in Java applications. .
     */
    protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

    /**
     *Is a generic class variable
     */
    private final Class<T> type;

    @SuppressWarnings("unchecked")
    public AbstractDAO() {
        this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    }

    private String createSelectQuery(String field) {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        sb.append(" * ");
        sb.append(" FROM ");
        sb.append(type.getSimpleName());
        sb.append(" WHERE " + field + " =?");
        return sb.toString();
    }

    /**
     * @return The method returns a list of all data available for a generic method
     * Firstly the connection is made, in a try catch statement, because the connection is possible to fail, with the SELECT * FROM...
     * SQL command all the elements from a line in a database are selected, then the list of objects is returned
     */
    public List<T> findAll() {
        // TODO:
        Connection connection =null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionFactory.getConnection();
            String qr = "SELECT * FROM " + type.getSimpleName();
            statement = connection.prepareStatement(qr);
            resultSet = statement.executeQuery();
            return createObjects(resultSet);
        }
        catch (SQLException e)
        {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());

        }finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }

    /**
     * @param name is the key that the method is looking for
     * @return returns a generic object
     * The method is looking for an object with a specific name. When the name is found in the table the object with that name is returned
     */
    public T findByName(String name) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        String query = createSelectQuery("name");
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(query);
            statement.setString(1, name);
            resultSet = statement.executeQuery();

            return createObjects(resultSet).get(0);
        } catch (SQLException e) {
            LOGGER.log(Level.WARNING, type.getName() + "DAO:findByName " + e.getMessage());
        } finally {
            ConnectionFactory.close(resultSet);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(connection);
        }
        return null;
    }
    /**
     * @param resultSet
     * @return returns a list of a generic object
     */
    private List<T> createObjects(ResultSet resultSet) {
        List<T> list = new ArrayList<T>();
        Constructor[] ctors = type.getDeclaredConstructors();
        Constructor ctor = null;
        for (int i = 0; i < ctors.length; i++) {
            ctor = ctors[i];
            if (ctor.getGenericParameterTypes().length == 0)
                break;
        }
        try {
            while (resultSet.next()) {
                ctor.setAccessible(true);
                T instance = (T)ctor.newInstance();
                for (Field field : type.getDeclaredFields()) {
                    String fieldName = field.getName();
                    Object value = resultSet.getObject(fieldName);
                    PropertyDescriptor propertyDescriptor = new PropertyDescriptor(fieldName, type);
                    Method method = propertyDescriptor.getWriteMethod();
                    method.invoke(instance, value);
                }
                list.add(instance);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IntrospectionException e) {
            e.printStackTrace();
        }
        return list;
    }

    /**
     * @param t is the generic object needed to be passed and work with
     * @return returns a generic object
     *The method takes all information possible for a specific object from the GUI, and the inserts the data from the
     * object in the data table
     */
    public T insert(T t) {

        Connection dbConnection =null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            dbConnection = ConnectionFactory.getConnection();

            String querry = "INSERT INTO " +  type.getSimpleName() + " ( ";
            for (Field field : type.getDeclaredFields())
            {
                if (field.getName().equals("id"))
                    continue;
                querry += field.getName();
                querry +=",";
            }
            querry = querry.substring(0, querry.length() - 1);
            querry +=")";
            querry += " VALUES (";
            for (Field field : type.getDeclaredFields())
            {
                if (field.getName().equals("id"))
                    continue;
                querry += "?,";
            }

            querry = querry.substring(0, querry.length() - 1);
            querry +=")";

            statement = dbConnection.prepareStatement(querry);
            int i=1;
            for (Field field : type.getDeclaredFields()) {
                if (field.getName().equals("id"))
                    continue;
                field.setAccessible(true);
                statement.setObject(i, field.get(t));
                i++;
            }
            statement.executeUpdate();

        }catch (Exception e)
        {
            LOGGER.log(Level.WARNING,"ClientDAO:inserClient" + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(dbConnection);
        }
        return t;
    }

    /**
     * @param t is the generic object needed to be passed and work with
     * @param id is the key that is looking for, to modify a specific line in the table
     * @return returns a generic object
     *The method is looking for a specific line in the database table by passing the id, and modifies the data with the data from the
     * object that was passed in
     */
    public T update(T t, int id) {
        // TODO:
        Connection dbConnection =null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            dbConnection = ConnectionFactory.getConnection();

            //"UPDATE client SET name = ?, adress = ?,email= ?,age =? WHERE id =?";
            String querry = "UPDATE " +  type.getSimpleName() + " SET ";
            for (Field field : type.getDeclaredFields())
            {
                querry += field.getName();
                querry +=" =?,";
            }
            querry = querry.substring(0, querry.length() - 1);
            querry +=" WHERE id=?";

            statement = dbConnection.prepareStatement(querry);
            int i=1;
            for (Field field : type.getDeclaredFields())
            {
                field.setAccessible(true);
                statement.setObject(i,field.get(t));
                i++;
            }
            statement.setObject(i,id);
            statement.executeUpdate();

        }catch (Exception e)
        {
            LOGGER.log(Level.WARNING,"ClientDAO:inserClient" + e.getMessage());
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(dbConnection);
        }
        return t;
    }

    /**
     * @param id is the key that is looking for, to modify a specific line in the table
     *The method is looking for the line with the id passed and then deletes the data from that line in the database
     */
    public void delete(int id) {
        // TODO:
        Connection dbConnection =null;
        PreparedStatement statement = null;
        ResultSet rs = null;
        try {
            dbConnection = ConnectionFactory.getConnection();

            //DELETE FROM client where id =?
            String querry = "DELETE FROM " +  type.getSimpleName();
            querry +=" WHERE id=?";

            statement = dbConnection.prepareStatement(querry);
            statement.setObject(1,id);
            statement.executeUpdate();

        }catch (Exception e)
        {
            LOGGER.log(Level.WARNING,"ClientDAO:inserClient" + e.getMessage());
            JOptionPane.showMessageDialog(null, type.getSimpleName() + "  Cannot be deleted if depends on other objects", "Error", JOptionPane.ERROR_MESSAGE);
        }finally {
            ConnectionFactory.close(rs);
            ConnectionFactory.close(statement);
            ConnectionFactory.close(dbConnection);
        }
    }
}
