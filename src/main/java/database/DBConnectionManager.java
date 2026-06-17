package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionManager {
    private static final String URL = "jdbc:mysql://localhost:3307/veloce_ai_db";
    private static final String USER = "root";
    private static final String PASSWORD = "Babel_301!bM&P";

    public static Connection getConnection(){
            try{
                return DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException e) {
                throw new RuntimeException("Failed to connect to database", e);
            }
    }
}
