/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author student2
 */
public class DatabaseConnection {

    private List<Connection> connectionPool;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        connectionPool = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            try {
                String url = "jdbc:mysql://localhost/laboratorija";
                String user = "root";
                String password = "";
                Connection connection = DriverManager.getConnection(url, user, password);

                connection.setAutoCommit(false);
                connectionPool.add(connection);
            } catch (SQLException ex) {
                System.out.println("Greska! Konekcija sa bazom nije uspesno uspostavljena!\n" + ex.getMessage());
                ex.printStackTrace();
                throw ex;
            }
        }

    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }
    
    public synchronized Connection pop() throws Exception{
        if(connectionPool.isEmpty()){
            throw new Exception("No available connection!");
        }
        Connection connection=connectionPool.get(0);
        connectionPool.remove(0);
        return connection;
    }
    
    public synchronized void push(Connection connection){
        connectionPool.add(connection);
    }
}
