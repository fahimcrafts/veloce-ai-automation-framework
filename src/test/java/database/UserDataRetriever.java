package database;

import models.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDataRetriever {
    public static String getUserNameById(int userId){
        String userName = null;

        String query = "SELECT name FROM users WHERE id = " + userId;

        try(
                Connection connection = DBConnectionManager.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                ){
            if(resultSet.next()){
                userName = resultSet.getString("name");
            }
        }   catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }

    public static User getUserById(int userId){
        User user = null;

        String query = "SELECT id, name, email FROM users WHERE id = " + userId;

        try(
            Connection connection = DBConnectionManager.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
                ){
                if(resultSet.next()){
                user = new User(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("email"));
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}
