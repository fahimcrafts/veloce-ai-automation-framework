package debug;

import database.DBConnectionManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserQueryTest {
    public static void main(String[] args) {
        String query = "SELECT * FROM users";


    try(
        Connection connection = DBConnectionManager.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
    ){
        while (resultSet.next()){
            System.out.println("ID: " + resultSet.getInt("id")
                    + ", Name: " + resultSet.getString("name")
                    + ", Email: " + resultSet.getString("email"));
        }
    }
    catch (Exception e){
        e.printStackTrace();
    }
    }
}
