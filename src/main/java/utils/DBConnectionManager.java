package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static Connection connection;

    private static final String URL = "jdbc:mysql://localhost:3307/veloce_ai_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Babel_301!bM&P";

    public static Connection getConnection(){
        if(connection == null){
            try{
                connection= DriverManager.getConnection(URL, USER, PASSWORD);
                System.out.println("Database connection established successfully");
            } catch (SQLException e) {
                System.out.println("Failed to connect to database");
                e.printStackTrace();
            }
        }
        return connection;
    }
}
